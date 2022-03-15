package com.daru.s1.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	@Autowired
	private ServletContext servletContext;

	public boolean remove(String path, String fileName)throws Exception{
		//file을 hdd에서 삭제
		//저장된 폴더명, 파일명 필요
		path = servletContext.getRealPath(path);
		File file = new File(path, fileName);
		return file.delete();
	}
	
	
	public String save(MultipartFile mutiMultipartFile, String path) throws Exception{
		//1. 어디에 저장 ?
		//파일저장은톰캣에서 저장하는것이 아니라 OS에서 저장
		//path=/resources/upload/member
		String realPath= servletContext.getRealPath(path);
		System.out.println(realPath);
		
		File file = new File(realPath); //파일객체에 폴더정보를담음
		
		if(!file.exists()) {
			//file2.mkdir(); directory를 만들어라,중간폴더가 없으면 에러
			file.mkdirs(); //중간폴더가 없으면 중간폴더도 만들어줌
		}
		
		//1. 시간
		Calendar ca = Calendar.getInstance();
		long l = ca.getTimeInMillis(); //현재시간을 밀리세컨즈로 변환
		System.out.println("time :"+l);
		String oriName = mutiMultipartFile.getOriginalFilename();//~.jpeg
		
		String fileName = l+"_"+oriName;
		System.out.println("fileName :"+fileName);
		
		
		//2. UUID
		fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+oriName;
		System.out.println("UUID :"+fileName);
		
		//file HDD에 저장
		//1. MultipartFile 클래스의 transfer to 메서드 사용
		//realpath fileName으로 이름
		//file = new File(realPath, fileName);
//		file = new File(file, fileName);
//		mutiMultipartFile.transferTo(file);
		
		//2. FileCopyUtils
		file = new File(file, fileName);
		FileCopyUtils.copy(mutiMultipartFile.getBytes(), file);
		return fileName;
	}
}
