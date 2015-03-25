package com.james.dbe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.james.dbe.Base.MvpActivity;
import com.james.dbe.Base.event.ClickEvent;

import rx.Observable;
import rx.Subscriber;


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
        Observable.just("Hello, world!")
                .subscribe(s -> Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show());
    }

    private void totalObservable() {
        Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("rx开始");
                subscriber.onCompleted();
            }
        });

        Subscriber<String> mySubsriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Toast.makeText(getApplicationContext(), "rx结束", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }
        };
        myObservable.subscribe(mySubsriber);
    }
}
