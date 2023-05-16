// 
// 
// 

package com.hr.util;

import java.util.Iterator;
import java.util.Collection;
import java.util.Map;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;

public class EncodeUtil
{
    public static void encode(final HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
        }
        catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        final Map map = request.getParameterMap();
        final Collection<String[]> vs = (Collection<String[]>)map.values();
        for (final String[] v : vs) {
            for (int i = 0; i < v.length; ++i) {
                try {
                    v[i] = new String(v[i].getBytes("ISO8859-1"), "UTF-8");
                }
                catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
