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
<title>Insert title here</title>
</head>
<body>
<h3>joinform.jsp</h3>
<form action="familymemberjoinproc.do" method="post">
fname : <input type="text" name="fname" /> <br />
fpass : <input type="text" name="fpass" /> <br />
tel : <input type="text" name="tel" /> <br />
addr : <input type="text" name="addr" /> <br />

<input type="submit" value="send" />

</form>

</body>
</html>