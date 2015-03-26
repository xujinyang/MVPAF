package com.james.dbe.spf;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 帮助存取SharedPreferences
 * <p/>
 * Created by Yufei Huang on 14-11-1.
 */
public class SharedPreferencesHelper {

    private SharedPreferences sp;

    public SharedPreferencesHelper(Context ctx, String name) {
        sp = ctx.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public String getString(String key) {
        return getString(key, "");
    }

    public String getString(String key, String defaultValue) {
        return sp.getString(key, defaultValue);
    }

    public boolean putString(String key, String content) {
        return sp.edit().putString(key, content).commit();
    }
}
