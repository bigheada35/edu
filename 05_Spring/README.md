
__01. STS ���� ������Ʈ ����� ���__

```java
1) �Ұ�
new -> spring legacy project -> simple spring Maven  --> �ʵ� --;

2) ���̺� ������Ʈ �����
new -> maven project -> new maven project -> filter : quickstart
  group id �� org.apache.maven.archetypes �̰�
 Artifact id�� maven-archetype-quickstart �� ����
���� -> 
     Grou Id : edu.kosmo
    Artifact Id : testHome2
    package: edu.kosmo.testHome2

 
3) Spring Bean Configuration (������ DI ���ü�) �����
edu.kosmo.testHome2 -> ���콺 ������ ���� -> new -> Spring Bean Configuration ���� -> 
Filename : (ex) ctx  ->   ctx.xml ������ ������ ��.


4) ���̺� ������Ʈ����  ������ ���̺귯�� ��� �����ϵ��� �ϱ�
pom.xml ���� ����
<dependencies>
</dependencies>
���̿�,
	
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-context</artifactId>
		<version>5.3.13</version>
	</dependency>
	
�� �߰��ϱ�.

```

__02. STS ���� ������Ʈ ����, Spring ����ϱ�.__
```java
1)
App.java ȭ�� �ȿ�

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

�ְ�,
public static void main( String[] args )
{
	�ȿ�,
	ApplicationContext context = new ClassPathXmlApplicationContext("edu/kosmo/testHome/appCTX5.xml");
	Rectangle rec = context.getBean(Rectangle.class);
	Triangle tri = context.getBean(Triangle.class);
	�� ����ϱ�.
}

2)appCTX5.xml ȭ�� �ȿ���  <bean></bean>���� Ŭ���� �߰� �ϱ�

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