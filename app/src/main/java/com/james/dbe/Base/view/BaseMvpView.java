package com.james.dbe.Base.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by james on 24/3/15.
 */
public abstract class BaseMvpView implements MvpView {
    View view;

    @Override
    public void init(int layoutId, LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(layoutId, container, false);
        ButterKnife.inject(this, view);
        OnViewCreated();
    }

    protected abstract void OnViewCreated();

    @Override
    public View getView() {
        return view;
    }
}
