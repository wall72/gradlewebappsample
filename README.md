# GradleWebAppSample
Gradle Web Application Sample

###1. Gradle Project 생성

###2. sample > Java Quickstart

###3. eclipse wtp 프로젝트 변환
####; build.gradle 수정

```{.no-highlight}
apply plugin: ‘war'
apply plugin: ‘eclipse-wtp'
...
eclipse {
    wtp {
        component {
            contextPath = project.name // 원하는 contextPath 지정. 단, 빈 컨텍스트패스는 '/' 로 지정
        }
        facet {
            facet name: 'jst.web', version: '2.5' // Servlet Spec Version 지정
            facet name: 'jst.java', version: '1.8' // Java Version 지정, 1.7 ...
        }
    }
}
```

####; Gradle build… > ‘eclipse'

###4. Project Dependency 추가
####; build.gradle

```{.no-highlight}
compile "joda-time:joda-time:2.4"
compile "javax.servlet:servlet-api:2.5"
```

####; Gradle > Refresh All

###5. web 폴더 및 소스 추가
####; src/main/webapp > index.jsp

```{.jsp}
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="daystogo" class="org.gradle.DateUtils"/>
<html>
<p><%=daystogo.daysToNewYear()%> days to go this year. Learn Gradle now!</p>
</html>
```

####; src/main/webapp/WEB-INF > web.xml

```{.xml}
<?xml version="1.0" encoding="utf-8"?>
<web-app 
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns="http://java.sun.com/xml/ns/javaee" 
	xmlns:web="http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
	                    http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
	version="2.5">
	<servlet>
		<servlet-name>SampleServlet</servlet-name>
		<servlet-class>org.gradle.SampleServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>SampleServlet</servlet-name>
		<url-pattern>/sampleservlet</url-pattern>
	</servlet-mapping>
	<welcome-file-list>
		<welcome-file>index.jsp</welcome-file>
	</welcome-file-list>
</web-app>
```

###6. servlet 및 POJO 소스 추가

####; SampleServlet 추가

```{.java}
package org.gradle;

import java.io.IOException;

import javax.servlet.http.*;

public class SampleServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println(new DateUtils().daysToNewYear() + " to go in 2014. Learn Gradle now!");
	}
}
```

####; DateUtil 추가

```{.java}
package org.gradle;

import org.joda.time.Days;
import org.joda.time.LocalDate;

public class DateUtils {

	public int daysToNewYear() {
		LocalDate fromDate = new LocalDate();
		LocalDate newYear = fromDate.plusYears(1).withDayOfYear(1);
		return Days.daysBetween(fromDate, newYear).getDays();
	}
}
```

###7. Gradle Assemble
####; Gradle build… > assemble
####; war 생성 확인

###8. Local Server 기동 확인
####; 서버 추가
####; Add > 프로젝트 추가
####; 접속 테스트
