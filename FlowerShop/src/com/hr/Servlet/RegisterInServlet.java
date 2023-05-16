// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import com.hr.dao.EASYBUY_USERDao;
import com.hr.entity.EASYBUY_USER;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class RegisterInServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        final String username = req.getParameter("userName");
        final String name = req.getParameter("name");
        final String rePassWord = req.getParameter("rePassWord");
        final String sex = req.getParameter("sex");
        final String year = req.getParameter("birthday");
        final String email = req.getParameter("email");
        final String mobile = req.getParameter("mobile");
        final String address = req.getParameter("address");
        final String veryCode = req.getParameter("veryCode");
        final HttpSession session = req.getSession();
        final String sysCode = (String)session.getAttribute("syscode");
        final EASYBUY_USER u = new EASYBUY_USER(username, name, rePassWord, sex, year, null, email, mobile, address, 1);
        final int count = EASYBUY_USERDao.insert(u);
        final PrintWriter out = resp.getWriter();
        if (sysCode.equals(veryCode)) {
            if (count > 0) {
                resp.sendRedirect("reg-result.jsp");
            }
            else {
                out.write("<script>");
                out.write("alert('register error');");
                out.write("location.href='register.jsp'");
                out.write("</script>");
                out.close();
            }
        }
    }
}
