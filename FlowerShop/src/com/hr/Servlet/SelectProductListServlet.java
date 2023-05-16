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
import com.hr.util.EncodeUtil;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class SelectProductListServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        EncodeUtil.encode(req);
        final ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = EASYBUY_PRODUCT_CATEGORYDao.selectFather();
        req.setAttribute("flist", (Object)flist);
        final ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = EASYBUY_PRODUCT_CATEGORYDao.selectChild();
        req.setAttribute("clist", (Object)clist);
        final HttpSession session = req.getSession();
        final ArrayList<Integer> ids = (ArrayList<Integer>)session.getAttribute("ids");
        if (ids != null) {
            final ArrayList<EASYBUY_PRODUCT> lastlylist = EASYBUY_PRODUCTDao.selectById(ids);
            req.setAttribute("lastlylist", (Object)lastlylist);
        }
        int cpage = 1;
        final int count = 8;
        final String cp = req.getParameter("cp");
        if (cp != null) {
            cpage = Integer.parseInt(cp);
        }
        int tpage = 0;
        final String fid = req.getParameter("fid");
        final String cid = req.getParameter("cid");
        final String name = req.getParameter("name");
        ArrayList<EASYBUY_PRODUCT> list = null;
        if (fid == null && cid == null) {
            list = EASYBUY_PRODUCTDao.selectAll(cpage, count);
            req.setAttribute("title", (Object)"\u5168\u90e8\u5546\u54c1");
            tpage = EASYBUY_PRODUCTDao.totalPage(count);
        }
        if (fid != null) {
            final int id = Integer.parseInt(fid);
            list = EASYBUY_PRODUCTDao.selectAllByFid(cpage, count, id);
            tpage = EASYBUY_PRODUCTDao.totalPageByFid(count, id);
            req.setAttribute("title", (Object)EASYBUY_PRODUCT_CATEGORYDao.selectById(id).getEPC_NAME());
        }
        if (cid != null) {
            final int id = Integer.parseInt(cid);
            list = EASYBUY_PRODUCTDao.selectAllByCid(cpage, count, id);
            tpage = EASYBUY_PRODUCTDao.totalPageByCid(count, id);
            req.setAttribute("title", (Object)EASYBUY_PRODUCT_CATEGORYDao.selectById(id).getEPC_NAME());
        }
        if (name != null) {
            list = EASYBUY_PRODUCTDao.selectAllByName(name);
            tpage = EASYBUY_PRODUCTDao.totalPageByName(count, name);
            req.setAttribute("title", (Object)("\u641c\u7d22\u5546\u54c1\uff1a" + name));
        }
        req.setAttribute("list", (Object)list);
        req.setAttribute("cpage", (Object)cpage);
        req.setAttribute("tpage", (Object)tpage);
        req.setAttribute("search_words", (Object)name);
        req.setAttribute("selected_fid", (Object)fid);
        req.getRequestDispatcher("product-list.jsp").forward((ServletRequest)req, (ServletResponse)resp);
    }
}
