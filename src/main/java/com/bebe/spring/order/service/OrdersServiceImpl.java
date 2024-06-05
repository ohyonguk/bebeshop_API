package com.bebe.spring.order.service;

import com.bebe.spring.order.dao.OrdersDAO;
import com.bebe.spring.vo.OrdersAddressVO;
import org.springframework.stereotype.Service;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
	OrdersDAO ordersDAO;
	
	@Override
	public Integer insertOrders(OrdersAddressVO oav) {
				return ordersDAO.insertOrders(oav);
	}

	@Override
	public Integer deleteCart(OrdersAddressVO oav) {
		// TODO Auto-generated method stub
		return ordersDAO.deleteCart(oav);
	}

	@Override
	public Integer stock(OrdersAddressVO oav) {
		// TODO Auto-generated method stub
		return ordersDAO.stock(oav);
	}

	@Override
	public Integer sales(OrdersAddressVO oav) {
		// TODO Auto-generated method stub
		return ordersDAO.sales(oav);
	}


}
