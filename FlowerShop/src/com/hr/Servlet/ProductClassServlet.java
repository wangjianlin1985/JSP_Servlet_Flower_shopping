// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import java.util.ArrayList;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class ProductClassServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final ArrayList<EASYBUY_PRODUCT_CATEGORY> epclist = EASYBUY_PRODUCT_CATEGORYDao.selectAll();
        req.setAttribute("epclist", (Object)epclist);
        req.getRequestDispatcher("productClass.jsp").forward((ServletRequest)req, (ServletResponse)resp);
    }
}
