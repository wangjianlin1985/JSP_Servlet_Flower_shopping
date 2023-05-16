// 
// 
// 

package com.web.shopservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import com.hr.entity.eb_shop;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import com.hr.dao.ESDao;
import com.hr.entity.EASYBUY_USER;
import com.hr.util.EncodeUtil;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class ShopSelect extends HttpServlet
{
    protected void service(final HttpServletRequest arg0, final HttpServletResponse arg1) throws ServletException, IOException {
        EncodeUtil.encode(arg0);
        arg1.setContentType("text/html;charset=utf-8");
        final PrintWriter out = arg1.getWriter();
        final HttpSession session = arg0.getSession();
        final EASYBUY_USER userCZ = (EASYBUY_USER)session.getAttribute("name");
        if (userCZ != null) {
            final EASYBUY_USER eu = (EASYBUY_USER)session.getAttribute("name");
            final String id = eu.getEU_USER_ID();
            final ArrayList<eb_shop> list = ESDao.getShop(id);
            arg0.setAttribute("shoplist", (Object)list);
            arg0.getRequestDispatcher("shopping.jsp").forward((ServletRequest)arg0, (ServletResponse)arg1);
        }
        else {
            out.print("<script>");
            out.print("alert('\u8bf7\u5148\u767b\u5f55');");
            out.print("location.href='login.jsp';");
            out.print("</script>");
            out.close();
        }
    }
}
