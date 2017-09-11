package net.linkcn.oa.daos;

import java.util.List;
import net.linkcn.oa.entity.User;

/**
 * 用户名登录接口[登录、解锁、忘记密码]
 * 
 * @author Mr-XJZ
 */
public interface IUserLogin
{
    /**
     * 用户登录
     * 
     * @param user
     * @param type
     * @return
     * @throws Exception
     */
    public List<User> isLogin(User user, String type) throws Exception;

    /**
     * 产生验证码
     * 
     * @return
     * @throws Exception
     */
    public String generateCaptchas(int length) throws Exception;

    /**
     * 检索密保问题
     * 
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List searchEncrypted() throws Exception;

    /**
     * 解锁
     * 
     * @param userId
     * @param encr_id
     * @param userContent
     * @return
     * @throws Exception
     */
    public boolean deblocking(Integer userId, Integer encr_id, String userContent) throws Exception;

    /**
     * 将byte数组转换为16进制输出
     * 
     * @param bytes
     * @return
     * @throws Exception
     */
    public String converByteToHexString(byte[] bytes) throws Exception;

    /**
     * AES加密算法
     * 
     * @param message
     * @param password
     * @return
     * @throws Exception
     */
    public byte[] AESJDKEncode(String message, String password) throws Exception;

    /**
     * AES解密算法
     * 
     * @param message
     * @param password
     * @return
     * @throws Exception
     */
    public byte[] AESJSKDecode(byte[] message, String password) throws Exception;

    /**
     * 发送邮件
     * 
     * @param from
     * @param to
     * @param subject
     * @param messageText
     * @return
     * @throws Exception
     */
    public boolean SendMail(String from, List<String> to, String subject, String messageText) throws Exception;

    /**
     * 根据用户邮箱名，查询用户信息
     * 
     * @param mail
     * @return
     * @throws Exception
     */
    public Integer ResetPassword(String mail) throws Exception;

    /**
     * 修改用户登录密码
     * 
     * @param id
     * @return
     * @throws Exception
     */
    public boolean ResetUserLoginPwd(Integer id, String pwd) throws Exception;
}
