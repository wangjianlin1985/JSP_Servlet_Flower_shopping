// 
// 
// 

package com.hr.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class Basedao
{
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getconn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jsp_flower_shop?useUnicode=true&characterEncoding=UTF-8", "root", "123456");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public static void closeall(final ResultSet rs, final Statement ps, final Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static int exectuIUD(final String sql, final Object[] params) {
        int count = 0;
        final Connection conn = getconn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; ++i) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            count = ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return count;
        }
        finally {
            closeall(null, ps, conn);
        }
        closeall(null, ps, conn);
        return count;
    }
}
