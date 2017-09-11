package net.linkcn.oa.servlet;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExamineLoginServlet extends HttpServlet
{
    private static final long serialVersionUID = -7242111315052757465L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }

    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html,charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // 获得会话对象，获取用户信息
        HttpSession session = request.getSession();
        // userMap 用户信息
        Map<Object, String[]> userMap = (Map<Object, String[]>) session.getAttribute("userInfo");
        // 如果userMap大小等于0，则转发到登录页面
        if (userMap == null)
            response.sendRedirect("ObtainCodeServlet?type=1");
        else
        {
            response.sendRedirect("peizhi.jsp");
        }
    }
}
