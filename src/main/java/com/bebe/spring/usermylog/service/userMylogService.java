package com.bebe.spring.usermylog.service;

import java.util.List;
import java.util.Map;

import com.bebe.spring.vo.QuestionVO;
import com.bebe.spring.vo.ReviewVO;

public interface userMylogService {
	
	
	//문의 목록
	public List<QuestionVO> qlist(Map<String, String> map) throws Exception;
	
	
	//목록
	public List<ReviewVO> rlist(Map<String, String> map) throws Exception;

	
	
}
