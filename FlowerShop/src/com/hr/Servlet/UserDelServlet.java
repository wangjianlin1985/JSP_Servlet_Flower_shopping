// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import com.hr.dao.EASYBUY_USERDao;
import com.hr.util.EncodeUtil;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class UserDelServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        EncodeUtil.encode(req);
        resp.setContentType("text/html;charset=utf-8");
        final String id = req.getParameter("id");
        final PrintWriter out = resp.getWriter();
        final int count = EASYBUY_USERDao.del(id);
        if (count > 0) {
            resp.sendRedirect("manage-result.jsp");
        }
        else {
            out.write("<script>");
            out.write("alert('\u5220\u9664\u5931\u8d25');");
            out.write("location.href='user.jsp'");
            out.write("</script>");
            out.close();
        }
    }
}
