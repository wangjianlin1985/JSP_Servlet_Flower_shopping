// 
// 
// 

package com.hr.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import com.hr.entity.EASYBUY_PRODUCT;
import java.util.ArrayList;

public class EASYBUY_PRODUCTDao
{
    public static ArrayList<EASYBUY_PRODUCT> selectAll() {
        final ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
        ResultSet rs = null;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_PRODUCT");
            rs = ps.executeQuery();
            while (rs.next()) {
                final EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"), rs.getString("EP_NAME"), rs.getString("EP_DESCRIPTION"), rs.getInt("EP_PRICE"), rs.getInt("EP_STOCK"), rs.getInt("EPC_ID"), rs.getInt("EPC_CHILD_ID"), rs.getString("EP_FILE_NAME"));
                list.add(p);
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
    
    public static ArrayList<EASYBUY_PRODUCT> selectAllByName(final String name) {
        final ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
        ResultSet rs = null;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_PRODUCT where EP_NAME like ?");
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                final EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"), rs.getString("EP_NAME"), rs.getString("EP_DESCRIPTION"), rs.getInt("EP_PRICE"), rs.getInt("EP_STOCK"), rs.getInt("EPC_ID"), rs.getInt("EPC_CHILD_ID"), rs.getString("EP_FILE_NAME"));
                list.add(p);
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
    
    public static EASYBUY_PRODUCT selectById(final int id) {
        EASYBUY_PRODUCT p = null;
        ResultSet rs = null;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_PRODUCT where EP_ID=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"), rs.getString("EP_NAME"), rs.getString("EP_DESCRIPTION"), rs.getInt("EP_PRICE"), rs.getInt("EP_STOCK"), rs.getInt("EPC_ID"), rs.getInt("EPC_CHILD_ID"), rs.getString("EP_FILE_NAME"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return p;
        }
        finally {
            Basedao.closeall(rs, ps, conn);
        }
        Basedao.closeall(rs, ps, conn);
        return p;
    }
    
    public static ArrayList<EASYBUY_PRODUCT> selectAllByFid(final int fid) {
        final ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
        ResultSet rs = null;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_PRODUCT where EPC_ID=?");
            ps.setInt(1, fid);
            rs = ps.executeQuery();
            while (rs.next()) {
                final EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"), rs.getString("EP_NAME"), rs.getString("EP_DESCRIPTION"), rs.getInt("EP_PRICE"), rs.getInt("EP_STOCK"), rs.getInt("EPC_ID"), rs.getInt("EPC_CHILD_ID"), rs.getString("EP_FILE_NAME"));
                list.add(p);
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
    
    public static ArrayList<EASYBUY_PRODUCT> selectAllByCid(final int cid) {
        final ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
        ResultSet rs = null;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_PRODUCT where EPC_CHILD_ID=?");
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                final EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"), rs.getString("EP_NAME"), rs.getString("EP_DESCRIPTION"), rs.getInt("EP_PRICE"), rs.getInt("EP_STOCK"), rs.getInt("EPC_ID"), rs.getInt("EPC_CHILD_ID"), rs.getString("EP_FILE_NAME"));
                list.add(p);
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
    
    public static int insert(final EASYBUY_PRODUCT p) {
        final String sql = "insert into EASYBUY_PRODUCT values(null,?,?,?,?,?,?,?)";
        final Object[] params = { p.getEP_NAME(), p.getEP_DESCRIPTION(), p.getEP_PRICE(), p.getEP_STOCK(), p.getEPC_ID(), p.getEPC_CHILD_ID(), p.getEP_FILE_NAME() };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int update(final EASYBUY_PRODUCT p) {
        if (!p.getEP_FILE_NAME().equals("")) {
            final String sql = "update EASYBUY_PRODUCT set EP_NAME=?,EP_DESCRIPTION=?,EP_PRICE=?,EP_STOCK=?,EPC_ID=?,EPC_CHILD_ID=?,EP_FILE_NAME=?  where EP_ID=?";
            final Object[] params = { p.getEP_NAME(), p.getEP_DESCRIPTION(), p.getEP_PRICE(), p.getEP_STOCK(), p.getEPC_ID(), p.getEPC_CHILD_ID(), p.getEP_FILE_NAME(), p.getEP_ID() };
            return Basedao.exectuIUD(sql, params);
        }
        final String sql = "update EASYBUY_PRODUCT set EP_NAME=?,EP_DESCRIPTION=?,EP_PRICE=?,EP_STOCK=?,EPC_ID=?,EPC_CHILD_ID=?  where EP_ID=?";
        final Object[] params = { p.getEP_NAME(), p.getEP_DESCRIPTION(), p.getEP_PRICE(), p.getEP_STOCK(), p.getEPC_ID(), p.getEPC_CHILD_ID(), p.getEP_ID() };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int del(final int id) {
        final String sql = "delete from EASYBUY_PRODUCT where EP_ID=?";
        final Object[] params = { id };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int totalPage(final int count) {
        int tpage = 1;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select count(*) from EASYBUY_PRODUCT");
            rs = ps.executeQuery();
            if (rs.next()) {
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
    
    public static int totalPageByFid(final int count, final int fid) {
        int tpage = 1;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select count(*) from EASYBUY_PRODUCT where EPC_ID=?");
            ps.setInt(1, fid);
            rs = ps.executeQuery();
            if (rs.next()) {
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
    
    public static int totalPageByCid(final int count, final int cid) {
        int tpage = 1;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select count(*) from EASYBUY_PRODUCT where EPC_CHILD_ID=?");
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            if (rs.next()) {
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
    
    public static int totalPageByName(final int count, final String name) {
        int tpage = 1;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select count(*) from EASYBUY_PRODUCT where EP_NAME like ?");
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            if (rs.next()) {
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
    
    public static ArrayList<EASYBUY_PRODUCT> selectAll(final int cpage, final int count) {
        final ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        final String sql = "select * from EASYBUY_PRODUCT order by EP_ID desc limit ?,? ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, count * (cpage - 1));
            ps.setInt(2, count);
            rs = ps.executeQuery();
            while (rs.next()) {
                final EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"), rs.getString("EP_NAME"), rs.getString("EP_DESCRIPTION"), rs.getInt("EP_PRICE"), rs.getInt("EP_STOCK"), rs.getInt("EPC_ID"), rs.getInt("EPC_CHILD_ID"), rs.getString("EP_FILE_NAME"));
                list.add(p);
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
    
    public static ArrayList<EASYBUY_PRODUCT> selectAllByFid(final int cpage, final int count, final int fid) {
        final ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        final String sql = "select * from EASYBUY_PRODUCT where EPC_ID = ? order by EP_ID desc limit ?,?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, fid);
            ps.setInt(2, count * (cpage - 1));
            ps.setInt(3, count);
            rs = ps.executeQuery();
            while (rs.next()) {
                final EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"), rs.getString("EP_NAME"), rs.getString("EP_DESCRIPTION"), rs.getInt("EP_PRICE"), rs.getInt("EP_STOCK"), rs.getInt("EPC_ID"), rs.getInt("EPC_CHILD_ID"), rs.getString("EP_FILE_NAME"));
                list.add(p);
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
    
    public static ArrayList<EASYBUY_PRODUCT> selectAllByCid(final int cpage, final int count, final int cid) {
        final ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        final String sql = "select * from EASYBUY_PRODUCT where EPC_CHILD_ID = ? order by EP_ID desc limit ?,?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cid);
            ps.setInt(2, count * (cpage - 1));
            ps.setInt(3, count);
            rs = ps.executeQuery();
            while (rs.next()) {
                final EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"), rs.getString("EP_NAME"), rs.getString("EP_DESCRIPTION"), rs.getInt("EP_PRICE"), rs.getInt("EP_STOCK"), rs.getInt("EPC_ID"), rs.getInt("EPC_CHILD_ID"), rs.getString("EP_FILE_NAME"));
                list.add(p);
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
    
    public static ArrayList<EASYBUY_PRODUCT> selectById(final ArrayList<Integer> ids) {
        final ArrayList<EASYBUY_PRODUCT> lastlylist = new ArrayList<EASYBUY_PRODUCT>();
        EASYBUY_PRODUCT p = null;
        ResultSet rs = null;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            for (int i = 0; i < ids.size(); ++i) {
                ps = conn.prepareStatement("select * from EASYBUY_PRODUCT where EP_ID=?");
                ps.setInt(1, ids.get(i));
                rs = ps.executeQuery();
                while (rs.next()) {
                    p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"), rs.getString("EP_NAME"), rs.getString("EP_DESCRIPTION"), rs.getInt("EP_PRICE"), rs.getInt("EP_STOCK"), rs.getInt("EPC_ID"), rs.getInt("EPC_CHILD_ID"), rs.getString("EP_FILE_NAME"));
                    lastlylist.add(p);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return lastlylist;
        }
        finally {
            Basedao.closeall(rs, ps, conn);
        }
        Basedao.closeall(rs, ps, conn);
        return lastlylist;
    }
    
    public static ArrayList<EASYBUY_PRODUCT> selectAllByT() {
        final ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        final String sql = "select * from EASYBUY_PRODUCT order by EP_PRICE asc limit 0,9";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                final EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"), rs.getString("EP_NAME"), rs.getString("EP_DESCRIPTION"), rs.getInt("EP_PRICE"), rs.getInt("EP_STOCK"), rs.getInt("EPC_ID"), rs.getInt("EPC_CHILD_ID"), rs.getString("EP_FILE_NAME"));
                list.add(p);
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
    
    public static ArrayList<EASYBUY_PRODUCT> selectAllByHot() {
        final ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        final String sql = "select * from ( select tab1.* from  (  select * from easybuy_product a,  (select ep_id eod_ep_id,sum(EOD_QUANTITY) buysum from EASYBUY_ORDER_DETAIL  group by EP_id order by sum(EOD_QUANTITY) desc) b  where a.ep_id=b.eod_ep_id order by buysum desc  ) tab1) tab2 limit 0,8";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                final EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"), rs.getString("EP_NAME"), rs.getString("EP_DESCRIPTION"), rs.getInt("EP_PRICE"), rs.getInt("EP_STOCK"), rs.getInt("EPC_ID"), rs.getInt("EPC_CHILD_ID"), rs.getString("EP_FILE_NAME"));
                list.add(p);
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
