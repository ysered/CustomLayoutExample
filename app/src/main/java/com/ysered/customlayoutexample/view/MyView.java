package com.ysered.customlayoutexample.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.ysered.customlayoutexample.R;
import com.ysered.customlayoutexample.view.util.ColorUtils;

public class MyView extends View {
    private static final String TAG = MyView.class.getSimpleName();

    private static final int[] STATE_DEFAULT = {R.attr.my_view_default};
    private static final int[] STATE_SELECTED = {R.attr.my_view_selected};

    private boolean isStateSelected = false;

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
    protected int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 2);
        if (isStateSelected) {
            mergeDrawableStates(drawableState, STATE_SELECTED);
        } else {
            mergeDrawableStates(drawableState, STATE_DEFAULT);
        }
        return drawableState;
    }

    public void setSelected(boolean isSelected) {
        if (this.isStateSelected != isSelected) {
            this.isStateSelected = isSelected;
            refreshDrawableState();
        }
    }

    private void init(Context context) {
        final Resources resources = context.getResources();
        final int width = (int) resources.getDimension(R.dimen.my_view_width);
        final int height = (int) resources.getDimension(R.dimen.my_view_height);
        setMeasuredDimension(width, height);

        setEnabled(true);
        setFocusable(true);
        setClickable(true);

        final StateListDrawable statesDrawable = new StateListDrawable();
        statesDrawable.addState(STATE_DEFAULT, new ColorDrawable(ColorUtils.getRandomColor(context)));
        statesDrawable.addState(STATE_SELECTED, new ColorDrawable(ColorUtils.getSelectedColor(context)));

        setBackground(statesDrawable);

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        setSelected(true);
                        break;
                    case MotionEvent.ACTION_UP:
                        setSelected(false);
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });
    }
}
