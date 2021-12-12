
__01. STS ���� ������Ʈ ����� ���__
- 1)�Ұ�
```java

new -> spring legacy project -> simple spring Maven  --> �ʵ� --;
```

- 2)���̺� ������Ʈ �����
```java
new -> maven project -> new maven project -> filter �� quickstart �� �Է��ѵ� ��޸���
�Ʒ��� ����Ʈ�� ������ ��
->
  group id �� org.apache.maven.archetypes �̰�
 Artifact id�� maven-archetype-quickstart �� ����
���� -> 
     Grou Id : edu.kosmo
    Artifact Id : testHome2
    package: edu.kosmo.testHome2
```
 
- 3)Spring Bean Configuration (������ DI ���ü�) �����
```java
edu.kosmo.testHome2 -> ���콺 ������ ���� -> new -> Spring Bean Configuration ���� -> 
Filename : (ex) ctx  ->   ctx.xml ������ ������ ��.
```

- 4)���̺� ������Ʈ����  ������ ���̺귯�� ��� �����ϵ��� �ϱ�
```xml
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

- 1)App.java ȭ�� �ȿ�
```java
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
```
- (2-1), (2-2), (2-3) ����� �ϳ��� �����Ͽ� ���

- (2-1)appCTX5.xml ȭ�� �ȿ���  bean �±� ���� ������ �Ķ���� ���·� Ŭ���� �߰� �ϱ�
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

- (2-2)appCTX5.xml ȭ�� �ȿ���  bean �±�  ���� setter ���·� Ŭ���� �߰� �ϱ�
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
- (2-3)p���ӽ����̽� �̿��Ͽ� Ŭ���� �߰� �ϱ�
```
(1)
spring bean configuration ���� ( appCTX5.xml ) �� ���� �Ʒ���
source ���� namespace ������ ���� ����

(2) p - http://www.springframework.org/schema/p  �κ��� üũ

(3) source ������ ���ƿ�
	appCTX5.xml�� �ҽ��� ��ܿ�
		xmlns:p="http://www.springframework.org/schema/p"
	�� �߰��Ǿ� ����.
	
 (4) appCTX5.xml�� �ҽ�����,
 
	<bean id="rec" class="edu.kosmo.testHome.Rectangle" p:width="10" p:height="10"/>
	<bean id="try" class="edu.kosmo.testHome.Triangle" p:width="20" p:height="20"/>
	
	�̷��� ���
```	
