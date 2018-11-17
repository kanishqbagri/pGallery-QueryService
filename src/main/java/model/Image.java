package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Image {

    public Image(){

    }
    public Image(String name, String url, String category) {
        this.name = name;
        this.url = url;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    String name;
    String url;
    String category;


}
