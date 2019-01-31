<%--
  Created by IntelliJ IDEA.
  User: Mateusz
  Date: 10.11.2018
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<%@include file="../fragments/head.jsp" %>
<%@include file="../fragments/header.jsp"%>

<main>
    <article>
        <section>
            <div id="gameContainer">
                <div id="gameLanguage">
                    <form>
                        <select id="language">
                            <option>PL</option>
                            <option>EN</option>
                        </select>
                    </form>
                </div>
                <div id="gameReset"></div>
                <div id="gameBoard"></div>
                <div id="gameGibbet"><img src="../resources/images/game/s0.png" alt="" /></div>
                <div id="gameAlphabet"></div>
                <div style="clear:both;"></div>
            </div>
            <div class="fl_right" id="passScore"></div>

        </section>
    </article>
</main>
<script type="text/javascript" src="../resources/js/hangman.js"></script>
<%@include file="../fragments/footer.jsp" %>
</body>
</html>