<%--
  Created by IntelliJ IDEA.
  User: mayeye
  Date: 2019-01-21
  Time: 오후 5:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form id="frm" action="${pageContext.request.contextPath}/board" method="post">
        <label>제목</label> <input type="text" name="title"/>
        <label>내용</label> <input type="text" name="content"/>
        <input type="submit" value="등록"/>
    </form>
</body>
</html>
