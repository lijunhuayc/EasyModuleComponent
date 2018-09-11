package com.renxin.cheku.app;

import android.app.Application;

import com.renxin.cheku.base_library.base.delegate.ApplicationDelegate;
import com.renxin.cheku.main.MainApplication;
import com.renxin.cheku.user_info.UserInfoApplication;

/**
 * Desc: 壳工程(主工程) Application 分发
 * Created by Junhua.Li
 * Date: 2018/06/20 20:50
 */
public class AppApplication extends ApplicationDelegate {
    static Application sApplication;

    public static Application getApplication() {
        return sApplication;
    }

    @Override
    public int getLevel() {
        return LEVEL_APP;
    }

    @Override
    public Class[] subDelegates() {
        return new Class[]{MainApplication.class, UserInfoApplication.class};
    }

    @Override
    public void onCreateDelegate() {
        sApplication = (Application) getApplicationContext();
    }
}

