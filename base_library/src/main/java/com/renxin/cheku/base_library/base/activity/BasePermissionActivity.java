package com.renxin.cheku.base_library.base.activity;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import com.renxin.cheku.base_library.base.activity.permission.PermissionCallback;
import com.renxin.cheku.base_library.base.activity.permission.PermissionImpl;
import com.renxin.cheku.base_library.domain.MainThreadScheduler;
import com.renxin.cheku.cooldialog.CoolDialog;

/**
 * Desc:
 * Created by JiaKun.Yang
 * Date: 2018/06/15 17:03
 */
public class BasePermissionActivity extends BaseTopActivity implements PermissionImpl {
    private int permissionRequestCode = 2098;
    private PermissionCallback permissionRunnable;

    /**
     * Android M运行时权限请求封装
     *
     * @param permissionDes 权限描述
     * @param runnable      请求权限回调
     * @param permissions   请求的权限（数组类型），直接从Manifest中读取相应的值，比如Manifest.permission.WRITE_CONTACTS
     */
    @Override
    public void checkPermission(@NonNull String permissionDes,
                                PermissionCallback runnable,
                                @NonNull String... permissions) {
        if (permissions.length == 0) return;
        this.permissionRunnable = runnable;
        if ((Build.VERSION.SDK_INT < Build.VERSION_CODES.M) || checkPermissionGranted(permissions)) {
            if (permissionRunnable != null) {
                permissionRunnable.hasPermission();
                permissionRunnable = null;
            }
        } else {
            requestPermission(permissionDes, permissionRequestCode, permissions);
        }
    }

    @Override
    public boolean checkPermissionGranted(String[] permissions) {
        boolean flag = true;
        for (String p : permissions) {
            if (ActivityCompat.checkSelfPermission(this, p) != PackageManager.PERMISSION_GRANTED) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    @Override
    public void requestPermission(String permissionDes, final int requestCode, final String[] permissions) {
        if (shouldShowRequestPermissionRationale(permissions)) {
            CoolDialog.Builder builder = new CoolDialog.Builder(this)
                    .setTitle("提示")
                    .setMessage(permissionDes)
                    .setNegativeButton("取消", (dialog1, which) -> {
                        if (permissionRunnable != null) {
                            permissionRunnable.noPermission();
                            permissionRunnable = null;
                        }
                    })
                    .setPositiveButton("确定", (dialog2, which)
                            -> ActivityCompat.requestPermissions(this, permissions, requestCode));
            if (Looper.myLooper() == Looper.getMainLooper()) {
                builder.show();
            } else {
                MainThreadScheduler.getInstance().post(builder::show);
            }
        } else {
            ActivityCompat.requestPermissions(this, permissions, requestCode);
        }
    }

    @Override
    public boolean shouldShowRequestPermissionRationale(String[] permissions) {
        boolean flag = false;
        for (String p : permissions) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, p)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == permissionRequestCode) {
            if (verifyPermissions(grantResults)) {
                if (permissionRunnable != null) {
                    permissionRunnable.hasPermission();
                    permissionRunnable = null;
                }
            } else {
                if (permissionRunnable != null) {
                    permissionRunnable.noPermission();
                    permissionRunnable = null;
                }
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public boolean verifyPermissions(int[] grantResults) {
        if (grantResults.length < 1) {
            return false;
        }

        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }
}
