package com.shiguangxiaowu.interview.business.fencemap;

import android.content.Context;
import android.graphics.Color;

import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.PolygonOptions;
import com.shiguangxiaowu.interview.business.fencemap.model.FencePoint;
import com.shiguangxiaowu.interview.common.map.SGBaseMapOverlay;

import java.util.List;

/**
 * 我的家人 图层
 * Created by meikai on 2019/04/27.
 */
public class FenceOverlay extends SGBaseMapOverlay {

    private Context context;
    private List<FencePoint> fencePointListGCJ;
    private List<FencePoint> fencePointListWGS;

    public FenceOverlay(Context context, List<FencePoint> fencePointListGCJ, List<FencePoint> fencePointListWGS) {
        this.context = context;
        this.fencePointListGCJ = fencePointListGCJ;
        this.fencePointListWGS = fencePointListWGS;
    }

    @Override
    public void onDraw() {

        drawFenceGCJ(fencePointListGCJ);
        drawFenceWGS(fencePointListWGS);

        mapController.moveCenter();
    }

    @Override
    public void clearMapElements() {

    }

    private void drawFenceGCJ(final List<FencePoint> fencePointList) {
        if (fencePointList == null || fencePointList.isEmpty()) {
            return;
        }

        PolygonOptions polygonOptions = new PolygonOptions();
        polygonOptions.fillColor(Color.TRANSPARENT);
        polygonOptions.strokeColor(Color.RED);
        for (int i = 0; i < fencePointList.size(); i++) {
            polygonOptions.add(new LatLng(fencePointList.get(i).lat, fencePointList.get(i).lng));
        }

        mapController.addPolygon(100, polygonOptions);

    }

    private void drawFenceWGS(final List<FencePoint> fencePointList) {
        if (fencePointList == null || fencePointList.isEmpty()) {
            return;
        }

        PolygonOptions polygonOptions = new PolygonOptions();
        polygonOptions.fillColor(Color.TRANSPARENT);
        polygonOptions.strokeColor(Color.BLUE);
        for (int i = 0; i < fencePointList.size(); i++) {
            polygonOptions.add(new LatLng(fencePointList.get(i).lat, fencePointList.get(i).lng));
        }

        mapController.addPolygon(100, polygonOptions);

    }

}
