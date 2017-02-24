package com.ysered.customlayoutexample.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ysered.customlayoutexample.R;
import com.ysered.customlayoutexample.view.util.ColorUtils;

public class TagView extends FrameLayout {

    private TextView tagText;
    private GradientDrawable backgroundShape;

    public TagView(Context context) {
        super(context);
        init(context);
    }

    public TagView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        applyAttributes(context, attrs);
    }

    public TagView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        applyAttributes(context, attrs);
    }

    public void setTagText(String text) {
        this.tagText.append(text);
    }

    public void setTagBackgroundColor(int color) {
        final int backgroundColor = ColorUtils.getColor(getContext(), color);
        backgroundShape.setColor(backgroundColor);
        setBackground(backgroundShape);
    }

    private void init(Context context) {
        final View view = inflate(context, R.layout.view_tag, this);
        tagText = (TextView) view.findViewById(R.id.tagText);
        tagText.setText("#");
        backgroundShape = (GradientDrawable) ContextCompat.getDrawable(context, R.drawable.shape_view_tag);
    }

    private void applyAttributes(Context context, AttributeSet attrs) {
        final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TagView);
        final String tag = typedArray.getString(R.styleable.TagView_tag_text);
        if (!TextUtils.isEmpty(tag)) {
            tagText.append(tag);
        }

        final int backgroundColor = typedArray.getColor(R.styleable.TagView_tag_background, ColorUtils.getWhiteColor(context));
        backgroundShape.setColor(backgroundColor);
        setBackground(backgroundShape);
        typedArray.recycle();
    }
}
