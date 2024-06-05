package com.bebe.spring.user.dao;

import java.util.List;

import com.bebe.spring.vo.OrdersAddressVO;
import com.bebe.spring.vo.OrdersVO;
import com.bebe.spring.vo.UsersVO;

public interface UserDao {
	List<OrdersVO> selectOrdersList(String id); 
	OrdersAddressVO selectAddress(int orderNo);
	Integer updatePostCancel(int orderNo);
	void modify(UsersVO vo);
}
