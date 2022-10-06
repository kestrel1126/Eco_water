package src.model;

import java.sql.*;

public class DamDataDAO {
    PreparedStatement psmt = null;
    ResultSet rs = null;
    Connection conn = null;
    String height, length, altitude, volume, darea, suparea, area, fwl, nwl, lwl, maltitude, lowlevelwater, tsuparea, valvol
            = "";


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

    public DamDataDTO getDamDataDTO() {
        DamDataDTO dto = new DamDataDTO();

        connect();
        try {


            String sql = "select * from water_dam where D_seq= 1";
            System.out.println("3");
            psmt = conn.prepareStatement(sql);
            System.out.println("4");
            rs = psmt.executeQuery();

            System.out.println("success2");

            while (rs.next()) {
                height = rs.getString(2);
                length = rs.getString(3);
                altitude = rs.getString(4);
                volume = rs.getString(5);
                darea = rs.getString(6);
                suparea = rs.getString(7);
                area = rs.getString(8);
                fwl = rs.getString(9);
                nwl = rs.getString(10);
                lwl = rs.getString(11);
                maltitude = rs.getString(12);
                lowlevelwater = rs.getString(13);
                tsuparea = rs.getString(14);
                valvol = rs.getString(15);

            }
            dto = new DamDataDTO(height, length, altitude, volume, darea, suparea,
                    area, fwl, nwl, lwl, maltitude, lowlevelwater, tsuparea, valvol);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        } finally {
            close();
        }

        return dto;

    }
}