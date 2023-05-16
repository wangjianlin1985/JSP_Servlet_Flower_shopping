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

public class DoProductClassUpdateServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        EncodeUtil.encode(req);
        final int id = Integer.parseInt(req.getParameter("id"));
        final int fid = Integer.parseInt(req.getParameter("parentId"));
        final String name = req.getParameter("className");
        EASYBUY_PRODUCT_CATEGORY pc;
        if (fid == 0) {
            pc = new EASYBUY_PRODUCT_CATEGORY(id, name, id);
        }
        else {
            pc = new EASYBUY_PRODUCT_CATEGORY(id, name, fid);
        }
        EASYBUY_PRODUCT_CATEGORYDao.update(pc);
        resp.sendRedirect("productClass");
    }
}
