<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" href="/css/aside.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<div class="half">
    <div class="name">
        <h4>마이페이지</h4> <br>
        <p>관리자님 안녕하세요!</p>
    </div>
    <div class="point">
        <img src="/img/man.png" alt="사람이미지"><br>
    </div>
    <div class="menulist">
        <div class="menu">
            <a href="admin_info"><img src="/img/menu.png" alt="메뉴사진">
                <p>관리자 정보</p>
            </a>
        </div>
        <div class="menu">
            <a href="product_add"><img src="/img/menu.png" alt="메뉴사진">
                <p>상품추가</p>
            </a>
        </div>
        <div class="menu">
            <a href="product_mng"><img src="/img/menu.png" alt="메뉴사진">
                <p>재고 관리</p>
            </a>
        </div>
        <div class="menu">
            <a href="user_mng"><img src="/img/menu.png" alt="메뉴사진">
                <p>회원 관리</p>
            </a>
        </div>
        <div class="menu">
            <a href="order_mng"><img src="/img/menu.png" alt="메뉴사진">
                <p>주문 현황</p>
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