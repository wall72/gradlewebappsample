<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="daystogo" class="org.gradle.DateUtils"/>
<html>
<p><%=daystogo.daysToNewYear()%> days to go this year. Learn Gradle now!</p>
</html>