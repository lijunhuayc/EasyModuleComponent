package com.renxin.cheku.base_library.model.bridge_model.user;

import android.text.TextUtils;

/**
 * Created on 2017/10/21.
 * <br/>
 * <p>Function:<p/>
 * <br/>
 *
 * @author Zhipeng.Fan
 */
public class CoolInfoBean {
    /**
     * ck_shop_info : {"company_address":"444","company_name":"33","head":"12333","id":1,"mobile":"33333","name":"顺哥","shop_id":1}
     * company_id : 1000100010001
     * create_account : 18608033699
     * create_time : 2017-10-12 11:04:36
     * del_flag : 0
     * enable : 0
     * foolprice_sum : 8
     * id : 1
     * share_sum : 1
     * shop_name : 某某某酷兜
     * shop_sum : 40
     * tody_view : 0
     * total_view : 1
     */
    private CkShopInfoBean ck_shop_info;
    private long company_id;
    private String create_account;
    private String create_time;
    private int del_flag;
    private int enable;
    private int foolprice_sum;
    private int id;
    private int share_sum;
    private String shop_name;
    private int shop_sum;
    private int tody_view;
    private int total_view;
    private String company_name;

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public CkShopInfoBean getCk_shop_info() {
        return ck_shop_info;
    }

    public void setCk_shop_info(CkShopInfoBean ck_shop_info) {
        this.ck_shop_info = ck_shop_info;
    }

    public long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(long company_id) {
        this.company_id = company_id;
    }

    public String getCreate_account() {
        return create_account;
    }

    public void setCreate_account(String create_account) {
        this.create_account = create_account;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(int del_flag) {
        this.del_flag = del_flag;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public int getFoolprice_sum() {
        return foolprice_sum;
    }

    public void setFoolprice_sum(int foolprice_sum) {
        this.foolprice_sum = foolprice_sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShare_sum() {
        return share_sum;
    }

    public void setShare_sum(int share_sum) {
        this.share_sum = share_sum;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public int getShop_sum() {
        return shop_sum;
    }

    public void setShop_sum(int shop_sum) {
        this.shop_sum = shop_sum;
    }

    public int getTody_view() {
        return tody_view;
    }

    public void setTody_view(int tody_view) {
        this.tody_view = tody_view;
    }

    public int getTotal_view() {
        return total_view;
    }

    public void setTotal_view(int total_view) {
        this.total_view = total_view;
    }

    public static class CkShopInfoBean {
        /**
         * company_address : 444
         * company_name : 33
         * head : 12333
         * id : 1
         * mobile : 33333
         * name : 顺哥
         * shop_id : 1
         */
        private String company_address;
        private String company_name;
        private String head;
        private int id;
        private String mobile;
        private String name;
        private String shop_id;

        public String getCompany_address() {
            return company_address;
        }

        public void setCompany_address(String company_address) {
            this.company_address = company_address;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getShop_id() {
            return shop_id;
        }

        public void setShop_id(String shop_id) {
            this.shop_id = shop_id;
        }

        public boolean checkData() {
            return !TextUtils.isEmpty(company_address) || !TextUtils.isEmpty(company_name) || !TextUtils.isEmpty(name);
        }
    }
}
