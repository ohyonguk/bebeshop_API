<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/css/aside.css">
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
<div class="half">
    <div class="name">
        <h4>마이페이지</h4> <br>
        <p>${sessionUser.id}님 안녕하세요!</p>
    </div>
    <div class="point">
        <img src="/img/man.png" alt="사람이미지"><br>
    </div>
    <div class="menulist">
        <div class="menu">
            <a href="/user/user_info"><img src="/img/menu.png" alt="메뉴사진">
                <p>회원 정보</p>
            </a>
        </div>
        <div class="menu">
            <a href="/user/mylog"><img src="/img/menu.png" alt="메뉴사진">
                <p>나의 활동</p>
            </a>
        </div>
        <div class="menu">
            <a href="/user/cart2"><img src="/img/menu.png" alt="메뉴사진">
                <p>장바구니</p>
            </a>
        </div>
        <div class="menu">
            <a href="/user/purchase_history"><img src="/img/menu.png" alt="메뉴사진">
                <p>구매 내역</p>
            </a>
        </div>
    </div>
</div>

<script>
    $('.menu').click(function() {
        var indexNo = $(this).index();
        $('.menu').css({
            'transform': 'none'
        });
        $(this).css({
            'transform': 'scale3d(1.2, 1.2, 0.3) translate(-7%, -5%)'
        })
    })
</script>