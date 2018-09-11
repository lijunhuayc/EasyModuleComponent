package com.renxin.cheku.sharesdk;

import android.content.Context;

import cn.sharesdk.framework.ShareSDK;

/**
 * Desc:
 * Created by Junhua.Li
 * Date: 2018/06/22 15:24
 */
public class ShareSdkUtils {
    public static final void init(Context pContext) {
        ShareSDK.initSDK(pContext);
    }
}
