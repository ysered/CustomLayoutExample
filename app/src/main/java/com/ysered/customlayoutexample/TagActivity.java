package com.ysered.customlayoutexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ysered.customlayoutexample.view.TagLayout;
import com.ysered.customlayoutexample.view.TagView;
import com.ysered.customlayoutexample.view.util.ColorUtils;

public class TagActivity extends AppCompatActivity {

    private TagLayout tagLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag);

        tagLayout = (TagLayout) findViewById(R.id.tagsLayout);
        for (int i = 0; i < 20; i++) {
            TagView tag = new TagView(this);
            tag.setTagBackgroundColor(ColorUtils.getRandomColor(this));
            tag.setTagText("Tag " + (i + 1));
            tagLayout.addView(tag);
        }
    }
}
