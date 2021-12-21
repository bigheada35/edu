__Spring Legacy project 만들고 할일__

- 1 pom.xml 파일  <properties> 이하 붙여 넣기.

		[pom.xml](pom.xml)

- 2 web.xml 파일내부 추가 (한글처리를 위한 UTF-8지정)
```xml
<!-- 한글처리 를 위한 UTF-8 지정해 주는 것인데, 기본적으로 넣어야 한다. -->

 	<filter>
          <filter-name>encodingFilter</filter-name>
          <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
          <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
          </init-param>
    </filter>
     
    <filter-mapping>
          <filter-name>encodingFilter</filter-name>
          <url-pattern>/*</url-pattern>
    </filter-mapping>
```
- 3 servlet-control.xml

- 4 root-context.xml

- 5 home.jsp 또는 다른  jsp파일 상단에 넣기
```java
<!-- 이거 붙여 넣기 한글 한글 한글 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 이거 하나 넣어 주기 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%-- 지우자 이거 <%@ page session="false" %> --%>

<!-- 이거 붙여 넣기 한글 한글 한글 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

```