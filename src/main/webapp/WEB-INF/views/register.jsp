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
    <title>Add user</title>
    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
  </head>
  <body>
  <%@include file="header.jsp"%>
    <section class="login-page">
      <h2>Załóż konto</h2>
      <form:form action="" modelAttribute="user" method="post">
        <div class="form-group">
          <form:input path="name" placeholder="Imię" name="name"/>
          <form:errors path="name" cssStyle="color: red; font-size: 12px" element="div" />
        </div>
        <div class="form-group">
          <form:input path="email" placeholder="E-mail" name="email"/>
          <form:errors path="email" cssStyle="color: red; font-size: 12px" element="div" />
        </div>
        <div class="form-group">
      <form:input path="password" placeholder="Hasło" name="password"/>
        </div>
        <div class="form-group">
      <form:input path="password2" placeholder="Powtórz hasło" name="password2"/>
        </div>

        <div class="form-group form-group--buttons">
          <a href="login.html" class="btn btn--without-border">Zaloguj się</a>
          <button class="btn" type="submit">Załóż konto</button>
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </div>
      </form:form>
    </section>
    <%@include file="footer.jsp"%>
  </body>
  <script src="<c:url value="resources/js/form.js"/>"></script>
</html>
