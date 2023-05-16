// 
// 
// 

package com.hr.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import com.hr.entity.EASYBUY_ORDER_DETAIL;
import java.util.ArrayList;

public class EASYBUY_ORDER_DETAILDao
{
    public static ArrayList<EASYBUY_ORDER_DETAIL> selectAll() {
        final ArrayList<EASYBUY_ORDER_DETAIL> list = new ArrayList<EASYBUY_ORDER_DETAIL>();
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_ORDER_DETAIL");
            rs = ps.executeQuery();
            while (rs.next()) {
                final EASYBUY_ORDER_DETAIL c = new EASYBUY_ORDER_DETAIL(rs.getInt("EOD_ID"), rs.getInt("EO_ID"), rs.getInt("EP_ID"), rs.getInt("EOD_QUANTITY"), rs.getInt("EOD_COST"));
                list.add(c);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        finally {
            Basedao.closeall(rs, ps, conn);
        }
        Basedao.closeall(rs, ps, conn);
        return list;
    }
    
    public static EASYBUY_ORDER_DETAIL selectById(final int id) {
        EASYBUY_ORDER_DETAIL c = null;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_ORDER_DETAIL where EOD_ID=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new EASYBUY_ORDER_DETAIL(rs.getInt("EOD_ID"), rs.getInt("EO_ID"), rs.getInt("EP_ID"), rs.getInt("EOD_QUANTITY"), rs.getInt("EOD_COST"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return c;
        }
        finally {
            Basedao.closeall(rs, ps, conn);
        }
        Basedao.closeall(rs, ps, conn);
        return c;
    }
    
    public static int insert(final EASYBUY_ORDER_DETAIL od) {
        final String sql = "insert into EASYBUY_ORDER_DETAIL values(null,?,?,?,?)";
        final Object[] params = { od.getEO_ID(), od.getEP_ID(), od.getEOD_QUANTITY(), od.getEOD_COST() };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int update(final EASYBUY_ORDER_DETAIL od) {
        final String sql = "update EASYBUY_ORDER_DETAIL set EO_ID=?,EP_ID=?,EOD_QUANTITY=?,EOD_COST=? where EOD_ID=?";
        final Object[] params = { od.getEO_ID(), od.getEP_ID(), od.getEOD_QUANTITY(), od.getEOD_ID() };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int del(final int id) {
        final String sql = "delete from EASYBUY_ORDER_DETAIL where EOD_ID=?";
        final Object[] params = { id };
        return Basedao.exectuIUD(sql, params);
    }
}
