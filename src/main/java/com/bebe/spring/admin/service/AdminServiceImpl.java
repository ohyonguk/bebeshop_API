package com.bebe.spring.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bebe.spring.admin.dao.AdminDao;
import com.bebe.spring.vo.OptionsVO;
import com.bebe.spring.vo.OrdersSearchVO;
import com.bebe.spring.vo.OrdersVO;
import com.bebe.spring.vo.ProductOptionsVO;
import com.bebe.spring.vo.ProductSearchVO;
import com.bebe.spring.vo.UsersVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao;

	@Override
	public Integer updatePasswd(String passwd) {
		return adminDao.updatePasswd(passwd);
	}

	@Override
	public Integer insertProduct(ProductOptionsVO productOpVo) {
		return adminDao.insertProduct(productOpVo);

	}

	@Override
	public List<UsersVO> selectUsers(String searchWord) {
		return adminDao.selectUsers(searchWord);
	}

	@Override
	public Integer deleteUser(String id) {
		return adminDao.deleteUser(id);
	}

	@Override
	public List<ProductOptionsVO> selectProductList(ProductSearchVO psVo) {
		return adminDao.selectProductList(psVo);
	}

	@Override
	public List<OptionsVO> selectOptions() {
		return adminDao.selectOptions();
	}

	@Override
	public Integer deleteProduct(int[] checkproductno) {
		for (int id : checkproductno)
			adminDao.deleteProduct(id);
		return null;
	}

	@Override
	public Integer deleteOthers(int[] checkproductno) {
		for (int productNo : checkproductno) {
			// 해당 상품번호의 모든 옵션 삭제
			adminDao.deleteOptions(productNo);
			// 상품 문의 삭제
			adminDao.deleteQuestion(productNo);
			// 상품 답변 삭제
			adminDao.deleteAnswer(productNo);
			// 상품 리뷰 삭제
			adminDao.deleteReview(productNo);
		}
		return null;
	}

	@Override
	public Integer insertOptions(OptionsVO optionsVo) {
		return adminDao.insertOptions(optionsVo);
	}

//주문 내역 검색
	@Override
	public List<OrdersVO> selectOrdersList(OrdersSearchVO osVo) {
		return adminDao.selectOrdersList(osVo);
	}

	@Override
	public Integer updateOrderSts(OrdersVO orderVo) {

		return adminDao.updateOrderSts(orderVo);
	}

	@Override
	public Integer updateSales(OrdersVO orderVo) {
		return adminDao.updateSales(orderVo);
	}

	@Override
	public Integer updateStock(OrdersVO orderVo) {
		return adminDao.updateStock(orderVo);
	}

}
