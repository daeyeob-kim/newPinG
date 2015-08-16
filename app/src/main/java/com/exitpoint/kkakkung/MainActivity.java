package com.exitpoint.kkakkung;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.exitpoint.kkakkung.library.*;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new ContentFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public static class ContentFragment extends Fragment implements AdapterView.OnItemClickListener {

        private ListView demosListView;
        Intent ServiceIntent;
        int requestCode;

        public ContentFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            String[] items = {
                    "1. inflator",
                    "2. Sample3",
                    "3. addFriend",
                    "4. Drag Test",
                    "5. sample2",
                    "6. sample4"
            };
            ArrayAdapter<String> simpleAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
            demosListView = (ListView) rootView.findViewById(R.id.demosListView);
            demosListView.setAdapter(simpleAdapter);
            demosListView.setOnItemClickListener(this);
            return rootView;
        }

        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            Toast.makeText(this.getActivity(),
                    "testCode: " + String.valueOf(requestCode)
                            + "\nResultCode: " + String.valueOf(resultCode), Toast.LENGTH_SHORT).show();
        }

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
                case 0: //1. 액티비티 추가
                        //2. 매니페스트에 추가
                        //3. 레이아웃 추가
                        //4. 아래 양식대로 넣으면 아마 될지도..
                    startActivity(new Intent(getActivity(), InflaterTest.class));
                    break;
                case 1:
                    startActivity(new Intent(getActivity(), Sample3.class));
                    break;
                case 2:
                    //startActivityForResult(Intent(), AddFriend.class);
                    Intent intent = new Intent(getActivity(), AddFriend.class);
                    requestCode = 10;
                    startActivityForResult(intent, requestCode);

                    break;
                case 3:
                    startActivity(new Intent(getActivity(), DragTestActivity.class));
                    break;
                case 4:
                    startActivity(new Intent(getActivity(), Sample2.class));
                    break;
                case 5:
                    startActivity(new Intent(getActivity(), Sample4.class));
                    break;
            }
        }
    }
}
