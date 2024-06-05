package com.bebe.spring.vo;

import java.util.Date;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class ProductVO {

	
	 private int productNo;

	   private String subCategory;
	   private String mainCategory;
	   private String productName;
	   private int productPrice;
	   private Date productDate;
	   private String productImg1;
	   private String productImg2;
	   private String productImg3;
	   private String productImg4;
	   private int productSales;
	   private int productTimesale;      

	  private String keyword;
	  int action;

}
