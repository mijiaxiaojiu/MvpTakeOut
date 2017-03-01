package com.xiaojiu.mvpdmeo;

import android.app.Application;
import android.content.Context;

/**
 * 作者：${xiaojiukeji} on 17/3/1 22:32
 * 作用:
 */

public class MyApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext() {
        return context;
    }
}
