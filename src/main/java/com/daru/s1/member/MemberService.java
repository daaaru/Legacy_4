package com.daru.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	//join
	public int join(MemberDTO memberDTO)throws Exception {
		return memberDAO.join(memberDTO);
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