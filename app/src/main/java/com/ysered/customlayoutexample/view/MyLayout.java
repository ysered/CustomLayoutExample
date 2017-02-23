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
                child.layout(point.x, point.y, point.x + width, point.y + height);
            }
        }
    }

    @Override
    public void addView(View child) {
        super.addView(child);
        final Point point = new Point(random.nextInt(getWidth()), random.nextInt(getHeight()));
        randomPoints.put(getChildCount() - 1, point);
    }
}
