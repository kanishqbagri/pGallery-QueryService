package com.pGallery.pGalleryqueryService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import service.ImageService;
import model.Image;

import javax.websocket.server.PathParam;
import java.security.InvalidKeyException;
import java.util.List;

@Controller
@RequestMapping("/")
@ComponentScan(basePackages = "/Users/kbagri/Downloads/pGallery-queryService/src/main/java/service/ImageService.java")
public class ImageResource {

    ImageService imgService= new ImageService();


    @RequestMapping(method = RequestMethod.GET, value = "/ping")
    public @ResponseBody String ping(){
        String [] kids= {"static/img/friendship/friendship1.jpg", "static/img/friendship/friendship2.jpg","static/img/friendship/friendship3.jpg","static/img/friendship/friendship4.jpg","static/img/friendship/friendship5.jpg","static/img/friendship/friendship6.jpg","static/img/friendship/friendship7.jpg","static/img/friendship/friendship8.jpg","static/img/friendship/friendship9.jpg"};
        return "pong1";
        //return "pong";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getImageData/{category}", produces = {"application/json", "application/xml"})
    public @ResponseBody List<Image> getData(@PathVariable("category") String cat){
//        String [] friendship= {"static/img_t/friendship/friendship1.jpg", "static/img_t/friendship/friendship2.jpg","static/img_t/friendship/friendship3.jpg","static/img_t/friendship/friendship4.jpg","static/img_t/friendship/friendship5.jpg","static/img_t/friendship/friendship6.jpg","static/img_t/friendship/friendship7.jpg","static/img_t/friendship/friendship8.jpg","static/img_t/friendship/friendship9.jpg","static/img_t/friendship/friendship10.jpg","static/img_t/friendship/friendship11.jpg"};
//        String [] kids={"static/img_t/kids/kids1.jpg", "static/img_t/kids/kids2.jpg","static/img_t/kids/kids3.jpg","static/img_t/kids/kids4.jpg","static/img_t/kids/kids5.jpg","static/img_t/kids/kids6.jpg","static/img_t/kids/kids7.jpg","static/img_t/kids/kids8.jpg","static/img_t/kids/kids9.jpg","static/img_t/kids/kids10.jpg","static/img_t/kids/kids11.jpg"};
//        String [] seasons={"static/img_t/seasons/seasons1.jpg", "static/img_t/seasons/seasons2.jpg","static/img_t/seasons/seasons3.jpg","static/img_t/seasons/seasons4.jpg","static/img_t/seasons/seasons5.jpg","static/img_t/seasons/seasons6.jpg","static/img_t/seasons/seasons7.jpg","static/img_t/seasons/seasons8.jpg","static/img_t/seasons/seasons9.jpg","static/img_t/seasons/seasons10.jpg","static/img_t/seasons/seasons11.jpg","static/img_t/seasons/seasons12.jpg","static/img_t/seasons/seasons13.jpg"};
//        String [] concerts={"static/img_t/concerts/concert1.jpg", "static/img_t/concerts/concert2.jpg","static/img_t/concerts/concert3.jpg","static/img_t/concerts/concert4.jpg","static/img_t/concerts/concert5.jpg","static/img_t/concerts/concert6.jpg","static/img_t/concerts/concert7.jpg","static/img_t/concerts/concert8.jpg"};
//        String [] landscapes={"static/img_t/landscape/landscape1.jpg", "static/img_t/landscape/landscape2.jpg","static/img_t/landscape/landscape3.jpg","static/img_t/landscape/landscape4.jpg","static/img_t/landscape/landscape5.jpg","static/img_t/landscape/landscape6.jpg","static/img_t/landscape/landscape7.jpg","static/img_t/landscape/landscape8.jpg","static/img_t/landscape/landscape9.jpg"};
            List<Image> imageList=null;
        try {
            imageList= imgService.getAllMessages(cat);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        return imageList;
    }

}

