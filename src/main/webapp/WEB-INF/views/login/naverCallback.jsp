<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript"	
src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript"	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>

	<form name="socialLogin">
	 <input type="hidden" id="id" name="id" value=""/>
	</form>

	<script type="text/javascript">
		//var naver_id_login = new naver_id_login("ifOs8Sf6tF3Y_TBfc808", "http://localhost/login/naverCallback");
		var naver_id_login = new naver_id_login("ifOs8Sf6tF3Y_TBfc808", "http://bebeshop.iptime.org:8080/login/naverCallback");
		var token = naver_id_login.oauthParams.access_token;
		naver_id_login.get_naver_userprofile("naverSignInCallback()");

		function naverSignInCallback() {
			var email = naver_id_login.getProfileData('email');
			$("#id").val(email);
	    	var frm = document.socialLogin;
	    	frm.action = "/login/socailLogin";
	    	frm.method = "get";
	    	frm.submit();			
		}

	</script>
</body>


</html>