<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="smt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title herhttp://localhost:9005/jspCript3/join/familymemberjoin.doe</title>
</head>
<body>
<h3>index.jsp</h3>
<hr />

<c:if test="${empty uid }" >
<a href="login/familymemberlogin.do">login</a>  | 
</c:if>

<c:if test="${not empty uid }">
<a href="login/familymemberlogoutproc.do">logout</a> | 
</c:if>

<a href="join/familymemberjoin.do">join</a>
<hr />
</body>
</html>