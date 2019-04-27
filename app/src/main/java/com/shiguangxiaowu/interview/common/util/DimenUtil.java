package com.shiguangxiaowu.interview.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.DimenRes;
import android.util.TypedValue;

/**
 * Created by meikai on 2019/04/27.
 */
public class DimenUtil {

    /**
     * 屏幕宽度
     */
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    /**
     * 屏幕高度
     */
    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    /**
     * dp转px
     */
    public static int dp2px(Context context, float dpVal) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    /**
     * sp转px
     */
    public static int sp2px(Context context, float spVal) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    /**
     * px转dp
     */
    public static int px2dp(Context context, int pxVal) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((pxVal / scale) + 0.5f);
    }

    /**
     * px转sp
     */
    public static int px2sp(Context context, int pxVal) {
        return (int) ((pxVal / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    /**
     * dimen资源转px
     */
    public static int dimen2px(Context context, @DimenRes int resId) {
        return context.getResources().getDimensionPixelSize(resId);
    }

}
