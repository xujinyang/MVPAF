package com.james.dbe.Base;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.james.dbe.Base.view.ContentView;

import butterknife.ButterKnife;

/**
 * Created by james on 25/3/15.
 */
public class BaseActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.inject(this);
        initActionBar();
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

    private void initActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_USE_LOGO | ActionBar.DISPLAY_SHOW_TITLE);
        }
    }

    public void setTitle(int titleId) {
        setTitle(getString(titleId));
    }

    public void setTitle(CharSequence title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }


}
