package com.renxin.cheku.main.net;

import com.renxin.cheku.base_library.model.BaseResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.renxin.cheku.base_library.data_source.net.APIVersionPath.BASE_API_VERSION;
import static com.renxin.cheku.base_library.data_source.net.APIVersionPath.ORDER_API_VERSION;

/**
 * Desc: look car module APIService
 * Created by Junhua.Li
 * Date: 2018/07/02 09:58
 */
public interface MainAPIService {
    /**
     * 检查服务器是否正在升级 status == 1 时表示可用
     *
     * @return
     */
    @GET("http://sc.yicheku.com.cn/datas/update/status.json")
    Call<BaseResult<String>> checkServiceStatus();

    /**
     * 检测商用车使用权限
     *
     * @param permission
     * @return
     */
    @GET(BASE_API_VERSION + "/user/validata/permission")
    Call<BaseResult<Boolean>> checkCommercialPermission(@Query("permission") String permission);

    /**
     * 切换乘用车/商用车版本
     *
     * @param status
     * @return
     */
    @PUT(BASE_API_VERSION + "/user/edit/modelType/{status}")
    Call<BaseResult<String>> putEditionStatus(@Path("status") int status);
    /**
     * 获取首页TAB配置频道列表
     * v2.4以前版本使用的是"/homeChannel/getChannel"
     *
     * @return
     */
    @GET("/open/config/get?config_key=home_menu_v2.4_android")
    Call<BaseResult<String>> getHomeBottomTabIconList();
}
