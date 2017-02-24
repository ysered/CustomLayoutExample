package com.ysered.customlayoutexample.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.view.View;

import com.ysered.customlayoutexample.view.util.ColorUtils;

public class MyView extends View {
    private static final String TAG = MyView.class.getSimpleName();

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

    private void init(Context context) {
        setMeasuredDimension(140, 140);

        setEnabled(true);
        setFocusable(true);
        setClickable(true);

        final int color = ColorUtils.getRandomColor(context);
        final int pressedColor = ColorUtils.getSelectedColor(context);
        final int[] pressedState = { android.R.attr.state_selected, android.R.attr.state_pressed };

        final StateListDrawable statesDrawable = new StateListDrawable();
        statesDrawable.addState(StateSet.WILD_CARD, new ColorDrawable(color));
        statesDrawable.addState(pressedState, new ColorDrawable(pressedColor));

        setBackground(statesDrawable);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked!!!");
            }
        });
    }
}
