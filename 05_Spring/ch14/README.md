__Spring Legacy project ����� ����__

- 1 pom.xml ����  <properties> ���� �ٿ� �ֱ�.

		[pom.xml](pom.xml)

- 2 web.xml ���ϳ��� �߰� (�ѱ�ó���� ���� UTF-8����)
```xml
<!-- �ѱ�ó�� �� ���� UTF-8 ������ �ִ� ���ε�, �⺻������ �־�� �Ѵ�. -->

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

- 5 home.jsp �Ǵ� �ٸ�  jsp���� ��ܿ� �ֱ�
```java
<!-- �̰� �ٿ� �ֱ� �ѱ� �ѱ� �ѱ� -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- �̰� �ϳ� �־� �ֱ� -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%-- ������ �̰� <%@ page session="false" %> --%>

<!-- �̰� �ٿ� �ֱ� �ѱ� �ѱ� �ѱ� -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

```