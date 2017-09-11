package net.linkcn.oa.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test4
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // 电子邮件
        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher("xiangjunzhong@qq.com");
        boolean isMatched = matcher.matches();
        System.out.println(isMatched);
    }
}
