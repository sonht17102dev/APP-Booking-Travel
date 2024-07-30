<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <jsp:forward page="/admin"/>  --%>
<% response.sendRedirect(pageContext.getServletContext().getContextPath() + "/home"); %>
</body>
</html>