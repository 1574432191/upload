package com.gjq.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class uploadController {
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@RequestMapping("/upload")
	public String upload(){
		return "upload";
	}
	@RequestMapping("/uploadPic")
	public String uploadPic(MultipartFile file) throws Exception, IOException{
		String filename = file.getOriginalFilename();
		String filePath="D:/picpath/";
		System.out.println(filename);
		File dir = new File(filePath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file2 = new File(dir,filename);
		System.out.println(dir);
		file.transferTo(file2);
		return "getpicture";
	}
	

}
