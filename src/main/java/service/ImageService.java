package service;

import model.Image;

import java.security.InvalidKeyException;
import model.s3Client;
import java.util.ArrayList;
import java.util.List;

public class ImageService {

//    String [] friendship= {"https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/friendship/friendship1.jpg", "https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/friendship/friendship2.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/friendship/friendship3.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/friendship/friendship4.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/friendship/friendship5.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/friendship/friendship6.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/friendship/friendship7.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/friendship/friendship8.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/friendship/friendship9.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/friendship/friendship10.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/friendship/friendship11.jpg"};
//    String [] kids={"https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/kids/kids1.jpg", "https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/kids/kids2.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/kids/kids3.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/kids/kids4.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/kids/kids5.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/kids/kids6.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/kids/kids7.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/kids/kids8.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/kids/kids9.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/kids/kids10.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/kids/kids11.jpg"};
//    String [] seasons={"https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/seasons/seasons1.jpg", "https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/seasons/seasons2.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/seasons/seasons3.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/seasons/seasons4.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/seasons/seasons5.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/seasons/seasons6.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/seasons/seasons7.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/seasons/seasons8.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/seasons/seasons9.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/seasons/seasons10.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/seasons/seasons11.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/seasons/seasons12.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/seasons/seasons13.jpg"};
//    String [] concerts={"https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/concerts/concert1.jpg", "https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/concerts/concert2.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/concerts/concert3.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/concerts/concert4.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/concerts/concert5.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/concerts/concert6.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/concerts/concert7.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/concerts/concert8.jpg"};
//    String [] landscapes={"https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/landscape/landscape1.jpg", "https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/landscape/landscape2.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/landscape/landscape3.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/landscape/landscape4.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/landscape/landscape5.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/landscape/landscape6.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/landscape/landscape7.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/landscape/landscape8.jpg","https://s3.us-east-2.amazonaws.com/photo-journal/static/img_t/landscape/landscape9.jpg"};
//
    public List<Image> getAllMessages(String category) throws InvalidKeyException{

        List<Image> imgList= new ArrayList<>();
        String [] categoryArray=null;


        switch (category){
            case "Kids":
                    String [] kids = s3Client.getObjectsFromBucket("kids").toArray(new String[0]);
                    categoryArray = kids;
                    break;

            case "Seasons":
                String [] seasons = s3Client.getObjectsFromBucket("seasons").toArray(new String[0]);
                    categoryArray=seasons;
                    break;

            case "Landscapes":
                    String [] landscapes = s3Client.getObjectsFromBucket("landscapes").toArray(new String[0]);
                    categoryArray=landscapes;
                    break;

            case "Friendship":
                    String [] friendship = s3Client.getObjectsFromBucket("friendship").toArray(new String[0]);
                    categoryArray=friendship;
                    break;

            case "Concerts":
                    String [] concerts = s3Client.getObjectsFromBucket("concerts").toArray(new String[0]);
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
