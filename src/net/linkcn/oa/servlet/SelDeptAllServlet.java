package net.linkcn.oa.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.linkcn.oa.dao.impl.UserMail;
import net.linkcn.oa.daos.IUserMail;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class SelDeptAllServlet extends HttpServlet
{
    private static final long serialVersionUID = 2540517731758744054L;

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
            // 调用后台方法实现查询所有部门信息
            IUserMail userMail = new UserMail();
            try
            {
                List list = userMail.infoDeptAll();
                JsonConfig jsonConfig = new JsonConfig(); // 建立配置文件
                jsonConfig.setIgnoreDefaultExcludes(false); // 设置默认忽略
                jsonConfig.setExcludes(new String[] { "users" });
                JSONArray jsonArray2 = JSONArray.fromObject(list, jsonConfig);
                // 把list转化成转化成json对象
                response.getWriter().print(jsonArray2);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
