package com.renxin.cheku.arouter;

/**
 * Desc: component module 路由表(不同module library 中的path 不能使用相同的 group)
 * Created by Junhua.Li
 * Date: 2018/06/21 10:02
 */
public class RouterTable {
    //arouter service path
    public static final String AROUTER_DEGRADE_SERVICE_SPECIAL_PATH = "/arouter_service/degrade_service_special_path";//DegradeService专用"任意的"path
    public static final String AROUTER_PATH_SERVICE_SPECIAL_PATH = "/arouter_service/path_service_special_path";//PathReplaceService专用"任意的"path
    public static final String AROUTER_JSON_SERVICE_SPECIAL_PATH = "/service/json";//SerializationService 的 path (ARouter文档固定了此path)
    //arouter provider path
    public static final String PROVIDER_USER_INFO_PROVIDER_IMPL = "/provider/user_info_provider_impl";//IProvider 共享接口, 获取用户信息
    public static final String PROVIDER_GLOBAL_HOST_PROVIDER_IMPL = "/provider/global_host_provider_impl";//IProvider 共享接口, 获取Host
    //arouter activity/fragment path
    public static final String MAIN_FRAGMENT_HTAB_HOME = "/main/fragment_htab_home";//HTabHomeFragment
    public static final String MAIN_FRAGMENT_HTAB_DISCOVERY = "/main/fragment_htab_discovery";//HTabDiscoveryFragment
    public static final String MAIN_MAIN_TAB_ACT = "/main/main_tab_act";//old_bitch 乘用车版本主页
    //
    public static final String USERINFO_LOGIN_ACTIVITY = "/userinfo/login_activity";//登陆页面
}
