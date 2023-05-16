// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class CheckUserNumServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String num = req.getParameter("num");
        final HttpSession session = req.getSession();
        final String sysCode = (String)session.getAttribute("syscode");
        final PrintWriter out = resp.getWriter();
        if (sysCode.equals(num)) {
            out.print("true");
        }
        else {
            out.print("false");
        }
        out.close();
    }
}
