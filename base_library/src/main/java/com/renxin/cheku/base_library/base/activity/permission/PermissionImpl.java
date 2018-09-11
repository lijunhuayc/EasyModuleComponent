package com.renxin.cheku.base_library.base.activity.permission;

import android.support.annotation.NonNull;

/**
 * Desc:权限动态检查
 * Created by JiaKun.Yang
 * Date: 2018/06/19 09:53
 */
public interface PermissionImpl {
    void checkPermission(@NonNull String permissionDes, PermissionCallback runnable, @NonNull String... permissions);

    boolean checkPermissionGranted(String[] permissions);

    void requestPermission(String permissionDes, final int requestCode, final String[] permissions);

    boolean shouldShowRequestPermissionRationale(String[] permissions);

    boolean verifyPermissions(int[] grantResults);
}
