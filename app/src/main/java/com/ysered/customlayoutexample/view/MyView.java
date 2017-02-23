package com.ysered.customlayoutexample.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.ysered.customlayoutexample.view.util.ColorUtils;

public class MyView extends View {

    public MyView(Context context) {
        super(context);
        init(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(100, 100);
    }

    private void init(Context context) {
        setBackgroundColor(ColorUtils.getRandomColor(context));
        setMeasuredDimension(100, 100);
        //setLayoutParams(new ViewGroup.LayoutParams(100, 100));
    }
}
