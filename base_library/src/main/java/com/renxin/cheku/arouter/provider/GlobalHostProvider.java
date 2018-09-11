package com.renxin.cheku.arouter.provider;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Desc:获取host共享接口
 * Created by JiaKun.Yang
 * Date: 2018/06/25 17:17
 */
public interface GlobalHostProvider extends IProvider {
    /**
     * debug环境比较使用
     *
     * @return
     */
    String getHostIPTest200();

    /**
     * debug环境比较使用
     *
     * @return
     */
    String getHostIPTest210();

    /**
     * 当前环境使用的 HOST (= HOST_IP + HOST_PORT)
     *
     * @return
     */
    String getHost();

    /**
     * 当前环境使用的 HOST_IP
     *
     * @return
     */
    String getHostIP();

    /**
     * 当前环境使用的 PORT
     *
     * @return
     */
    String getHostPort();

    String getPictureHost();

    String getStaticWebHost();

    String getUploadAppHost();

    /**
     * @param url
     * @return
     * @see com.renxin.cheku.base_library.utils.FileUtils#convertPicURL(String)
     */
    String convertPicURL(String url);

    /**
     * @return 返回接口前缀 [ HOST_IP + PREFIX ] , PREFIX = BASE、FINANCE、AUTH、等等接口版本前缀
     */
    String getInterfaceVersionPrefix();

    /**
     * @return 物流服务协议Url
     */
    String getLogisticsAgreementUrl();

    /**
     * @return 车源订单 代购协议
     */
    String getPurchaseAgreementUrl();
}
