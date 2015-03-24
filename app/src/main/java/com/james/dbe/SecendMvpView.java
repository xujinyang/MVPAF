package com.james.dbe;

import android.view.View;
import android.widget.TextView;

import com.james.dbe.Base.view.BaseMvpView;

import butterknife.InjectView;

/**
 * Created by james on 24/3/15.
 */
public class SecendMvpView extends BaseMvpView {
    @InjectView(R.id.secend)
    TextView secend;

    @Override
    protected void OnViewCreated() {

    }

    public void setListener(View.OnClickListener onClickListener) {
        secend.setOnClickListener(onClickListener);
    }
}
