package com.james.dbe;

import android.os.Bundle;

import com.james.dbe.Base.presenter.BasePresenter;
import com.james.dbe.Base.view.MvpView;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by james on 24/3/15.
 */
public class MvpActivity<P extends BasePresenter, V extends MvpView> extends BaseActivity {
    protected V view;
    protected P presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.from(getApplicationContext()).inject(this);
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
                presenter.setContext(this);
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


    protected Class<V> getViewClass() {
        Class<V> vClass = null;
        do {
            Type genType = getClass().getGenericSuperclass();
            if (!(genType instanceof ParameterizedType)) {
                break;
            }
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            if (params == null || params.length < 2) {
                break;
            }
            if (params[1] != null && params[1] instanceof Class) {
                vClass = (Class<V>) params[1];
            }
        } while (false);
        return vClass;
    }
}
