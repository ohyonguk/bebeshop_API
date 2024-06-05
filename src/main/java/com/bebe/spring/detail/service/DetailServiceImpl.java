package com.bebe.spring.detail.service;

import com.bebe.spring.detail.dao.DetailDao;
import com.bebe.spring.vo.CartVO;
import com.bebe.spring.vo.DetailVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("detailService")
@RequiredArgsConstructor
public class DetailServiceImpl implements DetailService {
	private DetailDao detailDao;

	@Override
	public DetailVO selectDetailMain(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.selectDetailMain(vo);
	}

	@Override
	public List<DetailVO> selectReview(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.selectReview(vo);
	}

	@Override
	public List<DetailVO> updateReview(int r_no) {

		return detailDao.updateReview(r_no);
	}

	@Override
	public List<DetailVO> selectOne(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.selectOne(vo);
	}

	@Override
	public List<DetailVO> selectAllQuestion(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.selectAllQuestion(vo);
	}

	@Override
	public List<DetailVO> selectOneQuestion(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.selectOneQuestion(vo);
	}

	@Override
	public List<DetailVO> selectOptions(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.selectOptions(vo);
	}

	@Override
	public List<DetailVO> selectSecondOptions(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.selectSecondOptions(vo);
	}

	@Override
	public Integer selectStock(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.selectStock(vo);
	}

	@Override
	public double selectStarAvg(DetailVO vo) {
		return detailDao.selectStarAvg(vo);
	}

	@Override
	public List<DetailVO> starCnt(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.starCnt(vo);
	}

	@Override
	public int starTotal(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.starTotal(vo);
	}

	@Override
	public Integer insertReview(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.insertReview(vo);
	}

	@Override
	public Integer insertQuestion(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.insertQuestion(vo);
	}

	@Override
	public Integer delAnswer(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.delAnswer(vo);
	}

	@Override
	public Integer delQuestion(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.delQuestion(vo);
	}

	@Override
	public Integer updateAnswer(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.updateAnswer(vo);
	}

	@Override
	public Integer updateQuestion(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.updateQuestion(vo);
	}

	@Override
	public List<DetailVO> selectRvBest1(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.selectRvBest1(vo);
	}

	@Override
	public List<DetailVO> selectRvBest0(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.selectRvBest0(vo);
	}

	@Override
	public Integer updateRvBest1(int[] cntRvNo) {
		for (int i : cntRvNo)
			detailDao.updateRvBest1(i);
		return null;
	}

	@Override
	public Integer updateRvBest0(int[] cntRvNo) {
		for (int i : cntRvNo)
			detailDao.updateRvBest0(i);
		return null;
	}

	// cart and order
	@Override
	public List<DetailVO> selectCart(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.selectCart(vo);
	}

	@Override
	public Integer insertCart(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.insertCart(vo);
	}

	@Override
	public Integer selectProductPrice(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.selectProductPrice(vo);
	}

	@Override
	public Integer selectOneReview(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.selectOneReview(vo);
	}

	@Override
	public CartVO orderItem(CartVO cv ) {
		// TODO Auto-generated method stub
		
		return detailDao.orderItem(cv);
	}

	@Override
	public int selectOrder(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.selectOrder(vo);
	}
	
	@Override
	public int selectDuplicateOpt(DetailVO vo) {
		// TODO Auto-generated method stub
		return detailDao.selectDuplicateOpt(vo);
	}


}
