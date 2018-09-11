package com.renxin.cheku.base_library.data_source.net;

import com.renxin.cheku.base_library.model.BaseResult;
import com.renxin.cheku.base_library.model.SystemConfigModel;
import com.renxin.cheku.base_library.model.bridge_model.user.LoginUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

import static com.renxin.cheku.base_library.data_source.net.APIVersionPath.BASE_API_VERSION;
import static com.renxin.cheku.base_library.data_source.net.APIVersionPath.CAR_API_VERSION;
import static com.renxin.cheku.base_library.data_source.net.APIVersionPath.STATISTICS_API_VERSION;

/**
 * Desc:
 * Created by Junhua.Li
 * Date: 2018/07/25 15:25
 */
public interface BaseLibraryAPIService {
    /**
     * 注册JPush
     *
     * @return
     */
    @FormUrlEncoded
    @POST("api2/user/jpush/register")
    Call<BaseResult<String>> postRegisterJPush(@Field("jtoken") String jtoken);

    /**
     * 数据上报
     *
     * @return
     */
    @Headers({"not-token:true"})
    @POST(STATISTICS_API_VERSION + "/new/report/event/upload")
    Call<BaseResult<String>> postDataReport(@Body String bodyContent);

    /**
     * 获取系统上报配置表
     *
     * @return
     */
    @Headers({"not-token:true"})
    @GET(BASE_API_VERSION + "/sysConfig/getByConfigKey")
    Call<BaseResult<SystemConfigModel>> getSystemConfig(@Query("configKey") String configKey);

    /**
     * 查询车系关注(以后都叫收藏)状态
     *
     * @param sub_brand_id
     * @return
     */
    @HTTP(method = "GET", path = CAR_API_VERSION + "/api/my/concern/is/add")
    Call<BaseResult<Boolean>> checkAttentionStatus(@Query("subId") long sub_brand_id);

    /**
     * 添加关注(以后都叫收藏)
     *
     * @param brand_id     brand_id 品牌id
     * @param sub_brand_id sub_brand_id 车系id
     * @param type         type 收藏类型 0为品牌 1为车系
     * @return
     */
    @FormUrlEncoded
    @POST(CAR_API_VERSION + "/api/my/concern/add")
    Call<BaseResult<Boolean>> addAttention(@Field("type") int type, @Field("brand_id") long brand_id, @Field("sub_brand_id") long sub_brand_id);

    /**
     * 取消关注(以后都叫收藏)
     *
     * @param ids
     * @return
     */
    @FormUrlEncoded
    @POST(CAR_API_VERSION + "/api/my/concern/delete")
    Call<BaseResult<Boolean>> delAttention(@Field("ids") String ids);

    /**
     * 查询资源和车型 收藏状态
     *
     * @param modelId
     * @return
     */
    @HTTP(method = "GET", path = CAR_API_VERSION + "/isAdd")
    Call<BaseResult<Boolean>> checkResAndCollectStatus(@Query("modelId") long modelId, @Query("resId") long resId);

    /**
     * 添加收藏车型
     *
     * @param modelId 车型id
     * @param cityId  城市id
     * @return
     */
    @FormUrlEncoded
    @POST(CAR_API_VERSION + "/api/enshrine/add/model")
    Call<BaseResult<Boolean>> addCollectCarModel(@Field("model_id") long modelId, @Field("city_id") long cityId);

    /**
     * 取消收藏车型
     *
     * @param ids 车型 ids 逗号分隔的字符串
     * @return
     */
    @FormUrlEncoded
    @POST(CAR_API_VERSION + "/api/enshrine/delete")
    Call<BaseResult<Boolean>> delCollectCarModel(@Field("ids") String ids);

    /**
     * 获取当前用户信息
     *
     * @return
     */
    @GET("/api2/user/auth")
    Call<BaseResult<LoginUser>> getUserInfo();
}
