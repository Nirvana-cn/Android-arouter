package com.example.arouter;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class ARouterApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initRouter();
    }

    private void initRouter() {
        ARouter.openDebug();
        ARouter.openLog();
        ARouter.init(this);
    }
}
