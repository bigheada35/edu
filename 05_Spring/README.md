
__Spring Legacy project만들고 할일__

- 1 pom.xml 파일 <properties> 이하 붙여 넣기.
- 2 web.xml 파일내부 추가 (한글처리를 위한 UTF-8지정)
```
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
```
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




#### 03.DI(Dependency Injection)-1
#### 04.DI(Dependency Injection)-2
#### 05.DI활용
#### 06.DI설정 방법
#### 07.생명주기(life cycle)
#### 08.외부파일을 이용한 설정

#### 09.AOP-I
#### 10.AOP-II

#### 11.MVC기초
#### 12.컨트롤러
#### 13.form 데이터
#### 14.@RequestMapping 파라미터
#### 15.폼 데이터 값 검증

#### 16.스프링MVC 게시판-1
#### 17.스프링MVC 게시판-2
#### 18.스프링MVC 게시판-3
#### 19.스프링MVC 게시판-4
#### 20.스프링MVC 게시판-5

#### 21.스프링JDBC

#### 22.트랜젝션(Transaction)-1
#### 23.트랜젝션(Transaction)-2
#### 24.트랜젝션(Transaction)-3

#### 25.Security-1
#### 26.Security-2
#### 27.Security-3

#### 28.Mybatis-1
#### 29.Mybatis-2
#### 30.Mybatis-3



