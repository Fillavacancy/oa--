package net.linkcn.oa.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.linkcn.oa.dao.impl.UserLogin;
import net.linkcn.oa.daos.IUserLogin;

public class DeblockingServlet extends HttpServlet
{
    private static final long serialVersionUID = 3248969662618529651L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html,charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // 接收页面参数
        Integer Dealernumber = Integer.parseInt(request.getParameter("Dealernumber"));
        Integer Cryptoguard = Integer.parseInt(request.getParameter("Cryptoguard"));
        String Answer = request.getParameter("Answer");
        String ValidCode = request.getParameter("ValidCode");
        ValidCode = ValidCode.toUpperCase();
        // 获取会话、进行判断输入的验证码和产生的验证码是否相同
        HttpSession session = request.getSession();
        // 得到自动产生的验证码
        String codes = session.getAttribute("codes").toString();
        // 如果输入的验证码和系统产生的验证码相同、才到数据库中进行数据匹配
        if (ValidCode.equals(codes))
        {
            // 调用后台方法实现用户解锁
            IUserLogin userLogin = new UserLogin();
            try
            {
                boolean isok = userLogin.deblocking(Dealernumber, Cryptoguard, Answer);
                if (isok)
                    response.getWriter().print("恭喜、账号解锁成功!");
                else
                    response.getWriter().print("抱歉、账号不存在或者密保问题和答案错误、解锁失败!");
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
            response.getWriter().print("抱歉、验证码输入错误!");
    }
}
