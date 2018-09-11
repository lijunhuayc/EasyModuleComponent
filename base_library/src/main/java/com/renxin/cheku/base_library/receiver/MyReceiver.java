package com.renxin.cheku.base_library.receiver;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.renxin.cheku.arouter.RouterTable;
import com.renxin.cheku.arouter.provider.UserInfoProvider;
import com.renxin.cheku.base_library.data_source.net.BaseLibraryAPIService;
import com.renxin.cheku.base_library.data_source.net.retrofit.RetrofitUtils;
import com.renxin.cheku.base_library.model.AppInfoModel;
import com.renxin.cheku.base_library.model.BaseResult;
import com.renxin.cheku.base_library.model.bridge_model.TransCenterBean;
import com.renxin.cheku.base_library.model.bridge_model.user.LoginUser;
import com.renxin.cheku.base_library.utils.Timber;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;

import cn.jpush.android.api.JPushInterface;
import retrofit2.Call;

/**
 * DESC: modify by junhua.li 此类不再直接接收消息推送, 消息接收提取到 jpush module中 通过 arouter 共享接口(IProvider) 形式代理转发到此类处理
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Timber.d("[MyReceiver] onReceive: action = %s, intent.getExtras(Bundle) = %s", intent.getAction(), printBundle(bundle));
        String extrasJson = bundle.getString(JPushInterface.EXTRA_EXTRA);
        Timber.d("[MyReceiver] onReceive: JPushInterface.EXTRA_EXTRA = %s", extrasJson);
        TransCenterBean.ExtrasMessageModel extrasExtrasMessageModel = new Gson().fromJson(extrasJson, TransCenterBean.ExtrasMessageModel.class);

        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
            Timber.d("[MyReceiver] onReceive: action = ACTION_REGISTRATION_ID, EXTRA_REGISTRATION_ID = %s", bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID));
            //send the Registration Id to your server...
        } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            Timber.d("[MyReceiver] onReceive: action = ACTION_MESSAGE_RECEIVED");
            processCustomMessage();// TODO: 2018/6/26 0026 这行好像没啥实质上的意义
        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
            Timber.d("[MyReceiver] onReceive: action = ACTION_NOTIFICATION_RECEIVED");
            refreshOrderList(context, extrasExtrasMessageModel);
            refreshUserInfo(extrasExtrasMessageModel);
            //此处可以收到 JPushInterface.EXTRA_EXTRA 字段信息
        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            Timber.d("[MyReceiver] onReceive: action = ACTION_NOTIFICATION_OPENED [用户点击通知栏]");
            //此处可以收到 JPushInterface.EXTRA_EXTRA 字段信息
            //点击通知栏时处理 JPushInterface.EXTRA_EXTRA 扩展消息信息, 比如按自定义消息类型处理页面跳转
            if (null == extrasExtrasMessageModel) {
                Timber.d("[MyReceiver] onReceive: action = ACTION_NOTIFICATION_OPENED, extrasExtrasMessageModel = null");
                return;
            }
            handleExtrasMessage(context, extrasExtrasMessageModel);//处理 extras 扩展消息
        } else if (JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(intent.getAction())) {
            Timber.d("[MyReceiver] onReceive: action = ACTION_RICHPUSH_CALLBACK");
        } else if (JPushInterface.ACTION_CONNECTION_CHANGE.equals(intent.getAction())) {
            Timber.d("[MyReceiver] onReceive: action = ACTION_CONNECTION_CHANGE, JPushInterface.EXTRA_CONNECTION_CHANGE = %s", intent.getBooleanExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false));
        } else {
            Timber.d("[MyReceiver] onReceive: others message.");
        }
    }

    private static void refreshOrderList(Context context, TransCenterBean.ExtrasMessageModel extrasExtrasMessageModel) {
        if (extrasExtrasMessageModel != null) {
            String params = extrasExtrasMessageModel.getMessage_param();
            if (!TextUtils.isEmpty(params)) {
                try {
                    JSONObject jsonObject = new JSONObject(params);
                    String action_type = jsonObject.optString("action_type");
                    if ("order_finance".equals(action_type)) {
                        Intent intent = new Intent();
                        intent.setAction("com.renxin.cheku.finance.notifyOrderStateChanged");
                        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                    }
                } catch (JSONException pE) {
                    pE.printStackTrace();
                }
            }
        }
    }

    /**
     * 处理 extras 扩展消息
     *
     * @param pContext
     * @param pExtrasMessageModel
     */
    private static void handleExtrasMessage(Context pContext, TransCenterBean.ExtrasMessageModel pExtrasMessageModel) {
        //打开自定义的Activity
        if (null != pExtrasMessageModel) {
            doStartApplicationWithPackageName(pContext);
            Intent intent = new Intent("com.renxin.cheku.finance.message");
            int type = pExtrasMessageModel.getType();
            intent.putExtra("type", type);
            if (type == 1) {
                intent.putExtra("title", pExtrasMessageModel.getTitle());
                intent.putExtra("url", pExtrasMessageModel.getWebsit());
            }
            pContext.sendStickyBroadcast(intent);
        }
    }

    public static boolean isForeground(Context context) {
        Log.d("balabala", "接收到notifycation的点击事件之后判断app是否已启动");
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (am == null) {
            return false;
        }
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(1);
        if (tasks != null && !tasks.isEmpty()) {
            ComponentName topActivity = tasks.get(0).topActivity;
            if (topActivity.getPackageName().equals(context.getPackageName())) {
                Log.d("balabala", "接收到notifycation的点击事件之后app已经启动了，将app拉到前台");
                am.moveTaskToFront(tasks.get(0).id, ActivityManager.MOVE_TASK_WITH_HOME);
                return true;
            }
        }
        return false;
    }

    /*打开app*/
    private static void doStartApplicationWithPackageName(Context context) {
        Log.d("balabala", "接收到notifycation的点击事件之后启动app或把app提到前台");
        if (isForeground(context)) {
            return;
        }
        Log.d("balabala", "接收到notifycation的点击事件之后检测到app未启动，将App打开");
        String packageName = AppInfoModel.getInstance().getPackageName();
        // 通过包名获取此APP详细信息，包括Activities、services、versioncode、name等等
        PackageInfo packageinfo = null;
        try {
            packageinfo = context.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageinfo == null) {
            return;
        }

        // 创建一个类别为CATEGORY_LAUNCHER的该包名的Intent
        Intent resolveIntent = new Intent(Intent.ACTION_MAIN);
        resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        resolveIntent.setPackage(packageinfo.packageName);

        // 通过getPackageManager()的queryIntentActivities方法遍历
        List<ResolveInfo> resolveinfoList = context.getPackageManager()
                .queryIntentActivities(resolveIntent, 0);

        ResolveInfo resolveinfo = resolveinfoList.iterator().next();
        if (resolveinfo != null) {
            Log.d("balabala", "接收到notifycation的点击事件之后启动app或把app提到前台时查找app的launcherActivity");
            // 这个就是我们要找的该APP的LAUNCHER的Activity[组织形式：packagename.mainActivityname]
            String className = resolveinfo.activityInfo.name;
            // LAUNCHER Intent
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // 设置ComponentName参数1:packagename参数2:MainActivity路径
            ComponentName cn = new ComponentName(packageName, className);
            intent.setComponent(cn);
            context.startActivity(intent);
        }
    }

    /**
     * 收到 type == 2 时即刻刷新用户信息
     *
     * @param bean
     */
    private static void refreshUserInfo(TransCenterBean.ExtrasMessageModel bean) {
        if (null != bean && bean.getType() == 2) {
            RetrofitUtils.getInstance().request(BaseLibraryAPIService.class, new RetrofitUtils.RetrofitCallback<BaseLibraryAPIService, LoginUser>() {
                @Override
                public void onSuccess(LoginUser model) {
                    Timber.d("[MyReceiver] refreshUser.onDataSuccess: InfoUserInfo = %s", model);
                    UserInfoProvider mUserInfoProvider = (UserInfoProvider) ARouter.getInstance().build(RouterTable.PROVIDER_USER_INFO_PROVIDER_IMPL).navigation();
                    mUserInfoProvider.setUserInfo(new Gson().toJson(model));
                }

                @Override
                public void onError(int pStatus, String pMessage) {
                    Timber.d("[MyReceiver] refreshUser.onError: pMessage = %s", pMessage);
                }

                @Override
                public Call<BaseResult<LoginUser>> getAPI(BaseLibraryAPIService pT) {
                    return pT.getUserInfo();
                }

                @Override
                public void onFinish() {
                }
            });
        }
    }

    // 打印所有的 intent extra 数据
    private static String printBundle(Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        for (String key : bundle.keySet()) {
            if (key.equals(JPushInterface.EXTRA_NOTIFICATION_ID)) {
                sb.append("\nkey:" + key + ", value:" + bundle.getInt(key));
            } else if (key.equals(JPushInterface.EXTRA_CONNECTION_CHANGE)) {
                sb.append("\nkey:" + key + ", value:" + bundle.getBoolean(key));
            } else if (key.equals(JPushInterface.EXTRA_EXTRA)) {
                if (bundle.getString(JPushInterface.EXTRA_EXTRA).isEmpty()) {
                    Timber.d("[MyReceiver] This message has no Extra data");
                    continue;
                }
                try {
                    JSONObject json = new JSONObject(bundle.getString(JPushInterface.EXTRA_EXTRA));
                    Iterator<String> it = json.keys();
                    while (it.hasNext()) {
                        String myKey = it.next().toString();
                        sb.append("\nkey:" + key + ", value: [" +
                                myKey + " - " + json.optString(myKey) + "]");
                    }
                } catch (JSONException e) {
                    Timber.d("[MyReceiver] Get message extra JSON error!");
                }
            } else {
                sb.append("\nkey:" + key + ", value:" + bundle.getString(key));
            }
        }
        return sb.toString();
    }

    //send msg to MainActivity
    private static void processCustomMessage() {
        // TODO: 2018/6/25 0025  这个 skin_home_navi 好像无用
    }
}
