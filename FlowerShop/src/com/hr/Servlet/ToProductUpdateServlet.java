// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import java.util.ArrayList;
import com.hr.entity.EASYBUY_PRODUCT;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.dao.EASYBUY_PRODUCTDao;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class ToProductUpdateServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter("id");
        final EASYBUY_PRODUCT p = EASYBUY_PRODUCTDao.selectById(Integer.parseInt(id));
        req.setAttribute("p", (Object)p);
        final ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = EASYBUY_PRODUCT_CATEGORYDao.selectFather();
        req.setAttribute("flist", (Object)flist);
        final ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = EASYBUY_PRODUCT_CATEGORYDao.selectChild();
        req.setAttribute("clist", (Object)clist);
        req.getRequestDispatcher("product-modify.jsp").forward((ServletRequest)req, (ServletResponse)resp);
    }
}
