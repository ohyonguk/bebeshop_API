package com.bebe.spring.order.dao;

import java.util.List;
import java.util.Map;

import com.bebe.spring.vo.OrdersAddressVO;

public interface OrdersDAO {
	Integer insertOrders(OrdersAddressVO oav );
    Integer deleteCart(OrdersAddressVO oav);
    Integer stock(OrdersAddressVO oav);
    Integer sales(OrdersAddressVO oav);
	 

}
