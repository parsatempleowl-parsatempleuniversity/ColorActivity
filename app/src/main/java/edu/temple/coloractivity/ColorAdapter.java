package edu.temple.coloractivity;

import android.graphics.Color;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;


public class ColorAdapter extends BaseAdapter {

   String[] colors;
   Context context;

   public ColorAdapter(Context context, String[] colors) {
       this.colors = colors;
       this.context = context;
   }

   @Override
   public int getCount() {
       return colors.length;
   }

   @Override
   public Object getItem(int position) {
       return colors[position];
   }

   @Override
   public long getItemId(int position) {
       return position;
   }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
       TextView textView = new TextView(context);

       textView.setText(colors[position]);

       textView.setBackgroundColor(Color.WHITE);

       return textView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        super.getDropDownView(position, convertView, parent);

        TextView textView;

        textView = (TextView) getView(position, convertView, parent);

        textView.setBackgroundColor(Color.parseColor(getItem(position).toString()));

        return textView;
    }
}
