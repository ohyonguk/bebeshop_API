<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>bebeshop</title>
    <link rel="stylesheet" href="/css/login/find_id.css">
</head>

<body>

 <header>
			<%@ include file="../header/header.jsp"%>
		</header>
    <div class="outbox">
        <div class="inbox">
            
                <div class="findid">
                    <div class="id">
                        <img src="/img/findid.png" width="90px">
                        <div class="id_test">
                            <h3>아이디 찾기</h3>
                        </div>
                    </div>

                    <div class="write">
                     				<!-- 일치하지 않을 때 -->
						<c:if test="${check == 1 }">
							
							<br>
							<label>일치하는 정보가 존재하지 않습니다.</label>
						</c:if>

						<!-- 일치할 때 -->
						<c:if test="${check == 0 }">
						<br>
						
						<label>찾으시는 아이디는(은) </label>
							<c:forEach items="${id}" var="i">							
							<label>${i.id}</label>
							</c:forEach>
						<label>입니다.</label>	
						</c:if>

                    </div>
                    <div class="secondinfo">
                        
                        <button class="btn_info"  onClick="location.href='/login/findpasswd'">비밀번호 찾기</button>
                        <button class="btn_info"  onClick="location.href='/login/login'">로그인</button>

                    </div>
                </div>
           
        </div>
    </div>
    
</body>
</html>