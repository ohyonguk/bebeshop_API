<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/admin/product_mng_option.css?ver=1">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <title>옵션추가</title>
</head>

<body>
<form action="productMngOptionAdd" method="post" name="opAdd">
    <input type="text"value="${pNo}"  name="productNo"/>&nbsp
    
    <select id="selectboxColor" name="productColor" required>
        <option value="">색상</option>
        <option value="옵션없음">선택안함</option>
        <option value="red">red</option>
        <option value="blue">blue</option>
        <option value="green">green</option>
        <option value="yellow">yellow</option>
    </select><br>
    
    <input type="text"value="${pName}"/>&nbsp
    <select id="selectboxSize" name="productSize" required>
        <option value="">사이즈</option>
        <option value="옵션없음">선택안함</option>
        <option value="S">S</option>
        <option value="M">M</option>
        <option value="L">L</option>
    </select><br>

    <input type="text"  id="stock" placeholder="재고" name="productStock" required></input><br>
    <input class="button" value="추가" id="addOp" type="submit">    
    <input class="button" value="닫기" type="button" id="close">
    </form>
    

</body>
<script>

 $('#addOp').click(function() {
 if($('#selectboxColor').val() != "" && $('#selectboxSize').val() !="" && $('#stock').val()!="")	{
	alert($('#selectboxColor').val() +", "+ $('#selectboxSize').val() +", "+  $('#stock').val() + "옵션 추가");
 }
 });
 
 $('#close').click(function() {
	 window.opener.location.reload();    //부모창 reload
	 window.close();    //현재 팝업창 Close
	 });
 
</script>
</html>