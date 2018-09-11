package com.renxin.cheku.arouter.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.google.gson.Gson;
import com.renxin.cheku.arouter.RouterTable;
import com.renxin.cheku.base_library.utils.Timber;

import java.lang.reflect.Type;

/**
 * Desc:
 * Created by Junhua.Li
 * Date: 2018/09/05 14:45
 */
@Route(path = RouterTable.AROUTER_JSON_SERVICE_SPECIAL_PATH, name = "GsonSerializationServiceImpl")
public class GsonSerializationServiceImpl implements SerializationService {
    Gson mGson = new Gson();

    @Override
    public <T> T json2Object(String input, Class<T> clazz) {
        Timber.d("ARouterService_GsonSerializationServiceImpl.json2Object: ");
        return mGson.fromJson(input, clazz);
    }

    @Override
    public String object2Json(Object instance) {
        Timber.d("ARouterService_GsonSerializationServiceImpl.object2Json: ");
        return mGson.toJson(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
        Timber.d("ARouterService_GsonSerializationServiceImpl.parseObject: ");
        return mGson.fromJson(input, clazz);
    }

    @Override
    public void init(Context context) {
        Timber.d("ARouterService_GsonSerializationServiceImpl.init: ");
    }
}
