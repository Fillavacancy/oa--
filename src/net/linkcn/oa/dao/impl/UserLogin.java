package net.linkcn.oa.dao.impl;

import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import net.linkcn.oa.daos.IUserLogin;
import net.linkcn.oa.util.HibernateUtil;
import net.linkcn.oa.entity.User;

public class UserLogin extends HibernateUtil implements IUserLogin
{
    Session     session     = null;
    Transaction transaction = null;

    /**
     * 用户登录
     */
    @SuppressWarnings("unchecked")
    public List<User> isLogin(User user, String type) throws Exception
    {
        List<User> list = null;
        StringBuffer hqlBuffer = new StringBuffer("from User u where 1=1 ");
        Map<String, Object> map = new HashMap<String, Object>();// 填充查询条件
        try
        {
            session = super.getSession();
            // 如果type等于编号、就根据编号登录
            if ("编号".equals(type))
            {
                hqlBuffer.append(" and u.userId = :userId ");
                map.put("userId", user.getUserId());
            }
            else
            {
                // 根据用户名进行登录
                hqlBuffer.append(" and u.userName = :userName ");
                map.put("userName", user.getUserName());
            }
            hqlBuffer.append(" and u.userPwd = :userPwd");
            map.put("userPwd", user.getUserPwd());
            list = session.createQuery(hqlBuffer.toString()).setProperties(map).list();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            super.close();
        }
        return list;
    }

    /**
     * 产生验证码
     */
    public String generateCaptchas(int length) throws Exception
    {
        Random randGen = null;
        char[] numbersAndLetters = null;
        if (length < 1)
        {
            return null;
        }
        if (randGen == null)
        {
            randGen = new Random();
            numbersAndLetters = ("0123456789ABCDEFGHIJKLMNPQRSTUVWXYZ").toCharArray();
        }
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++)
        {
            randBuffer[i] = numbersAndLetters[randGen.nextInt(35)];
        }
        return new String(randBuffer);
    }

    /**
     * 检索密保问题
     */
    @SuppressWarnings("unchecked")
    public List searchEncrypted() throws Exception
    {
        List list = null;
        try
        {
            session = super.getSession();
            String hql = "from Encrypted";
            list = session.createQuery(hql).list();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            super.close();
        }
        return list;
    }

    /**
     * 解锁
     */
    public boolean deblocking(Integer userId, Integer encr_id, String userContent) throws Exception
    {
        User user = null;
        boolean isok = false;
        try
        {
            session = super.getSession();
            transaction = session.beginTransaction();
            // 根据编号查询用户
            user = (User) session.get(User.class, Integer.valueOf(userId));
            // 如果用户存在，在判断密保问题是否一致
            if (user != null)
            {
                // 判断密保问题是否一致
                if (encr_id.equals(user.getEncrypted().getEncrId()))
                {
                    // 在判断密保答案是否一致
                    if (userContent.equals(user.getUserContent()))
                    {
                        // 如果 UserLock 等于是，才将其解锁
                        if ("是".equals(user.getUserLock()))
                        {
                            user.setUserLock("否");
                            transaction.commit();
                            isok = true;
                        }
                    }
                }
            }
        } catch (Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally
        {
            super.close();
        }
        return isok;
    }

    /**
     * 将byte数组转换为16进制输出
     */
    public String converByteToHexString(byte[] bytes) throws Exception
    {
        String result = "";
        for (int i = 0; i < bytes.length; i++)
        {
            int temp = bytes[i] & 0xff;
            String tempHex = Integer.toHexString(temp);
            if (tempHex.length() < 2)
                result += "0" + tempHex;
            else
                result += tempHex;
        }
        return result;
    }

    /**
     * AES加密算法
     */
    public byte[] AESJDKEncode(String message, String password) throws Exception
    {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(password.getBytes()));
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
        byte[] result = cipher.doFinal(message.getBytes());// 加密
        return result;
    }

    /**
     * AES解密算法
     */
    public byte[] AESJSKDecode(byte[] message, String password) throws Exception
    {
        KeyGenerator kGen = KeyGenerator.getInstance("AES");
        kGen.init(128, new SecureRandom(password.getBytes()));
        SecretKey secretKey = kGen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
        byte[] result = cipher.doFinal(message);// 解密
        return result;
    }

    /**
     * 发送邮件
     */
    public boolean SendMail(String from, List<String> to, String subject, String messageText) throws Exception
    {
        boolean isok = false;
        try
        {
            Properties prop = new Properties();
            prop.setProperty("mail.transport.protocol", "smtp");// 连接时的协议
            prop.setProperty("mail.smtp.host", "smtp.qq.com");// 主机名
            // prop.setProperty("mail.smtp.host", "smtp.163.com");//主机名
            prop.setProperty("mail.smtp.port", "465");// 主机名
            prop.setProperty("mail.smtp.auth", "true");// 是否开启权限控制
            prop.setProperty("mail.smtp.ssl.enable", "true");
            prop.setProperty("mail.debug", "true");// 如果设置为true则在发送邮件时会打印发送时的信息
            // 创建程序到邮件服务器之间的一次会话，即家到邮局的路
            javax.mail.Session session = javax.mail.Session.getInstance(prop);
            // 获取邮件对象
            Message msg = new MimeMessage(session);// 获取信封
            msg.setFrom(new InternetAddress(from));// 写上发送人，即发送方QQ邮箱
            // 写上收件人，第二个参数是数组，因为收件人可以多个
            for (String string : to)
            {
                msg.setRecipient(RecipientType.TO, new InternetAddress(string));
            }
            msg.setSubject(subject);// 标题
            msg.setText(messageText);// 内容
            msg.setSentDate(new Date());// 发送时间
            // 找到邮递员
            Transport trans = session.getTransport();// 创建快递员对象
            trans.connect(from, "speznafkobuwfifh");// 告诉快递员你的用户名和密码，证明你是用户，speznafkobuwfifh是授权码
            // trans.connect("xiangjunzhong@163.com","speznafkobuwfifh");//告诉快递员你的用户名和密码，证明你是用户，speznafkobuwfifh是授权码
            trans.sendMessage(msg, msg.getAllRecipients());// 给信给快递员，和告诉他收件人地址
            isok = true;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return isok;
    }

    /**
     * 根据用户邮箱名，查询用户信息
     */
    public Integer ResetPassword(String mail) throws Exception
    {
        Integer id = 0;
        try
        {
            session = super.getSession();
            String hql = "select user_id from user where user_mail = :mail";
            id = (Integer) session.createSQLQuery(hql).setParameter("mail", mail).uniqueResult();
            if (id == null)
            {
                id = -1;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            super.close();
        }
        return id;
    }

    /**
     * 修改用户登录密码
     */
    public boolean ResetUserLoginPwd(Integer id, String pwd) throws Exception
    {
        boolean isok = false;
        try
        {
            session = super.getSession();
            User user = (User) session.load(User.class, Integer.valueOf(id));
            transaction = session.beginTransaction();
            if (user != null)
            {
                user.setUserPwd(pwd);
            }
            transaction.commit();
            isok = true;
        } catch (Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally
        {
            super.close();
        }
        return isok;
    }
}
