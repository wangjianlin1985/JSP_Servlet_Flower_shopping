// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import com.hr.dao.EASYBUY_PRODUCTDao;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class ProductDelServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter("id");
        final int count = EASYBUY_PRODUCTDao.del(Integer.parseInt(id));
        if (count > 0) {
            req.getRequestDispatcher("productSelect").forward((ServletRequest)req, (ServletResponse)resp);
        }
    }
}
