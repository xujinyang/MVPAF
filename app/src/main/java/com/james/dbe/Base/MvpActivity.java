package com.james.dbe.Base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.james.dbe.Base.model.BaseMvpModel;
import com.james.dbe.Base.model.MvpModel;
import com.james.dbe.Base.view.ContentView;
import com.james.dbe.Base.view.MvpView;
import com.james.dbe.Base.view.ViewInterface;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.EventBusException;

/**
 * Created by james on 24/3/15.
 */
public class MvpActivity<V extends MvpView, M extends MvpModel> extends FragmentActivity {
    private V view;
    private M model;
    private EventBus eventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(view.getView());
        bindModel();
    }

    public V getView() {
        return view;
    }

    public M getModle() {
        return model;
    }

    public ViewInterface getInterface() {
        if (view instanceof ViewInterface) {
            return (ViewInterface) view;
        }
        return null;
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

    private void bindModel() {
        try {
            model = getModelClass().newInstance();
            ((BaseMvpModel) model).setContext(this);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
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

    protected Class<M> getModelClass() {
        Class<M> vClass = null;

        do {
            Type genType = getClass().getGenericSuperclass();
            if (!(genType instanceof ParameterizedType)) {
                break;
            }
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            if (params == null || params.length < 2) {
                break;
            }
            if (params[1] != null && params[1] instanceof Class) {
                vClass = (Class<M>) params[1];
            }
        } while (false);

        return vClass;
    }
}
