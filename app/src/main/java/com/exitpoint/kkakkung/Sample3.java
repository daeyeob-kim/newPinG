package com.exitpoint.kkakkung;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class Sample3 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample3);
        Toast.makeText(getApplicationContext(), "버튼 동적 생성 테스트", Toast.LENGTH_SHORT).show();

        Button btn = (Button) findViewById(R.id.ButtonPlus);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LinearLayout rel = (LinearLayout) View.inflate(
                        Sample3.this, R.layout.layout, null);

                //생성 규칙
                LinearLayout linear = (LinearLayout) findViewById(R.id.linear2);
                if(linear.getChildCount() < 3 ) {
                    if (linear.getChildCount() % 2 == 0) {
                        rel.setBackgroundColor(Color.GRAY);
                    } else {
                        rel.setBackgroundColor(Color.RED);
                    }
                    linear.addView(rel);
                }
                else if (linear.getChildCount() < 6 ) {


                    linear = (LinearLayout) findViewById(R.id.linear3);
                    if (linear.getChildCount() % 2 == 0) {
                        rel.setBackgroundColor(Color.GRAY);
                    } else {
                        rel.setBackgroundColor(Color.RED);
                    }
                    linear.addView(rel);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sample3, menu);
        return true;
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
