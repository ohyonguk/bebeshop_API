<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/css/user/cart.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
            <%@ include file="user_aside.jsp"%>
         </div>

         <div class="mainbox">
            <div class="orderbx">
               <h4 class="name3">장바구니</h4>
               <table class="order">
               
                  <tr>
							<th colspan="2" style="border-left: hidden; width:1000px">제품정보</th>
							<th style="width: 50px;">수량</th>
							<th style="width: 250px;">결제금액</th>
							<th style="width: 80px;">문의</th>
							<th style="width: 150px; border-right: hidden;">제품선택<input
								id="allCheck" type="checkbox" name="allCheck" /></th>
						</tr>
						
						<form  name="cart" id="cart">
						
							<c:forEach items="${cart}" var="cart">
							
								<tr>
									<td style="border-left: hidden" align=right><img
										src="${cart.productImg1 }" alt="a" width="120px" height="120px"></td>
									<td style="border-left: hidden" align="left"><a href="/productdetail?productNo=${cart.productNo}">
										<h3>제품명 : <input type="text"  name="productName" value="${cart.productName}" readonly/></h3>
										<h3>사이즈: <input type="text"  name="productSize" value="${cart.productSize}"  style="width: 100px " rereadonly/><br>
										 컬러: <input type="text"  name="productColor" value="${cart.productColor}" style="width: 100px " readonly/></h3>									
										<h3>가격: ${cart.productPrice}원</h3>
										</a>
									</td>
									<td align=center>
									<input type="text" id="quantity" value="${cart.quantity} "  style="text-align: center;" readonly/>
									</td>

									<td align=center>
										<h1>${cart.quantity*cart.productPrice}원</h1>
									</td>
									<td align=center><a
										href="/productdetail?productNo=${cart.productNo}">문의</a></td>
									<td align=center style="border-right: hidden">
									<input class="RowCheck" 	type="checkbox" name="RowCheck" value="${cart.productNo}">
									<input class="checked" type="hidden"  name="checked" value="false"/>
									<input type="hidden"  name="productNo" value="${cart.productNo}"/>
									</td>
								</tr>
							</c:forEach>
							
					</table>
					
					<div class= "formbtn">
					<input id="purchaseBtn"  type="button"  class="delete" value="삭제하기" onclick= "selDelete()" /> 
					<input id="purchaseBtn" type="button" class ="order" value="선택상품 결제" onclick="checkStock()"/>
					</div>
					</form>
            </div>
         </div>
      </div>
   </div>
   <script>
   
   var qty = parseInt($('#quantity').val());
   console.log(qty);
    function selDelete(){
         var frm =  document.cart;
         frm.action="/user/delete";
         frm.method="post";
         frm.submit();
      }

    function selOrder(){
        var cnt = $("input[name='RowCheck']:checked").length;
         if(cnt == 0){
             alert("선택된 상품이 없습니다.");
         }else{
        var frm = document.cart;
        frm.action="/user/goOrder";
        frm.method="post";
        frm.submit();
         }
     }
		
	function checkStock(){
			
       var formData = $("#cart").serialize(); 
       
        $.ajax({
            cache : false,
            url : "/user/checkStock", // 요기에
            type : 'POST', 
            data : formData, 
            success : function(data) {
                if(data == ""){
                	selOrder();
                }   
                else{
                	 alert(decodeURIComponent(data) + " 상품의 재고가 없습니다");
                }         
            }, // success 
    
            error : function(xhr, status) {
            	alert("전송실패");
            }// $.ajax 
	    });          
		}
	    
	</script>
</body>


<script type="text/javascript" src="/js/search.js"></script>
<script type="text/javascript" src="/js/cart.js"></script>
</html>