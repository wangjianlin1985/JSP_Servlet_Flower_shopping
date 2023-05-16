// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import com.hr.entity.EASYBUY_USER;
import javax.servlet.http.HttpSession;
import com.hr.dao.EASYBUY_USERDao;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class LoginServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        final String username = req.getParameter("userName");
        final String passWord = req.getParameter("passWord");
        final String veryCode = req.getParameter("veryCode");
        resp.setContentType("text/html;charset=utf-8");
        final HttpSession session = req.getSession();
        final String sysCode = (String)session.getAttribute("syscode");
        final int count = EASYBUY_USERDao.selectByNM(username, passWord);
        final EASYBUY_USER user = EASYBUY_USERDao.selectAdmin(username, passWord);
        if (sysCode.equals(veryCode)) {
            if (count > 0) {
                session.setAttribute("name", (Object)user);
                if (user.getEU_STATUS() == 2) {
                    resp.sendRedirect("manage/index.jsp");
                }
                else {
                    resp.sendRedirect("indexSelect");
                }
            }
            else {
                final PrintWriter out = resp.getWriter();
                out.print("<script>");
                out.print("alert('\u7528\u6237\u540d\u6216\u5bc6\u7801\u9519\u8bef');");
                out.print("location.href='login.jsp';");
                out.print("</script>");
                out.close();
            }
        }
        else {
            final PrintWriter out = resp.getWriter();
            out.print("<script>");
            out.print("alert('\u9a8c\u8bc1\u7801\u9519\u8bef');");
            out.print("location.href='login.jsp';");
            out.print("</script>");
            out.close();
        }
    }
}
