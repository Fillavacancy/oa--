package net.linkcn.oa.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.linkcn.oa.dao.impl.UserLogin;
import net.linkcn.oa.daos.IUserLogin;
import net.linkcn.oa.entity.Encrypted;

public class Test2
{
    public static void main(String[] args)
    {
        // 调用后台方法得到所有的密保信息
        IUserLogin login = new UserLogin();
        try
        {
            List list = login.searchEncrypted();
            if (list.size() > 0)
            {
                for (Iterator iterator = list.iterator(); iterator.hasNext();)
                {
                    Encrypted encrypted = (Encrypted) iterator.next();
                    System.out.println(encrypted.getEncrName());
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
