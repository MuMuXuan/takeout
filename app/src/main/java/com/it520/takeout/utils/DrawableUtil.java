package com.it520.takeout.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

public class DrawableUtil {
   public static GradientDrawable getDrawable(int contentColor,int strokeRgb,int radius){
       GradientDrawable gradientDrawable = new GradientDrawable();
       //确定矩形的绘制type
       gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
       //设置绘画矩形内容页的颜色
        gradientDrawable.setColor(contentColor);
       //镶边操作，（边的宽度，镶边的颜色）
       gradientDrawable.setStroke(1,strokeRgb);
       //绘制圆角矩形
       gradientDrawable.setCornerRadius(radius);

       return gradientDrawable;
   }

    /**
     * 通过代码实现颜色选择器
     * @param pressDrawable     按下时的图片
     * @param normalDrawable    没按下时的图片
     * @return
     */
    public  static StateListDrawable getStateListDrawable(Drawable pressDrawable,Drawable normalDrawable){
        StateListDrawable stateListDrawable = new StateListDrawable();
        //状态对应的数组   需要关联的图片     控件可用且被点击时
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed,android.R.attr.state_enabled},pressDrawable);
        //控件可用，但是没有选中时
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled},normalDrawable);
        stateListDrawable.addState(new int[]{},normalDrawable);
        return stateListDrawable;
    }
}
