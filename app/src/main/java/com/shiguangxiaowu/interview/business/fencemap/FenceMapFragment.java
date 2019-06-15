package com.shiguangxiaowu.interview.business.fencemap;

import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.model.LatLng;
import com.shiguangxiaowu.interview.R;
import com.shiguangxiaowu.interview.business.fencemap.model.FencePoint;
import com.shiguangxiaowu.interview.common.map.BaseMapFragment;
import com.shiguangxiaowu.interview.common.map.ITimeMapOverlay;
import com.shiguangxiaowu.interview.common.util.DimenUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 地图展示我的家人
 * Created by meikai on 2019/04/27.
 */
public class FenceMapFragment extends BaseMapFragment {

    private List<FencePoint> fencePointListGCJ;
    private List<FencePoint> fencePointListWGS;

    @Override
    protected void initData() {

        {
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

        {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(R.mipmap.sg__map_center);
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(DimenUtil.dp2px(getContext(), 36),
                    DimenUtil.dp2px(getContext(), 36));
            lp.gravity = Gravity.RIGHT | Gravity.BOTTOM;
            lp.setMargins(0, 0, DimenUtil.dp2px(getContext(), 15), DimenUtil.dp2px(getContext(), 165));
            layoutMapController.addView(imageView, lp);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mapController.sss();
                }
            });
        }

        fencePointListGCJ = new ArrayList<>();

        fencePointListGCJ.add(new FencePoint(30.00, 90.00));
        fencePointListGCJ.add(new FencePoint(30.00, 90.10));
        fencePointListGCJ.add(new FencePoint(30.00, 90.20));
        fencePointListGCJ.add(new FencePoint(30.00, 90.30));
        fencePointListGCJ.add(new FencePoint(30.00, 90.40));
        fencePointListGCJ.add(new FencePoint(30.00, 90.50));
        fencePointListGCJ.add(new FencePoint(30.00, 90.60));
        fencePointListGCJ.add(new FencePoint(30.00, 90.70));
        fencePointListGCJ.add(new FencePoint(30.00, 90.80));
        fencePointListGCJ.add(new FencePoint(30.00, 90.90));
        fencePointListGCJ.add(new FencePoint(30.10, 90.90));
        fencePointListGCJ.add(new FencePoint(30.20, 90.90));
        fencePointListGCJ.add(new FencePoint(30.30, 90.90));
        fencePointListGCJ.add(new FencePoint(30.40, 90.90));
        fencePointListGCJ.add(new FencePoint(30.50, 90.90));
        fencePointListGCJ.add(new FencePoint(30.60, 90.90));
        fencePointListGCJ.add(new FencePoint(30.70, 90.90));
        fencePointListGCJ.add(new FencePoint(30.80, 90.90));
        fencePointListGCJ.add(new FencePoint(30.90, 90.90));
        fencePointListGCJ.add(new FencePoint(30.90, 90.80));
        fencePointListGCJ.add(new FencePoint(30.90, 90.70));
        fencePointListGCJ.add(new FencePoint(30.90, 90.60));
        fencePointListGCJ.add(new FencePoint(30.90, 90.50));
        fencePointListGCJ.add(new FencePoint(30.90, 90.40));
        fencePointListGCJ.add(new FencePoint(30.90, 90.30));
        fencePointListGCJ.add(new FencePoint(30.90, 90.20));
        fencePointListGCJ.add(new FencePoint(30.90, 90.10));
        fencePointListGCJ.add(new FencePoint(30.90, 90.00));
        fencePointListGCJ.add(new FencePoint(30.80, 90.00));
        fencePointListGCJ.add(new FencePoint(30.70, 90.00));
        fencePointListGCJ.add(new FencePoint(30.60, 90.00));
        fencePointListGCJ.add(new FencePoint(30.50, 90.00));
        fencePointListGCJ.add(new FencePoint(30.40, 90.00));
        fencePointListGCJ.add(new FencePoint(30.30, 90.00));
        fencePointListGCJ.add(new FencePoint(30.20, 90.00));
        fencePointListGCJ.add(new FencePoint(30.10, 90.00));
        fencePointListGCJ.add(new FencePoint(30.00, 90.00));


        fencePointListWGS = new ArrayList<>(fencePointListGCJ.size());

        CoordinateConverter converter = new CoordinateConverter(getContext());
        for (int i = 0; i < fencePointListGCJ.size(); i++) {
            FencePoint fencePointGCJ = fencePointListGCJ.get(i);

            converter.from(CoordinateConverter.CoordType.GPS);
            converter.coord(new LatLng(fencePointGCJ.lat, fencePointGCJ.lng));
            LatLng latLng = converter.convert();

            FencePoint fencePointWGS = new FencePoint(latLng.latitude, latLng.longitude);
            fencePointListWGS.add(fencePointWGS);
        }

    }

    @Override
    protected ITimeMapOverlay generateOverlay() {

        return new FenceOverlay(getContext(), fencePointListGCJ, fencePointListWGS);
    }

}
