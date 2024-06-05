<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/css/board/admin_notice.css">
    <script src="https://kit.fontawesome.com/a216194d9c.js" crossorigin="anonymous"></script>

<title>Document</title>
</head>

<body>
	<div class="background">
		<header>
			<%@ include file="../header/header.jsp"%>
		</header>
		<div class="main">
			<div class="total">
				<div class="FAQ">
					<h1>BEST FAQ</h1>
					</br>
					<hr color="#000000" size="5px">
					<form role="form" method="GET">
						<table>
							<c:forEach items="${faqList}" var="faqList" begin="0" end="9">
								<tr onclick="location.href='/board/admin_write?faqNo=${faqList.faqNo}&b=2'" style="cursor:pointer">
									<td><c:out value="${faqList.rnum}" /></td>
									<td><c:out value="${faqList.faqTitle}" /></td>
									<td><c:out value="${faqList.faqContent}" /></td>
								</tr>
							</c:forEach>
						</table>
				</div>
				<div class="notice">
					<div class="buttonMenu">
						<h1>공지사항</h1>
						<a href="/board/admin_write?b=0"><input type="button" value="등록" class="button"></a>
					</div>
					</br>
					<hr color="#000000" size="5px">

					<table>
						<tr>                                         
							<th>NO</th>
							<th>공지사항</th>
							<th>공지일자</th>
							<th>공지제목</th>
						</tr>
						<c:forEach items="${noticeList}" var="noticeList" begin="0" end="4">
							<tr onclick="location.href='/board/admin_write?noticeNo=${noticeList.noticeNo}&b=1'" style="cursor:pointer">
								<td><c:out value="${noticeList.noticeNo}" /></td>
								<td><c:out value="${noticeList.noticeCategory}" /></td>
								<td><fmt:formatDate value="${noticeList.noticeDate}"/></td>
								<td><c:out value="${noticeList.noticeTitle}" /></td>
							</tr>
						</c:forEach>
					</table>
					</form>
					</br>
					<div class="next">
						<ul>
							
							<li><a href="/board/admin_notice?page=1&perPageNum=5"><i class="fas fa-angle-double-left"></i></a></li>
							<li><a href="/board/admin_notice${pageMaker.makeSearch(pageMaker.startPage-1)}"><i class="fas fa-angle-left"></i>&nbsp</a></li>
							
							<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
							 <li <c:out value="${pageMaker.cri.page == idx?'class=active':''}"/>>
							<a href="/board/admin_notice${pageMaker.makeSearch(idx)}" class="num">[${idx}]</a>&nbsp</li>
							</c:forEach>
							
							<c:if test="${pageMaker.next == true}">
                   			<li><a href="/board/admin_notice${pageMaker.makeSearch(pageMaker.endPage+1)}"><i class="fas fa-angle-right"></i>&nbsp</a></li>
                    		</c:if>
                  		    <c:if test="${pageMaker.next == false}">
                  		    <li><a href="/board/admin_notice${pageMaker.makeSearch(pageMaker.endPage)}"><i class="fas fa-angle-right"></i>&nbsp</a></li>
                  		    </c:if>
     
							<li><a href="/board/admin_notice?page=${pageMaker.last}&perPageNum=5"><i class="fas fa-angle-double-right"></i></a></li>

						</ul>
					</div>
				</div>
			</div>
			<%@ include file="../footer/footer.jsp"%>
		</div>
			
	</div>

	<script type="text/javascript" src="/js/search.js"></script>
	<script>
		const pos = document.querySelector('.pos').value;
		const button = document.querySelector('.button');


		if (pos == '회원' || pos =="비로그인") {
			button.style = "display: none";
		};
		
		
		
	</script>
</body>

</html>