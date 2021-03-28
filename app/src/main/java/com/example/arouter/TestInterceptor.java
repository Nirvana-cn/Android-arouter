package com.example.arouter;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

@Interceptor(priority = 8, name = "测试用拦截器")
public class TestInterceptor implements IInterceptor {
    private static final String TAG = "TestInterceptor";

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Log.d(TAG, "进入拦截器");
        Log.d(TAG, postcard.getPath());
        if ("/test/detail".equals(postcard.getPath())) {
            callback.onInterrupt(new RuntimeException("路由异常"));
        } else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {

    }
}
