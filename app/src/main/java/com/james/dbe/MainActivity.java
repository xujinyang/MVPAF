package com.james.dbe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.james.dbe.Base.MvpActivity;
import com.james.dbe.Base.event.ClickEvent;
import com.james.dbe.Base.view.ContentView;
import com.james.dbe.Base.view.ViewInterface;

@ContentView(R.layout.activity_main)
public class MainActivity extends MvpActivity<TestMvpView, TestModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getView().setListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                toSecendActivity();
            }
        });

        getEventBus().register(this);
    }

    private void toSecendActivity() {
        Intent intent = new Intent(MainActivity.this, SecendActivity.class);
        startActivity(intent);
    }

    public void onEvent(ClickEvent event) {
        Toast.makeText(getApplicationContext(), "测试eventBus", Toast.LENGTH_LONG).show();
        ((MainInterface) getInterface()).setName("测试成功");
    }

    public interface MainInterface extends ViewInterface {
        void setName(String name);
    }

}
