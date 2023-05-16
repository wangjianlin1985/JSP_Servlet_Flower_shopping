// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import com.hr.dao.EASYBUY_USERDao;
import com.hr.entity.EASYBUY_USER;
import com.hr.util.EncodeUtil;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class UserDoupdate extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        EncodeUtil.encode(req);
        resp.setContentType("text/html;charset=utf-8");
        final String username = req.getParameter("userName");
        final String name = req.getParameter("name");
        final String pwd = req.getParameter("passWord");
        final String sex = req.getParameter("sex");
        final String birthday = req.getParameter("birthday");
        final String email = req.getParameter("email");
        final String mobile = req.getParameter("mobile");
        final String address = req.getParameter("address");
        final String userStatus = req.getParameter("userStatus");
        int status = 1;
        if (userStatus != null && !"".equals(userStatus)) {
            status = Integer.parseInt(userStatus);
        }
        final EASYBUY_USER user = new EASYBUY_USER(username, name, pwd, sex, birthday, null, email, mobile, address, status);
        final int count = EASYBUY_USERDao.update(user);
        if (count > 0) {
            resp.sendRedirect("manage-result.jsp");
        }
        else {
            final PrintWriter out = resp.getWriter();
            out.print("<script>");
            out.print("alert('\u4fee\u6539\u5931\u8d25');");
            out.print("location.href='user'");
            out.print("</script>");
            out.close();
        }
    }
}
