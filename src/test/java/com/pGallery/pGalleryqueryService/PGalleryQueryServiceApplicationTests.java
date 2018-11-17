package com.pGallery.pGalleryqueryService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import service.ImageService;
import java.util.List;
import java.util.ArrayList;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PGalleryQueryServiceApplicationTests {

	@Test
	public void getImageData(){
		ImageService imgSvc = new ImageService();
		List li= new ArrayList<>();
		li=imgSvc.getAllMessages();
		System.out.println(li.get(0));
	}
}
