// 
// 
// 

package com.web.shopservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import com.hr.entity.EASYBUY_ORDER_DETAIL;
import com.hr.dao.ESDao;
import com.hr.entity.EASYBUY_USER;
import com.hr.util.EncodeUtil;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class gmServlet extends HttpServlet
{
    protected void service(final HttpServletRequest arg0, final HttpServletResponse arg1) throws ServletException, IOException {
        arg1.setContentType("text/html;charset=utf-8");
        final PrintWriter out = arg1.getWriter();
        EncodeUtil.encode(arg0);
        final HttpSession session = arg0.getSession();
        final EASYBUY_USER list = (EASYBUY_USER)session.getAttribute("name");
        final String id = list.getEU_USER_ID();
        final String name = list.getEU_USER_NAME();
        final String address = list.getEU_ADDRESS();
        final String price = arg0.getParameter("jstext");
        final String[] EP_ID = arg0.getParameterValues("spID");
        final String[] quantity = arg0.getParameterValues("number");
        final String[] sPPrice = arg0.getParameterValues("sPPrice");
        for (int i = 0; i < EP_ID.length; ++i) {
            ESDao.updateStock(Integer.parseInt(quantity[i]), Integer.parseInt(EP_ID[i]));
        }
        final int[] pprice = new int[EP_ID.length];
        for (int j = 0; j < EP_ID.length; ++j) {
            pprice[j] = Integer.parseInt(quantity[j]) * Integer.parseInt(sPPrice[j]);
        }
        final int count = ESDao.insertDD(id, name, address, Integer.parseInt(price));
        final int getSequenceId = ESDao.getSequenceId();
        for (int k = 0; k < EP_ID.length; ++k) {
            final EASYBUY_ORDER_DETAIL eod = new EASYBUY_ORDER_DETAIL(1, getSequenceId, Integer.parseInt(EP_ID[k]), Integer.parseInt(quantity[k]), pprice[k]);
            ESDao.eodInsert(eod);
        }
        final String[] esID = arg0.getParameterValues("esID");
        for (int l = 0; l < esID.length; ++l) {
            ESDao.esdelete(Integer.parseInt(esID[l]));
        }
        if (count > 0) {
            out.print("<script>");
            out.print("alert('\u8d2d\u7269\u6210\u529f');");
            out.print("location.href='shopping-result.jsp';");
            out.print("</script>");
            out.close();
        }
        else {
            out.print("<script>");
            out.print("alert('\u8d2d\u7269\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0\u9009\u62e9\u5546\u54c1');");
            out.print("location.href='ShopSelect';");
            out.print("</script>");
            out.close();
        }
    }
}
