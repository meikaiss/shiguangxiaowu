package com.shiguangxiaowu.interview.business.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shiguangxiaowu.interview.R;
import com.shiguangxiaowu.interview.business.apng.APngActivity;
import com.shiguangxiaowu.interview.business.familymap.FamilyMapGuideActivity;
import com.shiguangxiaowu.interview.business.fencemap.FenceMapActivity;
import com.shiguangxiaowu.interview.business.placeholder.PlaceHolderActivity;
import com.shiguangxiaowu.interview.common.util.DimenUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meikai on 2019/07/30.
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sg__main_activity);

        recyclerView = findViewById(R.id.main_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mainAdapter = new MainAdapter();
        recyclerView.setAdapter(mainAdapter);

    }

    private static class MainAdapter extends RecyclerView.Adapter<MainVH>{

        private List<Class> activityClassList = new ArrayList(){
            {
                add(FamilyMapGuideActivity.class);
                add(FenceMapActivity.class);
                add(PlaceHolderActivity.class);
                add(APngActivity.class);
            }
        };

        @NonNull
        @Override
        public MainVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            TextView textView = new TextView(viewGroup.getContext());
            textView.setGravity(Gravity.CENTER_VERTICAL);
            RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    DimenUtil.dp2px(viewGroup.getContext(), 50));
            lp.setMarginStart(DimenUtil.dp2px(viewGroup.getContext(), 15));
            textView.setLayoutParams(lp);

            MainVH vh = new MainVH(textView);

            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull MainVH mainVH, final int i) {

            String className =  activityClassList.get(i).getSimpleName();
            mainVH.textView.setText(className);

            mainVH.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), activityClassList.get(i));

                    v.getContext().startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return activityClassList.size();
        }
    }

    private static class MainVH extends RecyclerView.ViewHolder{

        public TextView textView;

        public MainVH(@NonNull View itemView) {
            super(itemView);
            this.textView = (TextView) itemView;
        }

    }

}
