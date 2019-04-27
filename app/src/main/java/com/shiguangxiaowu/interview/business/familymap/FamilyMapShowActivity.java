package com.shiguangxiaowu.interview.business.familymap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.shiguangxiaowu.interview.R;
import com.shiguangxiaowu.interview.base.BaseTimeActivity;
import com.shiguangxiaowu.interview.business.familymap.model.FamilyMemberModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by meikai on 2019/04/27.
 */
public class FamilyMapShowActivity extends BaseTimeActivity {

    private static final String KEY_MEMBER_LIST = "KEY_MEMBER_LIST";

    private FamilyMapShowFragment fragment;
    private List<FamilyMemberModel> memberModelList;

    public static void start(Context context, List<FamilyMemberModel> memberModelList) {
        Intent intent = new Intent(context, FamilyMapShowActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        intent.putExtra(KEY_MEMBER_LIST, (Serializable) memberModelList);
        context.startActivity(intent);
    }

    @Override
    protected int getContentLayoutResId() {
        return R.layout.sg__family_map_show_activity;
    }

    @Override
    protected void initView() {

        memberModelList = (List<FamilyMemberModel>) getIntent().getSerializableExtra(KEY_MEMBER_LIST);

        fragment = new FamilyMapShowFragment();
        fragment.setMemberModelList(memberModelList);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                fragment).commitAllowingStateLoss();
    }


}
