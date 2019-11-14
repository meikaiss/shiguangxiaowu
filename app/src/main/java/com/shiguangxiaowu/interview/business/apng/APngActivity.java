package com.shiguangxiaowu.interview.business.apng;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.github.sahasbhop.apngview.ApngDrawable;
import com.github.sahasbhop.apngview.ApngImageLoader;
import com.shiguangxiaowu.interview.R;

/**
 * Created by meikai on 2019/07/30.
 */
public class APngActivity extends AppCompatActivity {

    private ImageView imageView2;

    public static final String png_url = "https://avatars2.githubusercontent.com/u/11609129?s=460&v=4";
    public static final String png_url_2 = "https://d17qpog9ccnbkb.cloudfront.net/v5res/vova/2018-12-20/images/banners/0yuangou/0yuangou.png";
    public static final String apng_url = "http://littlesvr.ca/apng/images/GenevaDrive.png";
    public static final String apng_url_3 = "https://i.loli.net/2019/07/30/5d3feb8447db478729.png";

    public static final String awebp_url = "http://littlesvr.ca/apng/images/GenevaDrive.webp";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sg__apng_activity);

        ApngImageLoader.getInstance().init(getApplicationContext());


        imageView2 = findViewById(R.id.img_2);


        findViewById(R.id.btn_load_apng).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ApngImageLoader.ApngConfig apngConfig = new ApngImageLoader.ApngConfig(Integer.MAX_VALUE, true);
                ApngImageLoader.getInstance().displayApng(apng_url_3, imageView2, apngConfig);


            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = imageView2.getDrawable();

                if (drawable instanceof ApngDrawable) {
                    ((ApngDrawable) drawable).start();
                }

            }
        });


    }


}
