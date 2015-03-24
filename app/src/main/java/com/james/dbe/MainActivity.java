package com.james.dbe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.james.dbe.Base.MvpActivity;
import com.james.dbe.Base.event.ClickEvent;
import com.james.dbe.Base.view.ContentView;

@ContentView(R.layout.activity_main)
public class MainActivity extends MvpActivity<TestMvpView> implements TestMvpView.TestObserver {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getEventBus().register(this);
    }

    private void toSecendActivity() {
        Intent intent = new Intent(MainActivity.this, SecendActivity.class);
        startActivity(intent);
    }

    public void onEvent(ClickEvent event) {
        Toast.makeText(getApplicationContext(), "测试eventBus", Toast.LENGTH_LONG).show();
        getView().setName("测试成功");
    }

    @Override
    public void onClickName() {
        toSecendActivity();
    }
}
