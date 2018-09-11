package com.renxin.cheku.arouter.provider;

import android.content.Context;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Desc: 认证权限 共享接口
 * Created by Junhua.Li
 * Date: 2018/07/09 20:26
 */
public interface AuthPermissionCheckProvider extends IProvider {
    /**
     * 企业是否进行认证
     *
     * @param type 0 是否中级企业认证, 1是否高级企业认证
     * @return true 认证 false 未成功认证
     */
    boolean checkEnterpriseIsAuth(int type);

    /**
     * 检测高级企业认证(会弹窗)
     *
     * @param mContext
     * @return
     */
    boolean checkAdvancedEnterpriseAuth(Context mContext);

    /**
     * 检测中级企业认证(会弹窗)
     *
     * @param mContext
     * @return
     */
    boolean checkIntermediateEnterpriseAuth(Context mContext);

    boolean checkNonCompanyStaffAccountAuthEnterpriseStatus(Context mContext);
}
