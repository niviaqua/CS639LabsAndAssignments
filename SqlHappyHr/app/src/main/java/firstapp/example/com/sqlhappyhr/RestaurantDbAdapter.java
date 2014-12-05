package firstapp.example.com.sqlhappyhr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by murlidhar on 12/5/14.
 */
public class RestaurantDbAdapter {


        public static final String KEY_ROWID = "_id";
       // public static final String KEY_ID = "code";
        public static final String KEY_NAME = "name";
        public static final String KEY_ADDRESS = "address";
        public static final String KEY_PHONE = "phone";
        public static final String KEY_OFFERS = "offers";
        public static final String KEY_IMAGE = "restimage";




        private static final String TAG = "RestaurantDbAdapter";
        private DatabaseHelper mDbHelper;
        private SQLiteDatabase mDb;
        private static final String DATABASE_NAME = "Restaurants";
        private static final String SQLITE_TABLE = "HappyHours";
        private static final int DATABASE_VERSION = 1;
        private final Context mCtx;

        private static final String DATABASE_CREATE =
                "CREATE TABLE if not exists " + SQLITE_TABLE + " (" +
                        KEY_ROWID + " integer PRIMARY KEY autoincrement," +
                        KEY_NAME + "," +
                        KEY_ADDRESS + "," +
                        KEY_PHONE + "," +
                        KEY_OFFERS+ "," +
                        KEY_IMAGE+ "," +
                        " UNIQUE (" + KEY_ROWID +"));";

        private static class DatabaseHelper extends SQLiteOpenHelper {
            DatabaseHelper(Context context) {
                super(context, DATABASE_NAME, null, DATABASE_VERSION);
            }


            @Override
            public void onCreate(SQLiteDatabase db) {
                Log.w(TAG, DATABASE_CREATE);
                db.execSQL(DATABASE_CREATE);
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
                db.execSQL("DROP TABLE IF EXISTS " + SQLITE_TABLE);
                onCreate(db);
            }
        }

        public RestaurantDbAdapter(Context ctx) {
            this.mCtx = ctx;
        }
        public RestaurantDbAdapter open() throws SQLException {
            mDbHelper = new DatabaseHelper(mCtx);
            mDb = mDbHelper.getWritableDatabase();
            return this;
        }

        public void close() {
            if (mDbHelper != null) {
                mDbHelper.close();
            }
        }

        public long createRestaurant( String name,
                                  String address, String phone) {
            ContentValues initialValues = new ContentValues();
            //initialValues.put(KEY_ROWID, id);
            initialValues.put(KEY_NAME, name);
            initialValues.put(KEY_ADDRESS, address);
            initialValues.put(KEY_PHONE, phone);
         //   initialValues.put(KEY_OFFERS, deals);
          //  initialValues.put(KEY_IMAGE, imageUrl);

            return mDb.insert(SQLITE_TABLE, null, initialValues);
        }

        public boolean deleteAllRestaurants() {

            int doneDelete = 0;
            doneDelete = mDb.delete(SQLITE_TABLE, null , null);
            Log.w(TAG, Integer.toString(doneDelete));
            return doneDelete > 0;

        }

        public Cursor fetchRestaurantByAddress(String inputText) throws SQLException {
            Log.w(TAG, inputText);
            Cursor mCursor = null;
            if (inputText == null  ||  inputText.length () == 0)  {
                mCursor = mDb.query(SQLITE_TABLE, new String[] {KEY_ROWID
                                , KEY_NAME, KEY_ADDRESS, KEY_PHONE},
                        null, null, null, null, null);

            }
            else {
                mCursor = mDb.query(true, SQLITE_TABLE, new String[] {KEY_ROWID,
                               KEY_NAME, KEY_ADDRESS, KEY_PHONE},
                        KEY_ADDRESS + " like '%" + inputText + "%'", null,
                        null, null, null, null);
            }
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;

        }

        public Cursor fetchAllRest() {
            Cursor mCursor = mDb.query(SQLITE_TABLE, new String[] {KEY_ROWID,
                           KEY_NAME, KEY_ADDRESS, KEY_PHONE},
                    null, null, null, null, null);

            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }

        public void insertRestList() {
           createRestaurant("Aceluck","530 9th Ave New York New York 10018","347-880-6753");
           createRestaurant("Aceluck1","530 9th Ave New York New York 10019","347-880-6753");
            createRestaurant("Aceluck2","530 9th Ave New York New York 10038","347-880-6753");
            createRestaurant("Aceluck3","530 9th Ave New York New York 13418","347-880-6753");
            createRestaurant("Aceluck4","530 9th Ave New York New York 13218","347-880-6753");
            createRestaurant("Aceluck5","530 8th Ave New York New York 1065018","347-880-6753");
            createRestaurant("Aceluck6","340 9th Ave New York New York 1245618","347-880-6753");
            createRestaurant("Aceluck7","530 9th Ave New York New York 101018","347-880-6753");
            createRestaurant("Aceluck8","530 9th Ave New York New York 1005618","347-880-6753");
            createRestaurant("Aceluck9","532450 9th Ave New York New York 1001418","347-880-6753");
            createRestaurant("Aceluck10","530 9th Ave New York New York 1004318","347-880-6753");
            createRestaurant("Aceluck11","5543630 9th Ave New York New York 100134238","347-880-6753");
            createRestaurant("Aceluck12","5343620 9th Ave New York New York 100418","347-880-6753");
            createRestaurant("Aceluck","54326630 9th Ave New York New York 10034218","347-880-6753");
            createRestaurant("Aceluck","5398760 9th Ave New York New York 100418","347-880-6753");
            createRestaurant("Aceluck","5687930 3th Ave New York New York 1005418","347-880-6753");
            createRestaurant("Aceluck","530 2th Ave New York New York 1005418","347-880-6753");
            createRestaurant("Aceluck","530 9th Ave New York New York 1001328","347-880-6753");
            createRestaurant("Aceluck","530 9th Ave New York New York 10013248","347-880-6753");
            createRestaurant("Aceluck","530 9th Ave New York New York 100128","347-880-6753");
            createRestaurant("Aceluck","530 9th Ave New York New York 10043518","347-880-6753");
            createRestaurant("Aceluck","530 9th Ave New York New York 100178","347-880-6753");
            createRestaurant("Aceluck","530 9th Ave New York New York 10018878","347-880-6753");
            createRestaurant("Aceluck","530 9th Ave New York New York 1005618","347-880-6753");

        }

    }

