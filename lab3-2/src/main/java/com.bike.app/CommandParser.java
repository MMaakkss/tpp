package com.bike.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {
    private ShopDAO shopDAO = new ShopDAO();
    private ProductDAO productDAO = new ProductDAO();

    public void executeCommand(String command) {
        if (command.startsWith("insert shop")) {
            Pattern pattern = Pattern.compile("name='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                String shopName = matcher.group(1);
                shopDAO.insertShop(shopName);
                System.out.println("Inserted shop successfully.");
            } else {
                System.out.println("Invalid insert shop command format.");
            }
        } else if (command.startsWith("update shop")) {
            Pattern pattern = Pattern.compile("id=(\\d+), name='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int shopId = Integer.parseInt(matcher.group(1));
                String newShopName = matcher.group(2);
                shopDAO.updateShop(shopId, newShopName);
                System.out.println("Updated shop successfully.");
            } else {
                System.out.println("Invalid update shop command format.");
            }
        } else if (command.startsWith("delete shop")) {
            Pattern pattern = Pattern.compile("id=(\\d+)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int shopId = Integer.parseInt(matcher.group(1));
                shopDAO.deleteShop(shopId);
                System.out.println("Deleted shop successfully.");
            } else {
                System.out.println("Invalid delete shop command format.");
            }
        } else if (command.startsWith("read shop")) {
            shopDAO.getAllShops();

        } else if (command.startsWith("insert product")) {
            Pattern pattern = Pattern.compile("name='(.+?)', price=(\\d+(\\.\\d{1,2})?)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                String productName = matcher.group(1);
                double price = Double.parseDouble(matcher.group(2));
                productDAO.insertProduct(productName, price);
                System.out.println("Inserted product successfully.");
            } else {
                System.out.println("Invalid insert product command format.");
            }
        } else if (command.startsWith("update product")) {
            Pattern pattern = Pattern.compile("id=(\\d+), name='(.+?)', price=(\\d+(\\.\\d{1,2})?)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int productId = Integer.parseInt(matcher.group(1));
                String newProductName = matcher.group(2);
                double newPrice = Double.parseDouble(matcher.group(3));
                productDAO.updateProduct(productId, newProductName, newPrice);
                System.out.println("Updated product successfully.");
            } else {
                System.out.println("Invalid update product command format.");
            }
        } else if (command.startsWith("delete product")) {
            Pattern pattern = Pattern.compile("id=(\\d+)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int productId = Integer.parseInt(matcher.group(1));
                productDAO.deleteProduct(productId);
                System.out.println("Deleted product successfully.");
            } else {
                System.out.println("Invalid delete product command format.");
            }
        } else if (command.startsWith("read product")) {
            productDAO.getAllProducts();

        } else {
            System.out.println("Unknown command. Please try again.");
        }
    }
}
