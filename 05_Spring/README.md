
__Spring Legacy project����� ����__

- 1 pom.xml ���� <properties> ���� �ٿ� �ֱ�.
- 2 web.xml ���ϳ��� �߰� (�ѱ�ó���� ���� UTF-8����)
```
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
```
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




#### 03.DI(Dependency Injection)-1
#### 04.DI(Dependency Injection)-2
#### 05.DIȰ��
#### 06.DI���� ���
#### 07.�����ֱ�(life cycle)
#### 08.�ܺ������� �̿��� ����

#### 09.AOP-I
#### 10.AOP-II

#### 11.MVC����
#### 12.��Ʈ�ѷ�
#### 13.form ������
#### 14.@RequestMapping �Ķ����
#### 15.�� ������ �� ����

#### 16.������MVC �Խ���-1
#### 17.������MVC �Խ���-2
#### 18.������MVC �Խ���-3
#### 19.������MVC �Խ���-4
#### 20.������MVC �Խ���-5

#### 21.������JDBC

#### 22.Ʈ������(Transaction)-1
#### 23.Ʈ������(Transaction)-2
#### 24.Ʈ������(Transaction)-3

#### 25.Security-1
#### 26.Security-2
#### 27.Security-3

#### 28.Mybatis-1
#### 29.Mybatis-2
#### 30.Mybatis-3



