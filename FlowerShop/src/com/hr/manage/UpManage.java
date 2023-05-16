// 
// 
// 

package com.hr.manage;

import java.io.IOException;
import javax.servlet.ServletException;
import com.hr.dao.EASYBUY_COMMENTDao;
import com.hr.entity.EASYBUY_COMMENT;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class UpManage extends HttpServlet
{
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        final int id = Integer.parseInt(request.getParameter("orderId"));
        final String name = request.getParameter("name");
        final String replyContent = request.getParameter("replyContent");
        final String Content = request.getParameter("Content");
        final Date date = new Date();
        System.out.println(Content);
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String replyTime = sdf.format(date);
        final EASYBUY_COMMENT comment = new EASYBUY_COMMENT(id, Content, replyTime, replyContent, replyTime, name);
        comment.setEC_ID(id);
        final int num = EASYBUY_COMMENTDao.update(comment);
        if (num > 0) {
            response.sendRedirect("manage-result.jsp");
        }
        else {
            response.getWriter().print("<script>alert('\u66f4\u65b0\u5931\u8d25\uff01');history.back();</script>");
        }
    }
}
