package com.bebe.spring.index.service;

import com.bebe.spring.index.dao.IndexDAO;
import com.bebe.spring.vo.ProductVO;
import com.bebe.spring.vo.ReviewVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "indexService")
@RequiredArgsConstructor
public class IndexServiceImpl implements IndexService {
	IndexDAO indexDAO;

	@Override
	public List<ProductVO> newItem(ProductVO pv) {
		// TODO Auto-generated method stub

		return indexDAO.newItem(pv);
	}
	@Override
	public List<ProductVO> hotItem(ProductVO pv) {
		return indexDAO.hotItem(pv);
	}

	@Override
	public List<ReviewVO> bestRv(ReviewVO rv) {
		return indexDAO.bestRv(rv);
	}



	
	
		
}
