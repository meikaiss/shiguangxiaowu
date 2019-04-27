package com.shiguangxiaowu.interview.common.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by meikai on 2019/04/27.
 */
public class ViewBitmapUtil {

    /**
     * 获取 View 视图的 bitmap， 用于 View 已经挂载显示在界面上
     */
    public static Bitmap getBitmapFromView(View view) {
        if (view == null) {
            return null;
        }
        if (view.getWidth() == 0 || view.getHeight() == 0) {
            return null;
        }

        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.layout(0, 0, view.getWidth(), view.getHeight());
        view.draw(canvas);

        return bitmap;
    }

    /**
     * 获取 View 视图的 bitmap， 用于 View 未挂载显示在界面上
     */
    public static Bitmap getBitmapFromVirtualView(View view, float widthDp, float heightDp) {
        return getBitmapFromVirtualView(view, DimenUtil.dp2px(view.getContext(), widthDp),
                DimenUtil.dp2px(view.getContext(), heightDp));
    }

    public static Bitmap getBitmapFromVirtualView(View view, int widthPx, int heightPx) {
        if (view == null) {
            return null;
        }

        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(widthPx,
                View.MeasureSpec.EXACTLY);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(heightPx,
                View.MeasureSpec.EXACTLY);
        view.measure(widthMeasureSpec, heightMeasureSpec);

        FrameLayout frameLayout = new FrameLayout(view.getContext());
        frameLayout.addView(view);
        frameLayout.setDrawingCacheEnabled(true);
        frameLayout.destroyDrawingCache();
        frameLayout.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec
                        (0, View.MeasureSpec.UNSPECIFIED));
        frameLayout.layout(0, 0, frameLayout.getMeasuredWidth(), frameLayout.getMeasuredHeight());

        Bitmap cacheBitmap = frameLayout.getDrawingCache();
        if (cacheBitmap == null) {
            return null;
        } else {
            return cacheBitmap.copy(Bitmap.Config.ARGB_8888, false);
        }
    }


}
