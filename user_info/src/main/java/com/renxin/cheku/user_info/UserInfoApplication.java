package com.renxin.cheku.user_info;

import android.app.Application;

import com.renxin.cheku.base_library.BaseLibraryApplication;
import com.renxin.cheku.base_library.base.delegate.ApplicationDelegate;

/**
 * Desc:
 * Created by Junhua.Li
 * Date: 2018/07/24 11:03
 */
public class UserInfoApplication extends ApplicationDelegate {
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
