package net.linkcn.oa.servlet;

import java.io.IOException;
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
import net.linkcn.oa.entity.Personalbook;

public class SelPersonalbookServlet extends HttpServlet
{
    private static final long serialVersionUID = 4757754383899232297L;

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
            // 调用后台方法实现根据用户编号查询私人好友
            IUserMail userMail = new UserMail();
            try
            {
                List<Personalbook> list = userMail.infoPersonalbooks(userId);
                if (list.size() > 0)
                    session.setAttribute("Personalbook", list);
                else
                    session.setAttribute("Personalbook", "当前还没有私人好友，请点击新增好友！");
                response.sendRedirect("Personalbook.jsp");
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
