package com.james.dbe;

import android.app.Application;
import android.content.Context;

import com.james.dbe.module.AppModule;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by james on 25/3/15.
 */
public class App extends Application {
    ObjectGraph objectGraph;
    public static App from(Context context) {
        return (App) context.getApplicationContext();
    }
    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(getModules().toArray());
        inject(this);
    }

    public void inject(Object target) {
        objectGraph.inject(target);
    }

    public ObjectGraph getObjectGraph() {
        return objectGraph;
    }

    public List<Object> getModules() {
        return Arrays.<Object>asList(new AppModule(this));
    }

}
