package com.it520.takeout.presenter.api;

/* 
 * ============================================================
 * Editor: MuMuXuan(6511631@qq.com)
 *  
 * Time: 2017-02-23 22:54
 * 
 * Description: 
 *
 * Version: 1.0
 * ============================================================
 */

import com.it520.takeout.model.net.bean.ResponseInfo;
import com.it520.takeout.utils.Constant;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ResponseInfoAPI {

    @GET(Constant.LOGIN)
    Call<ResponseInfo> login(
            @Query("username")
            String username,
            @Query("password")
            String password);
}
