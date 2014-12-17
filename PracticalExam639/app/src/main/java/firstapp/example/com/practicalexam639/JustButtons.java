package firstapp.example.com.practicalexam639;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;


public class JustButtons extends ActionBarActivity {
    private Button click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_buttons);
        click = (Button) findViewById(R.id.button1);
        click.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Context context= getApplicationContext();
                int duration= Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, "Hit Button 1", duration );
                toast.show();

            }
        });

        click = (Button) findViewById(R.id.button2);
        click.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Context context= getApplicationContext();
                int duration= Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, "Hit Button 2", duration );
                toast.show();

            }
        });

        click = (Button) findViewById(R.id.button3);
        click.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Context context= getApplicationContext();
                int duration= Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, "Hit Button 3", duration );
                toast.show();

            }
        });

        click = (Button) findViewById(R.id.button4);
        click.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Context context= getApplicationContext();
                int duration= Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, "Hit Button 4", duration );
                toast.show();

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.just_buttons, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
