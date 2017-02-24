package com.it520.takeout.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceUtil {

    public static final String SP_FILE_NAME="cache";

    public static void putString(Context context,String key,String value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(key,value);
        //commit 同步的提交,有返回值
//        edit.commit();
        //apply 异步的提交,没有返回值
        edit.apply();
    }

    public static void putLong(Context context,String key,long value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong(key,value);
        //commit 同步的提交,有返回值
//        edit.commit();
        //apply 异步的提交,没有返回值
        edit.apply();
    }

    public static void putInt(Context context,String key,int value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(key,value);
        //commit 同步的提交,有返回值
//        edit.commit();
        //apply 异步的提交,没有返回值
        edit.apply();
    }


    public static String getString(Context context,String key){
        return getString(context,key,"");
    }

    public static String getString(Context context,String key,String defValue){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_FILE_NAME,
                Context.MODE_PRIVATE);
        String string = sharedPreferences.getString(key, defValue);
        return string;
    }

    public static long getLong(Context context,String key){
        return getLong(context,key,0);
    }

    public static long getLong(Context context,String key,long defValue){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_FILE_NAME,
                Context.MODE_PRIVATE);
        long string = sharedPreferences.getLong(key, defValue);
        return string;
    }

    public static int getInt(Context context,String key){
        return getInt(context,key,0);
    }

    public static int getInt(Context context,String key,int defValue){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_FILE_NAME,
                Context.MODE_PRIVATE);
        int string = sharedPreferences.getInt(key, defValue);
        return string;
    }
}
