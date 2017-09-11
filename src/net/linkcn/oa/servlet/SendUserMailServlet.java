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
import net.linkcn.oa.entity.Inboxanddustbin;
import net.linkcn.oa.entity.User;

public class SendUserMailServlet extends HttpServlet
{
    private static final long serialVersionUID = -2695444025963860987L;

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
            String userMail = null, userName = null, userDeptId = null;
            // 将userMap集合转换成set集合
            Set<Entry<Object, String[]>> set = userMap.entrySet();
            // 循环遍历获取用户信息
            for (Entry<Object, String[]> entry : set)
            {
                // value[0] -- 用户类型 value[1] -- 用户邮箱名 value[2] -- 用户编号
                String[] value = entry.getValue();
                userMail = value[1];
                userId = Integer.parseInt(value[2]);
                userDeptId = value[3];
                userName = value[4];
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
            // 创建收件箱对象
            Inboxanddustbin inboxanddustbin = new Inboxanddustbin();
            inboxanddustbin.setInbdusUserMail(userMail);
            inboxanddustbin.setInbdusAddresser(userName);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            inboxanddustbin.setInbdusDate(dateFormat.format(new Date()));
            inboxanddustbin.setInbdusSubject(subject);
            inboxanddustbin.setInbdusRecipients(recipients);
            inboxanddustbin.setInbdusPeopleWhoCopied(peopleWhoCopied);
            inboxanddustbin.setInbdusBlindCarbon(blindCarbon);
            inboxanddustbin.setInbdusContent(content);
            inboxanddustbin.setInbdusAccessory(accessory.substring(accessory.lastIndexOf("\\") + 1));
            inboxanddustbin.setInbdusDeptId(Integer.parseInt(userDeptId));
            inboxanddustbin.setInbdusType("收");
            inboxanddustbin.setUser(user);
            inboxanddustbin.setInbdusIsnewtype("新");
        }
    }
}
