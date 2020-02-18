package edu.temple.coloractivity;

import android.graphics.Color;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;


public class ColorAdapter extends BaseAdapter {

   ArrayList<String> arrayList;
   Context context;

   public ColorAdapter(Context context, ArrayList<String> arrayList) {
       this.arrayList = arrayList;
       this.context = context;
   }

   @Override
   public int getCount() {
       return arrayList.size();
   }

   @Override
   public Object getItem(int position) {
       return arrayList.get(position);
   }

   @Override
   public long getItemId(int position) {
       return position;
   }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
       TextView textView = new TextView(context);

       textView.setText(getItem(position).toString());

       textView.setBackgroundColor(Color.WHITE);

       return textView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        super.getDropDownView(position, convertView, parent);

        TextView textView;

        textView = (TextView) getView(position, convertView, parent);

        textView.setText(getItem(position).toString());

        textView.setBackgroundColor(Color.parseColor(getItem(position).toString()));

        return textView;
    }
}
