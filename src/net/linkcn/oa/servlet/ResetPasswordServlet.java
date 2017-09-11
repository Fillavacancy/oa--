package net.linkcn.oa.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.linkcn.oa.dao.impl.UserLogin;
import net.linkcn.oa.daos.IUserLogin;

public class ResetPasswordServlet extends HttpServlet
{
    private static final long serialVersionUID = -3188375131053972310L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html,charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // 接收页面录入参数
        String userMail = request.getParameter("userMail");
        String code = request.getParameter("code");
        code = code.toUpperCase();
        String pwd = request.getParameter("pwd");
        // 创建会话对象，获取验证码
        HttpSession session = request.getSession();
        String codes = session.getAttribute("codes").toString();
        // 判断系统产生的验证码和用户输入的验证码是否一致
        if (codes.equals(code))
        {
            // 调用后台方法实现修改用户密码
            IUserLogin userLogin = new UserLogin();
            try
            {
                Integer id = userLogin.ResetPassword(userMail);
                if (id != -1)
                {
                    boolean isok = userLogin.ResetUserLoginPwd(id, pwd);
                    if (isok)
                    {
                        response.getWriter().print("恭喜、重置密码成功！");
                    }
                    else
                    {
                        response.getWriter().print("抱歉、重置密码失败！");
                    }
                }
                else
                {
                    // 根据用户录入的邮箱名，没有查询到用户
                    response.getWriter().print("抱歉、没有查询到用户！");
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            // 验证码错误
            response.getWriter().print("抱歉、验证码输入错误！");
        }
    }
}
