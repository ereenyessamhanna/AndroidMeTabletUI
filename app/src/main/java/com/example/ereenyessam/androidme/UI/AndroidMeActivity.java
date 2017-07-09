package com.example.ereenyessam.androidme.UI;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ereenyessam.androidme.R;
import com.example.ereenyessam.androidme.data.AndroidImageAssert;

public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);
        if (savedInstanceState ==null)
        {

            BodyPartFragment headFragment = new BodyPartFragment();
            BodyPartFragment bodyFragment = new BodyPartFragment();
            BodyPartFragment legFragment = new BodyPartFragment();

            headFragment.setmImagesId(AndroidImageAssert.getHeads());
            int headIndex = getIntent().getIntExtra("headIndex",0);
            headFragment.setmPostion(headIndex);



            bodyFragment.setmImagesId(AndroidImageAssert.getBodies());
            int bodyIndex = getIntent().getIntExtra("bodyIndex",0);
            bodyFragment.setmPostion(bodyIndex);

            legFragment.setmImagesId(AndroidImageAssert.getLegs());
            int legIndex = getIntent().getIntExtra("legIndex",0);
            legFragment.setmPostion(legIndex);


            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .add(R.id.head_fragment, headFragment)
                    .commit();

            fragmentManager.beginTransaction()
                    .add(R.id.body_fragment, bodyFragment)
                    .commit();


            fragmentManager.beginTransaction()
                    .add(R.id.leg_fragment, legFragment)
                    .commit();



        }


    }
}
