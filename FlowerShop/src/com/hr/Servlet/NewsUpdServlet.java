// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import com.hr.entity.EASYBUY_NEWS;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import com.hr.dao.EASYBUY_NEWSDao;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class NewsUpdServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter("id");
        final EASYBUY_NEWS news = EASYBUY_NEWSDao.selectById(Integer.parseInt(id));
        req.setAttribute("news", (Object)news);
        req.getRequestDispatcher("news-modify.jsp").forward((ServletRequest)req, (ServletResponse)resp);
    }
}
