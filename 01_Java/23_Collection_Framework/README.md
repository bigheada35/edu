### �ؽ� = �з�(�ӵ� ������ �ҷ���)  = ���� = ����
### �ؽ� �˰����� = �з� �˰�����

### �ؽ� �˰������� ����
	�з���� : 
				3, 5, 7, 12, 25, 31
				
	�˰������� ����			
	�з��� �Ѵ�. 	
				ex: num % 3
	
	�з��� �� ������ Ž���� �ӵ��� �ſ� ��������.	


ex. �ؽ��±�
	#��۳�,  #����, #���������	#�ڹ�

### hashCode(), equals()�� ����/�� ����ϴ���?  ---> Set�� add()�� �Ҷ�, ���� ���� �Ǵܿ�
	hashCode() : �ӵ��� ���� �з� �˰����� --> ������ �����.
	equals() :  ���� ���� �Ǵ�

### HashCode()�� ȣ�� �ϴ� �� ---> Set����  add  �Ҷ� (�ӵ��� ���� �з� �˰�����)
	hashCode() :  �ӵ��� ���� �з� �˰����� �ϻ��̰�, ������ �������� �Ǵ������� �ʴ´�.
	equals() :  ���������� �Ǵ��Ѵ�.

### hashCode()�� �������̵� ���� ������ ?  --->  Set���� Object���� ȣ���Ѵ�.


### public native int hashCode();
	native�� �ǹ�?

#### Object�� hashCode�� ����Ѵٴ� �ǹ�? : 
	-->  ������ ��ü�� ���鶧���� 1���� �д�.
	
#### Override�� hashCode����  return num % 3 �� �ǹ�? : 
	-->  ������ 3���� �����. 
	
### Set�� ���� �ߺ�X, ����x �ε�, TreeSet<E> �� ������ �ȴ�. 