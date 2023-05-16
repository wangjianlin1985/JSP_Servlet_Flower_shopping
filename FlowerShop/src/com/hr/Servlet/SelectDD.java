// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import com.hr.entity.EASYBUY_Ddan;
import javax.servlet.http.HttpSession;
import com.hr.entity.EASYBUY_NEWS;
import com.hr.entity.EASYBUY_PRODUCT;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import com.hr.dao.EASYBUY_DdanDao;
import com.hr.util.EncodeUtil;
import java.util.ArrayList;
import com.hr.dao.EASYBUY_NEWSDao;
import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class SelectDD extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        final ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = EASYBUY_PRODUCT_CATEGORYDao.selectFather();
        req.setAttribute("flist", (Object)flist);
        final ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = EASYBUY_PRODUCT_CATEGORYDao.selectChild();
        req.setAttribute("clist", (Object)clist);
        final ArrayList<EASYBUY_PRODUCT> tlist = EASYBUY_PRODUCTDao.selectAllByT();
        req.setAttribute("tlist", (Object)tlist);
        final ArrayList<EASYBUY_PRODUCT> hlist = EASYBUY_PRODUCTDao.selectAllByHot();
        req.setAttribute("hlist", (Object)hlist);
        final ArrayList<EASYBUY_NEWS> nlist = EASYBUY_NEWSDao.selectAll();
        req.setAttribute("nlist", (Object)nlist);
        final HttpSession session = req.getSession();
        final ArrayList<Integer> ids = (ArrayList<Integer>)session.getAttribute("ids");
        if (ids != null) {
            final ArrayList<EASYBUY_PRODUCT> lastlylist = EASYBUY_PRODUCTDao.selectById(ids);
            req.setAttribute("lastlylist", (Object)lastlylist);
        }
        EncodeUtil.encode(req);
        final String dd = req.getParameter("dd");
        final ArrayList<EASYBUY_Ddan> dan = EASYBUY_DdanDao.selectById(dd);
        req.setAttribute("dan", (Object)dan);
        req.getRequestDispatcher("Dan.jsp").forward((ServletRequest)req, (ServletResponse)resp);
    }
}
