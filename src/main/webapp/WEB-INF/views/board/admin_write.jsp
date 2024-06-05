<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/css/header.css">
<link rel="stylesheet" href="/css/board/admin_write.css">
<script src="https://kit.fontawesome.com/a216194d9c.js"
	crossorigin="anonymous"></script>


<title>Document</title>
</head>

<body>
	<div class="background">
		<header>
			<%@ include file="../header/header.jsp"%>
		</header>
		<div class="main">
			<form name="frm" role="form">
				<div class="post">
					<h2>게시판</h2>
					<hr color="#000000" size="5px">
					</br> <select name="postSubject" class="choice" id="choice"
						onchange="select()">
						<!-- 각 페이지별 첫 선택값 노출 및 선택사항 조설 -->
						<c:if test="${b eq '0'}">
							<option value="공지분류">공지분류</option>
							<option value="Best FAQ">Best FAQ</option>
							<option value="공지사항">공지사항</option>

						</c:if>
						<c:if test="${b eq '2'}">
							<option value="Best FAQ">Best FAQ</option>
							<option value="공지사항">공지사항</option>

						</c:if>
						<c:if test="${b eq '1'}">
							<option value="공지사항">공지사항</option>
							<option value="Best FAQ">Best FAQ</option>

						</c:if>

					</select>
					<!-- 각 페이지별 첫 선택값 노출 및 선택사항 조설 -->
					<select class="choice" id="secondChoice" name="noticeCategory">
						<c:if test="${b eq '0' || b eq '2'}">
							<option value="공지사항">공지사항</option>
							<option value="이벤트">이벤트</option>
							<option value="고객안내">고객안내</option>
							<option value="문의사항">문의사항</option>
							<option value="타임세일">타임세일</option>
							<option value="일반문의">일반문의</option>
						</c:if>


						<c:if test="${b eq '1'}">
							<option value="공지사항"
								<c:if test="${readNotice.noticeCategory eq '공지사항'}">selected</c:if>>공지사항</option>
							<option value="이벤트"
								<c:if test="${readNotice.noticeCategory eq '이벤트'}">selected</c:if>>이벤트</option>
							<option value="고객안내"
								<c:if test="${readNotice.noticeCategory eq '고객안내'}">selected</c:if>>고객안내</option>
							<option value="문의사항"
								<c:if test="${readNotice.noticeCategory eq '문의사항'}">selected</c:if>>문의사항</option>
							<option value="타임세일"
								<c:if test="${readNotice.noticeCategory eq '타임세일'}">selected</c:if>>타임세일</option>
							<option value="일반문의"
								<c:if test="${readNotice.noticeCategory eq '일반문의'}">selected</c:if>>일반문의</option>
						</c:if>


					</select>
				</div>



				<!-- 제목 입력 사항 -->
				<div class="postTitle">
					<h2>* 제목</h2>
					<c:if test="${b eq '0'}">
						<input type="text" class="title"
							placeholder="${rumcount .rnum}제목을 입력해 주세요." name="faqTitle">
					</c:if>
					<c:if test="${b eq '1'}">
						<input type="text" class="title" name="noticeTitle"
							placeholder="제목을 입력해 주세요." value="${readNotice.noticeTitle}">
						<input type="hidden" value="${readNotice.noticeNo}"
							name="noticeNo" />
					</c:if>
					<c:if test="${b eq '2'}">
						<input type="text" class="title" name="faqTitle"
							placeholder="제목을 입력해 주세요." value="${readFaq.faqTitle}">
						<input type="hidden" value="${readFaq.faqNo}" name="faqNo" />
					</c:if>
				</div>



				<!-- 내용 입력 사항 -->
				<div class="postMain">
					<h2>* 내용</h2>
					<c:choose>
						<c:when test="${b eq 0}">
							<textarea class="content" placeholder="내용을 입력해 주세요."
								name="faqContent"></textarea>
						</c:when>
						<c:when test="${b eq 1}">
							<textarea class="content" placeholder="내용을 입력해 주세요."
								name="noticeContent">${readNotice.noticeContent}</textarea>
						</c:when>
						<c:otherwise>
							<textarea class="content" placeholder="내용을 입력해 주세요."
								name="faqContent">${readFaq.faqContent}</textarea>
						</c:otherwise>
					</c:choose>
				</div>
			</form>
			</br>

			<!-- 버튼 사항 -->
			<div class="buttonMenu">
				<input type="button" class="button" id="btnu" onclick="btnU()">
				<input type="button" class="button" id="btnd" onclick="btnD()">
			</div>
			<%@ include file="../footer/footer.jsp"%>
		</div>
	</div>
	<script type="text/javascript" src="/js/search.js"></script>
	<script>
        const pos = document.querySelector('.pos').value;
        const buttons = document.querySelectorAll('.button');
        const choices = document.querySelectorAll('.choice');
        let category = document.querySelector('#secondChoice');
        let title = document.querySelector('.title').value;
        let content = document.querySelector('.content').value;
        let form = document.createElement("form");
		let frm = document.frm;

        if(pos == '회원' || pos=="비로그인"){
            for(let button of buttons){
                button.style = "display: none";
            }
            for(let choice of choices){
                choice.disabled = true;
            }
            document.querySelector('.title').disabled = true;
            document.querySelector('.content').disabled = true;
        };

        if(title == "" && content ==""){
            for(let i=0; i<buttons.length; i++){
                buttons[0].value = "등록"
                buttons[1].value = "취소"               
            }
        }else{
            for(let i=0; i<buttons.length; i++){
                buttons[0].value = "수정"
                buttons[1].value = "삭제"               
            }
        };
        

        function select() {
            let selectedChoice = document.querySelector('#choice').selectedIndex;
            if (document.getElementsByTagName('option')[selectedChoice].value == "Best FAQ") {
                document.querySelector('#secondChoice').style.display = 'none' 
                document.querySelector('.title').setAttribute("name","faqTitle")
                document.querySelector('.content').setAttribute("name", "faqContent")
            }else{
                document.querySelector('#secondChoice').style.display = 'inline-block'
                document.querySelector('.title').setAttribute("name","noticeTitle")
                document.querySelector('.content').setAttribute("name", "noticeContent")
            }
        };
        

	
        function btnU() {
        	 let selectedChoice = document.querySelector('#choice');
        	if (!document.querySelector('.title').value || !document.querySelector('.content').value 
        			|| selectedChoice.value == "공지분류") {
                alert("입력사항을 다시 확인해 주시기 바랍니다.")
            } else {
            let value = document.querySelector("#btnu").value;
            let answer = confirm(value + " 하시겠습니까?");
            let selectedChoice = document.querySelector('#choice').selectedIndex;
	            if (value == "등록") {
	                if (answer == true) {     
	                	if (document.getElementsByTagName('option')[selectedChoice].value == "Best FAQ") {
	                			frm.action = "/board/writeFaq"
	                			frm.method = "post"
	                			frm.submit()
	                   	 }else{
	             			frm.action = "/board/writeNotice"
	             			frm.method = "post"
	             			frm.submit()
	                   	 }
	                };
	            }else if (value == "수정") {
	                if (answer == true) {
	                	<c:if test="${b eq '1'}">		 
	        			frm.action = "/board/update"
	        			frm.method = "post"
	        			frm.submit() 
	                	</c:if>
	                	<c:if test="${b eq '2'}"> 
	        			frm.action = "/board/update"
	        			frm.method = "post"
	        			frm.submit()    
	                 	</c:if>	
	                  	
	                    alert("수정되었습니다.") 
	                } else {location = "/board/admin_notice"}
	            } 
        	}
        };


        function btnD() {
            let value = document.querySelector("#btnd").value;
            let answer = confirm(value + " 하시겠습니까?");
            if (value == "취소") {
                if (answer == true) {
                   alert("취소되었습니다.") 
                   location = "/board/admin_notice"
             	} 
            };
            if (value == "삭제") {
              if (answer == true) {
                  <c:if test="${b eq '1'}">		 
                  location.href = "/board/delete?noticeNo="+${readNotice.noticeNo}+"&b=1" 
                  </c:if>
                  <c:if test="${b eq '2'}"> 
                  location.href = "/board/delete?faqNo="+${readFaq.faqNo}+"&b=2"               
                  </c:if>
                  alert("삭제되었습니다.") 
              	} else {
               	location = "/board/admin_notice"
              }
            	 
            };  
        };
       
    </script>
    
</body>

</html>