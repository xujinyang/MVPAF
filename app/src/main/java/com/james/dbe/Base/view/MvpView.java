package com.james.dbe.Base.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by james on 24/3/15.
 */
public interface MvpView {
    void init(int layoutId, LayoutInflater inflater, ViewGroup container);

    View getView();
}
