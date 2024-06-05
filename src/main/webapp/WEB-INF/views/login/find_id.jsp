<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<form action="#" method="POST">
                    <div class="write">
                         <span class="email"><input type="text" name="emailId" class="email" caption="이메일" maxlength="80"
                                    value="" placeholder="입력해주세요"" required></span>
                            <span class="space">@</span>
                            <span class="email"></span>
                            <span class="select">
                                <select class="select2" name="emailDomain" >
                                    <option value="etc">선택해주세요</option>
                                    <option value="naver.com">naver.com</option>
                                    <option value="gmail.com">gmail.com</option>
                                    <option value="nate.com">nate.com</option>
                                    <option value="hanmail.net">hanmail.net</option>
                                    <option value="korea.com">korea.com</option>
                                </select><br><br>
                        <input type="submit" value="확인" class="btn">
                    </div>
                    </form>
                    <div class="secondinfo">
                        
                        <button class="btn_info"  onClick="location.href='/login/findpasswd'">비밀번호 찾기</button>
                        <button class="btn_info"  onClick="location.href='/login/login'">로그인</button>

                    </div>
                </div>
            
        </div>
    </div>
    
</body>
</html>