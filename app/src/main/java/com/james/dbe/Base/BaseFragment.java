package com.james.dbe.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.james.dbe.Base.view.ContentView;
import com.james.dbe.MvpActivity;

import butterknife.ButterKnife;

/**
 * Created by james on 25/3/15.
 */
public class BaseFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    private int getLayoutId() {
        ContentView contentView = getClass().getAnnotation(ContentView.class);
        if (contentView == null) {
            Log.i("MVP", "ContentView is null");
        } else {
            return contentView.value();
        }
        return 0;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        injectViews(view);
    }

    protected ActionBar getSupportActionBar() {
        return ((MvpActivity) getActivity()).getSupportActionBar();
    }

    protected void setTitle(int resId) {
        try {
            ((MvpActivity) getActivity())
                    .getSupportActionBar().setTitle(resId);
        } catch (Exception e) {
            //NO OP
        }
    }

    protected void setTitle(String title) {
        try {
            ((MvpActivity) getActivity())
                    .getSupportActionBar().setTitle(title);
        } catch (Exception e) {
            //NO OP
        }
    }

    /**
     * 注入View
     *
     * @param view 需要注入的View
     */
    private void injectViews(final View view) {
        ButterKnife.inject(this, view);
    }
}
