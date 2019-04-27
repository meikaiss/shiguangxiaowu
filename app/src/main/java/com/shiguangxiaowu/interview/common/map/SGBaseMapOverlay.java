package com.shiguangxiaowu.interview.common.map;

/**
 * Created by meikai on 2019/04/27.
 */
public abstract class SGBaseMapOverlay implements ITimeMapOverlay {

    protected MapController mapController;

    @Override
    public void bindMapController(MapController mapController) {
        this.mapController = mapController;
    }
}
