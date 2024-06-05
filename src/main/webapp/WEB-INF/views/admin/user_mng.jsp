<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/admin/user_mng.css?ver=1">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <title>Document</title>
</head>

<body>
    <div class="background">

        <!-- 메뉴바 -->
        <header>
            <%@ include file= "../header/header.jsp" %>
        </header>

        <div class="main">
            <div class="aside">
            <%@ include file="admin_aside.jsp" %>
            </div>

            <div class="mainbox">
                <div class="purchase">
                    <h4>회원 관리</h4>
                    <hr style="border: solid black 2px;">
                </div>
                 <div class="page_name">
                <form action="user_mng" method="get">
                	<span>아이디로 검색</span>
                    <input type="text" name="searchWord"  id="searchWord" value="${searchWord}">
                    <input type="submit" class="btn" value="검색">
                 </form>
                </div >
                 <div class="log_table" >
                <table>
                <hr>
                    <tr>
                        <th width=250px;>회원아이디</th>
                        <th width=500px;>이메일</th>
                        <th width=150px;>관리</th>
                    </tr>
               </table>
               </div>
     		 <div class="log_table"  style="overflow:auto; height: 550px; width: 1170px;">
     		 <table>
			<c:forEach var="userlist" items="${userlist}">
				 <form action="user_mng" method="post" onsubmit="return confirm('삭제하시겠습니까?');">
                    <tr>                      
                            <td width=250px;><input type="text" name="id" value="${userlist.id}" class="idinput" readonly/></td>
                            <td width=500px;>${userlist.emailId}@${userlist.emailDomain}</td>
                            <td width=150px;><input type="submit" value="삭제" class="deletbtn"></td>                      
                    </tr>
                      </form>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>


<script type="text/javascript" src="/js/search.js"></script>

</html>