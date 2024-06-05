package com.bebe.spring.vo;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class FaqVO {
	private int faqNo;
	private String faqCategory;
	private String faqTitle;
	private String faqContent;
}
