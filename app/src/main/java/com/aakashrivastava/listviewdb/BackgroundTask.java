package com.aakashrivastava.listviewdb;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;


public class BackgroundTask extends AsyncTask<String, Product, String> {

    ProductAdapter productAdapter;
    Context context;
    Activity activity;
    ListView listView;

    //Constructor to allow access of SaveInfo and DisplayProduct class
    BackgroundTask(Context context) {
        this.context = context;
        activity = (Activity)context;
    }

    @Override
    protected String doInBackground(String... params) {
        String method = params[0];
        DBOperations dbOperations = new DBOperations(context);
        //Consider add_info as a marker which is passed from the saveInfo class. App will save data
        if(method.equals("add_info")) {
            String Id = params[1];
            String Name = params[2];
            int Price = Integer.parseInt(params[3]);
            int Quantity = Integer.parseInt(params[4]);
            SQLiteDatabase sqLiteDatabase = dbOperations.getWritableDatabase();//Focus on WRITABLE
            dbOperations.addInformation(sqLiteDatabase, Id, Name, Price, Quantity);
            return "One row inserted!";// You should know what's happening, get's posted as a Toast
        } else if(method.equals("get_info")) { //Same goes for get_info, passed from Display Product
            listView = (ListView)activity.findViewById(R.id.listView);
            SQLiteDatabase sqLiteDatabase = dbOperations.getReadableDatabase();//Focus on READABLE
            Cursor cursor = dbOperations.getInformation(sqLiteDatabase);//Cursor is used to store the values from DB, cursor passed from DBOperations class
            productAdapter = new ProductAdapter(context, R.layout.display_product_row);//display_row_product has the structure of each row of Table
            String id, name;
            int price, qty;
            while(cursor.moveToNext()) {
                id = cursor.getString(cursor.getColumnIndex(ProductContract.ProductEntry.ID));
                name = cursor.getString(cursor.getColumnIndex(ProductContract.ProductEntry.NAME));
                price = cursor.getInt(cursor.getColumnIndex(ProductContract.ProductEntry.PRICE));
                qty = cursor.getInt(cursor.getColumnIndex(ProductContract.ProductEntry.QTY));
                Product product = new Product(id, name, price, qty);
                publishProgress(product);
            }
            return "get_info";
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    //The name of method is quite descriptive itself
    @Override
    protected void onProgressUpdate(Product... values) {

        productAdapter.add(values[0]);
    }
    //Things to do after loading the data from DataBase
    @Override
    protected void onPostExecute(String result) {
        if(result.equals("get_info")) {
            listView.setAdapter(productAdapter);//Calling the object as adapter of ProductAdapter class in order to display items in the listView
        } else {
            Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
        }
    }
}
