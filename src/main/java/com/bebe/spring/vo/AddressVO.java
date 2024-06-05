package com.bebe.spring.vo;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class AddressVO {

	private String id;
	private int orderNo;
	private int zipcode;
	private String addr;
	private String addrDetail;
	private String tel;
	private String addrReceiver;
	private String addrRequest;
	
}
