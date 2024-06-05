<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="/css/user/my_log.css?ver=1">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>bebeshop</title>
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
				<div class="purchase">
					<h4 class="name3">나의 활동</h4>
					<hr style="border: solid black 2px;">
				</div>

				<form action="mylog" method="post">
					<input type="date" id="log_date" name="logDate" value="2021-06-30">
					<select id="select" name="select" required>
						<option value="">선택사항</option>
						<option value="question">문의</option>
						<option value="review">리뷰</option>
					</select> <input id="btn" type="submit" value="검색">
				</form>

				<div class="log_table">
					<table>
						<tr>
							<th id="table_date">작성일자</th>
							<th id="table_select">상품번호</th>
							<th id="table_content">작성내용</th>
						</tr>
					</table>
				</div>
				<div class="log_table"
					style="overflow: auto; height: 550px; width: 1150px;">
					<table>
						<c:if test="${select eq 'question'}">
							<c:forEach items="${list}" var="q">
								<tr>
									<td width=150px;><fmt:formatDate value="${q.qsDate}" pattern="yy-MM-dd" /></td>
									<td width=130px;><a href="/productdetail?productNo= ${q.productNo}">${q.productNo}</a></td>
									<td width=600px;>${q.qsContent}</td>
								</tr>
							</c:forEach>
						</c:if>

						<c:if test="${select eq 'review'}">
							<c:forEach items="${list}" var="r">
								<tr>
									<td width=150px;><fmt:formatDate value="${r.rvDate}" pattern="yy-MM-dd" /></td>
									<td width=130px;><a href="/productdetail?productNo= ${r.productNo}">${r.productNo}</a></td>
									<td width=600px;>${r.rvContent}</td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>


<script type="text/javascript">
	$(document).ready(function() {
		$('.aside').load("user_aside.html");
	});
</script>
<script type="text/javascript" src="/js/search.js"></script>

</html>