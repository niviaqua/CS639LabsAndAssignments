package firstapp.example.com.sqlhappyhr;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class AndroidListViewCursorAdaptorActivity extends Activity {

    private RestaurantDbAdapter dbHelper;
    private SimpleCursorAdapter dataAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        dbHelper = new RestaurantDbAdapter(this);
        dbHelper.open();

        //Clean all data
        dbHelper.deleteAllRestaurants();
        //Add some data
        dbHelper.insertRestList();

        //Generate ListView from SQLite Database
        displayListView();

    }

    private void displayListView() {

        Cursor cursor = dbHelper.fetchAllRest();

        // The desired columns to be bound
        String[] columns = new String[] {
                //RestaurantDbAdapter.KEY_ROWID,
                RestaurantDbAdapter.KEY_NAME,
                RestaurantDbAdapter.KEY_ADDRESS,
                RestaurantDbAdapter.KEY_PHONE
        };

        // the XML defined views which the data will be bound to
        int[] to = new int[] {

                R.id.name,
                R.id.address,
                R.id.phone,
        };

        // create the adapter using the cursor pointing to the desired data
        //as well as the layout information
        dataAdapter = new SimpleCursorAdapter(
                this, R.layout.rest_list,
                cursor,
                columns,
                to,
                0);

        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view,
                                    int position, long id) {
                // Get the cursor, positioned to the corresponding row in the result set
                Cursor cursor = (Cursor) listView.getItemAtPosition(position);

                // Get the state's capital from this row in the database.
               /* String restname =
                        cursor.getString(cursor.getColumnIndexOrThrow("name"));
              Toast.makeText(getApplicationContext(),
                        restname, Toast.LENGTH_SHORT).show();*/

              Intent intent = new Intent(view.getContext(),Rest_Details.class);
               view.getContext().startActivity(intent);

            }
        });

        EditText myFilter = (EditText) findViewById(R.id.myFilter);
        myFilter.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                dataAdapter.getFilter().filter(s.toString());
            }
        });

        dataAdapter.setFilterQueryProvider(new FilterQueryProvider() {
            public Cursor runQuery(CharSequence constraint) {
                return dbHelper.fetchRestaurantByAddress(constraint.toString());
            }
        });
    }
}
