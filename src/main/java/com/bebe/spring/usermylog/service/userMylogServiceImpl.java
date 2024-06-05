package com.bebe.spring.usermylog.service;

import com.bebe.spring.usermylog.dao.userMylogDAO;
import com.bebe.spring.vo.QuestionVO;
import com.bebe.spring.vo.ReviewVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value="userMylogService")
public class userMylogServiceImpl implements userMylogService{
	 userMylogDAO user;


	@Override
	public List<QuestionVO> qlist(Map<String, String> map) throws Exception {
		
		return user.qlist(map);
	}



	@Override
	public List<ReviewVO> rlist(Map<String, String> map) throws Exception {
		
		return user.rlist(map);
	}


	
}
