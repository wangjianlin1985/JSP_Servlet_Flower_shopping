// 
// 
// 

package com.hr.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import com.hr.entity.EASYBUY_NEWS;
import java.util.ArrayList;

public class EASYBUY_NEWSDao
{
    public static ArrayList<EASYBUY_NEWS> selectAll() {
        final ArrayList<EASYBUY_NEWS> list = new ArrayList<EASYBUY_NEWS>();
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_NEWS");
            rs = ps.executeQuery();
            while (rs.next()) {
                final EASYBUY_NEWS c = new EASYBUY_NEWS(rs.getInt("EN_ID"), rs.getString("EN_TITLE"), rs.getString("EN_CONTENT"), rs.getString("EN_CREATE_TIME"));
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
    
    public static EASYBUY_NEWS selectById(final int id) {
        EASYBUY_NEWS c = null;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_NEWS where EN_ID=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new EASYBUY_NEWS(rs.getInt("EN_ID"), rs.getString("EN_TITLE"), rs.getString("EN_CONTENT"), rs.getString("EN_CREATE_TIME"));
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
    
    public static ArrayList<EASYBUY_NEWS> selectAll(final int cpage, final int count) {
        final ArrayList<EASYBUY_NEWS> list = new ArrayList<EASYBUY_NEWS>();
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_NEWS order by EN_ID desc limit ?, ?");
            ps.setInt(1, count * (cpage - 1));
            ps.setInt(2, count);
            rs = ps.executeQuery();
            while (rs.next()) {
                final EASYBUY_NEWS c = new EASYBUY_NEWS(rs.getInt("EN_ID"), rs.getString("EN_TITLE"), rs.getString("EN_CONTENT"), rs.getString("EN_CREATE_TIME"));
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
    
    public static int totalPage(final int count) {
        int tpage = 1;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select count(*) from EASYBUY_NEWS");
            rs = ps.executeQuery();
            while (rs.next()) {
                final int sum = rs.getInt(1);
                if (sum % count == 0) {
                    tpage = sum / count;
                }
                else {
                    tpage = sum / count + 1;
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return tpage;
        }
        finally {
            Basedao.closeall(rs, ps, conn);
        }
        Basedao.closeall(rs, ps, conn);
        return tpage;
    }
    
    public static int insert(final EASYBUY_NEWS n) {
        final String sql = "insert into EASYBUY_NEWS values(null,?,?,NOW())";
        final Object[] params = { n.getEN_TITLE(), n.getEN_CONTENT() };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int update(final EASYBUY_NEWS n) {
        final String sql = "update EASYBUY_NEWS set EN_TITLE=?,EN_CONTENT=? where EN_ID=?";
        final Object[] params = { n.getEN_TITLE(), n.getEN_CONTENT(), n.getEN_ID() };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int del(final int id) {
        final String sql = "delete from EASYBUY_NEWS where EN_ID=?";
        final Object[] params = { id };
        return Basedao.exectuIUD(sql, params);
    }
}
