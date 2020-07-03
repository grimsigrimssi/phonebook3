<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- pom.xml 설정 시 오류 사라짐-->
    
  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	<body>
		<h1>전화번호 리스트</h1>
		<p>입력한 정보 내역 입니다.</p>
		${pageContext.request.contextPath }	
		<c:forEach items="${pList}" var="vo">
		<table border="1">
			<colgroup>
				<col style ="width:120px;">
				<col style ="width:170px;">
			</colgroup>	
			<tbody>
			 	<tr>
			 	<td>이름(name)</td>
			 	<td>${vo.name}</td>
			 	</tr>
			 	<tr>
			 	<td>핸드폰(hp)</td>
			 	<td>${vo.hp}</td>
			 	</tr>
			 	<tr>
			 	<td>회사(company)</td>
			 	<td>${vo.company}</td>
			 	</tr>
			 	<td><a href="${pageContext.request.contextPath }/phone/updateForm/${vo.no }">수정</a></td>
			 	<td><a href="${pageContext.request.contextPath }/phone/delete/${vo.no }">삭제</a></td>
			 	</tr>
			 </tbody>
		</table>
		</c:forEach>
		<br>

		<p>
			<a href="${pageContext.request.contextPath }/phone/writeForm">추가번호 등록</a>
		</p>

</body>
</html>