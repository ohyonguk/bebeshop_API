<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>


<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/css/index/index.css">
<script src="https://kit.fontawesome.com/a216194d9c.js"
	crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript" src="/js/index.js"></script>
	
	
<title>Document</title>
</head>

<body>

	<header id="header">
		<%@ include file="../header/header.jsp"%>
	</header>

	<div class="main">
		<div class="slideName"	>
 		</div>
		<!-- /* -----------------메인영역(slide)--------------------- */ -->
		<div class="slide">	
		    <input type="radio" name="pos" id="pos1" checked>
		    <input type="radio" name="pos" id="pos2">
		    <input type="radio" name="pos" id="pos3">
    	<ul>
<%-- 		      <li><img src="${slide.productImg1}"/></li> --%>
		     
		   <li><img class="slideImg" src="/img/slide5.png" onclick="javascript:location.href='/board/admin_notice'"/></li>
		   <li><img class="slideImg" src="/img/slide2.jpg" onclick="javascript:location.href='/product/searchPage?subCategory=101&page=1' "/></li>
		   <li><img class="slideImg" src="/img/slide3.png" onclick="javascript:location.href='/product/searchPage?subCategory=201&page=1'"/></li>
		   
		    <c:forEach items="${slide}" var="slide" >
		    </c:forEach>
		    
    	</ul>
    <p class="bullet">
      <label for="pos1">1</label>
      <label for="pos2">2</label>
      <label for="pos3">3</label> 
    </p>
     
  </div>    
  	<section class="Fsale">
			<h1 class="name">신상품</h1>

					<div class="Fbxs">
			 <c:forEach items="${slide}" var="slide" >
						<div class="Fbx">
					<a href="/productdetail?productNo=${slide.productNo}">
						<img src="${slide.productImg1}" alt="a">
					<h1>${slide.productName}</h1>
						<div class="price">
							<h4>${slide.productPrice}원</h4> 
						</div>
					</a>
				</div>
			</c:forEach>
					</div>

	</section>
  
  
  			<h1 style="border-top: 2px solid #badbf9;"></h1>
  
		<section class="Fsale">
			<h1 class="name">인기상품</h1>

			<c:forEach items="${Index}" var="row" varStatus="status">
				<c:if test="${status.index %3==0 }">
					<div class="Fbxs">
				</c:if>
				<div class="Fbx">
					<a href="/productdetail?productNo=${row.productNo}">
						<img src="${row.productImg1}" alt="a">
						<h1>${row.productName}</h1>
						<div class="price">
							<h4>${row.productPrice}원</h4>
						</div>
					</a>
				</div>
				<c:if test="${status.index %3==2 }">
					</div>
				</c:if>
			</c:forEach>

	</section>
					<h1 style="border-top: 2px solid #badbf9;"></h1>
	<!-- /* -----------------메인영역(베스트 리뷰)--------------------- */ -->
	<section class="review">
			<div class="rvname">			
				<!-- <span class="namebox"><h1>베스트 리뷰</h1></span> -->
				<h1 class="name">베스트 리뷰</h1>

			</div>
				<c:forEach items="${rv}" var="rev" varStatus="status">
				<c:if test="${status.index %2==0 }">
				<div class="rvboxs">
				</c:if>				
					<div class="rvbox right">
					<a href="/productdetail?productNo=${rev.productNo}">
						<span><c:forEach begin="1" end="${rev.rvStar}">
							<i class="fa fa-star"></i>
						</c:forEach>
							<h3>${rev.rvStar}</h3> </span>
							<div style="display: flex; margin-left: 15px">
							<div id="revimg"><img alt="test" src="${rev.productImg1}" width="100px" height="100px"></div>
							<div  id="revcontent" >${rev.rvContent}</div>		
							</div>		
						</a>
					</div>

					<c:if test="${status.index %2==1 }">
						</div>
					</c:if>
				</c:forEach>
	</section>
	<%@ include file="../footer/footer.jsp"%>
	</div>	
	
	<%--  <%=request.getRealPath("/") %>  --%>
	
</body>



</html>