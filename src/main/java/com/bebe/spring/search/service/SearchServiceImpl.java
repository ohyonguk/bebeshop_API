package com.bebe.spring.search.service;

import com.bebe.spring.search.dao.SearchDAO;
import com.bebe.spring.vo.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "searchService")
public class SearchServiceImpl implements SearchService {

	SearchDAO searchDao;
	

//	@Override
	public Integer ccount(Criteria cri) {
		// TODO Auto-generated method stub
		return searchDao.ccount(cri);
	}
//	@Override
	public List<Criteria> llist(Criteria cri) {
		// TODO Auto-generated method stub
		return searchDao.llist(cri);
	}

}
