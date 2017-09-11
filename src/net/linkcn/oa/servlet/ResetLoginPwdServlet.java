package net.linkcn.oa.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.linkcn.oa.dao.impl.UserLogin;
import net.linkcn.oa.dao.impl.UserMail;
import net.linkcn.oa.daos.IUserLogin;
import net.linkcn.oa.daos.IUserMail;

public class ResetLoginPwdServlet extends HttpServlet
{
    private static final long serialVersionUID = -500452145260005928L;

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
            // 获取页面录入的值
            String pwd = request.getParameter("pwd");// 已经在jquery中判断了两次密码是否一致
            // 调用后台加密方法、实现对密码的加密操作
            IUserLogin userLogin = new UserLogin();
            // 调用加密方法对用户录入的密码进行加密，然后在将加密过后的密码保存到数据库
            try
            {
                // 将用户录入的密码转换成字节码
                byte[] encodeMessage = userLogin.AESJDKEncode(pwd, "password");
                // 将字节码进行加密、得到一个加了密的字符串
                String Topwd = userLogin.converByteToHexString(encodeMessage);
                // 调用后台方法实现修改登录密码
                IUserMail userMail = new UserMail();
                boolean isok = userMail.updLoginPwd(userId, Topwd);
                if (isok)
                    response.getWriter().print("登录口令已更改，请在下次登录时使用新口令。");
                else
                    response.getWriter().print("登录口令更改失败。");
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
