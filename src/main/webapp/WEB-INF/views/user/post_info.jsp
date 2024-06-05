<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/user/post_info.css">
<title>Insert title here</title>
</head>
<body>
	<h1>배송조회</h1><br>
	<div>
		<div class="track_detail">

			<div class="flow2">
				<img src="/img/checkorder.png" width="50px">
				<div>배송준비</div>
			</div>
			<div>
				<img src="/img/next.png" width="50px" class="next">
			</div>
			<div class="flow3">
				<img src="/img/deliverygoing.png" width="50px">
				<div>배송중</div>
			</div>
			<div>
				<img src="/img/next.png" width="50px" class="next">
			</div>
			<div class="flow4">
				<img src="/img/location.png" width="50px">
				<div>배송완료</div>
			</div>
		</div>
	</div>

	<div class="delivery_info">
		<h2>배송현황 : ${orderlist.stsDelivery}</h2>
		<br>
		<table id="infotable">
			<tr>
				<td>주문번호</td>
				<td>: ${orderlist.orderNo}</td>
			</tr>
			<tr>
				<td>상품명</td>
				<td>: ${pName}</td>
			</tr>
			<tr>
				<td>옵션</td>
				<td>: ${orderlist.orderColor}, ${orderlist.orderSize}</td>
			</tr>
			<tr>
				<td>제품수량</td>
				<td>: ${orderlist.orderQty}</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>: ${orderlist.orderPrice}</td>
			</tr>
			<tr>
				<td>받는분</td>
				<td>: ${orderlist.addrReceiver}</td>
			</tr>
			<tr>
				<td>연락처</td>
				<td>: ${orderlist.tel}</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>: ${orderlist.addr} ${orderlist.addrDetail}</td>
			</tr>
			<tr>
				<td>배송요청사항</td>
				<td>: ${orderlist.addrRequest}</td>
			</tr>			
		</table>
	</div>
	<input type="button" value="닫기" onclick="self.close();" id="closebtn"/>
</body>
</html>