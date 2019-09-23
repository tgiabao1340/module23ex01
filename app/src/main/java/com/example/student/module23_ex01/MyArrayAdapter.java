package com.example.student.module23_ex01;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Employee> {
    private Activity context = null;
    private ArrayList<Employee> myList = null;
    private int layout_id;
    public MyArrayAdapter(Activity context, int textViewResourceId,ArrayList<Employee> myList){
        super(context,textViewResourceId,myList);
        this.context = context;
        this.layout_id = textViewResourceId;
        this.myList = myList;
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layout_id, null);
        if(myList.size()>0&&position>=0){
            TextView txtDisplay = convertView.findViewById(R.id.tv_item);
            Employee employee = myList.get(position);
            txtDisplay.setText(employee.toString());
            ImageView imageView = convertView.findViewById(R.id.img_item);
            if(employee.isGender()){
                imageView.setImageResource(R.drawable.male);
            }else {
                imageView.setImageResource(R.drawable.female);
            }
        }
        return convertView;
    }
}
