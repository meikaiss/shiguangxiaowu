package com.shiguangxiaowu.interview.common.map;

import com.amap.api.maps.model.Marker;

/**
 * Created by meikai on 2019/04/27.
 */
public class MarkerHolder {
    public String id;
    public Marker marker;
    public double lat;
    public double lng;

    public MarkerHolder(String id, Marker marker, double lat, double lng) {
        this.id = id;
        this.marker = marker;
        this.lat = lat;
        this.lng = lng;
    }
}
