<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

		<!DOCTYPE html>
		<html lang="ko">

		<head>
			<% String productNo=request.getParameter("productNo"); %>
				<meta charset="UTF-8">
				<meta http-equiv="X-UA-Compatible" content="IE=edge">
				<meta name="viewport" content="width=device-width, initial-scale=1.0">
				<link rel="stylesheet" href="/css/product/detail.css?ver=1">
				<title>Document</title>
				<!--링크들-->
				<script src="http://code.jquery.com/jquery-latest.js"></script>
				<link rel="stylesheet"
					href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
				<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		</head>

		<body>

			<div class="background">
				<header>
					<%@ include file="../header/header.jsp" %>
				</header>

				<div class="main">
					<div class="rvBestManage" style="position:absolute; top : 200px; left : 450px; text-align: center;">
						<div class="RvBest1">
							<form action="/productdetail/updateRvBest0" method="GET" name="delReivew">
								<input type="hidden" value="<%=productNo%>" name="productNo" />
								<h1>베스트 리뷰</h1>
								<table name="bestReview" border="1px solid black" id="bestRv"
									style="width: 1000px; font-size: 13px;">
									<tr style="background-color: #badbf9; color: white;">
										<th>&nbsp</th>
										<th>리뷰번호</th>
										<th>제품명</th>
										<th>ID</th>
										<th>별점</th>
										<th>등록날짜</th>
										<th>리뷰</th>
									</tr>
									<c:forEach items="${RvBest1}" var="r">
										<tr>
											<td><input type="checkbox" name="cntRvNo" id="cntRvNoBest"
													value="${r.rvNo}"></td>
											<td>${r.rvNo}</td>
											<td>${r.productName}</td>
											<td>${r.id}</td>
											<td>${r.rvStar}</td>
											<td>
											<fmt:formatDate value="${r.rvDate}" pattern="yy-MM-dd" />
											</td>
											<td>${r.rvContent}</td>
										</tr>
									</c:forEach>
								</table>

								<input type="submit" value="베스트리뷰 삭제" id="submitBtn" name="updateReviewBtn"
									style="padding: 5px; cursor: pointer; width:auto;" />
							</form>
						</div>
						
						<div class="RvBest0">
							<form action="/productdetail/updateRvBest1" method="GET" name="addReivew"
								style="top: auto; left: 460px; text-align: center; margin-top:100px;">
								<input type="hidden" value="<%=productNo%>" name="productNo" />
								<h1>회원리뷰</h1>
								<table name="userReview" border="1px solid black" id="userRv"
									style="width: 1000px; font-size: 13px;">
									<tr style="background-color: #badbf9; color: white;">
										<th>&nbsp</th>
										<th>리뷰번호</th>
										<th>제품명</th>
										<th>ID</th>
										<th>별점</th>
										<th>등록날짜</th>
										<th>리뷰</th>
									</tr>
									<tbody>
										<c:forEach items="${RvBest0}" var="r">
											<tr>
												<td><input type="checkbox" name="cntRvNo" id="cntRvNoUser"
														value="${r.rvNo}"></td>
												<td>${r.rvNo}</td>
												<td>${r.productName}</td>
												<td>${r.id}</td>
												<td>${r.rvStar}</td>
												<td>
												<fmt:formatDate value="${r.rvDate}" pattern="yy-MM-dd" />
												</td>
												<td>${r.rvContent}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>

								<input type="button" value="베스트리뷰 추가" id="submitBtn" name="updateReviewBtn"
									onclick='DoaddReivew()' style="padding: 5px; cursor: pointer; width:auto;" />
							</form>

						</div>
						
					</div>
				</div>
			</div>
			

			<script>

				function DoaddReivew() {
					var frm = document.addReivew;
					var bestRvCnt = $('#bestRv tr').length;
					var userRvCnt = $("#cntRvNoUser:checked").length;
					var rvsum = bestRvCnt + userRvCnt;
					if (rvsum > 5) {
						alert("베스트리뷰는 4개를 넘을 수 없습니다.");
					} else {
						frm.action = "/productdetail/updateRvBest1";
						frm.method = "get";
						frm.submit();
					}
				}

			</script>


		</body>

		</html>