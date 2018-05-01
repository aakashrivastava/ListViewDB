package com.aakashrivastava.listviewdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SaveInfo extends AppCompatActivity {

    EditText idE, nameE, quantityE, priceE;
    String id, name, price, quantity;
    DBOperations dbOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_info);

        //Initializing the fields
        idE = (EditText)findViewById(R.id.id);
        nameE = (EditText)findViewById(R.id.name);
        quantityE = (EditText)findViewById(R.id.qty);
        priceE= (EditText)findViewById(R.id.price);
    }

    public void saveData(View view) {
        //Converting fields to Strings
        id = idE.getText().toString();
        name = nameE.getText().toString();
        quantity = quantityE.getText().toString();
        price = priceE.getText().toString();

        //Passing the values to Async Task class so that the data can be loaded offline.
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute("add_info", id, name, price, quantity);
        //Need to finish the activity in order to save space.
        finish();

    }
}
