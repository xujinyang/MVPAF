package com.james.dbe;

import android.os.Bundle;
import android.view.View;

import com.james.dbe.Base.MvpActivity;
import com.james.dbe.Base.event.ClickEvent;
import com.james.dbe.Base.view.ContentView;

/**
 * Created by james on 24/3/15.
 */
@ContentView(R.layout.activity_secend)
public class SecendActivity extends MvpActivity<SecendMvpView> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getView().setListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getEventBus().post(new ClickEvent());
            }
        });
    }
}
