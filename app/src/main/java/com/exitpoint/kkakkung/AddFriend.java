package com.exitpoint.kkakkung;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddFriend extends Activity {
    //취소버튼으로 돌아갈 때 전달할 result
    private int basicResult = 99;
    //Return 버튼으로 돌아갈 때 전달할 result
    private int specialResult = 100;
    EditText SearchEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
        Toast.makeText(getApplicationContext(), "ADD Friend", Toast.LENGTH_SHORT).show();

        this.setResult(basicResult);
        Button btn = (Button) findViewById(R.id.btn2);
        SearchEdit = (EditText)findViewById(R.id.editText2);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),SearchEdit.getText(), Toast.LENGTH_SHORT).show();
                Intent resultIntent = new Intent();

                resultIntent.putExtra("memo", SearchEdit.getText().toString());
                setResult(specialResult, resultIntent);
                finish();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_friend, menu);
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
