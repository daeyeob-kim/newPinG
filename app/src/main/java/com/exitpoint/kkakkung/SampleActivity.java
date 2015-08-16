package com.exitpoint.kkakkung;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class SampleActivity extends ActionBarActivity {

    boolean visible = false;
    LayoutInflater inflater	= null;
    LinearLayout inflatedLayout	= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        // activity_main.xml에서 정의한 LinearLayout 객체 할당
        inflatedLayout = (LinearLayout)findViewById(R.id.inflatedLayout);
        // LayoutInflater 객체 생성
        inflater =  (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Inflated_Layout.xml로 구성한 레이아웃을 inflatedLayout 영역으로 확장
        inflater.inflate(R.layout.lnflated_layout, inflatedLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sample, menu);
        return true;
    }

    public void onClick(View v){

        if(visible == false)
        {
            LinearLayout inflatedLayout = (LinearLayout)findViewById(R.id.inflatedLayout);
            LayoutInflater inflater =  (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(R.layout.lnflated_layout, inflatedLayout);
            RelativeLayout relativeLayout = (RelativeLayout)inflater.inflate(R.layout.activity_sample, null);
            inflatedLayout.addView(relativeLayout);
            visible = true;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
