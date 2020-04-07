package com.demo.router.module1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.demo.router.annotation.Route;
import com.demo.router.api.Router;
import com.demo.router.provider.MainProvider;

@Route(path = "/module1/activity")
public class Module1Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module1);
    }

    public void jumpMain(View v) {
        Router.getInstance()
                .build("/main/activity")
                .navigation();
        finish();
    }

    public void callMainProvider(View v) {
        MainProvider mainProvider = (MainProvider) Router.getInstance()
                .build("/main/provider")
                .navigation();
        mainProvider.providerMain(this);
    }

    public void jumpModule2(View v) {
        Router.getInstance()
                .build("/module2/activity")
                .navigation();
        finish();
    }
}
