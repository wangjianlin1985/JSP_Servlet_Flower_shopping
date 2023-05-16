// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import com.hr.util.EncodeUtil;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class DoProductClassAddServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        EncodeUtil.encode(req);
        final int fid = Integer.parseInt(req.getParameter("parentId"));
        req.setCharacterEncoding("utf-8");
        final String name = req.getParameter("className");
        if (fid == 0) {
            final EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(0, name, 0);
            EASYBUY_PRODUCT_CATEGORYDao.insertOnFather(pc);
        }
        else {
            final EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(0, name, fid);
            EASYBUY_PRODUCT_CATEGORYDao.insert(pc);
        }
        resp.sendRedirect("productClass");
    }
}
