package firstapp.example.com.happyhours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by murlidhar on 11/5/14.
 */
public class SplashScreen extends Activity {

    private static int splash_time_out= 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, MyActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, splash_time_out);
    }

}
