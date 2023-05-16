// 
// 
// 

package com.web.shopservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import com.hr.entity.eb_shop;
import com.hr.dao.ESDao;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class UpdateServlet extends HttpServlet
{
    protected void service(final HttpServletRequest arg0, final HttpServletResponse arg1) throws ServletException, IOException {
        arg1.setContentType("text/html;charset=utf-8");
        final PrintWriter out = arg1.getWriter();
        final String str1 = arg0.getParameter("pid");
        final String str2 = arg0.getParameter("action");
        final String str3 = arg0.getParameter("getvalue");
        if (str2.equals("jia")) {
            ESDao.updateJia(Integer.parseInt(str1));
        }
        if (str2.equals("jian")) {
            ESDao.updateJian(Integer.parseInt(str1));
        }
        if (str2.equals("closeText")) {
            final eb_shop es = new eb_shop(Integer.parseInt(str1), "1", "1", 1, Integer.parseInt(str3), 1, 1, "1", 1);
            ESDao.updateClose(es);
        }
        if (str2.equals("delText")) {
            ESDao.getDeleteDD(Integer.parseInt(str1));
        }
        arg1.sendRedirect("ShopSelect");
    }
}
