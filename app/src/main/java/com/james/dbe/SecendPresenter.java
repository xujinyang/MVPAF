package com.james.dbe;

import com.james.dbe.Base.event.ClickEvent;
import com.james.dbe.Base.presenter.BasePresenter;
import com.james.dbe.Base.view.MvpView;

/**
 * Created by james on 24/3/15.
 */
public class SecendPresenter extends BasePresenter<SecendPresenter.SecendView> {

    public void sendEvent() {
        getEventBus().post(new ClickEvent());
    }

    public interface SecendView extends MvpView {

    }
}
