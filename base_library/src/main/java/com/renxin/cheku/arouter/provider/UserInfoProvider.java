package com.renxin.cheku.arouter.provider;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Desc: 用户信息共享接口
 * Created by Junhua.Li
 * Date: 2018/06/22 14:32
 */
public interface UserInfoProvider extends IProvider {
    void cleanCacheToken();

    String getToken();

    String getUserId();

    String getAccount();

    String getCompanyName();

    int getCompanyState();

    int getPersonState();

//    /**
//     * 获取的是 AreaLogicService.getCurrentCity
//     * @return 返回json 格式
//     */
//    String getCurrentCity();

    /**
     * 获取的是 UserLogicService.getCurrentLocation
     *
     * @return 返回json 格式
     */
    String getCurrentLocation();

    void setCurrentLocation(String pLocationStr);

    void saveLastLocationArea(String pLocationStr);

    int getCurrentProvinceId();

    int getCurrentCityId();

    void initUserInfo(String json);

    void setUserInfo(String json);

    void setToken(String token);

    int getModelType();

    boolean isUnitBoss();

    boolean isUnitAdmin();

    boolean isManager();

    boolean isPerson();

    boolean isLogined();

    void setIsPerson(int pIsPerson);

    void setIsManager(int pIsManager);
}
