// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import com.hr.dao.EASYBUY_NEWSDao;
import com.hr.util.EncodeUtil;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class NewsDelServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        EncodeUtil.encode(req);
        final String id = req.getParameter("id");
        final int count = EASYBUY_NEWSDao.del(Integer.parseInt(id));
        if (count > 0) {
            resp.sendRedirect("manage-result.jsp");
        }
        else {
            resp.setContentType("text/html;charset=utf-8");
            final PrintWriter out = resp.getWriter();
            out.print("<script>");
            out.print("alert('\u5220\u9664\u5931\u8d25');");
            out.print("location.href='newsselect'");
            out.print("</script>");
            out.close();
        }
    }
}
