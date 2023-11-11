<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 관리</title>
<jsp:include page="../header.jsp"></jsp:include><!-- 소스베이스 경로임 -->
</head>
<body>
      <div class="container">
         <div>
            <h1>도서목록</h1>
         </div>
         <div>
            <form>
                 <div class="row mb-2">
                 <div class="col-6"></div>
                    <div class="col">
                       <select name="search" class="form-select form-select-sm">
                           <option value="0">검색 항목을 선택하세요</option>
                           <option value="1" ${pager.search == 1 ? "selected" : ""}>도서번호</option>
                           <option value="2" ${pager.search == 2 ? "selected" : ""}>도서명</option>
                           <option value="3" ${pager.search == 3 ? "selected" : ""}>출판사</option>
                       </select>
                    </div>
                    <div class="col">
                        <input type="text" name="keyword" class="form-control form-contorl-sm" value="${pager.keyword}">                    
                    </div>
                    <div class="col-1 d-grid">
                        <button class="btn btn-sm btn-primary">검색</button>
                    </div>
                 </div>
            </form>
         </div>

       <div>
	     <table border="1" class = "table table-striped table-hover">
	        <thead class = "table-dark">
	            <tr>
	               <th>도서번호</th>
	               <th>도서명</th>
	               <th>출판사</th>
	               <th>가격</th>
	               <th>관리</th>
	            </tr>
	        </thead>
	        
	        <tbody>
	           <c:forEach var="item" items="${list}">
	               <tr>
	                  <td>${item.bookid}</td>
	                  <td>${item.bookname}</td>
	                  <td>${item.publisher}</td>
	                  <td>${item.price}</td>
	                 <td><a href="delete/${item.bookid}" class="btn btn-danger btn-sm"><i class="bi bi-trash"></i></a> <a href="update/${item.bookid}" class="btn btn-warning btn-sm"><i class="bi bi-wrench-adjustable"></i></a></td>
	               </tr>
	           </c:forEach>
	           <c:if test="${list.size() < 1}">
	               <tr>
	                  <td colspan="5"> 검색 된 도서가 업습니다.</td>
	               </tr> 
	           </c:if>
	        </tbody>
	        
	        	<tfoot>
					<tr>
						<td colspan = "5">
							<ul class="pagination justify-content-center mt-3">
							   	<li class="page-item"><a class="page-link" href="?page=1${pager.query}">처음</a></li>
							   	<li class="page-item"><a class="page-link" href="?page=${pager.prev}${pager.query}">이전</a></li>
								  	<c:forEach var="page" items="${pager.list}">
									  <li class="page-item"><a class="page-link ${page == pager.page ? 'active' : ''}" href="?page=${page}&offset=${pager.offset}">${page}</a></li>
								    </c:forEach>
							   	<li class="page-item"><a class="page-link" href="?page=${pager.next}${pager.query}">다음</a></li>
							   	<li class="page-item"><a class="page-link" href="?page=${pager.last}${pager.query}">마지막</a></li>
							</ul>
						</td> 
					</tr>
				</tfoot>
	        
	     </table> 
     </div>
     <div class = "md-5">
          <a href="add" class="btn btn-primary btn-sm">등록</a>
          <a href="dummy" class="btn btn-warning btn-sm">대량등록</a>
          <a href="init" class="btn btn-danger btn-sm">초기화</a>
          <a href=".." class="btn btn-secondary">이전</a>
     </div>
   </div>  
</body>
</html>


