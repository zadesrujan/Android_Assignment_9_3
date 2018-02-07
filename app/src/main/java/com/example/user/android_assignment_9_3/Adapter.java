package com.example.user.android_assignment_9_3;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adapter extends BaseAdapter {
    //public is a method and fields can be accessed by the members of any class.
    //class is a collections of objects.
    //created MainActivity and extends with Base Adapter.

    Activity context;
    String title[];
    String description[];
    //Intializing the variables.
    public Adapter(Activity context, String title[], String description[]) {
        //Making constructor
        super();
        this.context = context;
        this.title = title;
        this.description = description;
    }

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public int getCount() {
        return title.length;
    }
//it will count the length of the title
    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public Object getItem(int i) {
        return null;
    }
//getting the object i
    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public long getItemId(int i) {
        return 0;
    }
    // creating viewhOLDER CLASS it will be responsible for view
    private class ViewHolder {
        //Declaration of set of views
        TextView txtViewTitle;
        TextView txtViewDescription;
    }


    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public View getView(int position, View view, ViewGroup parent) {
        //This getView method matains how to create a view each time by inflating
        ViewHolder holder;
        LayoutInflater inflater = context.getLayoutInflater();//retreving layout of current context
        //Checking if view is null then assiging the view of customlist and holder holds the view
        if (view == null) {

            view = inflater.inflate(R.layout.second_activity,null);
            //attaching the layout to the view
            holder = new ViewHolder();
            //creating the object
            holder.txtViewTitle = (TextView) view.findViewById(R.id.textView);
            //giving the id of textview to holder
            holder.txtViewDescription = (TextView) view.findViewById(R.id.textView2);
            //giving the id of textview to holder
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }
        holder.txtViewTitle.setText(title[position]);
        //setting text to the holder
        holder.txtViewDescription.setText(description[position]);
        //setting Desciption from the holder

        return view;
        //returning view

    }
}