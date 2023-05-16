// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class ProductClassDelServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final int id = Integer.parseInt(req.getParameter("id"));
        EASYBUY_PRODUCT_CATEGORYDao.del(id);
        resp.sendRedirect("productClass");
    }
}
