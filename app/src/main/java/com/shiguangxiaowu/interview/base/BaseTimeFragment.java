package com.shiguangxiaowu.interview.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by meikai on 2019/04/27.
 */
public abstract class BaseTimeFragment extends Fragment {

    private boolean isDestroyed = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isDestroyed = false;
    }

    @Override
    public void onDestroyView() {
        isDestroyed = true;
        super.onDestroyView();
    }
}
