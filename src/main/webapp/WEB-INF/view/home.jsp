<%-- 
    Document   : home
    Created on : 16 Δεκ 2019, 10:49:09 πμ
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>My first Spring Security App</h1>
        <p>
            User: <security:authentication property="principal.username"/>
            <br/>
            Role(s): <security:authentication property="principal.authorities"/>
        </p>
        <hr>
        <security:authorize access="hasRole('ADMIN')">
        <a href="${pageContext.request.contextPath}/admin">Admin Page</a>
         </security:authorize>
        
        <br/>
        <security:authorize access="hasAnyRole('USER', 'ADMIN')">
        <a href="${pageContext.request.contextPath}/user">User Page</a>
        </security:authorize>
        <br/>
        <br/>
       <form:form action="${pageContext.request.contextPath}/logout" method="POST">
           <input type="submit" value="Logout">
       </form:form>
    </body>
</html>
