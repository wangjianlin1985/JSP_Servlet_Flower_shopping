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

public class UseraddServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        EncodeUtil.encode(req);
        resp.setContentType("text/html;charset=utf-8");
        final String username = req.getParameter("userName");
        final String name = req.getParameter("name");
        final String pwd = req.getParameter("passWord");
        final String sex = req.getParameter("sex");
        final String year = req.getParameter("birthday");
        final String email = req.getParameter("email");
        final String mobile = req.getParameter("mobile");
        final String address = req.getParameter("address");
        final EASYBUY_USER u = new EASYBUY_USER(username, name, pwd, sex, year, null, email, mobile, address, 1);
        final int count = EASYBUY_USERDao.insert(u);
        final PrintWriter out = resp.getWriter();
        if (count > 0) {
            resp.sendRedirect("manage-result.jsp");
        }
        else {
            out.write("<script>");
            out.write("alert('\u6dfb\u52a0\u5931\u8d25');");
            out.write("location.href='user-add.jsp'");
            out.write("</script>");
            out.close();
        }
    }
}
