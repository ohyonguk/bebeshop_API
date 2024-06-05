<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/order/order_sc.css">
    <link href="https://fonts.googleapis.com/css2?family=Handlee&family=Jua&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a216194d9c.js" crossorigin="anonymous"></script>
    <title>Document</title>
</head>

<body>
    <header>
        <%@ include file= "../header/header.jsp" %>
    </header>

    <div class="main">
        <!-- /* -----------------메인영역(slide)--------------------- */ -->
        <section class="confirm">
            <h1>결제가 완료되었습니다.</h1>
            <h4>감사합니다.</h4>
            <a href="/index/index"><input type="button" value="확인"></a>
        </section>
    </div>
    
    <script type="text/javascript" src="/js/search.js"></script>
</body>

</html>