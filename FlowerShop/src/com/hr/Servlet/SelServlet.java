// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import com.hr.entity.EASYBUY_COMMENT;
import java.util.ArrayList;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.dao.EASYBUY_COMMENTDao;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class SelServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final ArrayList<EASYBUY_COMMENT> list = EASYBUY_COMMENTDao.selectAll();
        final ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = EASYBUY_PRODUCT_CATEGORYDao.selectFather();
        req.setAttribute("flist", (Object)flist);
        final ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = EASYBUY_PRODUCT_CATEGORYDao.selectChild();
        req.setAttribute("clist", (Object)clist);
        req.setAttribute("list", (Object)list);
        req.getRequestDispatcher("guestbook.jsp").forward((ServletRequest)req, (ServletResponse)resp);
    }
}
