package net.linkcn.oa.test;

import net.linkcn.oa.dao.impl.UserLogin;
import net.linkcn.oa.daos.IUserLogin;

public class test
{
    public static void main(String[] args)
    {
        IUserLogin login = new UserLogin();
        String content = "wuyuling";
        String password = "password";
        try
        {
            byte[] encodeMessage = login.AESJDKEncode(content, password);
            System.out.println("加密后：" + login.converByteToHexString(encodeMessage));
            byte[] decodeMessage = login.AESJSKDecode(encodeMessage, password);
            System.out.println("解密后：" + new String(decodeMessage));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
