package com.james.dbe.Base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.james.dbe.Base.view.BaseMvpView;
import com.james.dbe.Base.view.ContentView;
import com.james.dbe.Base.view.MvpView;
import com.james.dbe.Base.view.PresenterObserver;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.EventBusException;

/**
 * Created by james on 24/3/15.
 */
public class MvpActivity<V extends MvpView> extends FragmentActivity {
    private V view;
    private EventBus eventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(view.getView());
        setListener();
    }

    public V getView() {
        return view;
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

    private void setListener() {
        if (this instanceof PresenterObserver)
            ((BaseMvpView) view).setListener((PresenterObserver) this);
    }

    private void init() {
        try {
            view = getViewClass().newInstance();
            view.init(getLayoutId(), getLayoutInflater(), null);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private int getLayoutId() {
        ContentView contentView = getClass().getAnnotation(ContentView.class);
        if (contentView == null) {
            Log.i("MVP", "ContentView is null");
        } else {
            return contentView.value();
        }
        return 0;
    }

    protected Class<V> getViewClass() {
        Class<V> vClass = null;
        do {
            Type genType = getClass().getGenericSuperclass();
            if (!(genType instanceof ParameterizedType)) {
                break;
            }
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            if (params == null || params.length < 1) {
                break;
            }
            if (params[0] != null && params[0] instanceof Class) {
                vClass = (Class<V>) params[0];
            }
        } while (false);
        return vClass;
    }
}
