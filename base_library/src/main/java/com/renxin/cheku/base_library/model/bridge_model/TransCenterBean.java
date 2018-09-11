package com.renxin.cheku.base_library.model.bridge_model;

import java.util.List;

/**
 * Created by GP62 on 2017/12/26.
 */
public class TransCenterBean {
    /**
     * list : [{"action_type":0,"brief":"很抱歉，您的支付凭证审核未通过，请重新上传支付凭证 ","content":"很抱歉，您的支付凭证审核未通过，请重新上传支付凭证 ","create_time":"2016-12-02 11:48:02","id":73,"message_param":"{\"action\": \"resouce_detail\",\"fields\": {\"id\": 2262428632369152,\"title\": \"资源详情\"}}","push_sys":0,"send_account":"sys","state":1,"title":"订单消息","type":0}]
     * page : {"pageCount":1,"pageNumber":1,"pageSize":5,"recordCount":1}
     * status : 1
     */
    private PageBean page;
    private int status;
    private List<ExtrasMessageModel> list;

    /**
     * message_param : {"action_type":"order","fields":{"supplier_location":"重庆市","receive_location":"贵阳市","brand_name":"大众","sub_brand_name":"迈腾","picture":"/autoalbum/files/20170628/354/0601183541_8.jpg","year":"2018","auto_model_name":"280TSI 双离合 舒适版","id":1426,"code":"RX171227120","order_type":1,"brand_id":8,"sub_brand_id":1909,"model_id":126272,"transport_company_name":"成都特力亚汽车服务有限公司","order_type_extra":{"name":"支付拖车款","brief":"确定金额及付款方式，付款","alias":"payment_transport","actions":[{"ibd":[{"action":"pay_transport"},{"action":"close"}]},{"ts":[]},{"tc":[]}],"flag_refund":1},"is_finish":"0"}}
     * msg_create_time : 2017-12-27 14:28:41
     * msg_id : 24011
     * msg_state : 0
     * msg_title : 订单创建成功
     */
    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ExtrasMessageModel> getList() {
        return list;
    }

    public void setList(List<ExtrasMessageModel> list) {
        this.list = list;
    }

    /**
     * message_param : 1418
     * msg_id : 22999
     * msg_title : 订单创建成功
     * msg_create_time : 2017-12-25 14:52:59
     * msg_state : 0
     * supplier_location : 重庆市万州区沙龙路三段三峡国际车界内（车管所背后）
     * receive_location : 贵阳市
     * brand_name : 大众
     * sub_brand_name : 迈腾
     * picture : /autoalbum/files/20170628/354/0601183541_8.jpg
     * year : 2018
     * auto_model_name : 280TSI 双离合 舒适版
     * id : 1418
     * code : RX171225120
     * order_type : 1
     * brand_id : 8
     * sub_brand_id : 1909
     * model_id : 126272
     * auto_color : 幻影黑
     * create_time : 2017-12-25 14:51:59
     * wait_pay_price : 1520
     * transit_price : 1520
     * refund_amount : 0
     * transport_company_name : 成都特力亚汽车服务有限公司
     * order_state : task_pay_transport
     * order_type_desc : 用户：支付物流费
     * order_type_extra : {"name":"支付拖车款","brief":"确定金额及付款方式，付款","alias":"payment_transport","actions":[{"ibd":[{"action":"pay_transport"},{"action":"close"}]},{"ts":[]},{"tc":[]}],"flag_refund":1}
     * is_finish : 0
     * is_comment : 0
     * is_receipt : 0
     * is_complaint : 0
     * is_refund : 0
     */
    public static class PageBean {
        /**
         * pageCount : 1
         * pageNumber : 1
         * pageSize : 5
         * recordCount : 1
         */
        private int pageCount;
        private int pageNumber;
        private int pageSize;
        private int recordCount;

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getRecordCount() {
            return recordCount;
        }

        public void setRecordCount(int recordCount) {
            this.recordCount = recordCount;
        }
    }

//    public static class ExtrasMessageModel {
//        private Long id;
//        private String title;
//        /**
//         * 简介
//         */
//        private String brief;
//        /**
//         * 详情
//         */
//        private String content;
//        /**
//         * 类型[0系统]
//         */
//        private Integer type;
//        private String create_time;
//        /**
//         * 状态[0未读 1已读]
//         */
//        private Integer state;
//        /**
//         * 是否删除[1已删除]
//         */
//        private Integer flg_del;
//        /**
//         * 发送方账号
//         */
//        private String send_account;
//        private String websit;
//        private String receive_account;
//        /**
//         * 消息通知类型（0通知消息，1订单消息）
//         */
//        private Integer message_type;
//        /**
//         * 消息类型的参数，(如订单消息这里就是存的订单号)
//         */
//        private String message_param;
//        /**
//         * 是否推送系统桌面（0不推送，1推送）
//         */
//        private Integer push_sys;
//        /**
//         * 订单ID（需要配合order_type使用）
//         */
//        private Long order_id;
//        /**
//         * 订单类型（0物流订单、1资源订单）
//         */
//        private Integer order_type;
//    }

    public static class ExtrasMessageModel {
        private long id;
        private String title;
        private String brief;//简介
        private String content;//详情
        private int type;//类型[0-系统(进入消息详情页), 1-web消息(进入webview打开websit字段), 2-刷新用户信息 ]
        private String create_time;//2018-05-29 19:14:49
        private int state;//状态[0未读 1已读]
        private int flg_del;//是否删除[1已删除] //前端好像不使用
        private String send_account;//发送方账号
        private String websit;
        private String receive_account;//接收方
        private int message_type;//消息通知类型（0通知消息，1订单消息）
        private String message_param;//消息类型的参数，(如订单消息这里就是存的订单号)
        //        private int push_sys;//是否推送系统桌面（0不推送，1推送）//前端好像不使用
        private long order_id;//订单ID（需要配合order_type使用）
        private int order_type;//订单类型（0物流订单、1资源订单）
        //订单消息使用以下对应字段
        private long msg_id;//同id (订单消息使用)
        private String msg_title;//同title (订单消息使用)
        private String msg_create_time;//2018-05-29 19:14:49 (订单消息使用)
        private int msg_state;//状态[0未读 1已读] (订单消息使用)
        //本地使用字段
        private boolean isShowChebox;

        public long getId() {
            return id;
        }

        public void setId(long pId) {
            id = pId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String pTitle) {
            title = pTitle;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String pBrief) {
            brief = pBrief;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String pContent) {
            content = pContent;
        }

        public int getType() {
            return type;
        }

        public void setType(int pType) {
            type = pType;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String pCreate_time) {
            create_time = pCreate_time;
        }

        public int getState() {
            return state;
        }

        public void setState(int pState) {
            state = pState;
        }

        public int getFlg_del() {
            return flg_del;
        }

        public void setFlg_del(int pFlg_del) {
            flg_del = pFlg_del;
        }

        public String getSend_account() {
            return send_account;
        }

        public void setSend_account(String pSend_account) {
            send_account = pSend_account;
        }

        public String getWebsit() {
            return websit;
        }

        public void setWebsit(String pWebsit) {
            websit = pWebsit;
        }

        public String getReceive_account() {
            return receive_account;
        }

        public void setReceive_account(String pReceive_account) {
            receive_account = pReceive_account;
        }

        public int getMessage_type() {
            return message_type;
        }

        public void setMessage_type(int pMessage_type) {
            message_type = pMessage_type;
        }

        public String getMessage_param() {
            return message_param;
        }

        public void setMessage_param(String pMessage_param) {
            message_param = pMessage_param;
        }

        public long getOrder_id() {
            return order_id;
        }

        public void setOrder_id(long pOrder_id) {
            order_id = pOrder_id;
        }

        public int getOrder_type() {
            return order_type;
        }

        public void setOrder_type(int pOrder_type) {
            order_type = pOrder_type;
        }

        public long getMsg_id() {
            return msg_id;
        }

        public void setMsg_id(long pMsg_id) {
            msg_id = pMsg_id;
        }

        public String getMsg_title() {
            return msg_title;
        }

        public void setMsg_title(String pMsg_title) {
            msg_title = pMsg_title;
        }

        public String getMsg_create_time() {
            return msg_create_time;
        }

        public void setMsg_create_time(String pMsg_create_time) {
            msg_create_time = pMsg_create_time;
        }

        public int getMsg_state() {
            return msg_state;
        }

        public void setMsg_state(int pMsg_state) {
            msg_state = pMsg_state;
        }

        public boolean isShowChebox() {
            return isShowChebox;
        }

        public void setShowChebox(boolean pShowChebox) {
            isShowChebox = pShowChebox;
        }
    }

    /*
    }
{
    "list":[
        {
            "action_type":0,
            "brief":"很抱歉，您的支付凭证审核未通过，请重新上传支付凭证 ",
            "content":"很抱歉，您的支付凭证审核未通过，请重新上传支付凭证 ",
            "create_time":"2016-12-02 11:48:02",
            "id":73,
            "message_param":"{"action": "resouce_detail","fields": {"id": 2262428632369152,"title": "资源详情"}}",
            "push_sys":0,
            "send_account":"sys",
            "state":1,
            "title":"订单消息",
            "type":0
        }
    ],
    "page":{
        "pageCount":1,
        "pageNumber":1,
        "pageSize":5,
        "recordCount":1
    },
    "status":1
}
    * */
}
