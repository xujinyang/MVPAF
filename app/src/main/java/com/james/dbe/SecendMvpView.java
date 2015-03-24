package com.james.dbe;

import android.view.View;
import android.widget.TextView;

import com.james.dbe.Base.view.BaseMvpView;
import com.james.dbe.Base.view.ContentView;

import butterknife.InjectView;

/**
 * Created by james on 24/3/15.
 */
@ContentView(R.layout.activity_secend)
public class SecendMvpView extends BaseMvpView<TestMvpView.TestObserver> {
    @InjectView(R.id.secend)
    TextView secend;

    @Override
    protected void OnViewCreated() {
        secend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getListener().onClickName();
            }
        });
    }


}
