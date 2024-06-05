package com.bebe.spring.vo;

import java.util.Date;

import org.springframework.stereotype.Repository;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Data
@Repository
public class Criteria {
	private String mainCategory;
	   private int productNo;
	   private String subCategory;
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
	
	private int page;
	private int perPageNum;
	private int num;
	private int nuum;
	
	int action;
	



	public Criteria() {
		this.page = 1;
		this.perPageNum =6;
		this.keyword= null;

	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum =6;
			return;
		}
		this.perPageNum=perPageNum;
	}
	// method for MyBatis SQL Mapper -
	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}
	public int getNum() {
		return num = ((this.getPage()) - 1) * 6 + 1;
	}

	public int getNuum() {
		return nuum = ((this.getPage()) - 1) * 6 + 6;
	}


	public int getPage() {
		return page;
	}
	
}
