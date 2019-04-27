package com.shiguangxiaowu.interview.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.Toolbar;

import com.shiguangxiaowu.interview.R;

/**
 * Created by meikai on 2019/04/27.
 */
public abstract class BaseTimeActivity extends AppCompatActivity {

    private Toolbar baseToolbar;
    private FrameLayout frameLayoutContainer;

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sg__base_activity);

        baseToolbar = findViewById(R.id.base_tool_bar);
        baseToolbar.setTitle(getTitle());

        frameLayoutContainer = findViewById(R.id.base_content_container);

        int layoutResId = getContentLayoutResId();
        if (layoutResId > 0) {
            LayoutInflater.from(this).inflate(layoutResId, frameLayoutContainer);
        }

        initView();
    }

    protected abstract void initView();

    protected abstract @LayoutRes
    int getContentLayoutResId();


}
