<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/css/info.css">
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
				<form method="post" action="user_info" class="form" id="form" >
					<div class="info">
						<table class="info_table">
							<caption>
								<h2>회원 정보</h2>
							</caption>
							<tr>
								<td id="fixinfo">아이디</td>
								<td id="userinfo">${sessionUser.id}
								<input type="hidden" name="id" value="${sessionUser.id}">
								<input type="hidden" id="passwd" value="${sessionUser.passwd}">
								</td>
							</tr>
							<tr>
								<td id="fixinfo">이메일</td>
								<td id="userinfo">${sessionUser.emailId}@${sessionUser.emailDomain}</td>
							</tr>
						</table>
					</div>
					<div>
						<div class="passwd">
							<h4>비밀번호변경</h4>
							<h5>*고객님의 비밀번호를 변경해 주세요.</h5>

							<table>
								<tr>
									<td id="fixinfo">현재 비밀번호</td>
									<td id="pw"><input type="password" name="nowpw" id="nowpw"
										placeholder="현재 비밀번호를 입력해주세요."></td>
								</tr>

								<tr>
									<td id="fixinfo">새 비밀번호</td>
									<td id="pw"><input type="password" name="passwd"
										id="newpw" placeholder="영어대소문자 + 숫자 + 특수문자 조합 6~12자리" required>
										<h6>영문 대소문자+숫자+특수문자 조합하여 6~12자리 가능하며, 특수문자는 !,@,#,$,%,^만
											사용가능합니다.</h6></td>
								</tr>
								<tr>
									<td id="fixinfo">새 비밀번호 확인</td>
									<td id="pw"><input type="password" name="newpwch"
										id="newpwch" required></td>
								</tr>
							</table>
						</div>
						<div class="bt">
							<input type="submit" id="button" value="비밀번호 변경">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
	<script src="/js/pwcheck.js"></script>
</body>



</html>