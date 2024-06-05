<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/css/admin/product_add.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>Document</title>
</head>

<body>
	<div class="background">

		<!-- 메뉴바 -->
		<header>
			<%@ include file="../header/header.jsp"%>
		</header>
		<div class="main">
			<div class="aside">
				<%@ include file="admin_aside.jsp"%>
			</div>
			<div class="mainbox">
				<div class="purchase">
					<h4>상품 추가</h4>
					<hr style="border: solid black 2px;">
				</div>
				<form action="product_add" method="post" onsubmit="return confirm('상품을 등록하시겠습니까?');" enctype="multipart/form-data">
					<div id="addndel">
						<input id="add" class="button" type="submit" value="등록">
					</div>
					<div id="subbox">

						<div id="infobox">
							<div>
								카테고리
								<div class="sizebtn">
									<select name="mainCategory"  id="category"  onchange="itemChange()" required>
										<option value="">카테고리를 선택하세요</option>
										<option value="1">강아지</option>
										<option value="2">고양이</option>
										<option value="3">사료</option>
										<option value="4">간식</option>
									</select>
								</div>
							</div>
							<div>
								분류
								<div class="sizebtn">
									<select name="subCategory" id="subcategory" required>
										<option value="" >분류 선택</option>
										</select>
								</div>
							</div>
							<div>
								상품명<br> <input type="text" name="productName" required style="width:250px;height:30px;font-size:16px;">
							</div>
							<div>
								수량<br> <input type="text" name="productStock" required style="width:250px;height:30px;font-size:16px;">
							</div>
							<div>
								금액<br> <input type="text" name="productPrice" required style="width:250px;height:30px;font-size:16px;">
							</div>
							<div>
								사이즈
								<div class="sizebtn">
									<select  id="size" name="productSize"  required>
										<option value="" >사이즈를 선택하세요</option>
										<option value="옵션없음">선택안함</option>
										<option value="S">S</option>
										<option value="M">M</option>
										<option value="L">L</option>
									</select>
								</div>
							</div>
							<div>
								색상
								<div class="colorbtn">
									<select id="color" name="productColor"  required>
										<option value="" >색상를 선택하세요</option>
										<option value="옵션없음">선택안함</option>
										<option value="red">빨강</option>
										<option value="blue">파랑</option>
										<option value="yellow">노랑</option>
										<option value="green">초록</option>
									</select>
								</div>
							</div>
						</div>
						<div id="imgbox">
							<h3>제품이미지</h3><br>
							    첫번째 이미지<input type="file" accept="image/* " class="imgfile"  name="file"	/>
							    두번째 이미지<input type="file" accept="image/*"  class="imgfile"  	name="file" /><br>
								세번째 이미지<input type="file" accept="image/*"  class="imgfile" 	name="file"/> 
								네번째 이미지<input type="file"	accept="image/*"  class="imgfile"  name="file" />  
							<div class="imgsubbox">
								<div id="img1"><img src="" /></div>
								<div id="img2"><img src="" /></div><br>
								<div id="img3"><img src="" /></div>
								<div id="img4"><img src="" /></div> 								  
							</div>							
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">

$(".imgfile").change(function(){
	var index = $(".imgfile").index(this) + 1; 		
		   if(this.files && this.files[0]) {
		    var reader = new FileReader;
		    reader.onload = function(data) {
		     $('#img'+index+' img').attr("src", data.target.result).width(150);        
		    }
		    reader.readAsDataURL(this.files[0]);
		   }
 });
  
  
  </script>
<script type="text/javascript" src="/js/search.js"></script>
<script type="text/javascript " src="/js/admin_product_add.js?ver=2"></script>

</html>