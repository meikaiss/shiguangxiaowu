package com.shiguangxiaowu.interview.common.map;

import android.util.Log;

import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by meikai on 2019/04/27.
 */
public class MapController {

    private MapView mapView;

    private Map<String, MarkerHolder> markerHolderHashMap = new HashMap<>();
    private Map<String, PolygonHolder> polygonHolderHashMap = new HashMap<>();

    public MapController(MapView mapView) {
        this.mapView = mapView;
    }

    public void addMarker(long id, MarkerOptions markerOptions) {
        Marker marker = mapView.getMap().addMarker(markerOptions);

        MarkerHolder holder = new MarkerHolder(id + "", marker, markerOptions.getPosition().latitude,
                markerOptions.getPosition().longitude);
        markerHolderHashMap.put(id + "", holder);
    }


    public void addPolygon(long id, PolygonOptions polygonOptions) {
        Polygon polygon = mapView.getMap().addPolygon(polygonOptions);
        PolygonHolder holder = new PolygonHolder(id + "", polygon, polygonOptions);
        polygonHolderHashMap.put(id + "", holder);
    }

    public void updateMarker(long id, MarkerOptions markerOptions) {
        MarkerHolder holder = markerHolderHashMap.remove(id + "");
        holder.marker.remove();
        addMarker(id, markerOptions);
    }

    public void sss() {
        for (Map.Entry<String, PolygonHolder> entry : polygonHolderHashMap.entrySet()) {
            boolean contain = entry.getValue().polygon.contains(new LatLng(30.50, 114.40));

            Log.e("", "contain=" + contain);
        }


    }

    public void moveCenter() {

        LatLngBounds.Builder builder = LatLngBounds.builder();

        for (Map.Entry<String, MarkerHolder> entry : markerHolderHashMap.entrySet()) {
            MarkerHolder holder = entry.getValue();
            builder.include(new LatLng(holder.lat, holder.lng));
        }
        for (Map.Entry<String, PolygonHolder> entry : polygonHolderHashMap.entrySet()) {
            PolygonHolder holder = entry.getValue();

            List<LatLng> latLngList = holder.polygonOptions.getPoints();
            for (int i = 0; i < latLngList.size(); i++) {
                builder.include(latLngList.get(i));
            }
        }

        int padding = 100;
        CameraUpdate update = CameraUpdateFactory
                .newLatLngBoundsRect(builder.build(), padding, padding, padding, padding);
        mapView.getMap().animateCamera(update);
    }

}
