package com.it520.takeout;

import android.app.Application;
import android.content.Context;
import android.os.Handler;


/* 
 * ============================================================
 * Editor: MuMuXuan(6511631@qq.com)
 *  
 * Time: 2017-02-23 22:47
 * 
 * Description: 
 *
 * Version: 1.0
 * ============================================================
 */

public class MyApplication extends Application {

    private  static Context sContext;
    private  static Handler sHandler;
    private  static int sMainThreadId;

    public static Context getContext(){
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        sMainThreadId = android.os.Process.myTid();
        sHandler = new Handler(getMainLooper());
    }

    public static Handler getMainThreadHandler() {
        return sHandler;
    }


    public static int getMainThreadId() {
        return sMainThreadId;
    }
}
