// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import com.hr.entity.EASYBUY_USER;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import com.hr.dao.EASYBUY_USERDao;
import com.hr.util.EncodeUtil;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class UserUpdateServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        EncodeUtil.encode(req);
        resp.setContentType("text/html;charset=utf-8");
        final String id = req.getParameter("id");
        final EASYBUY_USER user = EASYBUY_USERDao.selectById(id);
        req.setAttribute("user", (Object)user);
        req.getRequestDispatcher("user-modify.jsp").forward((ServletRequest)req, (ServletResponse)resp);
    }
}
