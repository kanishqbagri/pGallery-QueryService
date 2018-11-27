package service;

import model.Image;

import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;

public class ImageService {
    String [] kidImages= {"static/img/friendship/friendship1.jpg", "static/img/friendship/friendship2.jpg","static/img/friendship/friendship3.jpg","static/img/friendship/friendship4.jpg","static/img/friendship/friendship5.jpg","static/img/friendship/friendship6.jpg","static/img/friendship/friendship7.jpg","static/img/friendship/friendship8.jpg","static/img/friendship/friendship9.jpg"};
    String [] friendship= {"static/img_t/friendship/friendship1.jpg", "static/img_t/friendship/friendship2.jpg","static/img_t/friendship/friendship3.jpg","static/img_t/friendship/friendship4.jpg","static/img_t/friendship/friendship5.jpg","static/img_t/friendship/friendship6.jpg","static/img_t/friendship/friendship7.jpg","static/img_t/friendship/friendship8.jpg","static/img_t/friendship/friendship9.jpg","static/img_t/friendship/friendship10.jpg","static/img_t/friendship/friendship11.jpg"};
    String [] kids={"static/img_t/kids/kids1.jpg", "static/img_t/kids/kids2.jpg","static/img_t/kids/kids3.jpg","static/img_t/kids/kids4.jpg","static/img_t/kids/kids5.jpg","static/img_t/kids/kids6.jpg","static/img_t/kids/kids7.jpg","static/img_t/kids/kids8.jpg","static/img_t/kids/kids9.jpg","static/img_t/kids/kids10.jpg","static/img_t/kids/kids11.jpg"};
    String [] seasons={"static/img_t/seasons/seasons1.jpg", "static/img_t/seasons/seasons2.jpg","static/img_t/seasons/seasons3.jpg","static/img_t/seasons/seasons4.jpg","static/img_t/seasons/seasons5.jpg","static/img_t/seasons/seasons6.jpg","static/img_t/seasons/seasons7.jpg","static/img_t/seasons/seasons8.jpg","static/img_t/seasons/seasons9.jpg","static/img_t/seasons/seasons10.jpg","static/img_t/seasons/seasons11.jpg","static/img_t/seasons/seasons12.jpg","static/img_t/seasons/seasons13.jpg"};
    String [] concerts={"static/img_t/concerts/concert1.jpg", "static/img_t/concerts/concert2.jpg","static/img_t/concerts/concert3.jpg","static/img_t/concerts/concert4.jpg","static/img_t/concerts/concert5.jpg","static/img_t/concerts/concert6.jpg","static/img_t/concerts/concert7.jpg","static/img_t/concerts/concert8.jpg"};
    String [] landscapes={"static/img_t/landscape/landscape1.jpg", "static/img_t/landscape/landscape2.jpg","static/img_t/landscape/landscape3.jpg","static/img_t/landscape/landscape4.jpg","static/img_t/landscape/landscape5.jpg","static/img_t/landscape/landscape6.jpg","static/img_t/landscape/landscape7.jpg","static/img_t/landscape/landscape8.jpg","static/img_t/landscape/landscape9.jpg"};

    public List<Image> getAllMessages(String category) throws InvalidKeyException{

        List<Image> imgList= new ArrayList<>();
        String [] categoryArray=null;


        switch (category){
            case "Kids":
                    categoryArray = kids;
                    break;

            case "Seasons":
                    categoryArray=seasons;
                    break;

            case "Landscapes":
                    categoryArray=landscapes;
                    break;

            case "Friendship":
                    categoryArray=friendship;
                    break;

            case "Concerts":
                    categoryArray=concerts;
                    break;

            default :
                System.out.println("Invalid Selection");
        }
        if (categoryArray != null) {
            for (String img : categoryArray) {
                Image imgObj = new Image(img, img, category);
                imgList.add(imgObj);
            }
            return imgList;
        }
        else
            throw new InvalidKeyException();
    }
}
