// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import com.hr.dao.EASYBUY_USERDao;
import com.hr.util.EncodeUtil;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class UsernameCheckServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        EncodeUtil.encode(req);
        resp.setContentType("text/html;charset=utf-8");
        final String name = req.getParameter("name");
        final int count = EASYBUY_USERDao.selectByName(name);
        final PrintWriter out = resp.getWriter();
        if (count > 0) {
            out.print("false");
        }
        else {
            out.print("true");
        }
        out.close();
    }
}
