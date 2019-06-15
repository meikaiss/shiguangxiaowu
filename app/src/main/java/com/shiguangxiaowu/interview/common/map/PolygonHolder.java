package com.shiguangxiaowu.interview.common.map;

import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;

import java.io.Serializable;

/**
 * Created by meikai on 2019/06/15.
 */
public class PolygonHolder implements Serializable {

    public String id;
    public Polygon polygon;
    public PolygonOptions polygonOptions;

    public PolygonHolder(String id, Polygon polygon, PolygonOptions polygonOptions) {
        this.id = id;
        this.polygon = polygon;
        this.polygonOptions = polygonOptions;
    }

}
