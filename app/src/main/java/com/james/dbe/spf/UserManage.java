package com.james.dbe.spf;

import android.content.Context;
import android.util.Log;

import com.james.dbe.model.User;

import javax.inject.Inject;

/**
 * Created by james on 25/3/15.
 */
public class UserManage {

    private SharedPreferencesHelper preferencesHelper;
    @Inject
    public UserManage(Context context) {
        preferencesHelper = new SharedPreferencesHelper(context, "user");
    }

    public void saveUser(User user) {
        Log.i("UserManage", "saveUser");

    }

    public void getUser() {
        Log.i("UserManage", "getUser");
    }
}
