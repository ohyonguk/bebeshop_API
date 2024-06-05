package com.bebe.spring.vo;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
@Repository
public class QuestionVO {
   
   private int qsNo;
   private int productNo;
   private String id;
   private String qsTitle;
   private String qsContent;
   private int qsSecret;
   private Date qsDate;

}
