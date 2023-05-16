// 
// 
// 

package com.hr.manage;

import java.io.IOException;
import javax.servlet.ServletException;
import com.hr.entity.EASYBUY_COMMENT;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import com.hr.dao.EASYBUY_COMMENTDao;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class UpdateManage extends HttpServlet
{
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        final int id = Integer.parseInt(request.getParameter("id"));
        final EASYBUY_COMMENT comment = EASYBUY_COMMENTDao.selOne(id);
        if (comment != null) {
            request.setAttribute("list", (Object)comment);
            request.getRequestDispatcher("guestbook-modify.jsp").forward((ServletRequest)request, (ServletResponse)response);
        }
        else {
            response.getWriter().print("<script>alert('\u67e5\u8be2\u5931\u8d25\uff01');history.back();</script>");
        }
    }
}
