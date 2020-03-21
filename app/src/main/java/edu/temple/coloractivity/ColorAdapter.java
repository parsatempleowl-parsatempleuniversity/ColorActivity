package edu.temple.coloractivity;

import android.graphics.Color;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ColorAdapter extends BaseAdapter {

   private String[] colors;
   private Context context;
   private String[] colors_in_english;

   ColorAdapter(Context context, String[] colors, String[] colors_in_english) {
       this.colors = colors;
       this.colors_in_english = colors_in_english;
       this.context = context;
   }

   @Override
   public int getCount() {
       return colors_in_english.length;
   }

   @Override
   public Object getItem(int position) {
       return colors_in_english[position];
   }

   @Override
   public long getItemId(int position) {
       return 0;
   }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
       TextView textView = new TextView(context);

       textView.setText(colors[position]);

       textView.setBackgroundColor(Color.parseColor(getItem(position).toString());

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
