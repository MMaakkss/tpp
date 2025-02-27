package com.bike.app;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        BikeBrandDAO BikeBrandDAO = new BikeBrandDAO();
        ShopDAO shopDAO = new ShopDAO();
        ProductDAO productDAO = new ProductDAO();

        BikeBrand BikeBrand = new BikeBrand();
        BikeBrand.setBikeBrandName("Trek");
        int BikeBrandId = BikeBrandDAO.addBikeBrand(BikeBrand);
        System.out.println("Додано бренд з ID: " + BikeBrandId);

        Shop shop = new Shop();
        shop.setShopName("Shop4");
        int shopId = shopDAO.addShop(shop);
        System.out.println("Додано магазин з ID: " + shopId);

        Product product = new Product();
        product.setProductName("Fuel");
        product.setPrice(4000.00);
        int productId = productDAO.addProduct(product);
        System.out.println("Додано продукт з ID: " + productId);

        System.out.println("\nСписок брендів:");
        List<BikeBrand> cities = BikeBrandDAO.getAllCities();
        for (BikeBrand c : cities) {
            System.out.println("ID: " + c.getBikeBrandId() + ", Назва: " + c.getBikeBrandName());
        }

        System.out.println("\nСписок магазинів:");
        List<Shop> shops = shopDAO.getAllShops();
        for (Shop s : shops) {
            System.out.println("ID: " + s.getShopId() + ", Назва: " + s.getShopName());
        }

        System.out.println("\nСписок продуктів:");
        List<Product> products = productDAO.getAllProducts();
        for (Product p : products) {
            System.out.println("ID: " + p.getProductId() + ", Назва: " + p.getProductName() + ", Ціна: " + p.getPrice());
        }
    }
}
