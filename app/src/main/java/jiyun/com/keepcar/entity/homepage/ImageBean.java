package jiyun.com.keepcar.entity.homepage;

import java.util.List;

/**
 * Created by 阿三 on 2017/12/28.
 */
public class ImageBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : ["/upload/static/brand/home_brand_01.png","/upload/static/brand/home_brand_02.png","/upload/static/brand/home_brand_03.png","/upload/static/brand/home_brand_04.png"]
     */

    private String code;
    private String msg;
    private List<String> data;

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

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
