package com.exitpoint.kkakkung;

import android.app.Fragment;
import android.content.ClipData;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.exitpoint.kkakkung.CircularView;
import com.exitpoint.kkakkung.library.FloatingActionButton;
import com.exitpoint.kkakkung.library.FloatingActionMenu;
import com.exitpoint.kkakkung.library.SubActionButton;

import org.xmlpull.v1.XmlPullParser;
import com.exitpoint.kkakkung.library.animation.*;

/**
 * @author Mike Weng mike@mikeweng.com
 * */


public class CircularTest extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular_test);



        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new CustomAnimationDemoFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_circular_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class CustomAnimationDemoFragment extends Fragment {

        public CustomAnimationDemoFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_circular, container, false);

            ImageView fabContent = new ImageView(getActivity());
            fabContent.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_settings));

            FloatingActionButton darkButton = new FloatingActionButton.Builder(getActivity())
                    .setTheme(FloatingActionButton.THEME_DARK)
                    .setContentView(fabContent)
                    .setPosition(FloatingActionButton.POSITION_BOTTOM_CENTER)
                    .build();

            SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(getActivity())
                    .setTheme(SubActionButton.THEME_DARK);
            final ImageView rlIcon1 = new ImageView(getActivity());
            ImageView rlIcon2 = new ImageView(getActivity());
            ImageView rlIcon3 = new ImageView(getActivity());
            ImageView rlIcon4 = new ImageView(getActivity());
            ImageView rlIcon5 = new ImageView(getActivity());

            rlIcon1.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_chat));
            rlIcon2.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_camera));
            rlIcon3.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_video));
            rlIcon4.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_place));
            rlIcon5.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_headphones));





            View.OnTouchListener touchListener = new View.OnTouchListener(){
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    // 여기서 clipdata로 저장하나봄
                    String tag = v.getTag().toString();
                    ClipData clipData = ClipData.newPlainText("TAG", tag);

                    Toast.makeText(getActivity(), tag, Toast.LENGTH_SHORT).show();
                    View.DragShadowBuilder shadowBuilder;

                    shadowBuilder = new View.DragShadowBuilder(v);
                    v.startDrag(clipData, shadowBuilder, null, 0);


                    return false;
                }
            };

            rlIcon1.setOnTouchListener(touchListener);
            rlIcon2.setOnTouchListener(touchListener);
            rlIcon3.setOnTouchListener(touchListener);
            rlIcon4.setOnTouchListener(touchListener);
            rlIcon5.setOnTouchListener(touchListener);

            // Set 4 SubActionButtons
            FloatingActionMenu centerBottomMenu = new FloatingActionMenu.Builder(getActivity())
                    .setStartAngle(0)
                    .setEndAngle(-180)
                    .setAnimationHandler(new SlideInAnimationHandler())
                    .addSubActionView(rLSubBuilder.setContentView(rlIcon1).build())
                    .addSubActionView(rLSubBuilder.setContentView(rlIcon2).build())
                    .addSubActionView(rLSubBuilder.setContentView(rlIcon3).build())
                    .addSubActionView(rLSubBuilder.setContentView(rlIcon4).build())
                    .addSubActionView(rLSubBuilder.setContentView(rlIcon5).build())
                    .attachTo(darkButton)
                    .build();

            return rootView;
        }
    }
}
