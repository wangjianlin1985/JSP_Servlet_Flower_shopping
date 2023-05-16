// 
// 
// 

package com.hr.dao;

import com.hr.entity.EASYBUY_ORDER_DETAIL;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import com.hr.entity.eb_shop;
import java.util.ArrayList;

public class ESDao
{
    public static ArrayList<eb_shop> getShop(final String id) {
        final ArrayList<eb_shop> list = new ArrayList<eb_shop>();
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_SHOP where es_EU_USER_ID=? and ES_VALID=1 order by es_id desc");
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                final eb_shop es = new eb_shop(rs.getInt("es_id"), rs.getString("es_ep_file_name"), rs.getString("es_ep_name"), rs.getInt("es_ep_price"), rs.getInt("es_eod_quantity"), rs.getInt("es_ep_stock"), rs.getInt("es_ep_id"), rs.getString("es_EU_USER_ID"), rs.getInt("es_valid"));
                list.add(es);
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
    
    public static int updateJia(final int id) {
        final String sql = "update EASYBUY_SHOP set es_eod_quantity=es_eod_quantity+1 where es_id=?";
        final Object[] params = { id };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int updateJian(final int id) {
        final String sql = "update EASYBUY_SHOP set es_eod_quantity=es_eod_quantity-1 where es_id=?";
        final Object[] params = { id };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int updateClose(final eb_shop es) {
        final String sql = "update EASYBUY_SHOP set es_eod_quantity=? where es_id=?";
        final Object[] params = { es.es_eod_quantity, es.es_id };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int getDelete(final int id) {
        final String sql = "update EASYBUY_SHOP set es_vaild=2 where es_id=?";
        final Object[] params = { id };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int insertDD(final String id, final String name, final String address, final int price) {
        final String sql = "insert into EASYBUY_ORDER values(null,?,?,?,now(),?,1,1)";
        final Object[] params = { id, name, address, price };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int getSequenceId() {
        int id = 0;
        final Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select EO_ID from easybuy_order order by EO_ID desc limit 0,1");
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return id;
        }
        finally {
            Basedao.closeall(rs, ps, conn);
        }
        Basedao.closeall(rs, ps, conn);
        return id;
    }
    
    public static int eodInsert(final EASYBUY_ORDER_DETAIL eod) {
        final String sql = "insert into EASYBUY_ORDER_DETAIL values(null,?,?,?,?)";
        final Object[] params = { eod.getEO_ID(), eod.getEP_ID(), eod.getEOD_QUANTITY(), eod.getEOD_COST() };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int esdelete(final int id) {
        final String sql = "update  EASYBUY_SHOP set es_valid=2 where es_id=?";
        final Object[] params = { id };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int updateStock(final int stock, final int id) {
        final String sql = "update EASYBUY_PRODUCT set ep_stock=ep_stock-? where ep_id=?";
        final Object[] params = { stock, id };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int insert(final eb_shop sp) {
        final String sql = "insert into easybuy_shop values(null,?,?,?,?,?,?,?,1)";
        final Object[] params = { sp.getEs_ep_file_name(), sp.getEs_ep_name(), sp.getEs_ep_price(), sp.getEs_eod_quantity(), sp.getEs_ep_stock(), sp.getEs_ep_id(), sp.getEs_EU_USER_ID() };
        return Basedao.exectuIUD(sql, params);
    }
    
    public static int getDeleteDD(final int id) {
        final String sql = "delete from easybuy_shop where es_id=?";
        final Object[] params = { id };
        return Basedao.exectuIUD(sql, params);
    }
}
