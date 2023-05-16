// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import com.hr.dao.EASYBUY_ORDERDao;
import com.hr.entity.EASYBUY_ORDER;
import com.hr.util.EncodeUtil;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class OrderDoUServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        EncodeUtil.encode(req);
        final String orderId = req.getParameter("orderId");
        final String name = req.getParameter("name");
        final String addres = req.getParameter("addres");
        final String cost = req.getParameter("cost");
        final String tatus = req.getParameter("tatus");
        final EASYBUY_ORDER order = new EASYBUY_ORDER(Integer.parseInt(orderId), "", name, addres, "", Integer.parseInt(cost), Integer.parseInt(tatus), 1);
        final int count = EASYBUY_ORDERDao.update(order);
        if (count > 0) {
            resp.sendRedirect("manage-result.jsp");
        }
        else {
            resp.setContentType("text/html;charset=utf-8");
            final PrintWriter out = resp.getWriter();
            out.print("<script>");
            out.print("alert('\u4fee\u6539\u5931\u8d25');");
            out.print("location.href='ordersel'");
            out.print("</script>");
            out.close();
        }
    }
}
