package com.cs160.joleary.represent;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.support.wearable.view.GridViewPager;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    //    private TextView mTextView;
//    private Button mFeedBtn;
    private ImageButton ellipses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Resources res = getResources();

        final GridViewPager pager = (GridViewPager) findViewById(R.id.pager);
//        pager.setAdapter(new GridPagerAdapter(this, getFragmentManager()));


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null) {
            String catName = extras.getString("CAT_NAME");
            Log.d("In wear listener", "GOT CATNAME:" + catName);
        }

//        mFeedBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent sendIntent = new Intent(getBaseContext(), WatchToPhoneService.class);
//                startService(sendIntent);
//            }
//        });



        pager.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            @Override
            public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                // Adjust page margins:
                //   A little extra horizontal spacing between pages looks a bit
                //   less crowded on a round display.
//                final boolean round = insets.isRound();
//                int rowMargin = res.getDimensionPixelOffset(R.dimen.page_row_margin);
//                int colMargin = res.getDimensionPixelOffset(round ?
//                        R.dimen.page_column_margin_round : R.dimen.page_column_margin);
//                pager.setPageMargins(rowMargin, colMargin);

                // GridViewPager relies on insets to properly handle
                // layout for round displays. They must be explicitly
                // applied since this listener has taken them over.
                pager.onApplyWindowInsets(insets);
                return insets;
            }
        });

        pager.setAdapter(new GridPagerAdapter(this, getFragmentManager()));

    }
}
//      mFeedBtn = (Button) findViewById(R.id.feed_btn);

//        Intent intent = getIntent();
//        Bundle extras = intent.getExtras();

//        if (extras != null) {
//            String catName = extras.getString("CAT_NAME");
//            mFeedBtn.setText("Feed " + catName);
//        }

//        mFeedBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent sendIntent = new Intent(getBaseContext(), WatchToPhoneService.class);
//                startService(sendIntent);
//            }
//        });
//    }