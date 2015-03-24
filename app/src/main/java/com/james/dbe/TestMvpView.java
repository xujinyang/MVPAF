package com.james.dbe;

import android.view.View;
import android.widget.TextView;

import com.james.dbe.Base.view.BaseMvpView;
import com.james.dbe.Base.view.PresenterObserver;

import butterknife.InjectView;

/**
 * Created by james on 24/3/15.
 */
public class TestMvpView extends BaseMvpView<TestMvpView.TestObserver> {
    @InjectView(R.id.name)
    TextView name;

    @Override
    protected void OnViewCreated() {
        name.setText("fuck all");
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getListener().onClickName();
            }
        });
    }

    public void setName(String str) {
        name.setText(str);
    }

    public interface TestObserver extends PresenterObserver {
        void onClickName();
    }
}
