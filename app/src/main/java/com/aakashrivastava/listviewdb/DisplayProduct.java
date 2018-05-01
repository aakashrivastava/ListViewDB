package com.aakashrivastava.listviewdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DisplayProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_product);
        //Calling the constructor to pass the context of this activity
        BackgroundTask backgroundTask =  new BackgroundTask(this);
        backgroundTask.execute("get_info");
    }
}
