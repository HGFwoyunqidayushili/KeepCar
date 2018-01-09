package jiyun.com.keepcar.bean;

/**
 * 这个世界上没有天才和大神,只有不努力的笨蛋和菜鸟   ____刘荣斌_____
 */
public class TestBean {
    private  String image;
    private String name;
     private String content;
    private  String price;
    private  String carattribute;

    public TestBean(String image, String name, String content, String price, String carattribute) {
        this.image = image;
        this.name = name;
        this.content = content;
        this.price = price;
        this.carattribute = carattribute;
    }

    public TestBean() {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCarattribute() {
        return carattribute;
    }

    public void setCarattribute(String carattribute) {
        this.carattribute = carattribute;
    }
}
