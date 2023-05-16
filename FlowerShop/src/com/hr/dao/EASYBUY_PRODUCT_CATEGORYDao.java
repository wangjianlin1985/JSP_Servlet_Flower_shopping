// 
// 
// 

package com.hr.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import java.util.ArrayList;

public class EASYBUY_PRODUCT_CATEGORYDao
{
    public static ArrayList<EASYBUY_PRODUCT_CATEGORY> selectAll() {
        final ArrayList<EASYBUY_PRODUCT_CATEGORY> list = new ArrayList<EASYBUY_PRODUCT_CATEGORY>();
        ResultSet rs = null;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_PRODUCT_CATEGORY");
            rs = ps.executeQuery();
            while (rs.next()) {
                final EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(rs.getInt("EPC_ID"), rs.getString("EPC_NAME"), rs.getInt("EPC_PARENT_ID"));
                list.add(pc);
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
    
    public static EASYBUY_PRODUCT_CATEGORY selectById(final int id) {
        EASYBUY_PRODUCT_CATEGORY pc = null;
        ResultSet rs = null;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_PRODUCT_CATEGORY where EPC_ID=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                pc = new EASYBUY_PRODUCT_CATEGORY(rs.getInt("EPC_ID"), rs.getString("EPC_NAME"), rs.getInt("EPC_PARENT_ID"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return pc;
        }
        finally {
            Basedao.closeall(rs, ps, conn);
        }
        Basedao.closeall(rs, ps, conn);
        return pc;
    }
    
    public static int insert(final EASYBUY_PRODUCT_CATEGORY pc) {
        final String sql = "insert into EASYBUY_PRODUCT_CATEGORY values(null,?,?)";
        final Object[] params = { pc.getEPC_NAME(), pc.getEPC_PARENT_ID() };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int insertOnFather(final EASYBUY_PRODUCT_CATEGORY pc) {
        final String sql = "insert into EASYBUY_PRODUCT_CATEGORY values(null,?,0)";
        final Object[] params = { pc.getEPC_NAME() };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int update(final EASYBUY_PRODUCT_CATEGORY pc) {
        final String sql = "update EASYBUY_PRODUCT_CATEGORY set EPC_NAME=?,EPC_PARENT_ID=? where EPC_ID=?";
        final Object[] params = { pc.getEPC_NAME(), pc.getEPC_PARENT_ID(), pc.getEPC_ID() };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int del(final int id) {
        final String sql = "delete from EASYBUY_PRODUCT_CATEGORY where EPC_ID=?";
        final Object[] params = { id };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static ArrayList<EASYBUY_PRODUCT_CATEGORY> selectFather() {
        final ArrayList<EASYBUY_PRODUCT_CATEGORY> list = new ArrayList<EASYBUY_PRODUCT_CATEGORY>();
        ResultSet rs = null;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_PRODUCT_CATEGORY where EPC_PARENT_ID = 0");
            rs = ps.executeQuery();
            while (rs.next()) {
                final EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(rs.getInt("EPC_ID"), rs.getString("EPC_NAME"), rs.getInt("EPC_PARENT_ID"));
                list.add(pc);
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
    
    public static ArrayList<EASYBUY_PRODUCT_CATEGORY> selectChild() {
        final ArrayList<EASYBUY_PRODUCT_CATEGORY> list = new ArrayList<EASYBUY_PRODUCT_CATEGORY>();
        ResultSet rs = null;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_PRODUCT_CATEGORY where EPC_ID!=EPC_PARENT_ID");
            rs = ps.executeQuery();
            while (rs.next()) {
                final EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(rs.getInt("EPC_ID"), rs.getString("EPC_NAME"), rs.getInt("EPC_PARENT_ID"));
                list.add(pc);
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
}
