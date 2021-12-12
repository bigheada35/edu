
__01. STS 에서 프로젝트 만들기 방법__
- 1)불가
```java

new -> spring legacy project -> simple spring Maven  --> 않됨 --;
```

- 2)메이븐 프로젝트 만들기
```java
new -> maven project -> new maven project -> filter 에 quickstart 을 입력하여 기달리면
아래에 리스트가 생성이 됨
->
  group id 가 org.apache.maven.archetypes 이고
 Artifact id가 maven-archetype-quickstart 인 것을
선택 -> 
     Grou Id : edu.kosmo
    Artifact Id : testHome2
    package: edu.kosmo.testHome2
```
 
- 3)Spring Bean Configuration (스프링 DI 지시서) 만들기
```java
edu.kosmo.testHome2 -> 마우스 오른쪽 버턴 -> new -> Spring Bean Configuration 파일 -> 
Filename : (ex) ctx  ->   ctx.xml 파일이 생성이 됨.
```

- 4)메이븐 프로젝트에서  스프링 라이브러리 사용 가능하도록 하기
```java
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
	ApplicationContext context = new ClassPathXmlApplicationContext("edu/kosmo/testHome/appCTX5.xml");
	Rectangle rec = context.getBean(Rectangle.class);
	Triangle tri = context.getBean(Triangle.class);
	를 사용하기.
}
```

- 2)appCTX5.xml 화일 안에서  bean 태그 통해 생성자 파라메터 형태로 클래스 추가 하기
```java
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

- 3)appCTX5.xml 화일 안에서  bean 태그  통해 setter 형태로 클래스 추가 하기
```java

<!--    Rectangle rec = new Rectangle();
		rec.setWidth(10);
		rec.setHieght(10);
        Triangle tri = new Triangle();
		tri.setWidth(20);
		tri.setHeight(20);
 -->
 
  	<bean id="rec" class="edu.kosmo.testHome.Rectangle">
 		<property name="width" value="10"/>
 		<property name="height" value="10"/>
 	</bean>
 	<bean id="try" class="edu.kosmo.testHome.Triangle">
 		<property name="width" value="20"/>
 		<property name="height" value="20"/>
 	</bean>
	
```