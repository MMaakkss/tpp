package com.bike.app;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	public int addProduct(Product product) {
		String sql = "INSERT INTO product (productName, price) VALUES (?, ?)";
		try (Connection conn = DatabaseConnection.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, product.getProductName());
			pstmt.setDouble(2, product.getPrice());
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

	public Product getProductById(int id) {
		String sql = "SELECT * FROM product WHERE product_id = ?";
		try (Connection conn = DatabaseConnection.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Product(rs.getInt("product_id"),
						rs.getString("productName"),
						rs.getDouble("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		String sql = "SELECT * FROM product";
		try (Connection conn = DatabaseConnection.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				products.add(new Product(rs.getInt("product_id"),
						rs.getString("productName"),
						rs.getDouble("price")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
}
