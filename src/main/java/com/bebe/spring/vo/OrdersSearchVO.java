package com.bebe.spring.vo;

import java.util.Date;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class OrdersSearchVO {

	private String logDate;
	private int mainSelect;
	private String subSelect;
	private String searchWord;
}
