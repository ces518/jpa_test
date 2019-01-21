<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mayeye
  Date: 2019-01-21
  Time: 오후 5:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BOARD</title>
</head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
    var board = {
        init : function(){
            $('.add').on('click',function(){

            });
        }
    };
</script>
<body>
<a href="${pageContext.request.contextPath}/board/form">등록</a>
<table style="border:1px solid black;">
    <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
        </tr>
    </thead>
    <tbody>
    총게시물 :  ${page.totalElements}
                              <%--전체개수                 현재페이지          페이지당 게시물수--%>
    <c:set var="number" value="${page.totalElements - ((page.number) * page.size)}"/>
    <c:forEach items="${page.content}" var="result">
    <%--<c:forEach items="${list}" var="result">--%>
        <tr>
            <td>${number}</td>
            <td><c:out value="${result.title}"/></td>
        </tr>
        <c:set var="number" value="${number - 1}"/>
    </c:forEach>
    </tbody>
    <c:if test="${empty page}">
        <tr>
            <td>데이터가없습니다.</td>
        </tr>
    </c:if>
</table>

</body>
</html>
