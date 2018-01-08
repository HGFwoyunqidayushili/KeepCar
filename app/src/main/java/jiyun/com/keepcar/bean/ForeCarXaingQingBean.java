package jiyun.com.keepcar.bean;

import java.util.List;

/**
 * 这个世界上没有天才和大神,只有不努力的笨蛋和菜鸟   ____刘荣斌_____
 */
public class ForeCarXaingQingBean  {
    /**
     * code : 200
     * msg : 查询成功
     * data : {"total":4,"list":[{"code":"BOUT2721B2A09FA64B378614B41FB43DA5D9","productType":"精品","salesWays":"零售","promotionType":null,"productName":"防守打法","shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","salesNum":0,"discountPrice":0,"originalPrice":100,"poster":null,"activeCondition":"无","useYear":0,"activeBeginDate":null,"activeEndDate":null,"isPackage":"否","isShowMemberFlag":"1","logo":"/upload/static/carbrand/36.png","activeState":null},{"code":"BOUTD5F4805531ED48BA9351BC66155C8287","productType":"精品","salesWays":"零售","promotionType":null,"productName":"app精品","shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","salesNum":100,"discountPrice":0,"originalPrice":120,"poster":null,"activeCondition":"无","useYear":0,"activeBeginDate":null,"activeEndDate":null,"isPackage":"否","isShowMemberFlag":"1","logo":"/upload/static/carbrand/36.png","activeState":null},{"code":"BOUTB258A1D084094FDDB921386D0B35A024","productType":"精品","salesWays":"零售","promotionType":null,"productName":"精品零售上架标题","shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","salesNum":0,"discountPrice":0,"originalPrice":250,"poster":null,"activeCondition":"无","useYear":0,"activeBeginDate":null,"activeEndDate":null,"isPackage":"否","isShowMemberFlag":"1","logo":"/upload/static/carbrand/36.png","activeState":null},{"code":"BOUTDC0D720A40934ED98547756C59622392","productType":"精品","salesWays":"零售","promotionType":null,"productName":"欢迎购买","shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","salesNum":0,"discountPrice":0,"originalPrice":1200,"poster":null,"activeCondition":"无","useYear":0,"activeBeginDate":null,"activeEndDate":null,"isPackage":"否","isShowMemberFlag":"1","logo":"/upload/static/carbrand/36.png","activeState":null}],"pages":1,"hasNext":false}
     */

    private String code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * total : 4
         * list : [{"code":"BOUT2721B2A09FA64B378614B41FB43DA5D9","productType":"精品","salesWays":"零售","promotionType":null,"productName":"防守打法","shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","salesNum":0,"discountPrice":0,"originalPrice":100,"poster":null,"activeCondition":"无","useYear":0,"activeBeginDate":null,"activeEndDate":null,"isPackage":"否","isShowMemberFlag":"1","logo":"/upload/static/carbrand/36.png","activeState":null},{"code":"BOUTD5F4805531ED48BA9351BC66155C8287","productType":"精品","salesWays":"零售","promotionType":null,"productName":"app精品","shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","salesNum":100,"discountPrice":0,"originalPrice":120,"poster":null,"activeCondition":"无","useYear":0,"activeBeginDate":null,"activeEndDate":null,"isPackage":"否","isShowMemberFlag":"1","logo":"/upload/static/carbrand/36.png","activeState":null},{"code":"BOUTB258A1D084094FDDB921386D0B35A024","productType":"精品","salesWays":"零售","promotionType":null,"productName":"精品零售上架标题","shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","salesNum":0,"discountPrice":0,"originalPrice":250,"poster":null,"activeCondition":"无","useYear":0,"activeBeginDate":null,"activeEndDate":null,"isPackage":"否","isShowMemberFlag":"1","logo":"/upload/static/carbrand/36.png","activeState":null},{"code":"BOUTDC0D720A40934ED98547756C59622392","productType":"精品","salesWays":"零售","promotionType":null,"productName":"欢迎购买","shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","salesNum":0,"discountPrice":0,"originalPrice":1200,"poster":null,"activeCondition":"无","useYear":0,"activeBeginDate":null,"activeEndDate":null,"isPackage":"否","isShowMemberFlag":"1","logo":"/upload/static/carbrand/36.png","activeState":null}]
         * pages : 1
         * hasNext : false
         */

        private int total;
        private int pages;
        private boolean hasNext;
        private List<ListBean> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public boolean isHasNext() {
            return hasNext;
        }

        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * code : BOUT2721B2A09FA64B378614B41FB43DA5D9
             * productType : 精品
             * salesWays : 零售
             * promotionType : null
             * productName : 防守打法
             * shopName : 一汽大众—北京昌平分店
             * shopCode : SHOP00000010
             * salesNum : 0
             * discountPrice : 0.0
             * originalPrice : 100.0
             * poster : null
             * activeCondition : 无
             * useYear : 0.0
             * activeBeginDate : null
             * activeEndDate : null
             * isPackage : 否
             * isShowMemberFlag : 1
             * logo : /upload/static/carbrand/36.png
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
            private String logo;
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

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
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
}
