package com.bebe.spring.index.service;

import java.util.List;

import com.bebe.spring.vo.ProductVO;
import com.bebe.spring.vo.ReviewVO;

public interface IndexService {
	//신제품 슬라이드
	public List<ProductVO> newItem(ProductVO pv)	;
	//인기상품
	public List<ProductVO> hotItem(ProductVO pv); 
	//베스트리뷰
	public List<ReviewVO> bestRv(ReviewVO rv);
}
