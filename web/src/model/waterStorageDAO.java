package src.model;

import src.controller.getDailyWaterStorage;

import java.sql.*;
import java.util.ArrayList;

public class waterStorageDAO {
    PreparedStatement psmt = null;
    ResultSet rs = null;
    Connection conn = null;


    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://project-db-stu.ddns.net:3307/smai4",
                    "smai4",
                    "smai4");

            System.out.println("success1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.print("fail");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (psmt != null) {
                psmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<waterStorageDTO> getDwaterStorage(String month) {
        ArrayList<waterStorageDTO> list = new ArrayList<waterStorageDTO>();
        connect();
        try {
            String sql = "select S_waterStorage, S_time from water_status where S_time like '%"+month+"-%'";
            System.out.print("sql : "+sql);
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();

            while (rs.next()) {
                waterStorageDTO dto = new waterStorageDTO(rs.getFloat("S_waterStorage"), rs.getString("S_time"));
                list.add(dto);
            }
            System.out.print("get Data Size : "+list.size());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        } finally {
            close();
        }

        return list;

    }


}
