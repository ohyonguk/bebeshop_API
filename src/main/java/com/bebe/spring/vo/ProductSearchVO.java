package com.bebe.spring.vo;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class ProductSearchVO {
	   private String subCategory;
	   private String mainCategory;	
	   private String searchWord;
}
