package org.bhagwan.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABS_PATH="/Users/Bhagwan/git/online-shopping/onlineshopping/src/main/webapp/assets/images";
	private static String REAL_PATH="";
	private static final Logger logger=LoggerFactory.getLogger(FileUploadUtility.class);
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		
		REAL_PATH=request.getSession().getServletContext().getRealPath("/assets/images/");
		logger.info(REAL_PATH);
		logger.info(ABS_PATH);
		//to make sure all directories exists
		//please create the directories
		if(!new File(ABS_PATH).exists()){
			//create directory
			new File(ABS_PATH).mkdirs();
		}
		
		if(!new File(REAL_PATH).exists()){
			//create directory
			new File(REAL_PATH).mkdirs();
		}
		try{
			//server upload
			file.transferTo(new File(REAL_PATH+code+".jpeg"));
			//project directory upload
			file.transferTo(new File(ABS_PATH+code+".jpeg"));
			
		}catch(IOException ex){
			
		}
	}
}
