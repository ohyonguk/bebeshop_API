package com.bebe.spring.detail.service;

import com.bebe.spring.vo.CartVO;
import com.bebe.spring.vo.DetailVO;

import java.util.List;


public interface DetailService {
	DetailVO selectDetailMain(DetailVO vo);
	List<DetailVO> selectReview(DetailVO vo);
	List<DetailVO> updateReview(int r_no);
	List<DetailVO> selectOne(DetailVO vo);
	List<DetailVO> selectAllQuestion(DetailVO vo);
	List<DetailVO> selectOneQuestion(DetailVO vo);
	List<DetailVO> selectOptions(DetailVO vo);
	List<DetailVO> selectRvBest1(DetailVO vo);
	List<DetailVO> selectRvBest0(DetailVO vo);
	List<DetailVO> selectSecondOptions(DetailVO vo);
	Integer selectStock(DetailVO vo);

	double selectStarAvg(DetailVO vo);
	List <DetailVO> starCnt(DetailVO vo);
	int starTotal(DetailVO vo);
	Integer insertReview(DetailVO vo);
	Integer insertQuestion(DetailVO vo);
	Integer updateAnswer(DetailVO vo);
	Integer updateQuestion(DetailVO vo);
	Integer delQuestion(DetailVO vo);
	Integer delAnswer(DetailVO vo);
	Integer updateRvBest1(int[] cntRvNo);
	Integer updateRvBest0(int[] cntRvNo);
	Integer selectOneReview(DetailVO vo);

	//cart
	Integer insertCart(DetailVO vo);
	List<DetailVO> selectCart(DetailVO vo);
	Integer selectProductPrice(DetailVO vo);
	int selectDuplicateOpt(DetailVO vo);

	CartVO orderItem(CartVO cv);
	//order
	int selectOrder(DetailVO vo);

}
