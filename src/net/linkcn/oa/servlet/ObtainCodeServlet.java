package net.linkcn.oa.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.linkcn.oa.dao.impl.UserLogin;
import net.linkcn.oa.daos.IUserLogin;

public class ObtainCodeServlet extends HttpServlet
{
    private static final long serialVersionUID = -2879567705761835787L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html,charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // 调用后台方法得到一个自动产生的验证码
        IUserLogin login = new UserLogin();
        try
        {
            // 产生一个四位数的验证码[可以是数字]
            String code = login.generateCaptchas(4);
            // 得到会话对象
            HttpSession session = request.getSession();
            // 将自动产生的验证码保存到会话对象中
            session.setAttribute("codes", code);
            if (request.getParameter("type") != null)
            {
                // session.setAttribute("codes", code);
                response.sendRedirect("Login.jsp");
            }
            else
                response.getWriter().print(code);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
