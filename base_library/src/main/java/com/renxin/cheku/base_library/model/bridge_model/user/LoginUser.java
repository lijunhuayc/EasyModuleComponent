package com.renxin.cheku.base_library.model.bridge_model.user;

import java.util.List;

/**
 * @author shun
 * @version V1.0
 * @Package com.cos.gdt.ui.widget.title
 * @date 16/3/10 10:11
 */
public class LoginUser {
    private String id;
    private String loginname;
    private int loginCount;
    private String token;
    private int cert_company_state;//0 未提交； 1 待审核 ；2 审核成功 ；3 审核失败
    private int cert_person_state;//0 未提交； 1 待审核 ；2 审核成功 ；3 审核失败
    private int cert_company_manager_state;
    private int level;
    private int _uid;
    private int user_province;
    private int user_city;
    private int is_manager;
    private int is_person;
    private String create_time;
    private UserInfoBean userInfo;
    private CompanyBean company;
    private List<RolesBean> roles;
    private String role_id;
    private String name;
    private String mobile;
    private CoolInfoBean my_shop;
    private CoolInfoBean.CkShopInfoBean ck_shop_info;
    private boolean firstLogin;
    private int model_type;//0:每次启动提示,1,乘用车,2商务车

    public void setModel_type(int pModel_type) {
        model_type = pModel_type;
    }

    public int getModel_type() {
        return model_type;
    }

    public CoolInfoBean.CkShopInfoBean getCk_shop_info() {
        return ck_shop_info;
    }

    public void setCk_shop_info(CoolInfoBean.CkShopInfoBean ck_shop_info) {
        this.ck_shop_info = ck_shop_info;
    }

    public int getIs_manager() {
        return is_manager;
    }

    public void setIs_manager(int is_manager) {
        this.is_manager = is_manager;
    }

    public int getIs_person() {
        return is_person;
    }

    public void setIs_person(int is_person) {
        this.is_person = is_person;
    }

    public boolean isFirstLogin() {
        return firstLogin;
    }

    public int getUser_province() {
        return user_province;
    }

    public void setUser_province(int user_province) {
        this.user_province = user_province;
    }

    public int getUser_city() {
        return user_city;
    }

    public void setUser_city(int user_city) {
        this.user_city = user_city;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public CoolInfoBean getMy_shop() {
        return my_shop;
    }

    public void setMy_shop(CoolInfoBean my_shop) {
        this.my_shop = my_shop;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public int getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(int loginCount) {
        this.loginCount = loginCount;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCert_company_state() {
        return cert_company_state;
    }

    public void setCert_company_state(int cert_company_state) {
        this.cert_company_state = cert_company_state;
    }

    public int getCert_person_state() {
        return cert_person_state;
    }

    public void setCert_person_state(int cert_person_state) {
        this.cert_person_state = cert_person_state;
    }

    public int getCert_company_manager_state() {
        return cert_company_manager_state;
    }

    public void setCert_company_manager_state(int cert_company_manager_state) {
        this.cert_company_manager_state = cert_company_manager_state;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int get_uid() {
        return _uid;
    }

    public void set_uid(int _uid) {
        this._uid = _uid;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public CompanyBean getCompany() {
        return company;
    }

    public void setCompany(CompanyBean company) {
        this.company = company;
    }

    public List<RolesBean> getRoles() {
        return roles;
    }

    public void setRoles(List<RolesBean> roles) {
        this.roles = roles;
    }

    public static class UserInfoBean {
        private int id;
        private String last_time;
        private String realname;
        private int gender = -1;
        private String head;
        private String mobile;
        private String tel;
        private String id_card_image_a;
        private String id_card_image_b;
        private String co_name;
        private String co_address;
        private String co_id_image;
        private String id_card;
        private String birthday;
        private String loginName;

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLast_time() {
            return last_time;
        }

        public void setLast_time(String last_time) {
            this.last_time = last_time;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getId_card_image_a() {
            return id_card_image_a;
        }

        public void setId_card_image_a(String id_card_image_a) {
            this.id_card_image_a = id_card_image_a;
        }

        public String getId_card_image_b() {
            return id_card_image_b;
        }

        public void setId_card_image_b(String id_card_image_b) {
            this.id_card_image_b = id_card_image_b;
        }

        public String getCo_name() {
            return co_name;
        }

        public void setCo_name(String co_name) {
            this.co_name = co_name;
        }

        public String getCo_address() {
            return co_address;
        }

        public void setCo_address(String co_address) {
            this.co_address = co_address;
        }

        public String getCo_id_image() {
            return co_id_image;
        }

        public void setCo_id_image(String co_id_image) {
            this.co_id_image = co_id_image;
        }

        public String getId_card() {
            return id_card;
        }

        public void setId_card(String id_card) {
            this.id_card = id_card;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }
    }

    public static class CompanyBean {
        private long company_id;
        private String unit_id;
        private String company_name;
        private String company_addr;
        private int company_license_type;
        private String company_id_image;
        private String company_id_code;
        private String company_corporation_name;
        private String company_corporation_idcard_code;
        private int company_province;
        private int company_city;
        private String bmp_lat;
        private String bmp_lng;
        private int del_flag;
        private String province_name;
        private String city_name;
        private String district_name;
        private int district_id;

        public void setDistrict_name(String pDistrict_name) {
            district_name = pDistrict_name;
        }

        public int getDistrict_id() {
            return district_id;
        }

        public String getDistrict_name() {
            return district_name;
        }

        public void setDistrict_id(int pDistrict_id) {
            district_id = pDistrict_id;
        }

        public String getProvince_name() {
            return province_name;
        }

        public void setProvince_name(String province_name) {
            this.province_name = province_name;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public long getCompany_id() {
            return company_id;
        }

        public void setCompany_id(long company_id) {
            this.company_id = company_id;
        }

        public String getUnit_id() {
            return unit_id;
        }

        public void setUnit_id(String unit_id) {
            this.unit_id = unit_id;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getCompany_addr() {
            return company_addr;
        }

        public void setCompany_addr(String company_addr) {
            this.company_addr = company_addr;
        }

        public int getCompany_license_type() {
            return company_license_type;
        }

        public void setCompany_license_type(int company_license_type) {
            this.company_license_type = company_license_type;
        }

        public String getCompany_id_image() {
            return company_id_image;
        }

        public void setCompany_id_image(String company_id_image) {
            this.company_id_image = company_id_image;
        }

        public String getCompany_id_code() {
            return company_id_code;
        }

        public void setCompany_id_code(String company_id_code) {
            this.company_id_code = company_id_code;
        }

        public String getCompany_corporation_name() {
            return company_corporation_name;
        }

        public void setCompany_corporation_name(String company_corporation_name) {
            this.company_corporation_name = company_corporation_name;
        }

        public String getCompany_corporation_idcard_code() {
            return company_corporation_idcard_code;
        }

        public void setCompany_corporation_idcard_code(String company_corporation_idcard_code) {
            this.company_corporation_idcard_code = company_corporation_idcard_code;
        }

        public int getCompany_province() {
            return company_province;
        }

        public void setCompany_province(int company_province) {
            this.company_province = company_province;
        }

        public int getCompany_city() {
            return company_city;
        }

        public void setCompany_city(int company_city) {
            this.company_city = company_city;
        }

        public String getBmp_lat() {
            return bmp_lat;
        }

        public void setBmp_lat(String bmp_lat) {
            this.bmp_lat = bmp_lat;
        }

        public String getBmp_lng() {
            return bmp_lng;
        }

        public void setBmp_lng(String bmp_lng) {
            this.bmp_lng = bmp_lng;
        }

        public int getDel_flag() {
            return del_flag;
        }

        public void setDel_flag(int del_flag) {
            this.del_flag = del_flag;
        }
    }

    public static class RolesBean {
        private long role_id;
        private String name;
        private String code;
        private int del_flag;
        private int is_default;
        private String alias;
        private String account;
        private String last_time;
        private String parent_id;

        public long getRole_id() {
            return role_id;
        }

        public void setRole_id(long role_id) {
            this.role_id = role_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getDel_flag() {
            return del_flag;
        }

        public void setDel_flag(int del_flag) {
            this.del_flag = del_flag;
        }

        public int getIs_default() {
            return is_default;
        }

        public void setIs_default(int is_default) {
            this.is_default = is_default;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getLast_time() {
            return last_time;
        }

        public void setLast_time(String last_time) {
            this.last_time = last_time;
        }

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }
    }
}
