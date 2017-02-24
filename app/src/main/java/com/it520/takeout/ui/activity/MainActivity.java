package com.it520.takeout.ui.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.it520.takeout.R;
import com.it520.takeout.ui.fragment.HomeFragment;
import com.it520.takeout.ui.fragment.MeFragment;
import com.it520.takeout.ui.fragment.MoreFragment;
import com.it520.takeout.ui.fragment.OrderFragment;
import com.it520.takeout.utils.UIUtils;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks{


    @InjectView(R.id.main_fragment_container)
    FrameLayout mMainFragmentContainer;
    @InjectView(R.id.main_fragment_tabHost)
    FragmentTabHost mMainFragmentTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermission();
        ButterKnife.inject(this);
        initTabHost();
    }

    private void requestPermission() {
//        permission:android.permission.WRITE_EXTERNAL_STORAGE
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {//检查是否获取该权限
            Log.e(getClass().getSimpleName() + "xmg", "requestPermission: " + "已获取权限");
        } else {
            //第二个参数是被拒绝后再次申请该权限的解释
            //第三个参数是请求码
            //第四个参数是要申请的权限
            EasyPermissions.requestPermissions(this, "需要申请必要的存储等权限", 0, perms);
        }
    }

    private void initTabHost() {
        String[] tabTexts = getResources().getStringArray(R.array.main_tabs);
        int[] resIds = new int[]{R.drawable.home,R.drawable.order,R.drawable.me,R.drawable.more};
        Class<?>[] fragmentClasses = new Class[]{HomeFragment.class, OrderFragment.class, MeFragment.class, MoreFragment.class};
        //1 初始化 它能够替换Fragment,也是使用了FragmentManager ,需要把FragmentManager传给它
        mMainFragmentTabHost.setup(getApplicationContext(),getSupportFragmentManager(),R.id.main_fragment_container);
        //2 准备创建出来一个tab 不能直接用该类的方法来创建
        for (int i = 0; i < tabTexts.length; i++) {
            TabHost.TabSpec tabSpec = mMainFragmentTabHost.newTabSpec(tabTexts[i]);
            View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_tab, null);
            ImageView iv_item_tab = (ImageView) inflate.findViewById(R.id.iv_item_tab);
            TextView tv_item_tab = (TextView) inflate.findViewById(R.id.tv_item_tab);
            iv_item_tab.setImageResource(resIds[i]);
            tv_item_tab.setText(tabTexts[i]);
            tabSpec.setIndicator(inflate);
            //3 添加一个个tab进来
            mMainFragmentTabHost.addTab(tabSpec,fragmentClasses[i],null);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {
            // Do something after user returned from app settings screen, like showing a Toast.
            UIUtils.showToastSafe("请去设置中找到当前应用并提供权限");
        }
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults,this);
    }


    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        Log.e(getClass().getSimpleName() + "xmg", "onPermissionsGranted: " + "");
        //权限通过后，将会开始进行一些联网等操作

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        // (Optional) Check whether the user denied any permissions and checked "NEVER ASK AGAIN."
        // This will display a dialog directing them to enable the permission in app settings.
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).setTitle("权限认证失败").
                    setRationale("当前应用无法为您提供服务，请在应用设置中重新赋予权限")
                    .build().show();
        }
    }
}
