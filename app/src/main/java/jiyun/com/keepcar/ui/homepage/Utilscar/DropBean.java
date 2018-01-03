package jiyun.com.keepcar.ui.homepage.Utilscar;

/**
 * 这个世界上没有天才和大神,只有不努力的笨蛋和菜鸟   ____刘荣斌_____
 */
public class DropBean {
    private String name;
    private boolean choiced = false;
    public DropBean(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isChoiced() {
        return choiced;
    }
    public void setChoiced(boolean choiced) {
        this.choiced = choiced;
    }
}
