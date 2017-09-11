package net.linkcn.oa.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import net.linkcn.oa.entity.Outboxanddrafts;
import net.linkcn.oa.entity.User;

public class DraftsServlet extends HttpServlet
{
    private static final long serialVersionUID = -9144091522575224898L;

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
            String userMail = null;
            // 将userMap集合转换成set集合
            Set<Entry<Object, String[]>> set = userMap.entrySet();
            // 循环遍历获取用户信息
            for (Entry<Object, String[]> entry : set)
            {
                // value[0] -- 用户类型 value[1] -- 用户邮箱名 value[2] -- 用户编号
                String[] value = entry.getValue();
                userMail = value[1];
                userId = Integer.parseInt(value[2]);
            }
            // 接收页面参数
            String recipients = request.getParameter("shou");
            String peopleWhoCopied = request.getParameter("chao");
            String blindCarbon = request.getParameter("mi");
            String subject = request.getParameter("subject");
            String accessory = request.getParameter("accessory");
            String content = request.getParameter("content");
            User user = new User();
            user.setUserId(userId);
            // 创建草稿箱对象
            Outboxanddrafts outboxanddrafts = new Outboxanddrafts();
            outboxanddrafts.setOutdraUserMail(userMail);
            outboxanddrafts.setOutdraRecipients(recipients);
            outboxanddrafts.setOutdraPeopleWhoCopied(peopleWhoCopied);
            outboxanddrafts.setOutdraBlindCarbon(blindCarbon);
            outboxanddrafts.setOutdraSubject(subject);
            outboxanddrafts.setOutdraAccessory(accessory);
            outboxanddrafts.setOutdraContent(content);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            outboxanddrafts.setOutdraDate(dateFormat.format(new Date()));
            outboxanddrafts.setOutdraType("草");
            outboxanddrafts.setUser(user);
            // 调用后台方法实现添加草稿箱信息
            IUserMail draftsMail = new UserMail();
            try
            {
                boolean isok = draftsMail.saveDrafts(outboxanddrafts);
                if (isok)
                    response.getWriter().print("保存草稿箱成功!");
                else
                    response.getWriter().print("保存草稿箱失败!");
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
