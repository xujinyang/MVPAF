package com.james.dbe;

import android.widget.Toast;

import com.james.dbe.Base.presenter.BasePresenter;
import com.james.dbe.Base.view.MvpView;
import com.james.dbe.spf.UserManage;

import javax.inject.Inject;

/**
 * Created by james on 25/3/15.
 */
public class TestPresenter extends BasePresenter<TestPresenter.TestMvpView> {



    public void showName() {
        Toast.makeText(getContext(), "测试", Toast.LENGTH_LONG).show();
        view.changeName("改变");
    }

    interface TestMvpView extends MvpView {
        void changeName(String name);
    }
}
