package firstapp.example.com.toast;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Random;

public class MyActivity extends ActionBarActivity {


    private Button click;
    private static final Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        click = (Button) findViewById(R.id.btnClick);
        click.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Context context= getApplicationContext();
                int duration= Toast.LENGTH_SHORT;
                String[] toastMessages = new String[] {"Great!", "Genius", "A+", "Awesome!", "U did it again", "Aaah haa...u r great", "Oh stop it!"};
                int randomMsgIndex = new Random().nextInt(toastMessages.length - 1);
                Toast toast = Toast.makeText(context, toastMessages[randomMsgIndex], duration );
                toast.show();

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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
        if(id==R.id.action_exit) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
