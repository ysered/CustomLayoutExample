package com.ysered.customlayoutexample.view.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.ColorInt;

import com.ysered.customlayoutexample.R;

import java.util.Random;

/**
 * Helpers to get random color.
 */
public final class ColorUtils {
    /**
     * Color IDs.
     */
    private static final int[] COLORS = {
            R.color.color_red,
            R.color.color_pink,
            R.color.color_purple,
            R.color.color_deep_purple,
            R.color.color_indigo,
            R.color.color_blue,
            R.color.color_light_blue,
            R.color.color_cyan,
            R.color.color_teal,
            R.color.color_green,
            R.color.color_green_light,
            R.color.color_lime,
            R.color.color_yellow,
            R.color.color_amber,
            R.color.color_orange,
            R.color.color_deep_orange,
            R.color.color_brown,
            R.color.color_gray,
            R.color.color_blue_gray,
            R.color.color_black
    };
    private static final int MAX = COLORS.length;
    private static final Random random = new Random();

    /**
     * Returns random color based on colors defined in resources.

     * @param context
     * @return
     */
    public static @ColorInt int getRandomColor(Context context) {
        final Resources resources = context.getResources();
        final int randomIndex = random.nextInt(MAX);
        int color;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            color = resources.getColor(COLORS[randomIndex], context.getTheme());
        } else {
            color = resources.getColor(COLORS[randomIndex]);
        }
        return color;
    }
}
