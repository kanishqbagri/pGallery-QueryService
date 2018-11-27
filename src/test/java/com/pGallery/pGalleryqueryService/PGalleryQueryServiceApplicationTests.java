package com.pGallery.pGalleryqueryService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import service.ImageService;

import java.security.InvalidKeyException;
import java.util.List;
import java.util.ArrayList;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PGalleryQueryServiceApplicationTests {

	@Test
	public void getImageData(){
		ImageService imgSvc = new ImageService();
		List li= new ArrayList<>();
		try {
			li=imgSvc.getAllMessages("Kids");
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		System.out.println(li.get(0));
	}

	@Test
	public void getImageDataNegative(){
		ImageService imgSvc = new ImageService();
		List li= new ArrayList<>();
		try {
			li=imgSvc.getAllMessages("Invalid");
		} catch (InvalidKeyException e) {
			Assert.assertTrue(true);
		}

	}
}
