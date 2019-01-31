<%--
  Created by IntelliJ IDEA.
  User: Mateusz
  Date: 10.11.2018
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<%@include file="../fragments/head.jsp" %>
<%@include file="../fragments/header.jsp"%>

<main>
    <article>
        <div id="span">
            <table border="1" cellpadding="10">
                <tr>
                    <td>User name</td>
                    <td>Score</td>
                </tr>
                <c:forEach items="${mapUser}" var="entry">
                    <tr>
                        <td>${entry.key}</td>
                        <td>${entry.value}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </article>
</main>

<%@include file="../fragments/footer.jsp" %>
</body>
</html>

