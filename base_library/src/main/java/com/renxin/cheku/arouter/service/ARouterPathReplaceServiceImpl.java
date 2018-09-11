package com.renxin.cheku.arouter.service;

import android.content.Context;
import android.net.Uri;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.PathReplaceService;
import com.renxin.cheku.arouter.RouterTable;
import com.renxin.cheku.base_library.utils.Timber;

/**
 * Desc: 全局PATH 拦截, 可重写跳转 PATH, return null 表示不处理
 * Created by Junhua.Li
 * Date: 2018/06/21 16:20
 */
@Route(path = RouterTable.AROUTER_PATH_SERVICE_SPECIAL_PATH, name = "ARouterPathReplaceServiceImpl")
public class ARouterPathReplaceServiceImpl implements PathReplaceService {
    @Override
    public String forString(String path) {
        Timber.d("ARouterService_ARouterPathReplaceServiceImpl.forString: path = %s", path);
        // TODO: 2018/6/21 0021 可做 PATH 替换
        return path;
    }

    @Override
    public Uri forUri(Uri uri) {
        Timber.d("ARouterService_ARouterPathReplaceServiceImpl.forUri: uri = %s", uri);
        return uri;
    }

    @Override
    public void init(Context context) {
        Timber.d("ARouterService_ARouterPathReplaceServiceImpl.init: ");
    }
}
