package jiyun.com.keepcar.ui.adapter.carRenewal.bean;

import java.util.List;

/**
 * Created by 阿三 on 2018/1/3.
 */
public class Insurancecompany {

    /**
     * code : 200
     * msg : 查询成功
     * data : [{"dbid":"c5c3be82dfac47bf9ffea1cf8a82fd7a","shopId":"sysdata","name":"太平洋保险公司","code":"IECY92112E0DE41C4B439ADF42F0547E012A","insertUserId":"211074e8fe384287a9ec6baff7e8f874","insertUserName":"超级管理员","fullInitials":"tpybxgs","insertTime":"2017-11-27 09:49:27","updateUserId":"211074e8fe384287a9ec6baff7e8f874","updateUserName":"超级管理员","updateTime":"2017-11-27 09:50:27","delFlag":"0","isAll":null}]
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
         * dbid : c5c3be82dfac47bf9ffea1cf8a82fd7a
         * shopId : sysdata
         * name : 太平洋保险公司
         * code : IECY92112E0DE41C4B439ADF42F0547E012A
         * insertUserId : 211074e8fe384287a9ec6baff7e8f874
         * insertUserName : 超级管理员
         * fullInitials : tpybxgs
         * insertTime : 2017-11-27 09:49:27
         * updateUserId : 211074e8fe384287a9ec6baff7e8f874
         * updateUserName : 超级管理员
         * updateTime : 2017-11-27 09:50:27
         * delFlag : 0
         * isAll : null
         */

        private String dbid;
        private String shopId;
        private String name;
        private String code;
        private String insertUserId;
        private String insertUserName;
        private String fullInitials;
        private String insertTime;
        private String updateUserId;
        private String updateUserName;
        private String updateTime;
        private String delFlag;
        private Object isAll;

        public String getDbid() {
            return dbid;
        }

        public void setDbid(String dbid) {
            this.dbid = dbid;
        }

        public String getShopId() {
            return shopId;
        }

        public void setShopId(String shopId) {
            this.shopId = shopId;
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

        public String getInsertUserId() {
            return insertUserId;
        }

        public void setInsertUserId(String insertUserId) {
            this.insertUserId = insertUserId;
        }

        public String getInsertUserName() {
            return insertUserName;
        }

        public void setInsertUserName(String insertUserName) {
            this.insertUserName = insertUserName;
        }

        public String getFullInitials() {
            return fullInitials;
        }

        public void setFullInitials(String fullInitials) {
            this.fullInitials = fullInitials;
        }

        public String getInsertTime() {
            return insertTime;
        }

        public void setInsertTime(String insertTime) {
            this.insertTime = insertTime;
        }

        public String getUpdateUserId() {
            return updateUserId;
        }

        public void setUpdateUserId(String updateUserId) {
            this.updateUserId = updateUserId;
        }

        public String getUpdateUserName() {
            return updateUserName;
        }

        public void setUpdateUserName(String updateUserName) {
            this.updateUserName = updateUserName;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(String delFlag) {
            this.delFlag = delFlag;
        }

        public Object getIsAll() {
            return isAll;
        }

        public void setIsAll(Object isAll) {
            this.isAll = isAll;
        }
    }
}
