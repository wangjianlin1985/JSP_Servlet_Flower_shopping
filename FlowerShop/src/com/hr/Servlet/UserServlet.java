// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import com.hr.entity.EASYBUY_USER;
import java.util.ArrayList;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import com.hr.dao.EASYBUY_USERDao;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class UserServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        int cpage = 1;
        final int count = 15;
        final String cp = req.getParameter("cp");
        if (cp != null) {
            cpage = Integer.parseInt(cp);
        }
        final int tpage = EASYBUY_USERDao.totalPage(count);
        final ArrayList<EASYBUY_USER> list = EASYBUY_USERDao.selectAll(cpage, count);
        req.setAttribute("userlist", (Object)list);
        req.setAttribute("cpage", (Object)cpage);
        req.setAttribute("tpage", (Object)tpage);
        req.getRequestDispatcher("user.jsp").forward((ServletRequest)req, (ServletResponse)resp);
    }
}
