package com.aakashrivastava.listviewdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBOperations extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    //Name of DB
    private static final String DB_NAME = "product_info.db";
    //Query to create the Table
    private static final String CREATE_QUERY = "create table " + ProductContract.ProductEntry.TABLE_NAME +
            "("+ ProductContract.ProductEntry.ID + " text," + ProductContract.ProductEntry.NAME + " text," +
            ProductContract.ProductEntry.PRICE+ " integer," + ProductContract.ProductEntry.QTY + " integer);";
    //Database Creation
    DBOperations(Context context) {
        super(context,DB_NAME,null, DB_VERSION);
        Log.d("Database Operations","Database Created!");//Message on Logcat
    }

    //Table Creation
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_QUERY);
        Log.d("Database Operations", "Table Created");
    }

    //A mndatory method to be implemented
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Adds value to the table of the datatbse
    public void addInformation(SQLiteDatabase sqLiteDatabase, String id, String name, int price, int qty) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ProductContract.ProductEntry.ID,id);
        contentValues.put(ProductContract.ProductEntry.NAME,name);
        contentValues.put(ProductContract.ProductEntry.PRICE,price);
        contentValues.put(ProductContract.ProductEntry.QTY,qty);
        sqLiteDatabase.insert(ProductContract.ProductEntry.TABLE_NAME,null, contentValues);
        Log.d("Database Operations", "One row inserted!");
    }

    //Retrieves value from the Table in a Cursor variable
    public Cursor getInformation(SQLiteDatabase sqLiteDatabase) {
        //Projections to know the fields of Database
        String[] projections = {ProductContract.ProductEntry.ID, ProductContract.ProductEntry.NAME, ProductContract.ProductEntry.PRICE,
                ProductContract.ProductEntry.QTY};
        Cursor cursor = sqLiteDatabase.query(ProductContract.ProductEntry.TABLE_NAME, projections,
                null, null, null, null, null);
        return cursor;
    }


}
