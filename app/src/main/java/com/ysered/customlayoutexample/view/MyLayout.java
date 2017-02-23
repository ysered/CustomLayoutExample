package com.ysered.customlayoutexample.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

public class MyLayout extends ViewGroup {
    private static final String TAG = MyLayout.class.getSimpleName();

    private static final Random random = new Random();
    private final SparseArray<Point> randomPoints = new SparseArray<>();

    public MyLayout(Context context) {
        super(context);
    }

    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            Point point = randomPoints.get(i);
            View child = getChildAt(i);
            if (point != null
                    && child != null
                    && child.getVisibility() != GONE) {
                int width = child.getMeasuredWidth();
                int height = child.getMeasuredHeight();
                child.layout(point.x, point.y, width, height);
                Log.d(TAG, "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                Log.d(TAG, "x = " + point.x + ", y = " + point.y);
                Log.d(TAG, "width = " + width + ", height = " + height);
                Log.d(TAG, "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int desiredWidth = 1000;
        final int desiredHeight = 1000;
        // mode
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        // size
        final int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        final int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        // width
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            width = Math.min(desiredWidth, widthSize);
        } else {
            width = desiredWidth;
        }
        // height
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            height = Math.min(desiredHeight, heightSize);
        } else {
            height = desiredHeight;
        }
        // set width and height
        setMeasuredDimension(width, height);
        Log.d(TAG, "setMeasuredDimension(" + width + ", " + height + ")");
    }

    @Override
    public void addView(View child) {
        super.addView(child);
        final Point point = new Point(random.nextInt(getWidth() / 2), random.nextInt(getHeight() / 2));
        randomPoints.put(getChildCount() - 1, point);
    }
}
