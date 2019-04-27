package com.shiguangxiaowu.interview.common.map;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.shiguangxiaowu.interview.R;
import com.shiguangxiaowu.interview.base.BaseTimeFragment;
import com.shiguangxiaowu.interview.business.familymap.FamilyMemberMarkerView;
import com.shiguangxiaowu.interview.common.util.ViewBitmapUtil;

/**
 * 地图绘制基类
 * Created by meikai on 2019/04/27.
 */
public abstract class BaseMapFragment extends BaseTimeFragment {


    private MapView baseMapView;
    private FrameLayout layoutMapController;
    private FrameLayout layoutMapExtend;

    private ITimeMapOverlay iTimeMapOverlay;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.sg__base_map_fragment, container, false);

        baseMapView = root.findViewById(R.id.base_map_view);
        layoutMapController = root.findViewById(R.id.base_map_controller);
        layoutMapExtend = root.findViewById(R.id.base_map_extend);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        baseMapView.onCreate(savedInstanceState);
        baseMapView.getMap().getUiSettings().setRotateGesturesEnabled(false);

        iTimeMapOverlay = generateOverlay();
        if (iTimeMapOverlay != null) {
            iTimeMapOverlay.onDraw();
        }

        MarkerOptions markerOption = new MarkerOptions();
        markerOption.position(new LatLng(34.341568, 110.940174));
        markerOption.title("西安市").snippet("西安市：34.341568, 108.940174");

        markerOption.draggable(true);//设置Marker可拖动

        FamilyMemberMarkerView markerView = new FamilyMemberMarkerView(getContext());
        Bitmap markerBmp = ViewBitmapUtil.getBitmapFromVirtualView(markerView, 60, 60);

        markerOption.icon(BitmapDescriptorFactory.fromBitmap(markerBmp));
//        markerOption.icon(BitmapDescriptorFactory.fromBitmap(markerBmp));
        // 将Marker设置为贴地显示，可以双指下拉地图查看效果
        markerOption.setFlat(true);//设置marker平贴地图效果

        baseMapView.getMap().addMarker(markerOption);
    }

    protected abstract ITimeMapOverlay generateOverlay();

    @Override
    public void onResume() {
        super.onResume();
        baseMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        baseMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        baseMapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        baseMapView.onSaveInstanceState(outState);
    }

}
