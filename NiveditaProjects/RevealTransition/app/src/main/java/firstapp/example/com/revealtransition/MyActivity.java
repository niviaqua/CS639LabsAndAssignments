package firstapp.example.com.revealtransition;

import android.animation.Animator;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.MotionEvent;
import android.widget.ViewAnimator;
import android.graphics.drawable.Drawable;

public class MyActivity extends ActionBarActivity {


    private View mContentView;
    private int mShortAnimationDuration;
    private Button btnR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mShortAnimationDuration = getResources().getInteger(android.R.integer.config_mediumAnimTime);

        mContentView = findViewById(R.id.myView);
        mContentView.setVisibility(View.GONE);

        btnR= (Button) findViewById(R.id.btnReveal);
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                crossfade();

            }
        });
    }

    private void crossfade(){
       /* mContentView.setAlpha(0f);
        mContentView.setVisibility(View.VISIBLE);
        mContentView.animate()
                .alpha(1f)
                .setDuration(mShortAnimationDuration)
                .setListener(null);*/

        int cx = (mContentView.getLeft() + mContentView.getRight() ) / 2;
        int cy = (mContentView).getTop() + mContentView.getBottom() )

        int finalRadius = mContentView.getWidth();
        Animator anim= ViewAnimator
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
        if (id == R.id.action_exit) {
           finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
