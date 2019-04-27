package com.shiguangxiaowu.interview.business.familymap;

import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.shiguangxiaowu.interview.R;
import com.shiguangxiaowu.interview.business.familymap.model.FamilyMemberModel;
import com.shiguangxiaowu.interview.common.map.BaseMapFragment;
import com.shiguangxiaowu.interview.common.map.ITimeMapOverlay;
import com.shiguangxiaowu.interview.common.util.DimenUtil;

import java.util.List;

/**
 * 地图展示我的家人
 * Created by meikai on 2019/04/27.
 */
public class FamilyMapShowFragment extends BaseMapFragment {

    private List<FamilyMemberModel> memberModelList;

    public void setMemberModelList(List<FamilyMemberModel> memberModelList) {
        this.memberModelList = memberModelList;
    }

    @Override
    protected void initData() {

        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.mipmap.sg__map_center);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(DimenUtil.dp2px(getContext(), 36),
                DimenUtil.dp2px(getContext(), 36));
        lp.gravity = Gravity.LEFT | Gravity.BOTTOM;
        lp.setMargins(DimenUtil.dp2px(getContext(), 15), 0, 0, DimenUtil.dp2px(getContext(), 65));
        layoutMapController.addView(imageView, lp);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapController.moveCenter();
            }
        });
    }

    @Override
    protected ITimeMapOverlay generateOverlay() {
        return new FamilyOverlay(getContext(), memberModelList);
    }

}
