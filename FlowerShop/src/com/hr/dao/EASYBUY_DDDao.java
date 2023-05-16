// 
// 
// 

package com.hr.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import com.hr.entity.EASYBUY_DD;
import java.util.ArrayList;

public class EASYBUY_DDDao
{
    public static ArrayList<EASYBUY_DD> selectById(final int id) {
        final ArrayList<EASYBUY_DD> dd = new ArrayList<EASYBUY_DD>();
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_ORDER eo,EASYBUY_ORDER_DETAIL eod,EASYBUY_PRODUCT ep where eo.eo_id=? and eod.eo_id=eo.eo_id and eod.ep_id= ep.ep_id");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                final EASYBUY_DD d = new EASYBUY_DD(rs.getString("EP_NAME"), rs.getString("EP_FILE_NAME"), rs.getInt("EP_PRICE"), rs.getInt("EOD_QUANTITY"), rs.getInt("EP_STOCK"));
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
