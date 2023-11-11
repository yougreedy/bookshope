<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../header.jsp"></jsp:include><!-- 소스베이스 경로임 -->
<title>Insert title here</title>
</head>
<body>
   <div>
      <div>
          <h1>도서등록</h1>
      </div>
      
      <form method="post">
         <div>
	          <div>
				<label>도서번호:</label>
				<input type="number" name="bookid">
			  </div>
			
			   <div>
				 <label>도서명:</label>
				 <input type="text" name="bookname">
			   </div>
				
				<div>
				  <label>출판사:</label>
				   <input type="text" name="publisher">
				</div>
				
				<div>
				   <label>가격:</label>
				   <input type="number" name="price">
				</div>
				
				<div>
				   <button>등록</button>
				   <a href="list"><button type="button">목록</button></a>
				</div>
         </div>
      </form>
   </div>
</body>
</html>