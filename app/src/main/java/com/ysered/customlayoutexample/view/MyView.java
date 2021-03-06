package com.ysered.customlayoutexample.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.ysered.customlayoutexample.R;
import com.ysered.customlayoutexample.view.util.ColorUtils;

public class MyView extends View {
    private static final String TAG = MyView.class.getSimpleName();

    private static final int[] STATE_DEFAULT = {R.attr.my_view_default};
    private static final int[] STATE_SELECTED = {R.attr.my_view_selected};

    private boolean isSelected = false;

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 2);
        if (isSelected) {
            mergeDrawableStates(drawableState, STATE_SELECTED);
        } else {
            mergeDrawableStates(drawableState, STATE_DEFAULT);
        }
        return drawableState;
    }

    public void setSelected(boolean isSelected) {
        if (this.isSelected != isSelected) {
            this.isSelected = isSelected;
            refreshDrawableState();
        }
    }

    private void init(Context context) {
        final Resources resources = context.getResources();
        final int width = (int) resources.getDimension(R.dimen.my_view_width);
        final int height = (int) resources.getDimension(R.dimen.my_view_height);
        setMeasuredDimension(width, height);

        final Drawable[] selectedStateLayers = {
                new ColorDrawable(ColorUtils.getSelectedColor(context)),
                ContextCompat.getDrawable(context, R.drawable.bg_my_view_selected)
        };

        final StateListDrawable statesDrawable = new StateListDrawable();
        statesDrawable.addState(STATE_DEFAULT, new ColorDrawable(ColorUtils.getRandomColor(context)));
        statesDrawable.addState(STATE_SELECTED, new LayerDrawable(selectedStateLayers));
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
