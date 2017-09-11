package net.linkcn.oa.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.linkcn.oa.dao.impl.UserLogin;
import net.linkcn.oa.daos.IUserLogin;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class SearchEncryptedAll extends HttpServlet
{
    private static final long serialVersionUID = 704681062632737780L;

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
        // 调用后台方法得到所有的密保信息
        IUserLogin login = new UserLogin();
        try
        {
            List list = login.searchEncrypted();
            if (list.size() > 0)
            {
                JsonConfig jsonConfig = new JsonConfig(); // 建立配置文件
                jsonConfig.setIgnoreDefaultExcludes(false); // 设置默认忽略
                jsonConfig.setExcludes(new String[] { "users" });
                JSONArray jsonArray2 = JSONArray.fromObject(list, jsonConfig);
                // 把list转化成转化成json对象
                response.getWriter().print(jsonArray2);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
