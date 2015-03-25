package com.james.dbe.Base.presenter;

import android.os.Bundle;

/**
 * Created by james on 25/3/15.
 */
public interface MvpPresenter {
    /**
     * Activity.onCreate <br/>
     * Fragment.onViewCreated
     */
    void create(Bundle savedInstanceState);

    /**
     * Activity.onStart <br/>
     * Fragment.onStart
     */
    void start();

    /**
     * Activity.onResume <br/>
     * Fragment.onResume
     */
    void resume();

    /**
     * Activity.onPause <br/>
     * Fragment.onPause
     */
    void pause();

    /**
     * Activity.onStop <br/>
     * Fragment.onStop
     */
    void stop();

    /**
     * Activity.onDestory <br/>
     * Fragment.onDestory
     */
    void destory();

}
