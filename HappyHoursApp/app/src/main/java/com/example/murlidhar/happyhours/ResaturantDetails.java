package com.example.murlidhar.happyhours;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class ResaturantDetails extends ActionBarActivity {

        ExpandableListAdapter listAdapter;
        ExpandableListView expListView;
        List<String> listDataHeader;
        HashMap<String, List<String>> listDataChild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resaturant_details);


       /* if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();*/
           /* TextView tv = (TextView) findViewById(R.id.textView3);
            tv.setText(Html.fromHtml("<a href=https://www.google.com/maps/place/Aceluck/@40.75667,-73.993668,17z/data=!4m7!1m4!3m3!1s0x89c25852b3687ee3:0x221ce0689fc203e0!2sAceluck!3b1!3m1!1s0x89c25852b3687ee3:0x221ce0689fc203e0"));
            tv.setMovementMethod(LinkMovementMethod.getInstance());*/

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        // preparing list data
        prepareListData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);

        }

    //Preparing the list data

        public void prepareListData() {
            listDataHeader = new ArrayList<String>();
            listDataChild = new HashMap<String, List<String>>();

            // Adding child data
            listDataHeader.add("Food");
            listDataHeader.add("Drinks");
            listDataHeader.add("Order");

            // Adding child data
            List<String> food = new ArrayList<String>();
            food.add("Get 50% off on appetizers");

            List<String> drinks = new ArrayList<String>();
            drinks.add("$5 beer, $6 Wine and $8 Champagne");

            List<String> order = new ArrayList<String>();
            order.add("Seamless");
            order.add("Grubhub");
            order.add("Eat24");

            listDataChild.put(listDataHeader.get(0), food); // Header, Child data
            listDataChild.put(listDataHeader.get(1), drinks);
            listDataChild.put(listDataHeader.get(2), order);

            ImageView imgCall = (ImageView) findViewById(R.id.imgCall);
            imgCall.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+16467558893")); //change to original phone number
                    startActivity(intent);
                }
            });

            final String uri = "geo:40.75667,-73.993668?z=18";
            ImageView imgLocation = (ImageView) findViewById(R.id.imglocation);
            imgLocation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uri)));
                }

            });

            ImageView imgRest = (ImageView) findViewById(R.id.imageView);
            imgRest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    LayoutInflater layoutInflater
                            = (LayoutInflater)getBaseContext()
                            .getSystemService(LAYOUT_INFLATER_SERVICE);
                    View popupView = layoutInflater.inflate(R.layout.popup, null);
                    final PopupWindow popupWindow = new PopupWindow(
                            popupView,
                            WindowManager.LayoutParams.WRAP_CONTENT,
                            WindowManager.LayoutParams.WRAP_CONTENT);
                }

            });
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_resaturant_details, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /*ExpandableListAdapter listAdapter;
        ExpandableListView expListView;
        List<String> listDataHeader;
        HashMap<String, List<String>> listDataChild;
*/
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.resaturantdetails, container, false);
            return rootView;

        }
    }
}
