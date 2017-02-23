package com.it520.takeout;

import android.app.Application;
import android.content.Context;


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

    public static Context getContext(){
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }
}
