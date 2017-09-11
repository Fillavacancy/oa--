package net.linkcn.oa.test;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailDemo2
{
    public static void main(String[] args) throws AddressException, MessagingException
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
        Session session = Session.getInstance(prop);
        // 获取邮件对象
        Message msg = new MimeMessage(session);// 获取信封
        msg.setFrom(new InternetAddress("xiangjunzhong@qq.com"));// 写上发送人，即发送方QQ邮箱
        // 写上收件人，第二个参数是数组，因为收件人可以多个
        msg.setRecipients(RecipientType.TO, new InternetAddress[] { new InternetAddress("xiangjunzhong@qq.com") });
        msg.setSubject("这是来自java程序的一封邮件");// 标题
        msg.setText("恭喜发财，红包拿来!");// 内容
        msg.setSentDate(new Date());//发送时间
        // 找到邮递员
        Transport trans = session.getTransport();// 创建快递员对象
        trans.connect("xiangjunzhong@qq.com", "speznafkobuwfifh");// 告诉快递员你的用户名和密码，证明你是用户，speznafkobuwfifh是授权码
        // trans.connect("xiangjunzhong@163.com","speznafkobuwfifh");//告诉快递员你的用户名和密码，证明你是用户，speznafkobuwfifh是授权码
        trans.sendMessage(msg, msg.getAllRecipients());// 给信给快递员，和告诉他收件人地址
    }
}
