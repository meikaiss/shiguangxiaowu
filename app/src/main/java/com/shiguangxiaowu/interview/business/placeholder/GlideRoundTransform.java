package com.shiguangxiaowu.interview.business.placeholder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;


import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.security.MessageDigest;

/**
 * Created by ice_liu on 16/10/27.
 */

public class GlideRoundTransform extends BitmapTransformation {

    private static float radiusPx = 0f;

    //指定角 是否 启用 圆角效果，默认全部启用； true:启用，false:禁用； 顺序：左上、右上、右下、左下；
    private boolean[] radiusEnable = {true, true, true, true};

    public GlideRoundTransform(Context context, int dp, boolean[] radiusEnable) {
        radiusPx = Resources.getSystem().getDisplayMetrics().density * dp;
        this.radiusEnable = radiusEnable;
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        return roundCrop(pool, toTransform, radiusEnable);
    }

    private static Bitmap roundCrop(BitmapPool pool, Bitmap source, boolean[] radiusEnable) {
        if (source == null) {
            return null;
        }

        Bitmap result = pool.get(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(source, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
        canvas.drawRoundRect(rectF, radiusPx, radiusPx, paint);

        if (radiusPx > 0 && radiusEnable != null && radiusEnable.length == 4) {
            //暂不处理长度小于4的用法，虽然处理显得智能一些

            if (!radiusEnable[0]) {
                canvas.drawRect(0, 0, radiusPx, radiusPx, paint);
            }
            if (!radiusEnable[1]) {
                canvas.drawRect(canvas.getWidth() - radiusPx, 0, canvas.getWidth(), radiusPx, paint);
            }
            if (!radiusEnable[2]) {
                canvas.drawRect(canvas.getWidth() - radiusPx, canvas.getHeight() - radiusPx, canvas.getWidth(), canvas.getHeight(), paint);
            }
            if (!radiusEnable[3]) {
                canvas.drawRect(0, canvas.getHeight() - radiusPx, radiusPx, canvas.getHeight(), paint);
            }
        }



        return result;
    }

    public String getId() {
        return getClass().getName() + Math.round(radiusPx);
    }

    @Override
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {

    }
}
