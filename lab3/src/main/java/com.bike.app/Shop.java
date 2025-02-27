package com.bike.app;

public class Shop {
    private int shopId;
    private String shopName;

    public Shop() {}

    public Shop(int shopId, String shopName) {
        this.shopId = shopId;
        this.shopName = shopName;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopId=" + shopId +
                ", shopName='" + shopName + '\'' +
                '}';
    }
}
