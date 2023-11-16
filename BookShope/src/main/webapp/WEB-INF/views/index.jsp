<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header.jsp"></jsp:include><!-- 소스베이스 경로임 -->
<title>서점관리엽습</title>
</head>
<body>
   <div>
      <div>
          <h1>마당서점</h1>
      </div>
      <div>
         <a href="login">로그인</a>
         <a href="signup">회원가입</a>
      </div>
      <div>
         <a href="logout">로그아웃</a>
      </div>
      <div>
         <ul>
            <li><a href="book/list">도서관리</a></li>
            <li><a href="customer/list">고객관리</a></li>
         </ul>
      </div>
   </div>
   
   
   
</body>
</html>