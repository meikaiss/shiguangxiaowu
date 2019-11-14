package com.shiguangxiaowu.interview.business.placeholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.shiguangxiaowu.interview.R;
import com.shiguangxiaowu.interview.base.BaseTimeActivity;
import com.shiguangxiaowu.interview.common.util.DimenUtil;

/**
 * Created by meikai on 2019/07/19.
 */
public class PlaceHolderActivity extends BaseTimeActivity {

    private ImageView img1;
    private ImageView img2;
    private ImageView img3;

    private String path_error = "http://a.hiphoddaftos.baidu.com/image/pic/item/0b7b02087bf40ad15a962c0b592c11dfa8ecceec2123.jpg";
    private String path_right = "http://a.hiphotos.baidu.com/image/pic/item/0b7b02087bf40ad15a962c0b592c11dfa8ecceec.jpg";
    private int placeholderId = R.drawable.placeholder_shape_888888;
    private int errorId = R.drawable.placeholder_shape_888888;

    @Override
    protected void initView() {

        img1 = findViewById(R.id.img_test_1);
        img2 = findViewById(R.id.img_test_2);
        img3 = findViewById(R.id.img_test_3);


        int radiusPx = DimenUtil.dp2px(this, 20);

        boolean[] radiusEnable = {true, true, false, false};
        RequestOptions options = RequestOptions.bitmapTransform(new CenterCropRoundCornerTransform(radiusPx, radiusEnable))
                .placeholder(placeholderId).error(errorId);

        Glide.with(img1.getContext())
                .load(path_error)
                .apply(options)
                .into(img1);//四周都是圆角的圆角矩形图片


        int radiusDP = 20;
        Glide.with(img2.getContext())
                .load(path_right)
                .thumbnail(loadTransform(img2.getContext(),placeholderId,radiusDP, radiusEnable))
                .thumbnail(loadTransform(img2.getContext(),errorId,radiusDP, radiusEnable))
                .apply(RequestOptions.bitmapTransform(new CenterCropRoundCornerTransform(radiusPx, radiusEnable)))
                .into(img2);//四周都是圆角的圆角矩形图片。


        Glide.with(img3.getContext())
                .load(path_error)
                .thumbnail(loadTransform(img3.getContext(),placeholderId,radiusDP, radiusEnable))
                .thumbnail(loadTransform(img3.getContext(),errorId,radiusDP, radiusEnable))
                .apply(RequestOptions.bitmapTransform(new CenterCropRoundCornerTransform(radiusPx, radiusEnable)))
                .into(img3);//四周都是圆角的圆角矩形图片。

    }


    //加载圆角占位符, radiusDP 半径，单位：dp
    private static RequestBuilder<Drawable> loadTransform(Context context, @DrawableRes int placeholderId, int radiusDP,
                                                          boolean[] radiusEnable) {
        return Glide.with(context)
                .load(placeholderId)
                .apply(new RequestOptions().centerCrop()
                        .transform(new GlideRoundTransform(context, radiusDP, radiusEnable)));
    }

    @Override
    protected int getContentLayoutResId() {
        return R.layout.sg__place_holder_activity;
    }
}
