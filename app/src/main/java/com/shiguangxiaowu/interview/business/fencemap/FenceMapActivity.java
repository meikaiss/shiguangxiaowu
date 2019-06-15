package com.shiguangxiaowu.interview.business.fencemap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.shiguangxiaowu.interview.R;
import com.shiguangxiaowu.interview.base.BaseTimeActivity;

/**
 * Created by meikai on 2019/06/15.
 */
public class FenceMapActivity extends BaseTimeActivity {

    private FenceMapFragment fragment;


    public static void start(Context context) {
        Intent intent = new Intent(context, FenceMapActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }


    @Override
    protected void initView() {

        fragment = new FenceMapFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                fragment).commitAllowingStateLoss();
    }

    @Override
    protected int getContentLayoutResId() {
        return R.layout.sg__fence_map_activity;
    }

}
