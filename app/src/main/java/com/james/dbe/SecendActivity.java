package com.james.dbe;

import android.widget.TextView;

import com.james.dbe.Base.view.ContentView;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by james on 24/3/15.
 */
@ContentView(R.layout.activity_secend)
public class SecendActivity extends MvpActivity<SecendPresenter, SecendPresenter.SecendView> implements SecendPresenter.SecendView {

    @InjectView(R.id.secend)
    TextView secendView;

    @OnClick(R.id.secend)
    void onClickSecend() {
        presenter.sendEvent();
    }

}
