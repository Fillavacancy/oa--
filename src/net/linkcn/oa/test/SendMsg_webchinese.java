package net.linkcn.oa.test;

import java.io.UnsupportedEncodingException;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SendMsg_webchinese
{
    public static void main(String[] args) throws Exception
    {
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
        // 在头文件中设置转码
        post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        NameValuePair[] data = { new NameValuePair("Uid", "Fill a vacancy"), new NameValuePair("Key", "896710"), new NameValuePair("smsMob", "15298122809"), new NameValuePair("smsText", "恭喜发财！") };
        post.setRequestBody(data);
        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:" + statusCode);
        for (Header h : headers)
        {
            System.out.println(h.toString());
        }
        String result = new String(post.getResponseBodyAsString().getBytes("utf-8"));
        // 打印返回消息状态
        System.out.println(result);
        post.releaseConnection();
    }
}