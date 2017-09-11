package net.linkcn.oa.servlet;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.linkcn.oa.dao.impl.UserMail;
import net.linkcn.oa.daos.IUserMail;

public class DlePersonalbookServlet extends HttpServlet
{
    private static final long serialVersionUID = 7876787569689724878L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html,charset=UTF-8");
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
            // 接收页面的参数
            String id = request.getParameter("id");
            // 调用后台方法实现根据编号删除信息
            IUserMail userMail = new UserMail();
            try
            {
                boolean isok = userMail.delPersonalbooksByid(Integer.parseInt(id));
                if (isok)
                    response.sendRedirect("SelPersonalbookServlet");
                else
                {
                    request.setAttribute("message", "删除好友“" + id + "”失败！");
                    request.getRequestDispatcher("Personalbook.jsp").forward(request, response);
                }
            } catch (NumberFormatException e)
            {
                e.printStackTrace();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
