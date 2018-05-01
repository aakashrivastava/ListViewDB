package com.aakashrivastava.listviewdb;

public final class ProductContract {

    ProductContract() {

    }
    //The attributes on the DB table are named in this class
    public static abstract class ProductEntry {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String PRICE = "price";
        public static final String QTY = "qty";
        public static final String TABLE_NAME = "product_table";
    }
}
