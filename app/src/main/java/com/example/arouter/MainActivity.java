package com.example.arouter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/test/main")
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TestInterceptor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.text_main).setOnClickListener(v -> {
            ARouter.getInstance().build("/test/detail").navigation(this, new NavigationCallback() {
                @Override
                public void onFound(Postcard postcard) {
                    Log.d(TAG, "onFound");
                }

                @Override
                public void onLost(Postcard postcard) {
                    Log.d(TAG, "onLost");
                }

                @Override
                public void onArrival(Postcard postcard) {
                    Log.d(TAG, "onArrival");
                }

                @Override
                public void onInterrupt(Postcard postcard) {
                    Log.d(TAG, "onInterrupt");
                    ARouter.getInstance().build("/test/about").navigation();
                }
            });
        });
    }

}