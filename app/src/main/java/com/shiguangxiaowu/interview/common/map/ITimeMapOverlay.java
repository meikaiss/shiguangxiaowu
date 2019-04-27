package com.shiguangxiaowu.interview.common.map;

import java.util.Map;

/**
 * 地图绘制基类
 * Created by meikai on 2019/04/27.
 */
public interface ITimeMapOverlay {

    void bindMapController(MapController mapController);

    void onDraw();

    void clearMapElements();

}
