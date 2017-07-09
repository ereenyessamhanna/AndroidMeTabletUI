package com.example.ereenyessam.androidme.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.ereenyessam.androidme.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Ereeny Essam on 7/6/2017.
 */

public class MasterListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Integer> mImageIds;


    public MasterListAdapter(Context context,List<Integer> imageIds)
    {
        mContext = context;
        mImageIds = imageIds;
    }
    @Override
    public int getCount() {
        return mImageIds.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView ;

        if (convertView ==null)
        {
            //create image view to hold the comming image
            imageView =new ImageView(mContext);
            //set layout of image
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);



        }
        else {
            imageView = (ImageView) convertView;

        }
        //set image resource
        imageView.setImageResource(mImageIds.get(position));
        return imageView;
    }
}
