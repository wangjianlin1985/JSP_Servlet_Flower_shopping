// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import com.hr.dao.EASYBUY_COMMENTDao;
import com.hr.entity.EASYBUY_COMMENT;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class GueServlet extends HttpServlet
{
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        final String guestName = request.getParameter("guestName");
        final String guestContent = request.getParameter("guestContent");
        final Date date = new Date();
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final String time = sdf.format(date).toString();
        final EASYBUY_COMMENT comment = new EASYBUY_COMMENT(0, guestContent, time, "", null, guestName);
        final int num = EASYBUY_COMMENTDao.insert(comment);
        if (num > 0) {
            response.sendRedirect("SelallServlet");
        }
        else {
            response.getWriter().print("<script>alert('\u6dfb\u52a0\u5931\u8d25\uff01');history.back();</script>");
        }
    }
}
