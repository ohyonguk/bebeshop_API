package com.bebe.spring.usermylog.dao;

import java.util.List;
import java.util.Map;

import com.bebe.spring.vo.QuestionVO;
import com.bebe.spring.vo.ReviewVO;

public interface userMylogDAO {
	
	List<QuestionVO> qlist(Map<String, String> map) throws Exception;
	List<ReviewVO> rlist(Map<String, String> map) throws Exception;

}
