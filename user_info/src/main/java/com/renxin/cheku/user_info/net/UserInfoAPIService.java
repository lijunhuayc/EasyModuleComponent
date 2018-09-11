package com.renxin.cheku.user_info.net;

import com.renxin.cheku.base_library.model.BaseResult;
import com.renxin.cheku.base_library.model.bridge_model.user.LoginUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import static com.renxin.cheku.base_library.data_source.net.APIVersionPath.AUTH_API_VERSION;
import static com.renxin.cheku.base_library.data_source.net.APIVersionPath.BASE_API_VERSION;

/**
 * Desc: look car module APIService
 * Created by Junhua.Li
 * Date: 2018/07/02 09:58
 */
public interface UserInfoAPIService {
    /**
     * 签署管理员协议
     *
     * @return
     */
    @POST(BASE_API_VERSION + "/user/is/manager")
    Call<BaseResult<Boolean>> postAgreeAdminContract();

    /**
     * 签署负责人协议
     *
     * @return
     */
    @POST(BASE_API_VERSION + "/user/is/person")
    Call<BaseResult<Boolean>> postAgreeBossContract();

    /**
     * 发送验证码
     *
     * @param body
     * @return
     */
    @Headers({"not-token:true"})
    @POST("/api2/sms/smscode")
    Call<BaseResult<String>> sendSmsCode(@Body String body);

    /**
     * 获取当前用户信息
     *
     * @return
     */
    @GET("/api2/user/auth")
    Call<BaseResult<LoginUser>> getUserInfo();

    /**
     * 获取用户token
     *
     * @param body
     * @return
     */
    @Headers({"not-token:true"})
    @POST(AUTH_API_VERSION + "/public/login")
    Call<BaseResult<String>> getToken(@Body String body);

    /**
     * 注册
     *
     * @param name     用户名
     * @param smscode  短信验证码
     * @param password 用户密码
     * @return
     */
    @FormUrlEncoded
    @POST("/api2/user/register")
    Call<BaseResult<LoginUser>> register(@Field("name") String name, @Field("smscode") String smscode, @Field("password") String password);

    /**
     * 设置用户密码
     *
     * @param mobile
     * @param smscode
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("/api2/user/findpass")
    Call<BaseResult<String>> setPassword(@Field("mobile") String mobile, @Field("smscode") String smscode, @Field("newpass") String password);
}
