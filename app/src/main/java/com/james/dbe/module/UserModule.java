package com.james.dbe.module;

import android.content.Context;

import com.james.dbe.spf.UserManage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by james on 25/3/15.
 */
@Module(complete = false, library = true)
public class UserModule {

    @Provides
    @Singleton
    UserManage provideUserManage(Context context) {
        return new UserManage(context);
    }
}
