package com.james.dbe.Base.model;

import android.content.Context;

/**
 * Created by james on 24/3/15.
 */
public class BaseMvpModel implements MvpModel {
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public Context getContext() {
        return context;
    }
}
