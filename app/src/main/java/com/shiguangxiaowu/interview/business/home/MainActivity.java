package com.shiguangxiaowu.interview.business.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.shiguangxiaowu.interview.R;
import com.shiguangxiaowu.interview.business.familymap.FamilyMapShowActivity;
import com.shiguangxiaowu.interview.business.familymap.model.FamilyMemberModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sg__main_activity);

        findViewById(R.id.btn_open_demo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<FamilyMemberModel> memberModelList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    FamilyMemberModel memberModel = new FamilyMemberModel();
                    memberModel.id = 100 + i;
                    memberModel.nickName = "昵称" + i;
                    memberModel.avatar = avatarUrlList.get((int) Math.round(Math.random() * (avatarUrlList.size() - 1)));
                    memberModel.role = roleList.get((int) Math.round(Math.random() * (roleList.size() - 1)));
                    memberModel.lat = 34.341568 + 2 * (Math.random() * 2 - 1);
                    memberModel.lng = 108.940174 + 5 * (Math.random() * 2 - 1);

                    memberModelList.add(memberModel);
                }

                FamilyMapShowActivity.start(MainActivity.this, memberModelList);
            }
        });
    }

    private List<String> roleList = new ArrayList() {
        {
            add("我");
            add("爸爸");
            add("妈妈");
            add("爷爷");
            add("奶奶");
            add("哥哥");
            add("弟弟");
            add("姐姐");
            add("妹妹");
            add("外公");
            add("外婆");
            add("");
        }
    };

    private List<String> avatarUrlList = new ArrayList() {
        {
            add("http://img4.imgtn.bdimg.com/it/u=2702928358,1983540142&fm=26&gp=0.jpg");
            add("http://b-ssl.duitang.com/uploads/item/201804/29/20180429162017_nyzfa.thumb.700_0.jpg");
            add("http://img2.imgtn.bdimg.com/it/u=2644676324,1946207392&fm=26&gp=0.jpg");
            add("http://img2.imgtn.bdimg.com/it/u=2960908468,3515491574&fm=26&gp=0.jpg");
            add("http://img3.imgtn.bdimg.com/it/u=320299743,2735495070&fm=11&gp=0.jpg");
            add("http://img4.imgtn.bdimg.com/it/u=1854731975,1387458779&fm=26&gp=0.jpg");
            add("http://www.leewiart.com/userfiles/37456/ef5b2d18912646579c1040ecc73dc8b2_view_720"
                    + ".jpg?636132932205312500");
            add("http://pic163.nipic.com/file/20180426/8737320_182218844088_2.jpg");
            add("http://img.mp.itc.cn/upload/20170501/af6a2f6bccd8436ba64bd80dcf2af1dc_th.jpeg");
            add("http://5b0988e595225.cdn.sohucs.com/q_70,c_zoom,w_640/images/20190401/1427911711ad4fd895c229b8268e8cf6.jpeg");
            add("");
        }
    };

}
