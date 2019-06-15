package com.shiguangxiaowu.interview.common.map;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.amap.api.maps.MapView;
import com.shiguangxiaowu.interview.R;
import com.shiguangxiaowu.interview.base.BaseTimeFragment;

/**
 * 地图绘制基类
 * Created by meikai on 2019/04/27.
 */
public abstract class BaseMapFragment extends BaseTimeFragment {


    private MapView baseMapView;
    protected FrameLayout layoutMapController;
    private FrameLayout layoutMapExtend;

    private ITimeMapOverlay iTimeMapOverlay;
    protected MapController mapController;

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

        mapController = new MapController(baseMapView);

        initData();

        iTimeMapOverlay = generateOverlay();

        if (iTimeMapOverlay != null) {
            iTimeMapOverlay.bindMapController(mapController);
            iTimeMapOverlay.onDraw();
        }

    }

    protected abstract void initData();

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
