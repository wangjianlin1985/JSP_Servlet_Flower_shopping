// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import java.util.ArrayList;
import com.hr.entity.EASYBUY_NEWS;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import com.hr.dao.EASYBUY_NEWSDao;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class NewsSelectServlet2 extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter("id");
        EASYBUY_NEWS n = null;
        if (id != null) {
            n = EASYBUY_NEWSDao.selectById(Integer.parseInt(id));
        }
        req.setAttribute("n", (Object)n);
        final ArrayList<EASYBUY_NEWS> nlist = EASYBUY_NEWSDao.selectAll();
        req.setAttribute("nlist", (Object)nlist);
        req.getRequestDispatcher("news-view.jsp").forward((ServletRequest)req, (ServletResponse)resp);
    }
}
