package com.bebe.spring.vo;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class OptionsVO {
   
   private int productNo;
   private String productColor;
   private String productSize;
   private int productStock;

}
