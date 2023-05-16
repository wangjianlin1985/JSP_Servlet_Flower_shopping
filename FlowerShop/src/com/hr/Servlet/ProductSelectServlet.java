// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import com.hr.entity.EASYBUY_PRODUCT;
import java.util.ArrayList;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import com.hr.dao.EASYBUY_PRODUCTDao;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class ProductSelectServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        int cpage = 1;
        final int count = 5;
        final String cp = req.getParameter("cp");
        if (cp != null) {
            cpage = Integer.parseInt(cp);
        }
        int tpage = 0;
        final ArrayList<EASYBUY_PRODUCT> eplist = EASYBUY_PRODUCTDao.selectAll(cpage, count);
        tpage = EASYBUY_PRODUCTDao.totalPage(count);
        req.setAttribute("eplist", (Object)eplist);
        req.setAttribute("cpage", (Object)cpage);
        req.setAttribute("tpage", (Object)tpage);
        req.getRequestDispatcher("product.jsp").forward((ServletRequest)req, (ServletResponse)resp);
    }
}
