<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
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
                            <h3>비밀번호 찾기</h3>
                        </div>
                    </div>
                    <form action="/login/findpasswd" method="POST">
                    <div class="write">
                        <input type="text" class="text" placeholder=" 아이디를 입력해 주세요." name="id">
                        <br>
                        <span class="question"></span>
                        <span class="select1"><select class="select1" name="question">
                            <option value="질문1">졸업한 초등학교의 이름은 무엇입니까?</option>
                            <option value="질문2">가장 친한 친구의 이름은 무엇입니까?</option>
                            <option value="질문3">자신의 인생 좌우명은 무엇입니까?</option>
                            <option value="질문4">인상 깊게 읽은 책은 무엇입니까?</option>
                            <option value="질문5">내 어린시절 별명은 무엇입니까?</option>
                            </select>
                        </span>
                            <br>
                            <input type="text" class="textan" placeholder="질문 답변" name="answer">
                        <br>
                        <input type="submit" value="확인" class="btn">
                    </div>
                     </form>
                    <div class="secondinfo">
                        <button class="btn_info" onClick="location.href='/login/findid'">아이디 찾기</button>
                        <button class="btn_info" onClick="location.href='/login/login'">로그인</button>
                    </div>
                </div>
           
        </div>
    </div>
</body>
</html>