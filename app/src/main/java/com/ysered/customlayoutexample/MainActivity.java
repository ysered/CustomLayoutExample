package com.ysered.customlayoutexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.randomColorsButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.randomColorsButton:
                intent = new Intent(this, RandomColorsActivity.class);
                break;
            default:
                intent = null;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
