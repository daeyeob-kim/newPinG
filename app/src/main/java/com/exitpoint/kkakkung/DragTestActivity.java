package com.exitpoint.kkakkung;

import android.app.Activity;
import android.content.ClipData;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class DragTestActivity extends ActionBarActivity {

    private Button icon;
    private Button icon2;
    private LinearLayout layout;
    private LinearLayout layout2;
    private View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_test);

        icon = (Button) findViewById(R.id.icon);
        icon2 = (Button) findViewById(R.id.icon2);
        layout = (LinearLayout) findViewById(R.id.layout);
        layout2 = (LinearLayout) findViewById(R.id.layout2);

        icon.setTag("icon");
        icon2.setTag("icon2");
        layout.setTag("layout");
        layout2.setTag("layout2");

        View.OnTouchListener touchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 여기서 clipdata로 저장하나봄
                String tag = v.getTag().toString();
                ClipData clipData = ClipData.newPlainText("TAG", tag);

                // 자기 자신을 shadow함
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(icon);

                v.startDrag(clipData, shadow, null, 0);

                return false;
            }
        };
        // icon의 touchListener
        icon.setOnTouchListener(touchListener);
        icon2.setOnTouchListener(touchListener);
        layout.setOnDragListener(new MyDragListener());
        layout2.setOnDragListener(new MyDragListener());

    }

    class MyDragListener implements View.OnDragListener {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            View draggedButton = (View) event.getLocalState();

            final int action = event.getAction();
            switch (action) {
                case DragEvent.ACTION_DRAG_STARTED:

                    return true;
                case DragEvent.ACTION_DRAG_EXITED:

                    break;
                case DragEvent.ACTION_DRAG_ENTERED:

                    return true;
                case DragEvent.ACTION_DROP: {
                    ClipData dragData = event.getClipData();
                    final String tag = dragData.getItemAt(0).getText().toString();

                    if (v == findViewById(R.id.layout))
                        Toast.makeText(getApplicationContext(), "targetLayout: " + v.getTag() + " dragged :" + tag, Toast.LENGTH_SHORT).show();
                    else if (v == findViewById(R.id.layout2))
                        Toast.makeText(getApplicationContext(), "targetLayout: " + v.getTag() + " dragged :" + tag, Toast.LENGTH_SHORT).show();


                    return true;
                }

                case DragEvent.ACTION_DRAG_ENDED: {
                    // drag가 끝났을때

                    return (true);
                }

                default:
                    break;
            }
            return true;
        }
    }

}
