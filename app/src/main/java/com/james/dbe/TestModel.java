package com.james.dbe;

import android.widget.Toast;

import com.james.dbe.Base.model.BaseMvpModel;

/**
 * Created by james on 24/3/15.
 */
public class TestModel extends BaseMvpModel {
    public void showTast() {
        Toast.makeText(getContext(), "fuckAll", Toast.LENGTH_LONG).show();
    }
}
