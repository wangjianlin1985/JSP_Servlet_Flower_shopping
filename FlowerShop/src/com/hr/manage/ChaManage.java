// 
// 
// 

package com.hr.manage;

import java.io.IOException;
import javax.servlet.ServletException;
import com.hr.entity.EASYBUY_COMMENT;
import java.util.ArrayList;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import com.hr.dao.EASYBUY_COMMENTDao;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class ChaManage extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final ArrayList<EASYBUY_COMMENT> list = EASYBUY_COMMENTDao.selectAll();
        req.setAttribute("list", (Object)list);
        req.getRequestDispatcher("guestbook.jsp").forward((ServletRequest)req, (ServletResponse)resp);
    }
}
