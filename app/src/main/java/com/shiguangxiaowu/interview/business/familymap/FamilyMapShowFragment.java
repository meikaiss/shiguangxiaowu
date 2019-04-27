package com.shiguangxiaowu.interview.business.familymap;

import com.shiguangxiaowu.interview.common.map.BaseMapFragment;
import com.shiguangxiaowu.interview.common.map.ITimeMapOverlay;

/**
 * 地图展示我的家人
 * Created by meikai on 2019/04/27.
 */
public class FamilyMapShowFragment extends BaseMapFragment {

    @Override
    protected ITimeMapOverlay generateOverlay() {
        return new FamilyOverlay();
    }
}
