package jiyun.com.keepcar.entity.homepage;

import java.util.List;

/**
 * Created by 阿三 on 2018/1/3.
 */
public class CarActivity {


    /**
     * code : 200
     * msg : 查询成功
     * data : [{"code":"BOUTDC0D720A40934ED98547756C59622392","productType":"精品","salesWays":"零售","promotionType":null,"productName":"欢迎购买","shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","salesNum":0,"discountPrice":0,"originalPrice":1200,"poster":null,"activeCondition":"无","useYear":0,"activeBeginDate":null,"activeEndDate":null,"isPackage":"否","isShowMemberFlag":"1","logo":null,"activeState":null},{"code":"BOUTB258A1D084094FDDB921386D0B35A024","productType":"精品","salesWays":"零售","promotionType":null,"productName":"精品零售上架标题","shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","salesNum":0,"discountPrice":0,"originalPrice":250,"poster":null,"activeCondition":"无","useYear":0,"activeBeginDate":null,"activeEndDate":null,"isPackage":"否","isShowMemberFlag":"1","logo":null,"activeState":null},{"code":"BOUT2721B2A09FA64B378614B41FB43DA5D9","productType":"精品","salesWays":"零售","promotionType":null,"productName":"防守打法","shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","salesNum":0,"discountPrice":0,"originalPrice":100,"poster":null,"activeCondition":"无","useYear":0,"activeBeginDate":null,"activeEndDate":null,"isPackage":"否","isShowMemberFlag":"1","logo":null,"activeState":null},{"code":"RSIB16D37195960A4B7697347C06929596FB","productType":"保险","salesWays":"零售","promotionType":"无","productName":"保险存5000送2000限时活动","shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","salesNum":0,"discountPrice":0,"originalPrice":5000,"poster":"/upload/P01/P01001/P01_P01001_M007_SHOP00000010_8D19B34EB2474F9C91D619F7066DD662.jpg","activeCondition":"无","useYear":4,"activeBeginDate":null,"activeEndDate":null,"isPackage":"否","isShowMemberFlag":"1","logo":null,"activeState":null},{"code":"BOUTD5F4805531ED48BA9351BC66155C8287","productType":"精品","salesWays":"零售","promotionType":"买赠","productName":"app精品","shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","salesNum":100,"discountPrice":110,"originalPrice":120,"poster":null,"activeCondition":"无","useYear":0,"activeBeginDate":null,"activeEndDate":null,"isPackage":"否","isShowMemberFlag":"1","logo":null,"activeState":null},{"code":"RCWP791D547EF9DA4ADD8F1D52D39633AFE0","productType":"洗车","salesWays":"零售","promotionType":"限时抢购","productName":"app洗车01","shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","salesNum":100,"discountPrice":20,"originalPrice":8,"poster":"","activeCondition":"无","useYear":0,"activeBeginDate":null,"activeEndDate":null,"isPackage":"否","isShowMemberFlag":"1","logo":null,"activeState":null},{"code":"RSCPB7E8F85683C040A7B9ADB655BEFC645F","productType":"洗车套餐","salesWays":"零售","promotionType":"限时抢购","productName":"开心套餐","shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","salesNum":100,"discountPrice":100,"originalPrice":1000,"poster":"/upload/P01/P01001/P01_P01001_M017_SHOP00000010_71A1752D0E524BBD802864775D05247A.jpg","activeCondition":"无","useYear":0,"activeBeginDate":null,"activeEndDate":null,"isPackage":"是","isShowMemberFlag":"1","logo":null,"activeState":null},{"code":"IMPBD9C1A937E14E4FCE933A13AC3A7A4F06","productType":"项目套餐","salesWays":"零售","promotionType":null,"productName":"会员套餐维护包","shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","salesNum":401,"discountPrice":0,"originalPrice":200,"poster":"/upload/P01/P01001/P01_P01001_M003_SHOP00000010_0B7B695654704CCF963AD14FB91835C5.jpg","activeCondition":"无","useYear":0,"activeBeginDate":null,"activeEndDate":null,"isPackage":"是","isShowMemberFlag":"1","logo":null,"activeState":null}]
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
         * code : BOUTDC0D720A40934ED98547756C59622392
         * productType : 精品
         * salesWays : 零售
         * promotionType : null
         * productName : 欢迎购买
         * shopName : 一汽大众—北京昌平分店
         * shopCode : SHOP00000010
         * salesNum : 0
         * discountPrice : 0.0
         * originalPrice : 1200.0
         * poster : null
         * activeCondition : 无
         * useYear : 0.0
         * activeBeginDate : null
         * activeEndDate : null
         * isPackage : 否
         * isShowMemberFlag : 1
         * logo : null
         * activeState : null
         */

        private String code;
        private String productType;
        private String salesWays;
        private Object promotionType;
        private String productName;
        private String shopName;
        private String shopCode;
        private int salesNum;
        private double discountPrice;
        private double originalPrice;
        private Object poster;
        private String activeCondition;
        private double useYear;
        private Object activeBeginDate;
        private Object activeEndDate;
        private String isPackage;
        private String isShowMemberFlag;
        private Object logo;
        private Object activeState;

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

        public Object getPromotionType() {
            return promotionType;
        }

        public void setPromotionType(Object promotionType) {
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

        public Object getPoster() {
            return poster;
        }

        public void setPoster(Object poster) {
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

        public Object getLogo() {
            return logo;
        }

        public void setLogo(Object logo) {
            this.logo = logo;
        }

        public Object getActiveState() {
            return activeState;
        }

        public void setActiveState(Object activeState) {
            this.activeState = activeState;
        }
    }
}
