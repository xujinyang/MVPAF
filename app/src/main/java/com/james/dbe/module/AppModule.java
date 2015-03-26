package com.james.dbe.module;

import android.content.Context;

import com.james.dbe.App;
import com.james.dbe.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                App.class,
                MainActivity.class
        },
        includes = {
                UserModule.class
        },
        library = true
)
public class AppModule {
    App app;

    public AppModule(App ctx) {
        this.app = ctx;
    }

    @Provides
    Context provideContext() {
        return this.app;
    }

    @Provides
    App provideApp() {
        return app;
    }

}