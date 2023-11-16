<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header.jsp"></jsp:include><!-- 소스베이스 경로임 -->
<script>
  const msg = "${msg}"; /* ""없으면 안됨 */ 
  
  if(msg) alert(msg);
</script>
<title>서점관리엽습</title>
</head>
<body>
   <div>
      <div>
          <h1>마당서점</h1>
      </div>
     <!-- 
      sessionScope는 세션 범위에 속하는 변수를 참조하기 위해 사용됩니다. 
      세션은 일반적으로 로그인 정보나 사용자의 상태와 같이 여러 페이지에 걸쳐 유지해야 하는 정보를 저장하는 데 사용됩니다.
      따라서 세션 범위의 변수는 한 번 설정되면 여러 페이지에서 공유되며, 해당 세션이 유지되는 동안 계속 사용할 수 있습니다.
      --> 
      <c:if test="${sessionScope.member == null}">
	      <div>
	         <a href="login">로그인</a>
	         <a href="signup">회원가입</a>
	      </div>
      </c:if>
      <c:if test="${sessionScope.member != null}">
<%--           <p>환영합니다, ${loginName}님!</p> --%>
          <div>
             ${sessionScope.member.name} 님 환영합니다.!             
          </div>
	      <div>
	         <a href="logout">로그아웃</a>
	      </div>
      </c:if>
      <div>
         <ul>
            <li><a href="book/list">도서관리</a></li>
            <li><a href="customer/list">고객관리</a></li>
         </ul>
      </div>
   </div>
   
   
   
</body>
</html>