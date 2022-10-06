package src.model;

import java.sql.*;
import java.util.ArrayList;

public class DamStatusDAO {
    PreparedStatement psmt = null;
    ResultSet rs = null;
    Connection conn = null;
    String s_seq, s_time, s_lowLevelWater, s_waterStorage, s_POW, s_rainfall, s_inflow, s_tOutflow, s_ESR = "";


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

    public ArrayList<DamStatusDTO> getList() {
        ArrayList<DamStatusDTO> list = new ArrayList<DamStatusDTO>();
        DamStatusDTO dto = new DamStatusDTO();
        connect();
        try {


            String sql = "select * from water_status limit 10";
            System.out.println("3");
            psmt = conn.prepareStatement(sql);
            System.out.println("4");
            rs = psmt.executeQuery();

            System.out.println("success2");

            while (rs.next()) {

                s_time = rs.getString(2);
                s_lowLevelWater = rs.getString(3);
                s_waterStorage = rs.getString(4);
                s_POW = rs.getString(5);
                s_ESR = rs.getString(6);
                s_rainfall = rs.getString(7);
                s_inflow = rs.getString(8);
                s_tOutflow = rs.getString(9);

                dto = new DamStatusDTO(s_time, s_lowLevelWater, s_waterStorage, s_POW, s_rainfall, s_inflow, s_tOutflow, s_ESR);
                list.add(dto);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        } finally {
            close();
        }

        return list;

    }


    public DamStatusDTO getDamStatusDTO() {

        DamStatusDTO dto = new DamStatusDTO();
        connect();

        try {


            String sql = "select * from water_status";
            System.out.println("3");
            psmt = conn.prepareStatement(sql);
            System.out.println("4");
            rs = psmt.executeQuery();

            System.out.println("success2");

            while (rs.next()) {

                s_time = rs.getString(2);
                s_lowLevelWater = rs.getString(3);
                s_waterStorage = rs.getString(4);
                s_POW = rs.getString(5);
                s_rainfall = rs.getString(6);
                s_inflow = rs.getString(7);
                s_tOutflow = rs.getString(8);

                dto = new DamStatusDTO(s_time, s_lowLevelWater, s_waterStorage, s_POW, s_rainfall, s_inflow, s_tOutflow, s_ESR);

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        } finally {
            close();
        }

        return dto;
    }
}
