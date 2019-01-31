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
            <h2>Hangman</h2>
            <p>A game in which the object is for one player to guess the letters of an unknown word before the player who knows the word creates a stick figure of a hanged man by drawing one line for each incorrect guess</p>
            <h2>Strategy</h2>
            <p>The fact that the twelve most commonly occurring letters in the English language are e-t-a-o-i-n-s-h-r-d-l-u (from most to least), along with other letter-frequency lists, are used by the guessing player to increase the odds when it is their turn to guess. On the other hand, the same lists can be used by the puzzle setter to stump their opponent by choosing a word which deliberately avoids common letters (e.g. rhythm or zephyr) or one that contains rare letters (e.g. jazz).

                Another common strategy is to guess vowels first, as English only has five vowels (a, e, i, o, and u, while y may sometimes, but rarely, be used as a vowel) and almost every word has at least one.

                According to a 2010 study conducted by Jon McLoone for Wolfram Research, the most difficult words to guess include jazz, buzz, hajj, faff, fizz, fuzz and variations of these.</p>
        </section>
    </article>
</main>
<%@include file="../fragments/footer.jsp"%>
</body>
</html>
