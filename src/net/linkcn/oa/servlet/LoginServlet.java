package net.linkcn.oa.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.linkcn.oa.dao.impl.UserLogin;
import net.linkcn.oa.daos.IUserLogin;
import net.linkcn.oa.entity.User;

public class LoginServlet extends HttpServlet
{
    private static final long serialVersionUID = 5568359801913356646L;

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
        // // 获得会话对象，获取用户信息
        // HttpSession session = request.getSession();
        // // userMap 用户信息
        // Map<Object, String[]> userMap = (Map<Object, String[]>) session.getAttribute("userInfo");
        // // 如果userMap大小等于0，则转发到登录页面
        // if (userMap.size() <= 0)
        // response.sendRedirect("ObtainCodeServlet?type=1");
        // else
        // {
        // // 将userMap集合转换成set集合
        // Set<Entry<Object, String[]>> set = userMap.entrySet();
        // // 循环遍历获取用户信息
        // for (Entry<Object, String[]> entry : set)
        // {
        // // userName 用户名
        // String userName = (String) entry.getKey();
        // // value[0] -- 用户类型 value[1] -- 用户邮箱名 value[2] -- 用户编号   value[3] -- 用户部门编号
        // String[] value = entry.getValue();
        // String userType = value[0];
        // String userMail = value[1];
        // String userId = value[2];
        // String userDeptID = value[3];
        // String userName = value[4];//姓名
        // }
        // }
        // 接收登录页面的参数
        String loginType = request.getParameter("ddlLoginType");
        User user = new User();
        // 如果等于编号、根据编号登录
        if ("编号".equals(loginType))
        {
            user.setUserId(Integer.parseInt(request.getParameter("txt_UserName")));
        }
        else
        {
            // 根据用户名登录
            user.setUserName(request.getParameter("txt_UserName"));
        }
        user.setUserPwd(request.getParameter("txt_UserPwd"));
        // 接收页面验证码
        String code = request.getParameter("txt_ValidCode");
        code = code.toUpperCase();// 将页面录入的验证码，转换成大写
        // 获取会话、进行判断输入的验证码和产生的验证码是否相同
        HttpSession session = request.getSession();
        // 得到自动产生的验证码
        String codes = session.getAttribute("codes").toString();
        // 如果输入的验证码和系统产生的验证码相同、才到数据库中进行数据匹配
        if (code.equals(codes))
        {
            // 调用后台方法实现用户登录判断
            IUserLogin userLogin = new UserLogin();
            try
            {
                // 调用加密方法对用户录入的密码进行加密，然后在将加密过后的密码进行匹配
                byte[] encodeMessage = userLogin.AESJDKEncode(user.getUserPwd(), "password");
                // 将加密过后密码传入数据进行匹配
                user.setUserPwd(userLogin.converByteToHexString(encodeMessage));
                List<User> userList = userLogin.isLogin(user, loginType);
                // 如果userList集合大小等于1、匹配成功
                if (userList.size() == 1)
                {
                    User user2 = null;
                    for (Iterator iterator = userList.iterator(); iterator.hasNext();)
                    {
                        user2 = (User) iterator.next();
                    }
                    // 判断当前账号是否被管理员锁定
                    if ("否".equals(user2.getUserLock()))
                    {
                        // 用来保存登录成功的用户编号或者用户名，还有保存用户类别
                        Map<Object, String[]> mapInfoMap = new HashMap<Object, String[]>();
                        mapInfoMap.put(user2.getUserName(), new String[] { user2.getUserType().getUtypeName(), user2.getUserMail(), user2.getUserId().toString(),user2.getDept().getDeptId().toString(),user2.getUserName() });
                        // 将匹配成功的用户信息保存到session中
                        session.setAttribute("userInfo", mapInfoMap);
                        session.setAttribute("user", user2);
                        response.getWriter().print("登录成功!");
                    }
                    else
                    {
                        response.getWriter().print("抱歉，当前账号已经被管理员锁定，请先去完成解锁!");
                    }
                }
                else
                {
                    response.getWriter().print("抱歉，登录名或者密码错误!");
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            response.getWriter().print("抱歉，验证码输入错误!");
        }
    }
}
