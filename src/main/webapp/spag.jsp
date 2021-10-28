<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%
pageContext.setAttribute("result", "hello!");
%>
<body>
	<%=request.getAttribute("result") %>입니다.
	${requestScope.result}<br>
	${names[0]}<br>
	${notice.title}<br>
	${result}<br>
	${param.n}<br>
	${param.n > 3}<br>
	${empty param.n?"값이 비어 있습니다.":param.n}<br>
	${param.n/2}<br>
	${header.accept}
</body>
</html>