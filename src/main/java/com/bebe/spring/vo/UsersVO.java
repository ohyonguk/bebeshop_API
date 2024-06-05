package com.bebe.spring.vo;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class UsersVO {
	private String id;
	private String passwd;
	private String emailId;
	private String question;
	private String answer;
	private String emailDomain;
}

