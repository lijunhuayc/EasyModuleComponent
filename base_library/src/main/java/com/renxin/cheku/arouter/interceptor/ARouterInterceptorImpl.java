package com.renxin.cheku.arouter.interceptor;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.renxin.cheku.base_library.utils.Timber;

/**
 * Desc: finance module ARouter interrupt
 * Created by Junhua.Li
 * Date: 2018/06/21 15:29
 */
@Interceptor(priority = 6, name = "ARouterInterceptorImpl")
public class ARouterInterceptorImpl implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Timber.d("ARouterService_ARouterInterceptorImpl.process: ");
        callback.onContinue(postcard);
        // TODO: 2018/6/21 0021 这里做拦截处理
    }

    @Override
    public void init(Context context) {
        Timber.d("ARouterService_ARouterInterceptorImpl.init: ");
    }
}
