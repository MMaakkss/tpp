package com.bike.app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopDAO {

	public int addShop(Shop shop) throws SQLException {
		String sql = "INSERT INTO shop (shopName) VALUES (?)";

		try (Connection conn = DatabaseConnection.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, shop.getShopName());

			int affectedRows = stmt.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Створення магазину не вдалося, не додано жодного рядка.");
			}

			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					return generatedKeys.getInt(1);
				} else {
					throw new SQLException("Створення магазину не вдалося, ID не отримано.");
				}
			}
		}
	}

	public Shop getShopById(int id) throws SQLException {
		String sql = "SELECT * FROM shop WHERE shop_id = ?";

		try (Connection conn = DatabaseConnection.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Shop(rs.getInt("shop_id"), rs.getString("shopName"));
			}
		}
		return null;
	}

	public void updateShop(Shop shop) throws SQLException {
		String sql = "UPDATE shop SET shopName = ? WHERE shop_id = ?";

		try (Connection conn = DatabaseConnection.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, shop.getShopName());
			stmt.setInt(2, shop.getShopId());
			stmt.executeUpdate();
		}
	}

	public List<Shop> getAllShops() throws SQLException {
		List<Shop> shops = new ArrayList<>();
		String sql = "SELECT * FROM shop";

		try (Connection conn = DatabaseConnection.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				shops.add(new Shop(rs.getInt("shop_id"), rs.getString("shopName")));
			}
		}
		return shops;
	}
}
