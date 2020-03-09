package edu.temple.coloractivity;

import android.graphics.Color;
import android.util.Log;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;


public class ColorAdapter extends BaseAdapter {

   String[] colors;
   Context context;
   String[] colors_in_english;

   public ColorAdapter(Context context, String[] colors, String[] colors_in_english) {
       this.colors = colors;
       this.colors_in_english = colors_in_english;
       this.context = context;
   }

   @Override
   public int getCount() {
       return colors.length;
   }

   @Override
   public Object getItem(int position) {
       return colors_in_english[position];
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

        // Log.d("Selected Color", getItem(position).toString()); was used to debug the problem that I just fixed with the passing in of the
        // colors_in_english string array

        textView = (TextView) getView(position, convertView, parent);

        textView.setBackgroundColor(Color.parseColor(getItem(position).toString()));

        return textView;
    }
}
