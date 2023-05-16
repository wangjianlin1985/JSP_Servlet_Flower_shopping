// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import com.hr.dao.EASYBUY_NEWSDao;
import com.hr.entity.EASYBUY_NEWS;
import com.hr.util.EncodeUtil;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class NewsInsServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        EncodeUtil.encode(req);
        final String title = req.getParameter("title");
        final String content = req.getParameter("content");
        final EASYBUY_NEWS news = new EASYBUY_NEWS(0, title, content, null);
        final int count = EASYBUY_NEWSDao.insert(news);
        if (count > 0) {
            resp.sendRedirect("manage-result.jsp");
        }
        else {
            resp.setContentType("text/html;charset=utf-8");
            final PrintWriter out = resp.getWriter();
            out.print("<script>");
            out.print("alert('\u6dfb\u52a0\u5931\u8d25');");
            out.print("location.href='news-add.jsp'");
            out.print("</script>");
            out.close();
        }
    }
}
