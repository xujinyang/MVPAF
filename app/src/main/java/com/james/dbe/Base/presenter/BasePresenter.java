package com.james.dbe.Base.presenter;

import android.content.Context;
import android.os.Bundle;

import com.james.dbe.Base.view.MvpView;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.EventBusException;

/**
 * Created by james on 25/3/15.
 */
public class BasePresenter<V extends MvpView> implements MvpPresenter {
    protected V view;
    private EventBus eventBus;
    private Context context;

    public void setViewListener(V view) {
        this.view = view;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public EventBus getEventBus() {
        if (eventBus == null) {
            eventBus = EventBus.getDefault();
        }
        return eventBus;
    }

    public void registerEventBusListener(Object object) {
        if (getEventBus() != null) {
            try {
                getEventBus().register(object);
            } catch (EventBusException eventBusException) {
                eventBusException.printStackTrace();
            }
        }
    }

    public void unregisterEventBusListener(Object object) {
        if (getEventBus() != null) {
            getEventBus().unregister(object);
        }
    }

    @Override
    public void create(Bundle savedInstanceState) {

    }

    @Override
    public void start() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destory() {
        unregisterEventBusListener(this);
    }
}
