// 
// 
// 

package com.hr.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import com.hr.entity.EASYBUY_Ddan;
import java.util.ArrayList;

public class EASYBUY_DdanDao
{
    public static ArrayList<EASYBUY_Ddan> selectById(final String id) {
        final ArrayList<EASYBUY_Ddan> dd = new ArrayList<EASYBUY_Ddan>();
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_ORDER eo,EASYBUY_ORDER_DETAIL eod,EASYBUY_PRODUCT ep where eo.eo_user_id=? and eod.eo_id=eo.eo_id and eod.ep_id= ep.ep_id order by eo.eo_id desc");
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                final EASYBUY_Ddan d = new EASYBUY_Ddan(rs.getInt("EO_ID"), rs.getString("EO_USER_ID"), rs.getString("EP_NAME"), rs.getString("EP_FILE_NAME"), rs.getInt("EP_PRICE"), rs.getInt("EOD_QUANTITY"), rs.getInt("EP_STOCK"));
                dd.add(d);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return dd;
        }
        finally {
            Basedao.closeall(rs, ps, conn);
        }
        Basedao.closeall(rs, ps, conn);
        return dd;
    }
}
