package com.bebe.spring.vo;


import java.util.Date;
import java.util.List;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class OrdersAddressVO {

	
	//Address
	private String id;
	private int orderNo;
	private int zipcode;
	private String addr;
	private String addrDetail;
	private String tel;
	private String addrReceiver;
	private String addrRequest;
	
	//orders
	private int productNo;
	private int orderQty;
	private int orderPrice;
	private String stsDelivery;
	private String stsCancel;
	private Date orderDate;
	private String orderColor;
	private String orderSize;
	private String productName;
	private String productImg;
	

}
