package com.shiguangxiaowu.interview.business.familymap;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.shiguangxiaowu.interview.R;

/**
 * Created by meikai on 2019/04/27.
 */
public class FamilyMemberMarkerView extends FrameLayout {

    public ImageView imgAvatar;

    public FamilyMemberMarkerView(Context context) {
        super(context);
        initView(context, null, 0);
    }

    public FamilyMemberMarkerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs, 0);
    }

    public FamilyMemberMarkerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }


    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        LayoutInflater.from(context).inflate(R.layout.sg__family_member_marker_view, this);

        imgAvatar = findViewById(R.id.img_avatar);
    }

}
