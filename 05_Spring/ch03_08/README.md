
__01. STS 에서 프로젝트 만들기 방법__
- 1)불가
```java

new -> spring legacy project -> simple spring Maven  --> 않됨 --;
```

- 2)메이븐 프로젝트 만들기
```java
new -> maven project -> new maven project -> filter 에 quickstart 을 입력한뒤 기달리면
아래에 리스트가 생성이 됨
->
  group id 가 org.apache.maven.archetypes 이고
 Artifact id가 maven-archetype-quickstart 인 것을
선택 -> 
     Grou Id : edu.kosmo
	 Artifact Id : shape
    package: edu.kosmo.shape
```
 
- 3)Spring Bean Configuration (스프링 DI 지시서) 만들기
```java
1. src/main/ 밑에 디렉토리 resources 를 만들기

2. src/main/resources 밑에 
	마우스 오른쪽 버턴 -> new -> Spring Bean Configuration 파일 -> 
		Filename :  appCTX.xml 
		파일 만들기.
```

- 4)메이븐 프로젝트에서  스프링 라이브러리 사용 가능하도록 하기
```xml
pom.xml 파일 안의
<dependencies>
</dependencies>
사이에,
	
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-context</artifactId>
		<version>5.3.13</version>
	</dependency>
	
을 추가하기.

```

__02. STS 에서 프로젝트 에서, Spring 사용하기.__

- 1)App.java 화일 안에
```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

넣고,
public static void main( String[] args )
{
	안에,
	
	String config = "classpath:appCTX.xml";
	AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
	
	를 추가하기.
	
	그리고 bean 안에 생성된 객체를 가져다가  변수에 대입하기.
	(ex)
		Shape shape = ctx.getBean("shape", Shape.class);
		
}
```
- bean안에서 객체를 생성 하면서, 필드값을 전달 하는 방법
  (2-1), (2-2), (2-3) 방법중 하나를 선택하여 사용

- (2-1)appCTX5.xml 화일 안에서  setter 형태로 bean객체 필드값 채우기
```java

  	<bean id="rec" class="edu.kosmo.testHome.Rectangle">
 		<property name="width" value="10"/>
 		<property name="height" value="10"/>
 	</bean>
 	<bean id="try" class="edu.kosmo.testHome.Triangle">
 		<property name="width" value="20"/>
 		<property name="height" value="20"/>
 	</bean>
	
```

- (2-2)appCTX5.xml 화일 안에서  생성자 파라메터 형태로  bean객체 필드값 채우기
```xml
<!--    Rectangle rec = new Rectangle(10,10);
        Triangle tri = new Triangle(10,10);
 -->
 
 	<bean id="rec" class="edu.kosmo.testHome.Rectangle">
 		<constructor-arg name="width" value="10"/>
 		<constructor-arg name="height" value="10"/>
 	</bean>
 	<bean id="try" class="edu.kosmo.testHome.Triangle">
 		<constructor-arg name="width" value="20"/>
 		<constructor-arg name="height" value="20"/>
 	</bean>
```


- (2-3)p네임스페이스 이용하여 bean객체의 필드값 채우기.
```xml
(1)
spring bean configuration 파일 ( appCTX5.xml ) 의 왼쪽 아래에
source 탭을 namespace 탭으로 선택 변경

(2) p - http://www.springframework.org/schema/p  부분을 체크

(3) source 탭으로 돌아옴
	appCTX5.xml의 소스의 상단에
		xmlns:p="http://www.springframework.org/schema/p"
	가 추가되어 있음.
	
 (4) appCTX5.xml의 소스에서,
 
	<bean id="rec" class="edu.kosmo.testHome.Rectangle" p:width="10" p:height="10"/>
	<bean id="try" class="edu.kosmo.testHome.Triangle" p:width="20" p:height="20"/>
	
	이렇게 사용
```	
