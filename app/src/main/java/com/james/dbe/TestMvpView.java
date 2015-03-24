package com.james.dbe;

import android.view.View;
import android.widget.TextView;

import com.james.dbe.Base.view.BaseMvpView;

import butterknife.InjectView;

/**
 * Created by james on 24/3/15.
 */
public class TestMvpView extends BaseMvpView implements MainActivity.MainInterface {
    @InjectView(R.id.name)
    TextView name;

    @Override
    protected void OnViewCreated() {
        name.setText("fuck all");
    }

    protected void setListener(View.OnClickListener listener) {
        name.setOnClickListener(listener);
    }

    @Override
    public void setName(String str) {
        name.setText(str);
    }
}
