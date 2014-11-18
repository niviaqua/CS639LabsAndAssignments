package firstapp.example.com.toggletransition_kevin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by murlidhar on 10/28/14.
 */
public class SecondActivity extends Activity{


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
            setContentView(R.layout.secondactivity);
            // Button btnOne = (Button)findViewById(R.id.btnfirst);
            //btnOne.setOnClickListener(new View.OnClickListener() {
        }

        ;
    }

