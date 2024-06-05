package com.bebe.spring.vo;

import java.util.Date;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class ProductOrdersVO {

//	프로덕트
	   private int productNo;
	   private String subCategory;
	   private String mainCategory;
	   private String productName;
	   private int productPrice;
	   private String productImg1;
	   private String productImg2;
	   private String productImg3;
	   private String productImg4;
	   private Date productDate;
	   private int productSales;
	   private int productTimesale;   	   
	
//오더
		private String id;
		private int orderNo;
		private int orderQty;
		private int orderPrice;
		private String stsDelivery;
		private String stsCancel;
		private Date orderDate;
		private String orderColor;
		private String orderSize;
	
	
}
