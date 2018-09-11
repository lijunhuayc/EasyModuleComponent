package com.renxin.cheku.main;

import android.app.Application;

import com.renxin.cheku.base_library.BaseLibraryApplication;
import com.renxin.cheku.base_library.base.delegate.ApplicationDelegate;

/**
 * Desc: main module Application 分发
 * Created by Junhua.Li
 * Date: 2018/06/20 20:50
 */
public class MainApplication extends ApplicationDelegate {
    static Application sApplication;

    public static Application getApplication() {
        return sApplication;
    }

    @Override
    public int getLevel() {
        return LEVEL_BIZ;
    }

    @Override
    public Class[] subDelegates() {
        return new Class[]{BaseLibraryApplication.class};
    }

    @Override
    public void onCreateDelegate() {
        sApplication = (Application) getApplicationContext();
    }
}

