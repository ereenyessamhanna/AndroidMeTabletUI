package com.example.ereenyessam.androidme.UI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.media.ImageReader;
import android.media.ImageWriter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.ereenyessam.androidme.R;
import com.example.ereenyessam.androidme.data.AndroidImageAssert;

/**
 * Created by Ereeny Essam on 7/6/2017.
 */

public class MasterListFragment extends Fragment {


    OnImageClickListener mCallBack;

    public interface OnImageClickListener {
        void onImageSelected(int position);
    }

    public void onAttach(Context context) {
       super.onAttach(context);
        try {
            mCallBack = (OnImageClickListener) context;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString()+"mustImplement onClickListener");
        }
    }

    GridView gridView;

    public MasterListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        gridView = (GridView) rootView.findViewById(R.id.grid_view);

        gridView.setAdapter(new MasterListAdapter(getContext(), AndroidImageAssert.getAll()));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCallBack.onImageSelected(position);
            }
        });

        return rootView;
    }
}
