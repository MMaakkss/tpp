package com.bike.app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BikeBrandDAO {

    public int addBikeBrand(BikeBrand BikeBrand) {
        String sql = "INSERT INTO bikebrand (brandname) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, BikeBrand.getBikeBrandName());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<BikeBrand> getAllBikeBrands() {
        List<BikeBrand> BikeBrands = new ArrayList<>();
        String sql = "SELECT * FROM bikebrand";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                BikeBrand BikeBrand = new BikeBrand();
                BikeBrand.setBikeBrandId(rs.getInt("bike_id"));
                BikeBrand.setBikeBrandName(rs.getString("brandname"));
                BikeBrands.add(BikeBrand);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return BikeBrands;
    }

    public void updateBikeBrand(BikeBrand BikeBrand) {
        String sql = "UPDATE BikeBrand SET brandname = ? WHERE bike_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, BikeBrand.getBikeBrandName());
            pstmt.setInt(2, BikeBrand.getBikeBrandId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBikeBrand(int id) {
        String sql = "DELETE FROM bikebrand WHERE bike_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
