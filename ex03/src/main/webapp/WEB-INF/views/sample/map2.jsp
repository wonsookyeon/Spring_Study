<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Map Test</h1>
	<h3>${map}</h3>
	<h2>${map.name}</h2>
	<h2>${map.age}</h2>
	<h2>${map.address}</h2>
	
	<h1>Map2 Test</h1>
	<h3>${map2}</h3>
	<h2>이름 : ${map2.a1.name}</h2>
	<h2>나이 : ${map2.a1.age}</h2>
	<h2>주소 : ${map2.a1.address}</h2>
	<h2>${map2.a2}</h2>
	<h2>${map2.a3}</h2>

</body>
</html>