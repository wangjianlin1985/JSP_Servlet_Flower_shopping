// 
// 
// 

package com.hr.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import com.hr.entity.EASYBUY_USER;
import java.util.ArrayList;

public class EASYBUY_USERDao
{
    public static ArrayList<EASYBUY_USER> selectAll(final int cpage, final int count) {
        final ArrayList<EASYBUY_USER> list = new ArrayList<EASYBUY_USER>();
        ResultSet rs = null;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_USER order by EU_BIRTHDAY desc limit ?, ?");
            ps.setInt(1, count * (cpage - 1));
            ps.setInt(2, count);
            rs = ps.executeQuery();
            while (rs.next()) {
                final EASYBUY_USER u = new EASYBUY_USER(rs.getString("EU_USER_ID"), rs.getString("EU_USER_NAME"), rs.getString("EU_PASSWORD"), rs.getString("EU_SEX"), rs.getString("EU_BIRTHDAY"), rs.getString("EU_IDENTITY_CODE"), rs.getString("EU_EMAIL"), rs.getString("EU_MOBILE"), rs.getString("EU_ADDRESS"), rs.getInt("EU_STATUS"));
                list.add(u);
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
    
    public static ArrayList<EASYBUY_USER> selectAll() {
        final ArrayList<EASYBUY_USER> list = new ArrayList<EASYBUY_USER>();
        ResultSet rs = null;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_USER");
            rs = ps.executeQuery();
            while (rs.next()) {
                final EASYBUY_USER u = new EASYBUY_USER(rs.getString("EU_USER_ID"), rs.getString("EU_USER_NAME"), rs.getString("EU_PASSWORD"), rs.getString("EU_SEX"), rs.getString("EU_BIRTHDAY"), rs.getString("EU_IDENTITY_CODE"), rs.getString("EU_EMAIL"), rs.getString("EU_MOBILE"), rs.getString("EU_ADDRESS"), rs.getInt("EU_STATUS"));
                list.add(u);
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
    
    public static EASYBUY_USER selectById(final String id) {
        EASYBUY_USER u = null;
        ResultSet rs = null;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select m.*,DATE_FORMAT(m.eu_birthday,'%Y-%m-%d')birthday from EASYBUY_USER m where EU_USER_ID=?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                u = new EASYBUY_USER(rs.getString("EU_USER_ID"), rs.getString("EU_USER_NAME"), rs.getString("EU_PASSWORD"), rs.getString("EU_SEX"), rs.getString("birthday"), rs.getString("EU_IDENTITY_CODE"), rs.getString("EU_EMAIL"), rs.getString("EU_MOBILE"), rs.getString("EU_ADDRESS"), rs.getInt("EU_STATUS"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return u;
        }
        finally {
            Basedao.closeall(rs, ps, conn);
        }
        Basedao.closeall(rs, ps, conn);
        return u;
    }
    
    public static int selectByName(final String id) {
        int count = 0;
        ResultSet rs = null;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select count(*) from EASYBUY_USER where EU_USER_ID=?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return count;
        }
        finally {
            Basedao.closeall(rs, ps, conn);
        }
        Basedao.closeall(rs, ps, conn);
        return count;
    }
    
    public static int selectByNM(final String name, final String pwd) {
        int count = 0;
        ResultSet rs = null;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select count(*) from EASYBUY_USER where EU_USER_ID=? and EU_PASSWORD=?");
            ps.setString(1, name);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return count;
        }
        finally {
            Basedao.closeall(rs, ps, conn);
        }
        Basedao.closeall(rs, ps, conn);
        return count;
    }
    
    public static EASYBUY_USER selectAdmin(final String name, final String pwd) {
        EASYBUY_USER user = null;
        ResultSet rs = null;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_USER where EU_USER_ID=? and EU_PASSWORD=?");
            ps.setString(1, name);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new EASYBUY_USER(rs.getString("EU_USER_ID"), rs.getString("EU_USER_NAME"), rs.getString("EU_PASSWORD"), rs.getString("EU_SEX"), rs.getString("EU_BIRTHDAY"), rs.getString("EU_IDENTITY_CODE"), rs.getString("EU_EMAIL"), rs.getString("EU_MOBILE"), rs.getString("EU_ADDRESS"), rs.getInt("EU_STATUS"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return user;
        }
        finally {
            Basedao.closeall(rs, ps, conn);
        }
        Basedao.closeall(rs, ps, conn);
        return user;
    }
    
    public static int totalPage(final int count) {
        int tpage = 1;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select count(*) from EASYBUY_USER");
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
    
    public static int insert(final EASYBUY_USER u) {
        final String sql = "insert into EASYBUY_USER values(?,?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,?,?,?)";
        final Object[] params = { u.getEU_USER_ID(), u.getEU_USER_NAME(), u.getEU_PASSWORD(), u.getEU_SEX(), u.getEU_BIRTHDAY(), u.getEU_IDENTITY_CODE(), u.getEU_EMAIL(), u.getEU_MOBILE(), u.getEU_ADDRESS(), u.getEU_STATUS() };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int update(final EASYBUY_USER u) {
        final String sql = "update EASYBUY_USER set EU_USER_NAME=?,EU_PASSWORD=?,EU_SEX=?,EU_BIRTHDAY=DATE_FORMAT(?,'%Y-%m-%d'),EU_IDENTITY_CODE=?,EU_EMAIL=?,EU_MOBILE=?,EU_ADDRESS=?,EU_STATUS=? where EU_USER_ID=?";
        final Object[] params = { u.getEU_USER_NAME(), u.getEU_PASSWORD(), u.getEU_SEX(), u.getEU_BIRTHDAY(), u.getEU_IDENTITY_CODE(), u.getEU_EMAIL(), u.getEU_MOBILE(), u.getEU_ADDRESS(), u.getEU_STATUS(), u.getEU_USER_ID() };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int del(final String id) {
        final String sql = "delete from EASYBUY_USER where EU_USER_ID=? and EU_USER_ID!='admin'";
        final Object[] params = { id };
        return Basedao.exectuIUD(sql, params);
    }
}
