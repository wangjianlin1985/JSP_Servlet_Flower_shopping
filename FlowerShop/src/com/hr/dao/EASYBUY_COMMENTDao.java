// 
// 
// 

package com.hr.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import com.hr.entity.EASYBUY_COMMENT;
import java.util.ArrayList;

public class EASYBUY_COMMENTDao
{
    public static ArrayList<EASYBUY_COMMENT> selectAll() {
        final ArrayList<EASYBUY_COMMENT> list = new ArrayList<EASYBUY_COMMENT>();
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_COMMENT");
            rs = ps.executeQuery();
            while (rs.next()) {
                final EASYBUY_COMMENT c = new EASYBUY_COMMENT(rs.getInt("EC_ID"), rs.getString("EC_CONTENT"), rs.getString("EC_CREATE_TIME"), rs.getString("EC_REPLY"), rs.getString("EC_REPLY_TIME"), rs.getString("EC_NICK_NAME"));
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
    
    public static EASYBUY_COMMENT selectById(final int id) {
        EASYBUY_COMMENT c = null;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_COMMENT where EC_ID=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new EASYBUY_COMMENT(rs.getInt("EC_ID"), rs.getString("EC_CONTENT"), rs.getString("EC_CREATE_TIME"), rs.getString("EC_REPLY"), rs.getString("EC_REPLY_TIME"), rs.getString("EC_NICK_NAME"));
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
    
    public static int insert(final EASYBUY_COMMENT c) {
        final String sql = "insert into EASYBUY_COMMENT values(null,?,NOW(),?,?,?)";
        final Object[] params = { c.getEC_CONTENT(), c.getEC_REPLY(), c.getEC_REPLY_TIME(), c.getEC_NICK_NAME() };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int update(final EASYBUY_COMMENT c) {
        final String sql = "update EASYBUY_COMMENT set EC_REPLY=?,EC_REPLY_TIME=DATE_FORMAT(?,'%Y-%m-%d') where EC_ID=?";
        final Object[] params = { c.getEC_REPLY(), c.getEC_REPLY_TIME(), c.getEC_ID() };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int del(final int id) {
        final String sql = "delete from EASYBUY_COMMENT where EC_ID=?";
        final Object[] params = { id };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static ArrayList<EASYBUY_COMMENT> selPage(final int page, final int pagesize) {
        final ArrayList<EASYBUY_COMMENT> list = new ArrayList<EASYBUY_COMMENT>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        final int min = (page - 1) * pagesize;
        try {
            conn = Basedao.getconn();
            final String sql = "select * from easybuy_comment order by Ec_create_time desc limit " + min + "," + pagesize;
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                final EASYBUY_COMMENT comment = new EASYBUY_COMMENT();
                comment.setEC_ID(rs.getInt("ec_id"));
                comment.setEC_CONTENT(rs.getString("Ec_content"));
                comment.setEC_CREATE_TIME(rs.getString("Ec_create_time"));
                comment.setEC_REPLY(rs.getString("Ec_reply"));
                comment.setEC_REPLY_TIME(rs.getString("Ec_reply_time"));
                comment.setEC_NICK_NAME(rs.getString("Ec_nick_name"));
                list.add(comment);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return list;
        }
        finally {
            Basedao.closeall(rs, pst, conn);
        }
        Basedao.closeall(rs, pst, conn);
        return list;
    }
    
    public static EASYBUY_COMMENT selOne(final int id) {
        final EASYBUY_COMMENT comment = new EASYBUY_COMMENT();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = Basedao.getconn();
            final String sql = "select * from EASYBUY_COMMENT where Ec_id=?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                comment.setEC_ID(rs.getInt("ec_id"));
                comment.setEC_CONTENT(rs.getString("Ec_content"));
                comment.setEC_CREATE_TIME(rs.getString("Ec_create_time"));
                comment.setEC_REPLY(rs.getString("Ec_reply"));
                comment.setEC_REPLY_TIME(rs.getString("Ec_reply_time"));
                comment.setEC_NICK_NAME(rs.getString("Ec_nick_name"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return comment;
        }
        finally {
            Basedao.closeall(rs, pst, conn);
        }
        Basedao.closeall(rs, pst, conn);
        return comment;
    }
    
    public static int u(final EASYBUY_COMMENT comment) {
        int num = 0;
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = Basedao.getconn();
            final String sql = "update EASYBUY_COMMENT set EC_NICK_NAME=?,EC_REPLY=? where EC_ID=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, comment.getEC_NICK_NAME());
            pst.setString(2, comment.getEC_REPLY());
            pst.setInt(3, comment.getEC_ID());
            num = pst.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
            return num;
        }
        finally {
            Basedao.closeall(null, pst, conn);
        }
        Basedao.closeall(null, pst, conn);
        return num;
    }
    
    public static int getMax(final int pagesize) {
        int max = 0;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = Basedao.getconn();
            final String sql = "select count(*) from EASYBUY_COMMENT";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                final int count = rs.getInt(1);
                if (count % pagesize == 0) {
                    max = count / pagesize;
                }
                else {
                    max = count / pagesize + 1;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return max;
        }
        finally {
            Basedao.closeall(rs, pst, conn);
        }
        Basedao.closeall(rs, pst, conn);
        return max;
    }
    
    public static ArrayList<EASYBUY_COMMENT> selPages(final String name, final int page, final int pages) {
        final ArrayList<EASYBUY_COMMENT> al = new ArrayList<EASYBUY_COMMENT>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        final int min = (page - 1) * pages;
        try {
            conn = Basedao.getconn();
            final String sql = "select * from easybuy_comment where ec_nick_name=? order by ec_create_time desc limit " + min + "," + pages;
            pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            rs = pst.executeQuery();
            while (rs.next()) {
                final EASYBUY_COMMENT com = new EASYBUY_COMMENT();
                com.setEC_ID(rs.getInt("ec_id"));
                com.setEC_CONTENT(rs.getString("ec_content"));
                com.setEC_CREATE_TIME(rs.getString("ec_create_time"));
                com.setEC_NICK_NAME(rs.getString("ec_nick_name"));
                com.setEC_REPLY(rs.getString("ec_reply"));
                com.setEC_REPLY_TIME(rs.getString("ec_reply_time"));
                al.add(com);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return al;
        }
        finally {
            Basedao.closeall(rs, pst, conn);
        }
        Basedao.closeall(rs, pst, conn);
        return al;
    }
}
