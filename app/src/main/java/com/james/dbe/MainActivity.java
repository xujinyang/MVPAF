package com.james.dbe;

import android.widget.TextView;

import com.james.dbe.Base.event.ClickEvent;
import com.james.dbe.Base.view.ContentView;
import com.james.dbe.spf.UserManage;

import javax.inject.Inject;

import butterknife.InjectView;
import butterknife.OnClick;

@ContentView(R.layout.activity_main)
public class MainActivity extends MvpActivity<TestPresenter, TestPresenter.TestMvpView> implements TestPresenter.TestMvpView {
    @InjectView(R.id.name)
    TextView nameView;
    @Inject
    UserManage userManage;

    @OnClick(R.id.name)
    void onNameClick() {
        presenter.showName();
        userManage.getUser();
    }

    @Override
    public void changeName(String name) {
        nameView.setText(name);
    }

    public void onEventMainThread(ClickEvent event) {
        nameView.setText("接受到event");
    }
}
