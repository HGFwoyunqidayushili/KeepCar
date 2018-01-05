package jiyun.com.keepcar.bean;

/**
 * 这个世界上没有天才和大神,只有不努力的笨蛋和菜鸟   ____刘荣斌_____
 */
public class TestBeanXiChe {
    private String image;
    private String name;
    private String content;
    private String original_price;
    private String present_price;

    public TestBeanXiChe(String image, String name, String content, String original_price, String present_price) {
        this.image = image;
        this.name = name;
        this.content = content;
        this.original_price = original_price;
        this.present_price = present_price;
    }

    public TestBeanXiChe() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(String original_price) {
        this.original_price = original_price;
    }

    public String getPresent_price() {
        return present_price;
    }

    public void setPresent_price(String present_price) {
        this.present_price = present_price;
    }
}
