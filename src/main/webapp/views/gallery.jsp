<%--
  Created by IntelliJ IDEA.
  User: Mateusz
  Date: 10.11.2018
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body onload="gallery()">
<%@include file="../fragments/head.jsp" %>
<%@include file="../fragments/header.jsp" %>

<main>
    <article>
        <div id="slider">gallery</div>
        <div id="span">
            <span onclick="choosePhoto(1)" style="cursor: pointer">[1]</span>
            <span onclick="choosePhoto(2)" style="cursor: pointer">[2]</span>
            <span onclick="choosePhoto(3)" style="cursor: pointer">[3]</span>
            <span onclick="choosePhoto(4)" style="cursor: pointer">[4]</span>
            <span onclick="choosePhoto(5)" style="cursor: pointer">[5]</span>
            <span onclick="choosePhoto(5)" style="cursor: pointer">[6]</span>
        </div>
    </article>
</main>
<script type="text/javascript" src="../resources/js/gallery.js"></script>
<%@include file="../fragments/footer.jsp" %>
</body>
</html>