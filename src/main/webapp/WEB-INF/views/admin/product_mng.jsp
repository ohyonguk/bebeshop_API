<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/css/admin/product_mng.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>Document</title>
</head>

<body>
   <div class="background">

      <!-- 메뉴바 -->
      <header>
         <%@ include file="../header/header.jsp"%>
      </header>
      <div class="main">
         <div class="aside">
            <%@ include file="admin_aside.jsp"%>
         </div>

         <div class="mainbox" >
            <div class="purchase">
               <h4>재고 관리</h4>
               <hr style="border: solid black 2px;">
            </div>
            <form action="searchproduct" method="post" name="formcategory">
               <div class="log">
                  <select id="mainCategory" name="mainCategory"
                     onchange="itemChange()" required>
                     <option value="">카테고리</option>
                     <option value="1">강아지</option>
                     <option value="2">고양이</option>
                     <option value="3">사료</option>
                     <option value="4">간식</option>
                  </select> <select id="subCategory" name="subCategory" required>
                     <option value="">분류 선택</option>
                  </select> 
                  <input id="searchWord" name="searchWord" style="width:250px;height:30px;font-size:16px;"> &nbsp
                  <input class="button" id="search" type="submit" value="검색">               
            </form>         
            <input id="delbtn" class="button" value="삭제" type="button" readonly>
            </div>
             <div class="log_table"  id="productlist" >
             <hr>
            <table id="managerTh">
                  <tr>
                  <th >선택</th>
                  <th >품번</th>
                  <th >이미지</th>
                  <th >상품명</th>
                  <th>금액</th>
                  <th >색상 / 사이즈 : 재고</th>
                  <th>판매량</th>
                  <th>옵션추가</th>
               </tr>
               </table>
               </div>
            <div id="productmain" style="overflow:auto; height: 590px; width: 1170px;">

               <div class="log_table"  id="productlist" >              
            	<table id="manager">
               <input type="hidden" value="${map.psVo.searchWord}" id="searchWordval"/>
               
               <c:forEach var="list" items="${map.productlist}" varStatus="st">
               <c:if test="${st.index ==0}">
               <form name="formproduct">
                  <input type="hidden" value="${list.subCategory}" id="subCategoryval" name="subCategory">
                  <input type="hidden" value="${list.mainCategory}" id="mainCategoryval">                  
               </c:if>
                  <tr>
                     <td width=80px;>
                        <!-- 선택 -->
                        <div class="productcheck">
                           <input type="checkbox" value="${list.productNo}" name="checkproductno">
                        </div>
                     </td>
                     <td width=80px;>
                        <!-- 상품 번호 -->
                        <div class="productno" >${list.productNo}</div>
                     </td>
                     <td width=120px;>
                     		<img style="width:80px; height: 80px;" alt="제품사진" src="${list.productImg1}">
                     </td>
                     <td width=120px;>
                        <!-- 상품 이름 -->
                        <a href="/productdetail?productNo=${list.productNo}">
                        <div class="productname">${list.productName}</div>
                        </a>
                     </td>
                     <td width=80px;>
                        <!-- 금액 -->
                        <div class="price">${list.productPrice}</div>
                     </td>
                     <td id="option" >      
                     <div style="overflow:auto; height: 120px;">           
                        <c:forEach var="option" items="${map.optionlist}">   
                           <c:if test="${list.productNo == option.productNo}">
                              <div class="optionC">
                                 <div> ${option.productColor}</div>/<div>${option.productSize}</div>:<div>${option.productStock}</div>
                              </div>
                           </c:if>   
                        </c:forEach>   
                        </div>                      
                        </td>                  
                     <td width=120px;>
                        <!-- 판매량 -->
                        <div class="saleamount">${list.productSales}</div>
                     </td>

                     </tr>
                     <c:if test="${st.last}"></form></c:if>         
                  </c:forEach>
                  </table>
                  </div>
                  <div class="log_table"  id="opdiv">
               <table id="optable">    
               <c:forEach var="list" items="${map.productlist}" varStatus="st">               
               		<tr>                                    
                     <td>
                        <div >
                           <button class="button" onclick="popup(${st.index})">옵션 추가</button>
                        </div>
                     </td>               
                     </tr>
                  </c:forEach>
               </table>   
               </div>                  
            </table>
         </div>
         </div>
      </div>
   </div>

</body>
<script>
   function popup(num) {
      console.log(num);
      var productno = $(".productno").eq(num).text(); 
      console.log(productno);
      var productname = $(".productname").eq(num).text(); 
      console.log(productname);

      var url = "/admin/productMngOption?pno=" + productno + "&pname="
            + productname;
      /*     var url="/admin/product_mng_option"; */
      var option = "width=600, height=200, top=400, left=1400"
      window.open(url, "옵션선택", option).focus();
   }
</script>

<script type="text/javascript" src="/js/admin_product_mng.js?ver=4"></script>
<script type="text/javascript" src="/js/search.js"></script>

</html>