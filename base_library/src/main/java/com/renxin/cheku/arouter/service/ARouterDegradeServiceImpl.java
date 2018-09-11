package com.renxin.cheku.arouter.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.renxin.cheku.arouter.RouterTable;
import com.renxin.cheku.base_library.utils.Timber;

/**
 * Desc: 全局降级策略 navigation 无回调时找不到router path才会触发
 * Created by Junhua.Li
 * Date: 2018/06/21 15:42
 */
@Route(path = RouterTable.AROUTER_DEGRADE_SERVICE_SPECIAL_PATH, name = "ARouterDegradeServiceImpl")
public class ARouterDegradeServiceImpl implements DegradeService {
    @Override
    public void onLost(Context context, Postcard postcard) {
        Timber.d("ARouterService_ARouterDegradeServiceImpl.onLost: ");
        // TODO: 2018/6/21 0021 根据 path 做降级处理(比如某组件加载失败无法路由跳转时, 可在这里跳转到其他备用页面)
    }

    @Override
    public void init(Context context) {
        Timber.d("ARouterService_ARouterDegradeServiceImpl.init: ");
    }
}
