package com.example.tablebooking;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public Integer[] mThumbIds = {
            R.drawable.chair_black, R.drawable.chair_black, R.drawable.empty, R.drawable.chair_black,
            R.drawable.table_black, R.drawable.table_black, R.drawable.empty, R.drawable.table_black,
            R.drawable.chair_black, R.drawable.chair_black, R.drawable.empty, R.drawable.chair_black,
            R.drawable.empty, R.drawable.empty, R.drawable.empty, R.drawable.empty,
            R.drawable.chair_black, R.drawable.table_black, R.drawable.empty, R.drawable.empty,


    };

    public Integer[] getmThumbIds(){
        return mThumbIds.clone();
    }


    public ImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int size= (int) (80 * mContext.getResources().getDisplayMetrics().density);
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(size, size));
        return imageView;
    }

}
