<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="/css/header.css">
<!-- 소셜 -->
<!-- <link href="https://fonts.googleapis.com/css2?family=Handlee&display=swap" rel="stylesheet"></head>
    <link href="https://fonts.googleapis.com/css2?family=Handlee&family=Jua&display=swap" rel="stylesheet"> -->
    

	
	
	<!-- 소셜 -->
	
<div class="headerbx">
   <a href="/index/index"><img src="/img/logo.png" alt="logo" width="100px" height="100px"></a>

    <!--------------------- 상단 아이디 및 아이콘이 들어가는 공간 --------------------->
    <div class="menubx">
        <h6 class="shop"><a href="/product/searchPage?subCategory=101&page=1">SHOP</a></h6>
        <c:choose>
        <c:when test="${sessionUser.id eq 'admin'}">
        <input type="button" value="관리자" class="pos">
        <h6 class="headertag"><a href="/admin/admin_info">${sessionUser.id}</a></h6>
        </c:when>
        <c:when test="${empty sessionUser.id}">
                <input type="button" value="비로그인" class="pos">
        </c:when>        
        <c:otherwise>
         <input type="button" value="회원" class="pos">
         <h6 class="headertag"><a href="/user/user_info">${sessionUser.id}</a></h6>
        </c:otherwise>
        </c:choose>
                
            <h6 class="headertag"><a href="/board/admin_notice">게시판</a></h6>
        <c:choose>
        	<c:when test="${empty sessionUser.id}">
        		<h6 class="headertag"><a href="/login/login">로그인</a></h6>
        	</c:when>
        <c:otherwise> 
				<h6 onclick="signOut()" style="cursor: pointer;" class="headertag">로그아웃</h6>

        </c:otherwise>
        </c:choose>
        <c:choose>
         	<c:when test="${empty sessionUser.id}">
            <a onclick="alert('로그인 후 이용해주세요.')" class="headertag"><img src="/img/cart.png" alt="cart" width="20px" height="20px"></a>
            </c:when>
            <c:otherwise>
         	<a href="/user/cart2" class="headertag"><img src="/img/cart.png" alt="cart" width="20px" height="20px"></a>
        	</c:otherwise>
        </c:choose>
            <img src="/img/search.png" alt="search" width="20px" height="20px" class="btn">
    </div>
  		<form method="get" action="/product/searchPage"> 
        <div class="search"><input type="text"  value="${keyword}" name="keyword" id="keyword"><i class="fa fa-times" aria-hidden="true"></i></div>
        </form>
</div>


<script>
function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
    });
	auth2.disconnect();
      console.log('User signed out.');
      $(document).ready(function(){
	location.replace("/login/logout");    	  
      });
  }
  
    function onLoad() {
      gapi.load('auth2', function() {
        gapi.auth2.init();
      });
    }

    </script>





