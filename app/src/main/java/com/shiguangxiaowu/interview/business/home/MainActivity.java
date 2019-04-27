package com.shiguangxiaowu.interview.business.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.shiguangxiaowu.interview.R;
import com.shiguangxiaowu.interview.business.familymap.FamilyMapShowActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sg__main_activity);

        findViewById(R.id.btn_open_demo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FamilyMapShowActivity.start(MainActivity.this);
            }
        });
    }
}
