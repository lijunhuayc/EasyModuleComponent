package com.renxin.cheku.base_library;

import android.app.Application;
import android.content.pm.PackageManager;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.renxin.cheku.base_library.base.delegate.ApplicationDelegate;
import com.renxin.cheku.base_library.data_report.ReportDataService;
import com.renxin.cheku.base_library.data_source.SharedPreferencesUtils;
import com.renxin.cheku.base_library.utils.FileUtils;
import com.renxin.cheku.base_library.utils.MyToast;
import com.renxin.cheku.base_library.utils.Timber;
import com.renxin.cheku.sharesdk.ShareSdkUtils;
import com.umeng.analytics.MobclickAgent;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import cn.jpush.android.api.JPushInterface;

import static com.renxin.cheku.base_library.data_source.SharedPreferencesUtils.Key.SP_KEY_CHANNEL_NAME;

/**
 * Desc: base_library module 分发 application
 * PS: 此 Application并非APP的Application, 需要通过 getApplicationContext() 来获取
 * Created by Junhua.Li
 * Date: 2018/06/20 17:02
 */
public class BaseLibraryApplication extends ApplicationDelegate {
    static Application sApplication;

    public static Application getApplication() {
        return sApplication;
    }

    @Override
    public int getLevel() {
        return LEVEL_BASE_LIB;
    }

    @Override
    public Class[] subDelegates() {
        return new Class[0];
    }

    @Override
    public void onCreateDelegate() {
        sApplication = (Application) getApplicationContext();
        //created by lijunhua
        //SharedPreferencesUtils初始化需要在有SharedPreferencesUtils使用的代码前面
        // (比如: ReportDataService.getInstance().init()中会发起网络请求, 会加载WebAPI类触发static代码块,其中会使用到SharedPreferencesUtils)
        //SP 初始化完后预先读取 渠道名(WebAPI 中开发环境配置用)
        SharedPreferencesUtils.init(sApplication);
        try {
            SharedPreferencesUtils.setString(SP_KEY_CHANNEL_NAME, sApplication.getPackageManager().getApplicationInfo(sApplication.getPackageName(), PackageManager.GET_META_DATA).metaData.getString("UMENG_CHANNEL"));
        } catch (PackageManager.NameNotFoundException pE) {
            pE.printStackTrace();
        }

        //--------------
        MyToast.init(sApplication);
        FileUtils.init(sApplication);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new Timber.Tree() {
                @Override
                protected void log(int priority, String tag, String message, Throwable t) {
                    if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                        return;
                    }
                    FakeCrashLibrary.log(priority, tag, message);
                    if (t != null) {
                        if (priority == Log.ERROR) {
                            FakeCrashLibrary.logError(t);
                        } else if (priority == Log.WARN) {
                            FakeCrashLibrary.logWarning(t);
                        }
                    }
                }
            });
        }

        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.printStackTrace(); // 打印日志的时候打印线程堆栈
        }
        ARouter.init(sApplication); // 尽可能早，推荐在Application中初始化
        //推送注册
        JPushInterface.setDebugMode(BuildConfig.DEBUG);
        JPushInterface.init(sApplication);
        setJPushAlias("lijunhua");
        Timber.d("JPush UUID: %s", JPushInterface.getUdid(sApplication));

        MobclickAgent.setDebugMode(BuildConfig.DEBUG);
        ShareSdkUtils.init(sApplication);//分享初始化

//        ReportDataService.getInstance().init();//初始化数据上报服务 //TODO ...
        //created by lijunhua
    }

    /**
     * 测试机别名, 仅DEBUG执行
     *
     * @param alias
     */
    private void setJPushAlias(String alias) {
        if (BuildConfig.DEBUG) {
            if (SharedPreferencesUtils.getBoolean("has_alias", false)) {
                JPushInterface.setAlias(sApplication, alias, (pCode, pAlias, pSet) -> {
                    switch (pCode) {
                        case 0:
                            Timber.d("[JPushInterface] JPushInterface.setAlias success. alias = %s", pAlias);
                            SharedPreferencesUtils.setBoolean("has_alias", true);
                            MyToast.showTestToast("JPush setAliasAndTags success. alias = " + pAlias + "[Test]\n仅仅测试环境 ");
                            break;
                        case 6002:
                            Timber.d("[JPushInterface] JPushInterface.setAlias failure, code = %s", pCode);
                            Executors.newSingleThreadScheduledExecutor().schedule(() -> setJPushAlias(pAlias), 60, TimeUnit.SECONDS);//延迟60s 重新设置别名
                            break;
                        default:
                            Timber.d("[JPushInterface] JPushInterface.setAlias failure, code = %s", pCode);
                            MyToast.showTestToast("JPush setAliasAndTags failure, code = " + pCode + ".[Test]\n仅仅测试环境 ");
                            break;
                    }
                });
            }
        }
    }
}

final class FakeCrashLibrary {
    public static void log(int priority, String tag, String message) {
        // TODO add log entry to circular buffer.
    }

    public static void logWarning(Throwable t) {
        // TODO report non-fatal warning.
    }

    public static void logError(Throwable t) {
        // TODO report non-fatal error.
    }

    private FakeCrashLibrary() {
        throw new AssertionError("No instances.");
    }
}
