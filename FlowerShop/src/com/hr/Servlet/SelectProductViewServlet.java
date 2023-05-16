// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import com.hr.entity.EASYBUY_PRODUCT;
import javax.servlet.http.HttpSession;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import com.hr.dao.EASYBUY_PRODUCTDao;
import java.util.ArrayList;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class SelectProductViewServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = EASYBUY_PRODUCT_CATEGORYDao.selectFather();
        req.setAttribute("flist", (Object)flist);
        final ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = EASYBUY_PRODUCT_CATEGORYDao.selectChild();
        req.setAttribute("clist", (Object)clist);
        final String id = req.getParameter("id");
        final HttpSession session = req.getSession();
        ArrayList<Integer> ids = (ArrayList<Integer>)session.getAttribute("ids");
        if (ids == null) {
            ids = new ArrayList<Integer>();
        }
        if (ids.size() >= 5) {
            ids.remove(0);
        }
        if (id != null && !ids.contains(Integer.parseInt(id))) {
            ids.add(Integer.parseInt(id));
        }
        session.setAttribute("ids", (Object)ids);
        ids = (ArrayList<Integer>)session.getAttribute("ids");
        if (ids != null) {
            final ArrayList<EASYBUY_PRODUCT> lastlylist = EASYBUY_PRODUCTDao.selectById(ids);
            req.setAttribute("lastlylist", (Object)lastlylist);
        }
        EASYBUY_PRODUCT p = null;
        if (id != null) {
            p = EASYBUY_PRODUCTDao.selectById(Integer.parseInt(id));
        }
        req.setAttribute("p", (Object)p);
        req.getRequestDispatcher("product-view.jsp").forward((ServletRequest)req, (ServletResponse)resp);
    }
}
