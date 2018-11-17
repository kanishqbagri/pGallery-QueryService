package service;

import model.Image;

import java.util.ArrayList;
import java.util.List;

public class ImageService {
    String [] kidImages= {"static/img/friendship/friendship1.jpg", "static/img/friendship/friendship2.jpg","static/img/friendship/friendship3.jpg","static/img/friendship/friendship4.jpg","static/img/friendship/friendship5.jpg","static/img/friendship/friendship6.jpg","static/img/friendship/friendship7.jpg","static/img/friendship/friendship8.jpg","static/img/friendship/friendship9.jpg"};
    public List<Image> getAllMessages(){
        List<Image> imgList= new ArrayList<>();
        for (String img : kidImages){
            Image imgObj= new Image(img, img, "kids");
            imgList.add(imgObj);
        }

        return imgList;
    }
}
