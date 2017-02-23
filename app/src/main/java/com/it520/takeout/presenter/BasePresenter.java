package com.it520.takeout.presenter;

/* 
 * ============================================================
 * Editor: MuMuXuan(6511631@qq.com)
 *  
 * Time: 2017-02-09 20:55 
 * 
 * Description:业务层公共部分代码封装
 *
 * Version: 1.0
 * ============================================================
 */

import com.it520.takeout.model.dao.DBHelper;
import com.it520.takeout.presenter.api.ResponseInfoAPI;
import com.it520.takeout.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BasePresenter {

    protected static ResponseInfoAPI mResponseInfoAPI;
    protected static DBHelper sDBHelper;

    //数据库
    //网络请求
    public BasePresenter(){
        if(mResponseInfoAPI==null){
            Retrofit.Builder builder = new Retrofit.Builder();
            builder.baseUrl(Constant.BASEURL);
            builder.addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = builder.build();
            mResponseInfoAPI = retrofit.create(ResponseInfoAPI.class);
        }
        if (sDBHelper == null) {
            sDBHelper = DBHelper.getSingleton();
        }
    }
}
