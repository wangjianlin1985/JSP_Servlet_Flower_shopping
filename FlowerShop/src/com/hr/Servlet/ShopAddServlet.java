// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import com.hr.entity.EASYBUY_PRODUCT;
import com.hr.entity.eb_shop;
import com.hr.dao.ESDao;
import com.hr.entity.EASYBUY_USER;
import com.hr.dao.EASYBUY_PRODUCTDao;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class ShopAddServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        EASYBUY_PRODUCT p = null;
        final String pid = req.getParameter("id");
        final String count = req.getParameter("count");
        if (pid != null) {
            p = EASYBUY_PRODUCTDao.selectById(Integer.parseInt(pid));
        }
        resp.setContentType("text/html;charset=utf-8");
        final PrintWriter out = resp.getWriter();
        final HttpSession session = req.getSession();
        final EASYBUY_USER user = (EASYBUY_USER)session.getAttribute("name");
        if (user != null) {
            final EASYBUY_USER eu = (EASYBUY_USER)session.getAttribute("name");
            final String id = eu.getEU_USER_ID();
            final ArrayList<eb_shop> list = ESDao.getShop(id);
            req.setAttribute("shoplist", (Object)list);
            final String uid = user.getEU_USER_ID();
            final int valid = 1;
            final eb_shop sp = new eb_shop(0, p.getEP_FILE_NAME(), p.getEP_NAME(), p.getEP_PRICE(), Integer.parseInt(count), p.getEP_STOCK(), p.getEP_ID(), uid, valid);
            ESDao.insert(sp);
            resp.sendRedirect("ShopSelect");
            return;
        }
        out.print("<script>");
        out.print("alert('\u8bf7\u5148\u767b\u5f55');");
        out.print("location.href='login.jsp';");
        out.print("</script>");
        out.close();
    }
}
