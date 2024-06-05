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
<script type="text/javascript">
	
</script>
<link rel="stylesheet" href="/css/login/find_passwd.css">

</head>
<body>

 <header>
			<%@ include file="../header/header.jsp"%>
		</header>
	<div class="outbox">
		<div class="inbox">
			
				<div class="findpasswd">
					<div class="id">
						<img src="/img/findpasswd.png" width="90">
						<div class="passwd_test">
							<h3>비밀번호 확인</h3>
						</div>
					</div>

					<div class="write">
						<!-- 이름과 전화번호가 일치하지 않을 때-->
						<c:if test="${check == 1}">
							<script>
								opener.document.findform.name.value = "";
								opener.document.findform.phone.value = "";
							</script>
							<br><br><br>
							<label>일치하는 정보가 존재하지 않습니다.</label>
						</c:if>

						<!-- 이름과 비밀번호가 일치하지 않을 때 -->
						<c:if test="${check == 0 }">
						<br><br><br>
							<label>찾으시는 비밀번호는 ' ${passwd}' 입니다.</label>
							<div class="form-label-group">
							</div>
						</c:if>

					</div>
					<div class="secondinfo">
						<button class="btn_info" onclick="location='/login/findid'">아이디 찾기</button>
						<button class="btn_info" onclick="location='/login/login'">로그인</button>
					</div>
				</div>
			
		</div>
	</div>
</body>
</html>