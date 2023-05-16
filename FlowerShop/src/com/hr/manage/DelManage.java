// 
// 
// 

package com.hr.manage;

import java.io.IOException;
import javax.servlet.ServletException;
import com.hr.dao.EASYBUY_COMMENTDao;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class DelManage extends HttpServlet
{
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        final int id = Integer.parseInt(request.getParameter("id"));
        final int num = EASYBUY_COMMENTDao.del(id);
        if (num > 0) {
            response.sendRedirect("manage-result.jsp");
        }
        else {
            response.getWriter().print("<script>alert('\u5220\u9664\u5931\u8d25!');location.href='SelManage'<script>");
        }
    }
}
