
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
1. src/main/ �ؿ� ���丮 resources �� �����

2. src/main/resources �ؿ� 
	���콺 ������ ���� -> new -> Spring Bean Configuration ���� -> 
		Filename :  appCTX.xml 
		���� �����.
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
	
	String config = "classpath:appCTX.xml";
	AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
	
	�� �߰��ϱ�.
	
	�׸��� bean �ȿ� ������ ��ü�� �����ٰ�  ������ �����ϱ�.
	(ex)
		Shape shape = ctx.getBean("shape", Shape.class);
		
}
```
- bean�ȿ��� ��ü�� ���� �ϸ鼭, �ʵ尪�� ���� �ϴ� ���
  (2-1), (2-2), (2-3) ����� �ϳ��� �����Ͽ� ���

- (2-1)appCTX5.xml ȭ�� �ȿ���  setter ���·� bean��ü �ʵ尪 ä���
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

- (2-2)appCTX5.xml ȭ�� �ȿ���  ������ �Ķ���� ���·�  bean��ü �ʵ尪 ä���
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


- (2-3)p���ӽ����̽� �̿��Ͽ� bean��ü�� �ʵ尪 ä���.
```xml
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
