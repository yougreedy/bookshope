<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header.jsp"></jsp:include>
<script src="/resources/js/password_check.js"></script>
<!--  <script src="/resources/js/password_check_jquery.js"></script>  -->
<script src="/resources/js/check_id.js"></script>
<script>
function valid(item) {
    if (item.eq && item.tag.value !== item.eq.value) {
        alert(item.msg);
        item.tag.focus();
        return false;
    }

    if (!item.tag.value) {
        alert(item.msg);
        item.tag.focus();
        return false;
    }
    return true;
}

function signup() {
    const form = document.signup_form;

    const tags = [
        { tag: form.custid, msg: "아이디는 필수입니다." },
        { tag: form.passwd, msg: "비밀번호를 입력해주세요." },
        { tag: form.passwd_confirm, msg: "비밀번호 확인을 해주세요." },
        { tag: form.passwd_confirm, msg: "비밀번호와 비밀번호 확인이 일치하지 않습니다.", eq: form.passwd },
        { tag: form.name, msg: "고객명을 입력해주세요." }
    ];

    for (item of tags) {
        if (!valid(item)) return;
    }
    form.submit();
}
</script>
<title>회원가입</title>
</head>
<body>
   <div>
      <div>
          <h1>회원가입</h1>
      </div>
      
      <form action="post" name="signup_form">
          <div>
          
             <div class="form-group">
                <label for="id">아이디:</label>
                <input type="text" name="custid" id="id">
                <button type="button" id="check_id">[비동기]증복확인</button>
                <button type="button" id="check_id_sync">[동기]증복확인</button>
             </div>
             
             <div>
                <label for="pwd">비밀번호:</label>
                <input type="password" name="passwd" id="pwd">
                <button type="button" class="password_check" data-for="passwd">확인</button>
             </div>
             
	         <div>
				<label for="pwd">비밀번호 확인:</label>
				<input type="password" name="passwd_confirm" id="pwd"> 
				<button type="button" class="password_check" data-for="passwd_confirm">확인</button>
			</div>
	       
			<div>
			    <label for="custna">고객명:</label>
                <input type="text" name="name" id="custna">
			</div>
            
            <div>
			    <label for="addr">주소:</label>
                <input type="text" name="address" id="addr">
			</div> 
            
             <div>
			    <label for="phone">전화번호:</label>
                <input type="text" name="phone" id="phone">
			</div>
			
			 <div>
                <button type="button" onclick="signup()">등록</button>
               <a href="/"><button type="button">처음으로</button></a>
			</div>
             
          </div>
      </form>
   </div>
</body>
</html>






















