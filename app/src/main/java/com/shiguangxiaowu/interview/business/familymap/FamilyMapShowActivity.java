package com.shiguangxiaowu.interview.business.familymap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.shiguangxiaowu.interview.R;
import com.shiguangxiaowu.interview.base.BaseTimeActivity;

/**
 * Created by meikai on 2019/04/27.
 */
public class FamilyMapShowActivity extends BaseTimeActivity {

    FamilyMapShowFragment fragment;

    public static void start(Context context){
        Intent intent = new Intent(context, FamilyMapShowActivity.class);
        if (!(context instanceof Activity)){
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    @Override
    protected int getContentLayoutResId() {
        return R.layout.sg__family_map_show_activity;
    }

    @Override
    protected void initView() {
        fragment = new FamilyMapShowFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                fragment).commitAllowingStateLoss();
    }


}
