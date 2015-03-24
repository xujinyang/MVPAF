package com.james.dbe.Base.view;

import android.util.Log;
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
    public void init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(getLayoutId(), container, false);
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

    private int getLayoutId() {
        ContentView contentView = getClass().getAnnotation(ContentView.class);
        if (contentView == null) {
            Log.i("MVP", "ContentView is null");
        } else {
            return contentView.value();
        }
        return 0;
    }
}
