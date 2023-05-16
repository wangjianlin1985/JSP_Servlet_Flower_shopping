// 
// 
// 

package com.hr.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;
import java.awt.Graphics2D;
import java.io.OutputStream;
import java.awt.image.RenderedImage;
import javax.imageio.ImageIO;
import java.awt.Font;
import java.util.Random;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class UserNumServlet extends HttpServlet
{
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final int width = 120;
        final int height = 60;
        final BufferedImage img = new BufferedImage(width, height, 1);
        final Graphics2D g = img.createGraphics();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.YELLOW);
        final Random rand = new Random();
        for (int i = 0; i < 15; ++i) {
            final int x1 = rand.nextInt(width);
            final int y1 = rand.nextInt(width);
            final int x2 = rand.nextInt(width);
            final int y2 = rand.nextInt(width);
            g.drawLine(x1, y1, x2, y2);
        }
        final Font f = new Font("Times New Roman", 1, 50);
        g.setFont(f);
        int red = 0;
        int green = 0;
        int blue = 0;
        String code = "";
        for (int j = 0; j < 4; ++j) {
            red = rand.nextInt(255);
            green = rand.nextInt(255);
            blue = rand.nextInt(255);
            final Color c = new Color(red, green, blue);
            g.setColor(c);
            final int num = rand.nextInt(10);
            code = String.valueOf(code) + num;
            g.drawString(new StringBuilder(String.valueOf(num)).toString(), j * 20 + 20, 49);
        }
        final HttpSession session = req.getSession();
        session.setAttribute("syscode", (Object)code);
        final ServletOutputStream out = resp.getOutputStream();
        ImageIO.write(img, "jpg", (OutputStream)out);
    }
}
