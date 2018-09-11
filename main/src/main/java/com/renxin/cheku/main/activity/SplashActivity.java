package com.renxin.cheku.main.activity;

import android.support.annotation.NonNull;

import com.renxin.cheku.base_library.base.activity.BaseActivity;
import com.renxin.cheku.main.R;

/**
 * Desc:
 * Created by Junhua.Li
 * Date: 2018/09/06 10:44
 */
public class SplashActivity extends BaseActivity {
    @NonNull
    @Override
    protected String getPageName() {
        return "APP启动页面";
    }

    @Override
    protected int initLayout() {
        return R.layout.main_activity_splash;
    }

    @Override
    protected void initUI() {

    }

    @Override
    protected void onCreated() {

    }
}
