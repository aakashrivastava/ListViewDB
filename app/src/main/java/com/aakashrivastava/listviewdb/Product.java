package com.aakashrivastava.listviewdb;

public class Product {

    //A class for getter and setter methods

    private String id, name;
    private int price, qty;

    public Product(String id, String name, int price, int qty) {
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setQty(qty);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
