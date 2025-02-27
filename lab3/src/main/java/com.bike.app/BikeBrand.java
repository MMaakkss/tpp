package com.bike.app;

public class BikeBrand {
    private int bikeId;
    private String brandNam;

    public BikeBrand() {}

    public BikeBrand(int bikeId, String brandNam) {
        this.bikeId = bikeId;
        this.brandNam = brandNam;
    }

    public int getbikeId() {
        return bikeId;
    }

    public void setbikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public String getbrandNam() {
        return brandNam;
    }

    public void setbrandNam(String brandNam) {
        this.brandNam = brandNam;
    }

    @Override
    public String toString() {
        return "BikeBrand{" +
                "bikeId=" + bikeId +
                ", brandNam='" + brandNam + '\'' +
                '}';
    }
}
