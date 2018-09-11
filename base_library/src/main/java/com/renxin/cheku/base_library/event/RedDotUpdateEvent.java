package com.renxin.cheku.base_library.event;

/**
 * Desc: HTabMineFragment 页面红点更新
 * Created by Junhua.Li
 * Date: 2018/08/29 9:52
 */
public class RedDotUpdateEvent {
    private int resource;//": 0,
    private int finance;//": 0,
    private int transit;//": 0
    private int message;//": 0,

    public RedDotUpdateEvent(int pResource, int pFinance, int pTransit, int pMessage) {
        resource = pResource;
        finance = pFinance;
        transit = pTransit;
        message = pMessage;
    }

    public int getFinance() {
        return finance;
    }

    public void setFinance(int pFinance) {
        finance = pFinance;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int pMessage) {
        message = pMessage;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int pResource) {
        resource = pResource;
    }

    public int getTransit() {
        return transit;
    }

    public void setTransit(int pTransit) {
        transit = pTransit;
    }
}
