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
<%@include file="fragments/head.jsp" %>

<body>

<main>
    <article>
        <div id="span">
            <h1>Hangman Game</h1>
            <c:if test="${sessionScope.user==null}">
                <h5><a href="views/login.jsp"> Sign in </a></h5>
                <h5><a href="views/register.jsp"> Sign up </a></h5>
            </c:if>
            <c:if test="${sessionScope.user!=null}">
                <h5><a href="home.html"> Home Page </a></h5>
            </c:if>

        </div>
    </article>
</main>
</body>
</html>
