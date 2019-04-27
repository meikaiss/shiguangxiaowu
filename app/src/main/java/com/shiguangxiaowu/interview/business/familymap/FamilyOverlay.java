package com.shiguangxiaowu.interview.business.familymap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.shiguangxiaowu.interview.R;
import com.shiguangxiaowu.interview.business.familymap.model.FamilyMemberModel;
import com.shiguangxiaowu.interview.common.map.SGBaseMapOverlay;
import com.shiguangxiaowu.interview.common.util.ViewBitmapUtil;

import java.util.List;

/**
 * 我的家人 图层
 * Created by meikai on 2019/04/27.
 */
public class FamilyOverlay extends SGBaseMapOverlay {

    private Context context;
    private List<FamilyMemberModel> memberModelList;

    public FamilyOverlay(Context context, List<FamilyMemberModel> memberModelList) {
        this.context = context;
        this.memberModelList = memberModelList;
    }

    @Override
    public void onDraw() {

        if (memberModelList != null && memberModelList.size() > 0) {
            for (int i = 0; i < memberModelList.size(); i++) {
                drawMember(memberModelList.get(i));
            }

            mapController.moveCenter();
        }

    }

    @Override
    public void clearMapElements() {

    }

    private void drawMember(final FamilyMemberModel memberModel) {
        final MarkerOptions markerOption = new MarkerOptions();
        markerOption.position(new LatLng(memberModel.lat, memberModel.lng));
        markerOption.title(memberModel.role).snippet(memberModel.nickName);

        markerOption.draggable(true);//设置Marker可拖动

        FamilyMemberMarkerView markerView = new FamilyMemberMarkerView(context);
        int memberSquare = context.getResources().getDimensionPixelSize(R.dimen.sg__family_member_square_dimen);

        Bitmap markerBmp = ViewBitmapUtil.getBitmapFromVirtualView(markerView, memberSquare, memberSquare);

        markerOption.icon(BitmapDescriptorFactory.fromBitmap(markerBmp));
        markerOption.setFlat(true);//设置marker平贴地图效果

        mapController.addMarker(memberModel.id, markerOption);

        Glide.with(context).load(memberModel.avatar)
                .apply(new RequestOptions().placeholder(R.drawable.sg__shape_family_member_placeholder)
                        .error(R.drawable.sg__shape_family_member_placeholder))
                .circleCrop().listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target,
                    boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target,
                    DataSource dataSource, boolean isFirstResource) {

                FamilyMemberMarkerView markerView = new FamilyMemberMarkerView(context);
                markerView.imgAvatar.setImageDrawable(resource);

                int memberSquare = context.getResources().getDimensionPixelSize(R.dimen.sg__family_member_square_dimen);
                Bitmap markerBmp = ViewBitmapUtil.getBitmapFromVirtualView(markerView, memberSquare, memberSquare);

                markerOption.icon(BitmapDescriptorFactory.fromBitmap(markerBmp));
                markerOption.setFlat(true);//设置marker平贴地图效果

                mapController.updateMarker(memberModel.id, markerOption);

                return false;
            }
        }).submit();

    }

}
