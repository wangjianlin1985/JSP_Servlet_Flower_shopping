// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import com.hr.entity.EASYBUY_NEWS;
import java.util.ArrayList;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import com.hr.dao.EASYBUY_NEWSDao;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class NewsselectServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        int cpage = 1;
        final int count = 10;
        final String cp = req.getParameter("cp");
        if (cp != null) {
            cpage = Integer.parseInt(cp);
        }
        final int tpage = EASYBUY_NEWSDao.totalPage(count);
        final ArrayList<EASYBUY_NEWS> newslist = EASYBUY_NEWSDao.selectAll(cpage, count);
        req.setAttribute("newslist", (Object)newslist);
        req.setAttribute("cpage", (Object)cpage);
        req.setAttribute("tpage", (Object)tpage);
        req.getRequestDispatcher("news.jsp").forward((ServletRequest)req, (ServletResponse)resp);
    }
}
