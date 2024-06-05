package com.bebe.spring.vo;

import java.util.Date;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class ReviewVO {
	private int rvNo;
	private String id;
	private int productNo;
	private String rvContent;
	private Date rvDate;
	private int rvStar;
	private int rvBest;
	
	private String productImg1;
}
