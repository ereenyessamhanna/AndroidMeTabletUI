package com.example.ereenyessam.androidme.UI;

import android.nfc.Tag;
import android.nfc.tech.TagTechnology;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ereenyessam.androidme.R;
import com.example.ereenyessam.androidme.data.AndroidImageAssert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ereeny Essam on 7/6/2017.
 */

public class BodyPartFragment extends Fragment {
    public static final String mImageIdList = "image_ids";
    public static final String mListPostion = "list_position";


    private List<Integer> mImagesId;
    private int mPostion;

    public BodyPartFragment()
    {

    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {


        if (savedInstanceState!=null)
        {
            mImagesId = savedInstanceState.getIntegerArrayList(mImageIdList);
            mPostion = savedInstanceState.getInt(mListPostion);
        }

        View rootView = inflater.inflate(R.layout.fragement_body_part,container,false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);




        if (mImagesId!=null)
        {
            imageView.setImageResource(mImagesId.get(mPostion));


            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int size = mImagesId.size();
                    if (mPostion<size-1)
                    {
                        mPostion++;
                    }
                   else {
                        mPostion = 0;
                    }


                    imageView.setImageResource(mImagesId.get(mPostion));

                }
            });
        }
        else {
            Log.v("BodyPartFragment","This is a null image id");
        }


        return rootView;
    }

    public void setmImagesId(List<Integer> imagesId)
    {
        mImagesId=imagesId;
    }
    public void setmPostion(int postion)
    {
        mPostion=postion;
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putIntegerArrayList(mImageIdList, (ArrayList<Integer>) mImagesId);
        bundle.putInt(mListPostion, mPostion);

    }
}
