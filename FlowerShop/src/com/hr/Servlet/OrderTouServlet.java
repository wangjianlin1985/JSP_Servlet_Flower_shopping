// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import com.hr.entity.EASYBUY_DD;
import java.util.ArrayList;
import com.hr.entity.EASYBUY_ORDER;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import com.hr.dao.EASYBUY_DDDao;
import com.hr.dao.EASYBUY_ORDERDao;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class OrderTouServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter("id");
        final EASYBUY_ORDER order = EASYBUY_ORDERDao.selectById(Integer.parseInt(id));
        final ArrayList<EASYBUY_DD> dlist = EASYBUY_DDDao.selectById(Integer.parseInt(id));
        req.setAttribute("dlist", (Object)dlist);
        req.setAttribute("order", (Object)order);
        req.getRequestDispatcher("order-modify.jsp").forward((ServletRequest)req, (ServletResponse)resp);
    }
}
