package com.james.dbe.Base.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by james on 24/3/15.
 */
public abstract class BaseMvpView<I extends PresenterObserver> implements MvpView {
    View view;
    I listener;

    @Override
    public void init(int layoutId, LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(layoutId, container, false);
        ButterKnife.inject(this, view);
        OnViewCreated();
    }

    protected abstract void OnViewCreated();

    public I getListener() {
        return listener;
    }

    public void setListener(I listener) {
        this.listener = listener;
    }

    @Override
    public View getView() {
        return view;
    }
}
