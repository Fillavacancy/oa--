package net.linkcn.oa.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.linkcn.oa.dao.impl.UserMail;
import net.linkcn.oa.daos.IUserMail;

public class SelOutboxanddraftsServlet extends HttpServlet
{
    private static final long serialVersionUID = -1118318254529549726L;

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
            Integer userId = 0;
            // 将userMap集合转换成set集合
            Set<Entry<Object, String[]>> set = userMap.entrySet();
            // 循环遍历获取用户信息
            for (Entry<Object, String[]> entry : set)
            {
                // value[0] -- 用户类型 value[1] -- 用户邮箱名 value[2] -- 用户编号
                String[] value = entry.getValue();
                userId = Integer.parseInt(value[2]);
            }
            // 调用后台方法实现根据用户用户编号查询所属草稿箱信息
            IUserMail userMail = new UserMail();
            try
            {
                List infoList = userMail.infoOutboxanddrafts(userId, "草");
                if (infoList.size() > 0)
                    session.setAttribute("OutboxanddraftsC", infoList);
                response.sendRedirect("OutboxanddraftsC.jsp");
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
