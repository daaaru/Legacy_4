package com.daru.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.daru.s1.util.FileManager;


@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private FileManager fileManager;
	
	public MemberFileDTO datilFile(MemberFileDTO memberFileDTO)throws Exception{
		return memberDAO.detailFile(memberFileDTO);
	}
	
	
	//join
	public int join(MemberDTO memberDTO, MultipartFile photo)throws Exception {
		int result = memberDAO.join(memberDTO);
		//1. 파일을하드디스크에 저장
		String fileName = fileManager.save(photo, "resources/upload/member");
		
		//2. 정보를 DB에 저장
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId(memberDTO.getId());
		memberFileDTO.setFileName(fileName);
		memberFileDTO.setOriName(photo.getOriginalFilename());
		result = memberDAO.addFile(memberFileDTO);
		
		return result;
	}
	
	//login
	public MemberDTO login(MemberDTO memberDTO)throws Exception{
		return memberDAO.login(memberDTO);
	}
	
	//mypage
	public MemberDTO mypage(MemberDTO memberDTO)throws Exception{
		return memberDAO.mypage(memberDTO);
	}
	
}