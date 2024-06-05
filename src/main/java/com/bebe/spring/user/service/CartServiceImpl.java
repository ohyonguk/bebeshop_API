package com.bebe.spring.user.service;

import com.bebe.spring.user.dao.CartDAO;
import com.bebe.spring.vo.CartVO;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service(value = "cartService")
public class CartServiceImpl implements CartService {
	CartDAO cartDAO;

	@Override
	public List<CartVO> cart( CartVO cv) {
		// TODO Auto-generated method stub
		return cartDAO.cart(cv);
	}

	@Override
	public int delete(CartVO cv) {

		 return cartDAO.delete(cv);
		
	}

	@Override
	public CartVO order(CartVO cv) {
		// TODO Auto-generated method stub
		return cartDAO.order(cv);
	}

	@Override
	public Integer checkSoldOut(CartVO cv) {
		// TODO Auto-generated method stub
		return cartDAO.checkSoldOut(cv);
	}
	
	
	
}
