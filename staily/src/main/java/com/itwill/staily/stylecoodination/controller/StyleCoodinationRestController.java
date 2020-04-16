package com.itwill.staily.stylecoodination.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;
import com.itwill.staily.stylecoodination.service.StyleCoodinationService;
import com.itwill.staily.util.Board;

@RestController
@RequestMapping("/style")
public class StyleCoodinationRestController {
	@Autowired
	 private StyleCoodinationService styleCoodinationService;
	
	@RequestMapping(value="/ImgUpload")
	public void fileUpload(HttpServletRequest req, HttpServletResponse resp, 
                 MultipartHttpServletRequest multiFile) throws Exception {
		JsonObject json = new JsonObject();
		PrintWriter printWriter = null;
		OutputStream out = null;
		OutputStream out2 = null;
		File f = new File("임시.jpg"); // img폴더 경로를 구하기 위한 작업
		MultipartFile file = multiFile.getFile("upload");
		if(file != null){
			if(file.getSize() > 0 ){
				if(file.getContentType().toLowerCase().startsWith("image/")){
					try{
						String fileName = file.getName();
						byte[] bytes = file.getBytes();
						//String uploadPath = "C:/Users/starthink/git/Final-Project/staily/src/main/webapp/img";
						//String uploadPath = "C:/Users/user/git/Final-Project/staily/src/main/webapp/img";
						//String uploadPath = f.getAbsolutePath();
						String[] uploadPathArray = f.getAbsolutePath().split("\\\\");
						String uploadPath = uploadPathArray[0] + "\\" +  uploadPathArray[1] + "\\" + uploadPathArray[2] + 
											"/git/Final-Project/staily/src/main/webapp/img";
						
						
						/*
						int lastNum = uploadPath.lastIndexOf("\\"); // 백슬래쉬를 넣되, 이스케이핑 시키기 위해 두번 씀
						uploadPath = uploadPath.substring(0, lastNum);
						System.out.println(uploadPath);
						 */
						String uploadPath2 = req.getSession().getServletContext().getRealPath("/img");
			
						File uploadFile = new File(uploadPath);
						if(!uploadFile.exists()){
							uploadFile.mkdirs();
						}
							/*
						 	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	   						String newfilename = df.format(new Date()) + Integer.toString((int) (Math.random()*10));
	   	
							File f = new File("C:\\Users\\stu\\git\\Final-Project\\staily\\src\\main\\webapp\\images\\product\\image\\" + newfilename +".jpg");
							 */
						
						// 데이터명 난수 생성
						SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
   						fileName = df.format(new Date()) + Integer.toString((int) (Math.random()*10));
   						System.out.println(fileName);
						//fileName = UUID.randomUUID().toString();
						uploadPath = uploadPath + "/" + fileName;
						uploadPath2 = uploadPath2 + "/" + fileName;
						out = new FileOutputStream(new File(uploadPath));
                        out.write(bytes);
                        out2 = new FileOutputStream(new File(uploadPath2));
                        out2.write(bytes);
                        
                        printWriter = resp.getWriter();
                        resp.setContentType("text/html");
                        String fileUrl = req.getContextPath() + "/img/" + fileName;
                        
                        System.out.println(fileUrl);
                        //String fileUrl = uploadPath;
                        
                        // json 데이터로 등록
                        // {"uploaded" : 1, "fileName" : "test.jpg", "url" : "/img/test.jpg"}
                        // 이런 형태로 리턴이 나가야함.
                        json.addProperty("uploaded", 1);
                        json.addProperty("fileName", fileName);
                        json.addProperty("url", fileUrl);
                        
                        printWriter.println(json);
                    }catch(IOException e){
                        e.printStackTrace();
                        
                    }finally{
                        if(out != null){
                            out.close();
                            out2.close();
                        }
                        if(printWriter != null){
                            printWriter.close();
                        }
					}
				}
			}
		}
	}	
	
	@RequestMapping(value = "/board_one_for_udate_read", produces = "application/json;charset=UTF-8")
	public Board style_view(@RequestParam String bNo) {
		Board board = new Board();
		int intBNo = Integer.parseInt(bNo);
		
		Board updateBoard = styleCoodinationService.findUpdateBoard(intBNo);
		return updateBoard;
	}

	
	
}
