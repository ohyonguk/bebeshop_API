package com.bebe.spring.user.dao;

import java.util.List;

import com.bebe.spring.vo.CartVO;

public interface CartDAO {
		public List<CartVO> cart(CartVO cv);
		public int delete(CartVO cv);	
		public CartVO order(CartVO cv);
		public Integer checkSoldOut(CartVO cv);
		
}
