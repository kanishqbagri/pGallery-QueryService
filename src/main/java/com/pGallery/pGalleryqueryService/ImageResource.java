package com.pGallery.pGalleryqueryService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.context.annotation.ComponentScan;
import service.ImageService;
import model.Image;
import java.util.List;

@Controller
@RequestMapping("/")
@ComponentScan(basePackages = "/Users/kbagri/Downloads/pGallery-queryService/src/main/java/service/ImageService.java")
public class ImageResource {

    ImageService imgService= new ImageService();


    @RequestMapping(method = RequestMethod.GET, value = "/ping")
    public @ResponseBody String ping(){
        String [] kids= {"static/img/friendship/friendship1.jpg", "static/img/friendship/friendship2.jpg","static/img/friendship/friendship3.jpg","static/img/friendship/friendship4.jpg","static/img/friendship/friendship5.jpg","static/img/friendship/friendship6.jpg","static/img/friendship/friendship7.jpg","static/img/friendship/friendship8.jpg","static/img/friendship/friendship9.jpg"};
        return "pong";
        //return "pong";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getImageData", produces = {"application/json", "application/xml"})
    public @ResponseBody List<Image> getData(){
        String [] kids= {"static/img/friendship/friendship1.jpg", "static/img/friendship/friendship2.jpg","static/img/friendship/friendship3.jpg","static/img/friendship/friendship4.jpg","static/img/friendship/friendship5.jpg","static/img/friendship/friendship6.jpg","static/img/friendship/friendship7.jpg","static/img/friendship/friendship8.jpg","static/img/friendship/friendship9.jpg"};
        return imgService.getAllMessages();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getImageData2", produces = {"application/json"})
    public @ResponseBody String getData2(){
        String [] kids= {"static/img/friendship/friendship1.jpg", "static/img/friendship/friendship2.jpg","static/img/friendship/friendship3.jpg","static/img/friendship/friendship4.jpg","static/img/friendship/friendship5.jpg","static/img/friendship/friendship6.jpg","static/img/friendship/friendship7.jpg","static/img/friendship/friendship8.jpg","static/img/friendship/friendship9.jpg"};

        return "" + imgService.getAllMessages();
    }

}

