// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import com.hr.entity.EASYBUY_ORDER;
import java.util.ArrayList;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import java.net.URLEncoder;
import com.hr.dao.EASYBUY_ORDERDao;
import com.hr.util.EncodeUtil;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class OrderSelServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        int cpage = 1;
        final int count = 10;
        EncodeUtil.encode(req);
        final String cp = req.getParameter("cp");
        final String id = req.getParameter("orderId");
        String name = req.getParameter("userName");
        name = ((name == null) ? "" : name);
        if (cp != null) {
            cpage = Integer.parseInt(cp);
        }
        final int tpage = EASYBUY_ORDERDao.totalPage(count, id, name);
        final ArrayList<EASYBUY_ORDER> order = EASYBUY_ORDERDao.selectAll(cpage, count, id, name);
        req.setAttribute("order", (Object)order);
        req.setAttribute("cpage", (Object)cpage);
        req.setAttribute("tpage", (Object)tpage);
        req.setAttribute("orderId", (Object)id);
        req.setAttribute("userName", (Object)URLEncoder.encode(name, "utf-8"));
        req.getRequestDispatcher("order.jsp").forward((ServletRequest)req, (ServletResponse)resp);
    }
}
