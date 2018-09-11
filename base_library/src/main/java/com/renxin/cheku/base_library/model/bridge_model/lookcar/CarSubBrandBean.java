package com.renxin.cheku.base_library.model.bridge_model.lookcar;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 车辆相关模块临时桥接放入base library(modified by ljh)
 * Created by fanzhipeng on 2018/1/30.
 */
public class CarSubBrandBean {
    /**
     * subBrands : [{"carType":"紧凑型车","minPrice":13.18,"name":"速腾","id":1765,"maxPrice":21.88,"bid":8,"guidePriceRange":"13.18-21.88万","picture":"/cardfs/product/g16/M08/CE/81/s_autohomecar__wKgH5ln7IESAcq-3AAkEnhKRKG4600.jpg"},{"carType":"紧凑型车","minPrice":8.49,"name":"桑塔纳","id":1793,"maxPrice":13.89,"bid":8,"guidePriceRange":"8.49-13.89万","picture":"/cardfs/product/g6/M01/23/C4/s_autohomecar__wKgHzVfH24GAR3voAAh1x_6ldRU774.jpg"},{"carType":"中型车","minPrice":18.99,"name":"帕萨特","id":1796,"maxPrice":30.39,"bid":8,"guidePriceRange":"18.99-30.39万","picture":"/cardfs/product/g6/M04/07/FB/s_autohomecar__wKgHzVihifOADerxAAYDfwRXVHg801.jpg"},{"carType":"小型车","minPrice":7.59,"name":"POLO","id":1798,"maxPrice":14.69,"bid":8,"guidePriceRange":"7.59-14.69万","picture":"/upload/2014/8/6/s_20140806072335496497111.jpg"},{"carType":"MPV","minPrice":14.58,"name":"途安","id":1799,"maxPrice":23.08,"bid":8,"guidePriceRange":"14.58-23.08万","picture":"/cardfs/product/g6/M08/03/47/s_autohomecar__wKgH3FnjcIWAHsEQAAd6iLCdIDs279.jpg"},{"carType":"紧凑型车","minPrice":7.99,"name":"捷达","id":1905,"maxPrice":13.49,"bid":8,"guidePriceRange":"7.99-13.49万","picture":"/cardfs/product/g11/M00/94/38/s_autohomecar__wKjBzFggY42AdUPdAAsX51TRHJ8462.jpg"},{"carType":"中型车","minPrice":18.99,"name":"迈腾","id":1909,"maxPrice":31.69,"bid":8,"guidePriceRange":"18.99-31.69万","picture":"/cardfs/product/g20/M15/5F/12/s_autohomecar__wKgFWVnD0K6ADBvEAAps2Uygutk033.jpg"},{"carType":"紧凑型车","minPrice":19.58,"name":"甲壳虫","id":2061,"maxPrice":27.46,"bid":8,"guidePriceRange":"19.58-27.46万","picture":"/cardfs/product/g5/M03/B1/A0/s_autohomecar__wKgH21g8BJ2AK0VKAAcD4f-XGe4555.jpg"},{"carType":"MPV","minPrice":26.98,"name":"夏朗","id":2063,"maxPrice":37.68,"bid":8,"guidePriceRange":"26.98-37.68万","picture":"/cardfs/product/g10/M05/95/7E/s_autohomecar__wKgH4FnPabuADZ28AAiDlIOAWvo636.jpg"},{"carType":"中大型SUV","minPrice":65.88,"name":"途锐","id":2064,"maxPrice":90.88,"bid":8,"guidePriceRange":"65.88-90.88万","picture":"/cardfs/product/g15/M0E/26/F0/s_autohomecar__wKgH5VmC6wyAdzVfAA997AczRiU020.jpg"},{"carType":"紧凑型车","minPrice":10.99,"name":"朗逸","id":2370,"maxPrice":15.99,"bid":8,"guidePriceRange":"10.99-15.99万","picture":"/cardfs/product/g13/M15/97/73/s_autohomecar__wKgH1FkS25mAIUoyAAbr4Rhd3xA813.jpg"},{"carType":"紧凑型SUV","minPrice":26.28,"name":"Tiguan","id":2373,"maxPrice":39.18,"bid":8,"guidePriceRange":"26.28-39.18万","picture":"/cardfs/product/g21/M09/03/89/s_autohomecar__wKgFWlo6DCSAR0HoAAf67lvDw1w903.jpg"},{"carType":"MPV","minPrice":41.88,"name":"迈特威","id":2379,"maxPrice":56.28,"bid":8,"guidePriceRange":"41.88-56.28万","picture":"/cardfs/product/g22/M03/FF/2F/s_autohomecar__wKjBwVk2VwiACOUpAAytMPx_FEY762.jpg"},{"carType":"紧凑型车","minPrice":10.78,"name":"宝来","id":2381,"maxPrice":15.38,"bid":8,"guidePriceRange":"10.78-15.38万","picture":"/cardfs/product/g7/M00/CC/DB/s_autohomecar__wKjB0Fn7HEeARhP9AAwkbWOJ9_4992.jpg"},{"carType":"跑车","minPrice":22.28,"name":"尚酷","id":2610,"maxPrice":39.08,"bid":8,"guidePriceRange":"22.28-39.08万","picture":"/upload/2014/9/3/s_20140903113016139424411.jpg"},{"carType":"紧凑型车","minPrice":12.19,"name":"高尔夫","id":2714,"maxPrice":23.99,"bid":8,"guidePriceRange":"12.19-23.99万","picture":"/cardfs/product/g12/M08/D7/00/s_autohomecar__wKgH4loBhpqAIm6hAA9fyU6UGMs437.jpg"},{"carType":"紧凑型SUV","minPrice":19.98,"name":"途观","id":2871,"maxPrice":23.78,"bid":8,"guidePriceRange":"19.98-23.78万","picture":"/cardfs/product/g10/M14/A7/34/s_autohomecar__wKgH0Vg2wKeAF2DDAAbznB4IjxM302.jpg"},{"carType":"中型车","minPrice":25.28,"name":"一汽-大众CC","id":2932,"maxPrice":34.28,"bid":8,"guidePriceRange":"25.28-34.28万","picture":"/cardfs/product/g22/M11/90/41/s_autohomecar__wKjBwVoCzUWAe0HYAAfILPYyenE473.jpg"},{"carType":"紧凑型车","minPrice":40.78,"name":"高尔夫(进口)","id":3509,"maxPrice":41.38,"bid":8,"guidePriceRange":"40.78-41.38万","picture":"/cardfs/product/g8/M02/08/A5/s_autohomecar__wKgHz1ZmxS-AeMzqAAc46mV82qU530.jpg"},{"carType":"紧凑型车","minPrice":11.29,"name":"朗行","id":3879,"maxPrice":16.29,"bid":8,"guidePriceRange":"11.29-16.29万","picture":"/cardfs/product/g9/M0B/36/C8/s_autohomecar__wKgH31jH9SSAUffZAAYEzqXAX4M947.jpg"},{"carType":"紧凑型车","minPrice":14.89,"name":"朗境","id":4023,"maxPrice":17.19,"bid":8,"guidePriceRange":"14.89-17.19万","picture":"/cardfs/product/g10/M11/38/FD/s_autohomecar__wKgH0VjRCFKANMhMAAj5dDGJz6U006.jpg"},{"carType":"MPV","minPrice":35.18,"name":"凯路威","id":4152,"maxPrice":41.88,"bid":8,"guidePriceRange":"35.18-41.88万","picture":"/cardfs/product/g17/M0B/C2/9C/s_autohomecar__wKjBxln4U0CAAiRKAAY5LvZB2xs603.jpg"},{"carType":"紧凑型车","minPrice":14.59,"name":"凌渡","id":4308,"maxPrice":22.89,"bid":8,"guidePriceRange":"14.59-22.89万","picture":"/cardfs/product/g20/M0C/BE/43/s_autohomecar__wKjBw1oOueKAXqJ6AAfE11Tpxeo236.jpg"},{"carType":"紧凑型车","minPrice":13.19,"name":"高尔夫·嘉旅","id":4687,"maxPrice":19.79,"bid":8,"guidePriceRange":"13.19-19.79万","picture":"/cardfs/product/g19/M0B/4D/25/s_autohomecar__wKgFWFckjQuARQiVAAkuNBSCL8k510.jpg"},{"carType":"中型车","minPrice":26.68,"name":"蔚揽","id":4722,"maxPrice":43.08,"bid":8,"guidePriceRange":"26.68-43.08万","picture":"/cardfs/product/g13/M00/D3/3C/s_autohomecar__wKjByloARbKAVdGeAAhDu1EDoO4938.jpg"},{"carType":"中大型车","minPrice":34.9,"name":"辉昂","id":4791,"maxPrice":65.9,"bid":8,"guidePriceRange":"34.90-65.90万","picture":"/cardfs/product/g13/M12/D9/BA/s_autohomecar__wKgH41oDC_eABG9_AAi33ZNiuuw004.jpg"},{"carType":"中大型SUV","minPrice":30.89,"name":"途昂","id":4873,"maxPrice":51.89,"bid":8,"guidePriceRange":"30.89-51.89万","picture":"/cardfs/product/g21/M06/E8/4F/s_autohomecar__wKgFVVimj9CAJBqnAAjG1Ou6sQ8758.jpg"},{"carType":"紧凑型车","minPrice":11.69,"name":"蔚领","id":4877,"maxPrice":16.29,"bid":8,"guidePriceRange":"11.69-16.29万","picture":"/cardfs/product/g9/M12/D0/63/s_autohomecar__wKgH0FoAbCOAf3XNAAooXh-Oz0M410.jpg"},{"carType":"中型SUV","minPrice":22.38,"name":"途观L","id":4936,"maxPrice":35.98,"bid":8,"guidePriceRange":"22.38-35.98万","picture":"/cardfs/product/g25/M09/4B/A6/s_autohomecar__ChcCr1pchRiAUGXpAAnzO7mH4rk264.jpg"},{"carType":"紧凑型车","name":"高尔夫新能源(进口)","id":5292,"bid":8,"guidePriceRange":"28.88万","picture":"/cardfs/product/g9/M13/8F/9A/s_autohomecar__wKgH0FYIb46AXVYkAAvRWAbn1fI221.jpg"}]
     * homeSell : 0
     * brandId : 8
     * name : 大众
     * logo : /app/image/brands/1.png
     * sellBrand : 0
     */
    private int homeSell;
    private int brandId;
    private String name;
    private String logo;
    private int sellBrand;
    private List<SubBrandsBean> subBrands;

    public int getHomeSell() {
        return homeSell;
    }

    public void setHomeSell(int homeSell) {
        this.homeSell = homeSell;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getSellBrand() {
        return sellBrand;
    }

    public void setSellBrand(int sellBrand) {
        this.sellBrand = sellBrand;
    }

    public List<SubBrandsBean> getSubBrands() {
        return subBrands;
    }

    public void setSubBrands(List<SubBrandsBean> subBrands) {
        this.subBrands = subBrands;
    }

    public static class SubBrandsBean implements Parcelable {
        /**
         * carType : 紧凑型车
         * minPrice : 13.18
         * name : 速腾
         * id : 1765
         * maxPrice : 21.88
         * bid : 8
         * guidePriceRange : 13.18-21.88万
         * picture : /cardfs/product/g16/M08/CE/81/s_autohomecar__wKgH5ln7IESAcq-3AAkEnhKRKG4600.jpg
         */
        private String carType;
        private float minPrice;
        private String name;
        private int id;
        private float maxPrice;
        private int bid;
        private String guidePriceRange;
        private String picture;
        private String companyAraName;
        private String bName;
        private String mailPrice;

        public String getMailPrice() {
            return mailPrice;
        }

        public void setMailPrice(String mailPrice) {
            this.mailPrice = mailPrice;
        }

        public String getbName() {
            return bName;
        }

        public void setbName(String bName) {
            this.bName = bName;
        }

        public String getCompanyAraName() {
            return companyAraName;
        }

        public void setCompanyAraName(String companyAraName) {
            this.companyAraName = companyAraName;
        }

        public String getCarType() {
            return carType;
        }

        public void setCarType(String carType) {
            this.carType = carType;
        }

        public float getMinPrice() {
            return minPrice;
        }

        public void setMinPrice(float minPrice) {
            this.minPrice = minPrice;
        }

        public float getMaxPrice() {
            return maxPrice;
        }

        public void setMaxPrice(float maxPrice) {
            this.maxPrice = maxPrice;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getBid() {
            return bid;
        }

        public void setBid(int bid) {
            this.bid = bid;
        }

        public String getGuidePriceRange() {
            return guidePriceRange;
        }

        public void setGuidePriceRange(String guidePriceRange) {
            this.guidePriceRange = guidePriceRange;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.carType);
            dest.writeFloat(this.minPrice);
            dest.writeString(this.name);
            dest.writeInt(this.id);
            dest.writeFloat(this.maxPrice);
            dest.writeInt(this.bid);
            dest.writeString(this.guidePriceRange);
            dest.writeString(this.picture);
            dest.writeString(this.companyAraName);
            dest.writeString(this.bName);
            dest.writeString(this.mailPrice);
        }

        public SubBrandsBean() {
        }

        protected SubBrandsBean(Parcel in) {
            this.carType = in.readString();
            this.minPrice = in.readFloat();
            this.name = in.readString();
            this.id = in.readInt();
            this.maxPrice = in.readFloat();
            this.bid = in.readInt();
            this.guidePriceRange = in.readString();
            this.picture = in.readString();
            this.companyAraName = in.readString();
            this.bName = in.readString();
            this.mailPrice = in.readString();
        }

        public static final Parcelable.Creator<SubBrandsBean> CREATOR = new Parcelable.Creator<SubBrandsBean>() {
            @Override
            public SubBrandsBean createFromParcel(Parcel source) {
                return new SubBrandsBean(source);
            }

            @Override
            public SubBrandsBean[] newArray(int size) {
                return new SubBrandsBean[size];
            }
        };
    }
}
