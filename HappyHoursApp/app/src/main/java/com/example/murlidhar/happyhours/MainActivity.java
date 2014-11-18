package com.example.murlidhar.happyhours;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final String[] restaurants = {"Aceluck", "Atomic Wings", "Curry Hut", "Baluchis", "Subway", "EOS", "Market Cafe", "Thai Select", "Hells Kitchen", "HK Lounge", "Dave's Tavern", "Pie Face", "Shorty's"};

        final ListAdapter theAdapter = new MyAdapter(this, restaurants);

        ListView theListView = (ListView) findViewById(R.id.listView);
        theListView.setAdapter(theAdapter);
        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String restPicked = "You selected " + String.valueOf(parent.getItemAtPosition(position));
                //String test= String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(MainActivity.this, restPicked, Toast.LENGTH_SHORT).show();
               // TextView txt= (TextView) findViewById(R.id.textView);
               // txt.setText(test);
                //Intent newActivity = new Intent(view.getContext(),MyAdapter.class);
                //startActivity(newActivity);



                Intent restInfo = new Intent(view.getContext(), ResaturantDetails.class);
                restInfo.putExtra("restname", restaurants);
                startActivity(restInfo);

            }
        });

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
}
