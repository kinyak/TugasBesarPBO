package com.pbo.rendi;

class smartphone {
    private String smartphoneName;
    private int price;
    private int quantity;
    private String merek;

    public smartphone(String itemName, int price,String merek, int quantity) {
        this.smartphoneName = itemName;
        this.price = price;
        this.merek = merek;
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSmartphoneName() {
        return smartphoneName;
    }

    public String getMerek() {
        return merek;
    }
}