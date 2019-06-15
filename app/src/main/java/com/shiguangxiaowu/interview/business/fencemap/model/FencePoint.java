package com.shiguangxiaowu.interview.business.fencemap.model;

/**
 * Created by meikai on 2019/06/15.
 */
public class FencePoint {

    public long id;

    public double lat;
    public double lng;

    public String coorType;


    public FencePoint(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }
}
