<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Add new user</title>
    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
  </head>
  <body>
  <header class="">
    <nav class="container container--70">
      <ul class="nav--actions">
        <li><a href="<c:url value="/login"/>" class="btn btn--small btn--without-border">Zaloguj</a></li>
        <li><a href="<c:url value="/adduser"/>" class="btn btn--small btn--highlighted">Załóż konto</a></li>
      </ul>

      <ul>
        <li><a href="<c:url value="/#"/>" class="btn btn--without-border active">Start</a></li>
        <li><a href="<c:url value="/adddonation"/>" class="btn btn--without-border">O co chodzi?</a></li>
        <li><a href="#" class="btn btn--without-border">O nas</a></li>
        <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
        <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
      </ul>
    </nav>
    <section class="login-page">
      <h2>Załóż konto</h2>
      <form:form action="" modelAttribute="user" method="post">
        <div class="form-group">
          <form:input path="name" placeholder="Imię" name="name"/>
          <form:errors path="name" cssStyle="color: red; font-size: 12px" element="div" />
        </div>
        <div class="form-group">
          <form:input path="lastName" placeholder="Nazwisko" />
          <form:errors path="lastName" cssStyle="color: red; font-size: 12px" element="div" />
        </div>
        <spring:bind path="email">
        <div class="form-group">
          <form:input path="email" type="email" placeholder="E-mail" name="email"/>
          <form:errors path="email" cssStyle="color: red; font-size: 12px" element="div" />
        </div>
        </spring:bind>
        <spring:bind path="password">
        <div class="form-group">
          <form:input type="password" path="password" placeholder="Hasło" name="password"/>
          <form:errors path="password" cssStyle="color: red; font-size: 12px" element="div" />
        </div>
        </spring:bind>
        <div class="form-group">
          <form:input type="password" path="password2" placeholder="Powtórz hasło" name="password2"/>
          <form:errors path="password2" cssStyle="color: red; font-size: 12px" element="div" />
        </div>

        <div class="form-group form-group--buttons">
          <a href="login.html" class="btn btn--without-border">Zaloguj się</a>
          <button class="btn" type="submit">Załóż konto</button>
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </div>
      </form:form>
    </section>
  </header>
    <%@include file="footer.jsp"%>
  </body>
  <script src="<c:url value="resources/js/form.js"/>"></script>
</html>
