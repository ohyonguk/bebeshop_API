<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/admin/order_mng.css?ver=3">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <title>Document</title>
</head>

<body>
    <div class="background">

        <!-- 메뉴바 -->
        <header>
             <%@ include file= "../header/header.jsp" %>
        </header>

        <div class="main">
            <div class="aside">
            	<%@ include file="admin_aside.jsp" %>
            </div>

            <div class="mainbox">
                <div class="purchase">
                    <h4>주문 현황</h4>
                    <hr style="border: solid black 2px;">
                </div>
                <div class="page_name">
                <form action="order_mng" method="post">
                    <!-- <input type="date" name="logDate" class="log_date"> -->

                    <select class="category" name="mainSelect" id="category" onchange="itemChange()">
                        <option value="">카테고리</option>                        
                        <option value="1">배송상태</option>
                        <option value="2">취소상태</option>
                        <option value="3">아이디</option>
                        <option value="4">주문번호</option>
                      </select>
                    <select class="subcategory" name="subSelect" id="subcategory" required >
                    <option value="">분류선택</option>
                      </select>
                    <input type="text" name="searchWord"  id="searchWord">
                    <input type="submit" class="btn" value="검색">
                    </form>
                </div >
                <div class="log_table" >
                    <hr>
                    <table>
                        <tr>
                            <th width=100px;>결제일자</th>
                            <th width=100px;>주문번호</th>
                            <th width=100px;>상품번호</th>                           
                            <th width=100px;>회원아이디</th>
                            <th width=590px;>주문상태</th>
                        </tr>
                        </table>
                        </div>
                        <div class="log_table"  style="overflow:auto; height: 550px; width: 1170px;">
                        <table>
                        <c:forEach items="${list}"  var="list" varStatus="index">
                        <form action="sts_update" method="post"  name="stsform">
                        <tr>
                            <td width=100px;>
                               <fmt:formatDate value="${list.orderDate}" pattern="yy-MM-dd"/>
                            </td>
                            <td width=100px;><input type="hidden" value="${list.orderNo}" name="orderNo"/> ${list.orderNo}</td>
                            <td width=100px;>${list.productNo}</td>
                            <td width=100px;>${list.id}</td>
                            <td width=590px;>
                            <input class="stsinput" type="text" value="${list.stsDelivery}" class="stsDelivery" readonly/>
                            <select class="category" name="stsDelivery" class="stsDeliverySel">
                            <c:choose>
                            <c:when test="${list.stsDelivery eq '배송준비'}">
                                <option value="배송준비">배송준비</option>                        
                                <option value="배송중">배송중</option>
                                <option value="배송완료">배송완료</option>
                            </c:when>
                            <c:when test="${list.stsDelivery eq '배송중'}">
                                <option value="배송중">배송중</option>
                                <option value="배송완료">배송완료</option>
                            </c:when>
                            <c:when test="${list.stsDelivery eq '배송완료'}">
                                <option value="배송완료">배송완료</option>
                            </c:when>

							</c:choose>
							
							
                              </select>
                              <input class="stsCancel" type="text" value="${list.stsCancel}" class="stsCancel" readonly/>
                              

                              <select class="stsCancelSel" name="stsCancel" class="stsCancelSel">     
                             <c:choose>
                                 <c:when test="${list.stsCancel eq '취소대기'}">                       		 
                           		 <option value="취소대기">취소대기</option>
                           		 <option value="취소완료">취소완료</option>
                           	  </c:when>
                           		 
                            <c:when test="${list.stsCancel eq '취소'}">  
                           		  <option value="취소">취소</option>
                          	  </c:when>
                          	  <c:otherwise>
                           		  <option value="취소완료">취소완료</option>
                            </c:otherwise>
                            </c:choose>							      
                              </select>

                              <input type="submit" class="btn" id="stsbtn" value="변경">
                              
                               <input type="hidden" name ="productNo" value="${list.productNo}"/>
                               <input type="hidden" name ="orderQty" value="${list.orderQty}"/>
                               <input type="hidden" name ="orderColor" value="${list.orderColor}"/>
                               <input type="hidden"  name ="orderSize"  value="${list.orderSize}"/>
                       		   <input type='hidden' name ='mainSelect'  value='${searchList.mainSelect}'/>
                     		   <input type='hidden' name ='subSelect'  value='${searchList.subSelect}'/>
                     		   <input type='hidden' name ='searchWord'  value='${searchList.searchWord}'/> 
                            </td>
                        </tr>
                        </form>
                       </c:forEach>
                    </table>
                    </div>
                </div>
            </div>
        </div>
</body>


<script type="text/javascript">

if(!${empty searchList.mainSelect}){
stsSet();
}
function stsSet(){
	console.log(${searchList.mainSelect});
	console.log('${searchList.subSelect}');
	console.log('${searchList.searchWord}');
	$("#category").val(${searchList.mainSelect}).attr("selected","selected");
	itemChange();
	$("#subcategory").val("${searchList.subSelect}").prop("selected", true);
	$("#searchWord").val('${searchList.searchWord}');
	}

function itemChange(){
	 var changeItem = ["배송준비","배송중","배송완료"];  
	 var changeItem2 = ["취소대기","취소완료"];  
	 var selectItem = $("#category").val();
	 
	  $('#subcategory').empty();
	  
	 if(selectItem == "1"){
		 var option = $("<option value=''>분류 선택</option>");
	  	$('#subcategory').append(option);
	 		for(var count = 0; count < changeItem.length; count++){  
	 		 	var option = $("<option value='"+changeItem[count]+"'>"+changeItem[count]+"</option>");
	 			$('#subcategory').append(option);
	 		}   
		$('#searchWord').attr("disabled", true);
	 }

	 else if(selectItem == "2"){
		 var option = $("<option value=''>분류 선택</option>");
	  	$('#subcategory').append(option);
	 		for(var count = 0; count < changeItem2.length; count++){  
	 		 	var option = $("<option value='"+changeItem2[count]+"'>"+changeItem2[count]+"</option>");
	 			$('#subcategory').append(option);
	 		}   
		$('#searchWord').attr("disabled", true);
	 }

	 else if(selectItem == "3") {
	    var option = $("<option value='3' selected disable>아이디</option>");
	    $('#subcategory').append(option);
	$('#searchWord').attr("disabled", false);
	 }
	 else{
	     var option = $("<option value='4' selected disable>주문번호</option>");
	    $('#subcategory').append(option);
	$('#searchWord').attr("disabled", false);
	 }  
	 }
</script>
<!-- <script type="text/javascript" src="/js/order_mng.js"></script> -->
<script type="text/javascript" src="/js/search.js"></script>

</html>