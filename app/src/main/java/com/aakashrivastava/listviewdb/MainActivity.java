package com.aakashrivastava.listviewdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Button to switch to SaveInfo Activity
    public void addProduct(View view) {
        startActivity(new Intent(MainActivity.this, SaveInfo.class));
    }

    //Button to switch to DisplayProduct Activity
    public void displayProduct(View view) {
        startActivity(new Intent(MainActivity.this, DisplayProduct.class));
    }
}
