package jiyun.com.keepcar.entity.homepage;

import java.util.List;

/**
 * Created by 阿三 on 2018/1/3.
 */
public class CarActivity {

    /**
     * code : 200
     * msg : 查询成功
     * data : [{"code":"RSIB16D37195960A4B7697347C06929596FB","productType":"保险","salesWays":"零售","promotionType":"无","productName":"保险存5000送2000限时活动","shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","salesNum":0,"discountPrice":0,"originalPrice":5000,"poster":"/upload/P01/P01001/P01_P01001_M007_SHOP00000010_8D19B34EB2474F9C91D619F7066DD662.jpg","activeCondition":"无","useYear":4,"activeBeginDate":null,"activeEndDate":null,"isPackage":"否","isShowMemberFlag":"1"},{"code":"RSCPB7E8F85683C040A7B9ADB655BEFC645F","productType":"洗车套餐","salesWays":"零售","promotionType":null,"productName":"开心套餐","shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","salesNum":0,"discountPrice":0,"originalPrice":1000,"poster":"/upload/P01/P01001/P01_P01001_M017_SHOP00000010_71A1752D0E524BBD802864775D05247A.jpg","activeCondition":"无","useYear":0,"activeBeginDate":null,"activeEndDate":null,"isPackage":"是","isShowMemberFlag":"1"}]
     */

    private String code;
    private String msg;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * code : RSIB16D37195960A4B7697347C06929596FB
         * productType : 保险
         * salesWays : 零售
         * promotionType : 无
         * productName : 保险存5000送2000限时活动
         * shopName : 一汽大众—北京昌平分店
         * shopCode : SHOP00000010
         * salesNum : 0
         * discountPrice : 0.0
         * originalPrice : 5000.0
         * poster : /upload/P01/P01001/P01_P01001_M007_SHOP00000010_8D19B34EB2474F9C91D619F7066DD662.jpg
         * activeCondition : 无
         * useYear : 4.0
         * activeBeginDate : null
         * activeEndDate : null
         * isPackage : 否
         * isShowMemberFlag : 1
         */

        private String code;
        private String productType;
        private String salesWays;
        private String promotionType;
        private String productName;
        private String shopName;
        private String shopCode;
        private int salesNum;
        private double discountPrice;
        private double originalPrice;
        private String poster;
        private String activeCondition;
        private double useYear;
        private Object activeBeginDate;
        private Object activeEndDate;
        private String isPackage;
        private String isShowMemberFlag;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getProductType() {
            return productType;
        }

        public void setProductType(String productType) {
            this.productType = productType;
        }

        public String getSalesWays() {
            return salesWays;
        }

        public void setSalesWays(String salesWays) {
            this.salesWays = salesWays;
        }

        public String getPromotionType() {
            return promotionType;
        }

        public void setPromotionType(String promotionType) {
            this.promotionType = promotionType;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getShopCode() {
            return shopCode;
        }

        public void setShopCode(String shopCode) {
            this.shopCode = shopCode;
        }

        public int getSalesNum() {
            return salesNum;
        }

        public void setSalesNum(int salesNum) {
            this.salesNum = salesNum;
        }

        public double getDiscountPrice() {
            return discountPrice;
        }

        public void setDiscountPrice(double discountPrice) {
            this.discountPrice = discountPrice;
        }

        public double getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(double originalPrice) {
            this.originalPrice = originalPrice;
        }

        public String getPoster() {
            return poster;
        }

        public void setPoster(String poster) {
            this.poster = poster;
        }

        public String getActiveCondition() {
            return activeCondition;
        }

        public void setActiveCondition(String activeCondition) {
            this.activeCondition = activeCondition;
        }

        public double getUseYear() {
            return useYear;
        }

        public void setUseYear(double useYear) {
            this.useYear = useYear;
        }

        public Object getActiveBeginDate() {
            return activeBeginDate;
        }

        public void setActiveBeginDate(Object activeBeginDate) {
            this.activeBeginDate = activeBeginDate;
        }

        public Object getActiveEndDate() {
            return activeEndDate;
        }

        public void setActiveEndDate(Object activeEndDate) {
            this.activeEndDate = activeEndDate;
        }

        public String getIsPackage() {
            return isPackage;
        }

        public void setIsPackage(String isPackage) {
            this.isPackage = isPackage;
        }

        public String getIsShowMemberFlag() {
            return isShowMemberFlag;
        }

        public void setIsShowMemberFlag(String isShowMemberFlag) {
            this.isShowMemberFlag = isShowMemberFlag;
        }
    }
}
