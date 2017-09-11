package net.linkcn.oa.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.linkcn.oa.dao.impl.UserLogin;
import net.linkcn.oa.daos.IUserLogin;

public class SendMailServlet extends HttpServlet
{
    private static final long serialVersionUID = 9155087513924455389L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html,charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // 获取页面录入的参数
        String from = "xiangjunzhong@qq.com";
        String to = request.getParameter("mail");
        List<String> list = new ArrayList<String>();
        list.add(to);
        String subject = "卓越办公系统、密码找回！";
        String messageText = "";
        // 调用后台方法实现用户登录判断
        IUserLogin login = new UserLogin();
        try
        {
            messageText = login.generateCaptchas(4);
            HttpSession session = request.getSession();
            boolean isokMail = login.SendMail(from, list, subject, messageText);
            if (isokMail)
            {
                // 获取会话、将给客户端发送的验证码保存到会话中
                session.setAttribute("codes", messageText);
                response.getWriter().print("验证码发送成功!");
            }
            else
            {
                response.getWriter().print("验证码发送失败!");
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
