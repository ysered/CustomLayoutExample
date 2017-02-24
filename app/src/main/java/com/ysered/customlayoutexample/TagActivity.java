package com.ysered.customlayoutexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.ysered.customlayoutexample.view.TagView;

public class TagActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag);

        final LinearLayout tagsContainer = (LinearLayout) findViewById(R.id.tagsContainer);
        final TagView tagView = new TagView(this);
        tagView.setTagBackgroundColor(R.color.color_yellow);
        tagView.setTagText("Tag2");
        tagsContainer.addView(tagView);
    }
}
