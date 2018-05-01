package com.aakashrivastava.listviewdb;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends ArrayAdapter{

    List list = new ArrayList();

    public ProductAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    //Adding the value from Product class
    public void add(@Nullable Product object) {
        list.add(object);
        super.add(object);
    }

    //Getting count of the number of rows
    @Override
    public int getCount() {
        return list.size();
    }

    //Getting the position of the current row in the table
    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    //Inflating the View for one row,
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        ProductHolder productHolder;
        if(row==null) {
            //Inflating the layout
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.display_product_row, parent, false);
            productHolder = new ProductHolder();
            //Referencing the variables to place Holder so that we can assign the correct place
            productHolder.textViewID = (TextView)row.findViewById(R.id.q_id);
            productHolder.textViewName = (TextView)row.findViewById(R.id.q_name);
            productHolder.textViewPrice = (TextView)row.findViewById(R.id.q_price);
            productHolder.textViewQty = (TextView)row.findViewById(R.id.q_qty);
            row.setTag(productHolder);
        } else {
            productHolder = (ProductHolder)row.getTag();
        }
        //Placing the variables in their rightful thrones
        Product product = (Product)getItem(position);
        productHolder.textViewID.setText(product.getId().toString());
        productHolder.textViewName.setText(product.getName().toString());
        productHolder.textViewPrice.setText(Integer.toString(product.getPrice()));
        productHolder.textViewQty.setText(Integer.toString(product.getQty()));

        return row;
    }

    static class ProductHolder {
        TextView textViewID, textViewName, textViewPrice, textViewQty;
    }
}
