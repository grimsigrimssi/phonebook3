<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		전화번호를 수정하려면<br>
		수정하고 "수정" 버튼을 클릭하세요.
	</p>
	 	<form action="/phonebook3/phone/update" method="get">
		이름(name): <input type="text" name="name" value="${vo.name}"> <br>
		핸드폰(hp): <input type="text" name="hp" value="${vo.hp}"> <br>
		회사(company): <input type="text" name="company" value="${vo.company}"> <br>	
		<button type="submit">수정</button>
		</form>
		
		<p>
		<a href="/phonebook3/phone/list">리스트 바로가기</a>
		</p>
</body>
</html>