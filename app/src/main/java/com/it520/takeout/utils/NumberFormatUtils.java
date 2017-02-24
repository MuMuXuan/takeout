package com.it520.takeout.utils;

import java.text.NumberFormat;

public class NumberFormatUtils {

    //格式化数据保留两位小数  并且带￥
    public static String formatDigits(double data){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        nf.setMaximumFractionDigits(2);
        return nf.format(data);
    }
}
