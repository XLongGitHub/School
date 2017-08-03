package database;

import java.sql.*;

public class DB {
    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    private static Connection getConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/school?"+"user=root&password=123456aa");
            return  conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Statement getStmt() {
        try {
            return getConn().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet executeQuery(String sql ) {
        System.out.println(sql);

        try {
            pstmt = getConn().prepareStatement(sql);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean executeUpdate(String sql) {
        try {
            pstmt = getConn().prepareStatement(sql);
            if (pstmt.executeUpdate() != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

//    public static boolean insert(String sql) {
//        try {
//            pstmt = getConn().prepareStatement(sql);
//            if (pstmt.executeUpdate() != 0) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
}
