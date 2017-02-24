package com.ysered.customlayoutexample;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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
}
