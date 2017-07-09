package com.example.ereenyessam.androidme.UI;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.ereenyessam.androidme.R;
import com.example.ereenyessam.androidme.data.AndroidImageAssert;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {


    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    Button mNextBtn;

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      if (findViewById(R.id.android_me_linear_layout)!=null)
      {
          mTwoPane = true;

          mNextBtn = (Button) findViewById(R.id.next_btn);
          mNextBtn.setVisibility(View.GONE);

          GridView  gridView = (GridView) findViewById(R.id.grid_view);
          gridView.setNumColumns(2);


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
        else
      {
          mTwoPane = false;
      }
    }


    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "Position clicked" + position, Toast.LENGTH_LONG).show();

        int bodyPartNumber = position / 12;
        int listIndex = position - 12 * bodyPartNumber;

        if (mTwoPane) {

            BodyPartFragment bodyPartFragment = new BodyPartFragment();
            switch (bodyPartNumber)
            {
                case 0:
                    bodyPartFragment.setmImagesId(AndroidImageAssert.getHeads());
                    bodyPartFragment.setmPostion(listIndex);

                    getSupportFragmentManager().beginTransaction()
                                                .replace(R.id.head_fragment,bodyPartFragment)
                                                .commit();
                    break;


                case 1:
                    bodyPartFragment.setmImagesId(AndroidImageAssert.getHeads());
                    bodyPartFragment.setmPostion(listIndex);

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.body_fragment,bodyPartFragment)
                            .commit();
                    break;

                case 2:
                    bodyPartFragment.setmImagesId(AndroidImageAssert.getHeads());
                    bodyPartFragment.setmPostion(listIndex);

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.leg_fragment,bodyPartFragment)
                            .commit();
                    break;


            }
        } else {


            switch (bodyPartNumber) {
                case 0:
                    headIndex = listIndex;
                    break;
                case 1:
                    bodyIndex = listIndex;
                    break;
                case 2:
                    legIndex = listIndex;
                    break;
                default:
                    break;
            }
            Bundle savedImage = new Bundle();
            savedImage.putInt("headIndex", headIndex);
            savedImage.putInt("bodyIndex", bodyIndex);
            savedImage.putInt("legIndex", legIndex);

            final Intent intent = new Intent(this, AndroidMeActivity.class);
            intent.putExtras(savedImage);

            mNextBtn = (Button) findViewById(R.id.next_btn);
            mNextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(intent);
                }
            });

        }
    }
}
