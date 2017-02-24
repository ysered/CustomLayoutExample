package com.ysered.customlayoutexample;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.ysered.customlayoutexample.view.MyLayout;
import com.ysered.customlayoutexample.view.MyView;

public class RandomColorsActivity extends AppCompatActivity {

    private MyLayout myLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_colors);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(null);
        }
        myLayout = (MyLayout) findViewById(R.id.myLayout);
        myLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        final int x = (int) event.getX();
                        final int y = (int) event.getY();
                        addViewAtPosition(x, y);
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemPlusOne:
                addView();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void addView() {
        final MyView myView = new MyView(this);
        myLayout.addView(myView);
    }

    private void addViewAtPosition(int x, int y) {
        final MyView myView = new MyView(this);
        myLayout.addViewAtPosition(myView, x, y);
    }
}
