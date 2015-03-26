package com.james.dbe.Base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.james.dbe.Base.presenter.BasePresenter;
import com.james.dbe.Base.view.MvpView;
import com.james.dbe.MvpActivity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by james on 25/3/15.
 */
public class MvpFragment<P extends BasePresenter, V extends MvpView> extends BaseFragment {
    protected MvpActivity mvpActivity;
    protected P presenter;
    protected V view;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mvpActivity = (MvpActivity) getActivity();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpInit();
        init();
    }

    private void init() {
        if (presenter != null) {
            presenter.registerEventBusListener(this);
        }
    }

    private void mvpInit() {
        try {
            if (getPresenterClass() != null)
                presenter = getPresenterClass().newInstance();
            if (this instanceof MvpView) {
                view = (V) this;
            }
            if (presenter != null) {
                presenter.setViewListener(view);
                presenter.setContext(getActivity());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Class<P> getPresenterClass() {
        Class<P> pClass = null;

        do {
            Type genType = getClass().getGenericSuperclass();
            if (!(genType instanceof ParameterizedType)) {
                break;
            }
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            if (params == null || params.length < 1) {
                break;
            }
            if (params[0] != null && params[0] instanceof Class) {
                pClass = (Class<P>) params[0];
            }
        } while (false);

        return pClass;
    }

}
