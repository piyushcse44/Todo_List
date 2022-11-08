package com.example.todo_list;

import static com.example.todo_list.R.color.*;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

// Creating an Adapter Class
 
public class MyAdaptor extends ArrayAdapter<Store_spinner_element> {
   ArrayList<Store_spinner_element> spinner_list;
   
    public MyAdaptor(Context context, int textViewResourceId,
                     ArrayList<Store_spinner_element> objects) {
        super(context, textViewResourceId, objects);
        spinner_list =objects;
    }

    public View getCustomView(int position, View convertView,
                              ViewGroup parent) {

// Inflating the layout for the custom Spinner

        View layout = LayoutInflater.from(getContext()).inflate(R.layout.spinner_layout,parent,false);

// Declaring and Typecasting the textview in the inflated layout
        TextView spinner_name = (TextView) layout
                .findViewById(R.id.spinner_name);

// Setting the text using the arraylist
        spinner_name.setText(spinner_list.get(position).spinner_name);


// Declaring and Typecasting the imageView in the inflated layout
        ImageView spinner_img = (ImageView) layout.findViewById(R.id.spinner_image);

// Setting an image using the id's in the arraylist
        spinner_img.setImageResource(spinner_list.get(position).spinner_img);


            spinner_name.setPaddingRelative(20,20,20,20);
            spinner_img.setPaddingRelative(20,20,20,20);











        return layout;
    }

    // It gets a View that displays in the drop down popup the data at the specified position
    @Override
    public View getDropDownView(int position, View convertView,
                                @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    // It gets a View that displays the data at the specified position
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
}
