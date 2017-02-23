package com.it520.takeout.model.dao;

/* 
 * ============================================================
 * Editor: MuMuXuan(6511631@qq.com)
 *  
 * Time: 2017-02-23 22:51
 * 
 * Description: 
 *
 * Version: 1.0
 * ============================================================
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.it520.takeout.MyApplication;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;

public class DBHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASENAME = "ite520.db";
    private static final int DATABASEVERSION = 1;
    public DBHelper(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    private static volatile DBHelper sInstance;
    
    public static DBHelper getSingleton(){
        if(sInstance==null){
            synchronized (DBHelper.class){
                if(sInstance==null){
                    sInstance = new DBHelper(MyApplication.getContext());
                }
            }
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }
}
