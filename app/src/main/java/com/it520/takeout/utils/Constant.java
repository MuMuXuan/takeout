package com.it520.takeout.utils;


public interface Constant {

    String BASEURL="http://172.16.0.116:8080/";
    // 登陆
    String LOGIN="TakeoutService/login";
    // http://localhost:8080/TakeoutService/home
    String HOME="TakeoutService/home";
    // http://localhost:8080/TakeoutService/goods?sellerId=1
    String GOODS = "TakeoutService/goods";
    //    http://localhost:8080/TakeoutService/address?userId=2163&&&&&&
    String ADDRESS="TakeoutService/address";

    String ORDER = "TakeoutService/order";
    String PAY="TakeoutService/pay";

    // 短信登陆的分类值
    int LOGIN_TYPE_SMS=2;



}
