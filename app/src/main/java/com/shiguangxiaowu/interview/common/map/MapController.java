package com.shiguangxiaowu.interview.common.map;

import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by meikai on 2019/04/27.
 */
public class MapController {

    private MapView mapView;

    private Map<String, MarkerHolder> markerMap = new HashMap<>();

    public MapController(MapView mapView) {
        this.mapView = mapView;
    }

    public void addMarker(long id, MarkerOptions markerOptions) {
        Marker marker = mapView.getMap().addMarker(markerOptions);

        MarkerHolder holder = new MarkerHolder(id + "", marker, markerOptions.getPosition().latitude,
                markerOptions.getPosition().longitude);
        markerMap.put(id + "", holder);
    }

    public void updateMarker(long id, MarkerOptions markerOptions) {
        MarkerHolder holder = markerMap.remove(id + "");
        holder.marker.remove();
        addMarker(id, markerOptions);
    }

    public void moveCenter() {

        LatLngBounds.Builder builder = LatLngBounds.builder();

        for (Map.Entry<String, MarkerHolder> entry : markerMap.entrySet()) {
            MarkerHolder holder = entry.getValue();
            builder.include(new LatLng(holder.lat, holder.lng));
        }

        int padding = 100;
        CameraUpdate update = CameraUpdateFactory
                .newLatLngBoundsRect(builder.build(), padding, padding, padding, padding);
        mapView.getMap().animateCamera(update);
    }

}
