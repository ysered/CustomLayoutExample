package com.ysered.customlayoutexample.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
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
        final int lastIndex = getChildCount() - 1;
        final View child = getChildAt(lastIndex);
        final Point point = randomPoints.get(lastIndex);
        if (point != null && child != null) {
            int width = child.getMeasuredWidth();
            int height = child.getMeasuredHeight();
            child.layout(point.x, point.y, point.x + width, point.y + height);
        }
    }

    @Override
    public void addView(View child) {
        addNewView(child, random.nextInt(getWidth()), random.nextInt(getHeight()));
    }

    public void addViewAtPosition(View child, int x, int y) {
        addNewView(child, x, y);
    }

    private void addNewView(View child, int x, int y) {
        super.addView(child);
        final int centerX = x - (child.getMeasuredWidth() / 2);
        final int centerY = y - (child.getMeasuredHeight() / 2);

        final int xPos = centerX > 0 ? centerX : x;
        final int yPos = centerY > 0 ? centerY : y;

        final Point point = new Point(xPos, yPos);
        randomPoints.put(getChildCount() - 1, point);
    }
}
