<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String msg = (String)request.getAttribute("msg");
    Cookie[] c = request.getCookies();
    String cookieVal="";
    if(c!=null){
        for(Cookie i:c){
            if(i.getName().equals("saveId")){
                cookieVal=i.getValue();
            }
        }
    }
    
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/login/login.css?ver=1">
    <link href="https://fonts.googleapis.com/css2?family=Handlee&display=swap" rel="stylesheet"></head>
    <link href="https://fonts.googleapis.com/css2?family=Handlee&family=Jua&display=swap" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
    <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
    
    <meta name="google-signin-scope" content="profile email">
	<meta name="google-signin-client_id"
   content="1059402509993-5dgo9oqfau9tharl9cbb1qe4prp40h0j.apps.googleusercontent.com">
	<script src="https://apis.google.com/js/platform.js" async defer></script>
    
    <title>bebeshop</title>
</head>
    <body>
    <header>
			<%@ include file="../header/header.jsp"%>
		</header>
    <div class="outbx">
       <div class="inbx">
           <h1>WELCOME</h1>
           <form action="/login/login" method="post">
               <div class="login">
                   <h1>로그인</h1>
                   <input name ="id" type="id" class="id" value="<%=cookieVal !="" ? cookieVal : "" %>" placeholder="아이디" >
                   <input name="passwd" type="password" class="passwd" placeholder="비밀번호">
                   <!-- 한줄로 내리기 위해 div 처리 -->
                   <div class="checkbx"><input type="checkbox" class="check" name="saveId" <%=cookieVal!=""?"checked" : ""%>>&nbsp<label>아이디 저장</label></div>
                   <input type="submit" value="로그인" class="btn">
                   <div class="found"><h6><a href="/login/findid">아이디 찾기</a>
                   </h6>&nbsp|&nbsp<h6><a href="/login/findpasswd">비밀번호 찾기</a></h6>&nbsp|&nbsp
                   <h6><a href="/login/constent">회원가입</a></h6>
                   </div>
                   </form>
                   <div class="social">
                   <form name= "socialLogin">
                   		<div class="k-signin">
	                  	 <img src="/img/kakao.png" width=25; id="kao" onclick="kakaoLogin()"/>
	                 	</div>
		                  <div class="g-signin2" data-onsuccess="onSignIn" 
		                   data-width="25" data-height="25" data-longtitle="false">
		                   </div>
		                    <div class="n-signin" id="naver_id_login">
		                    <img src="/img/naver.png" width=25; id="na" onclick="naverLogin()"/>
		                     </div>
		                    <input type="hidden" id="id" name="id" value=""/>	                    
          			  
          			 </div>
               </div>
           </form> 
           
        </div>
    </div>


    <script type="text/javascript"> 
    
    $(document).ready(function(){
        if("${errorMessage}"!=""){
        alert("${errorMessage}");
        }
        
     });
//구글로그인
function onSignIn(googleUser) {
	  	  
	var profile = googleUser.getBasicProfile();
	  	  console.log("ID: " + profile.getId());
	  	  var email = profile.getEmail();
	  	$('#id').val(email);
	  	  console.log("Email: " + email);

	  	var frm = document.socialLogin;
    	frm.action = "/login/socailLogin";
    	frm.method = "get";
    	frm.submit();
	  	}

    //카카오로그인
    function kakaoLogin(){
    	window.Kakao.init("f0e088ffc8de3aeaca97aa4221edcafb");
    	window.Kakao.Auth.login({
    		scope: 'profile_nickname, account_email',
    		success: function(authObj){
    			console.log(authObj);
    			window.Kakao.API.request({
    				url:'/v2/user/me', 
    				success: res=>{
    					const kakao_account = res.kakao_account;
    					var email = kakao_account.email;
    					console.log("email : "+email);
    					$('#id').val(email);
    					console.log($('#id').val());			
    					var frm = document.socialLogin;
				    	frm.action = "/login/socailLogin";
				    	frm.method = "get";
				    	frm.submit();
    				}
    			});
    		}
    	});
    }
   
    //네이버로그인

	  	var naver_id_login = new naver_id_login("ifOs8Sf6tF3Y_TBfc808", "http://bebeshop.iptime.org:8080/login/naverCallback");

	  	var state = naver_id_login.getUniqState();
	  	naver_id_login.setButton("green", 1, 25);
	  	naver_id_login.setDomain("http://bebeshop.iptime.org:8080/login/login");

	  	naver_id_login.setState(state);
	  	//naver_id_login.setPopup();
	  	naver_id_login.init_naver_id_login();
	  		  
</script>
</body>


</html>