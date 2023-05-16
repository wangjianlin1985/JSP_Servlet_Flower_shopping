// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.entity.EASYBUY_PRODUCT;
import com.jspsmart.upload.SmartUploadException;
import com.jspsmart.upload.SmartUpload;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class DoProductAddServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final SmartUpload su = new SmartUpload();
        su.initialize(this.getServletConfig(), req, resp);
        try {
            su.upload();
        }
        catch (SmartUploadException e) {
            e.printStackTrace();
        }
        final Files fs = su.getFiles();
        final File f = fs.getFile(0);
        final String fname = f.getFileName();
        try {
            su.save("images/product");
        }
        catch (SmartUploadException e2) {
            e2.printStackTrace();
        }
        final Request req2 = su.getRequest();
        final String pname = req2.getParameter("productName");
        final String id = req2.getParameter("parentId");
        final String price = req2.getParameter("productPrice");
        final String desc = req2.getParameter("productDesc");
        final String stock = req2.getParameter("productStock");
        EASYBUY_PRODUCT p = null;
        if (price != null && stock != null && id != null) {
            p = new EASYBUY_PRODUCT(0, pname, desc, Integer.parseInt(price), Integer.parseInt(stock), Integer.parseInt(id.split("-")[0]), Integer.parseInt(id.split("-")[1]), fname);
        }
        int count = 0;
        if (p != null) {
            count = EASYBUY_PRODUCTDao.insert(p);
        }
        req.getRequestDispatcher("productSelect").forward((ServletRequest)req, (ServletResponse)resp);
    }
}
