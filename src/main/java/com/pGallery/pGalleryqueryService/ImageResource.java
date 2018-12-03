package com.pGallery.pGalleryqueryService;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import service.ImageService;
import model.Image;
import model.s3Client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        return "pong";
        //return "pong";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getImageData/{category}", produces = {"application/json", "application/xml"})
    public @ResponseBody List<Image> getData(@PathVariable("category") String cat){
            List<Image> imageList=null;
        try {
            imageList= imgService.getAllMessages(cat);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        return imageList;
    }

    @Controller
    public class FileUploadController {

        //destination folder to upload the files
        private String UPLOAD_FOLDER = "/tmp/";

        @RequestMapping("/upload")
        public ModelAndView showUpload() {
            return new ModelAndView("upload");
        }

        @PostMapping("/upload")
        public ModelAndView fileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
            String status="Invalid";
            String message="Please select a valid file";

            if (file.isEmpty()) {
            status="Invalid";
            message="Please select a valid file";
                return new ModelAndView(status, message, "Please select a file and try again");
            }

            try {
                // read and write the file to the selected location-
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
                status="Successful";
                message="Upload Successful";

                //Write to S3 myuploads bucket
                s3Client.putObjectsInBucket(file.getOriginalFilename(), path.toString());


            } catch (IOException e) {
                e.printStackTrace();
            }

            return new ModelAndView(status, message, "File Uploaded sucessfully");
        }

    }



}

