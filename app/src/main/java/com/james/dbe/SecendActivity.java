package com.james.dbe;

import android.os.Bundle;

import com.james.dbe.Base.MvpActivity;
import com.james.dbe.Base.event.ClickEvent;

/**
 * Created by james on 24/3/15.
 */

public class SecendActivity extends MvpActivity<SecendMvpView> implements TestMvpView.TestObserver {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClickName() {
        getEventBus().post(new ClickEvent());
    }
}
