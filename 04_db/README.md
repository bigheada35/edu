
__04. SQL*PLUS ��ɾ��� ����__
	
__05. Ư�� ���ڵ� ���� �� SQL�Լ� �����ϱ�__
```
- select/from/where ��
- ���/��/�� ������
- between and ������
- in
- like ������ �� ���ϵ� ī��
	%
	_
	ESCAPE �ɼ�				
- null�� ���� ������	
- ������ ���� order by��
- distinct/��Ī/���� ������
- ���� ������
	"||" ������
```
__06. SQL ������ �Լ� - ���� �Լ� ���� �Լ�__
```sql
1) �Լ��� ���� �� DUAL ���̺�
2) ���� �Լ�
	abs
		���밪�� 
	floor
		�Ҽ��� �Ʒ��� ������ �Լ�
	round
		Ư�� �ڸ������� �ݿø�
	trunc
		Ư�� �ڸ������� �߶�
	mod
		������ ������ �� �� �������� ����� �ǵ����ִ� �Լ�
3) ���� ó�� �Լ�
	upper
	lower
	initcap
		�̴ϼȸ� �빮�ڷ�
	length
		���� ���̸� ����
	lengthb
		����Ʈ ��
	instr
		Ư�� ������ ��ġ�� ����
	substr
		��� ���ڿ��̳� �÷��� �ڷῡ�� ���� ��ġ���� ���� ������ŭ�� ���ڸ� ����
		ex:
		�ε��� 4���� �����ؼ� ���� 3���� ����
		select substr ('welcome to oracle', 4, 3) from dual;
		
		ex:
		9���� �Ի��� ����� ���
		select ename, 19||substr(hiredate, 1, 2)�⵵, substr(hiredate, 4, 2)�� from emp where substr(hiredate, 4, 2) = '09';
```
__07. SQL ������ �Լ� - ��¥�Լ�/�� ��ȯ�Լ�/�Ϲ��Լ�__
```sql
1) ��¥ �Լ�
sysdate
	�ý��ۿ��� ���� ��¥�� �о� �ͼ� ���
	select sysdate from dual;
	
months_between	
	�� �������� �ٹ��� ���� ��
	select ename, sysdate, hiredate, months_between(sysdate, hiredate) �ٹ������� from emp;
	
add_months
	�Ի� ��¥���� 4������ �߰��� �����
	select ename, hiredate, add_months(hiredate, 4) from emp;
	
2) �� ��ȯ �Լ�(������, ������, ��¥��)

to_char
	���� ��¥�� ���������� ��ȯ�Ͽ� ���
	select sysdate, to_char(sysdate, 'yyyy-mm-dd') from dual;

	 ���� ��¥�� �ð��� ���
	select to_char(sysdate, 'yyyy/mm/dd, hh24:mi:ss') from dual;
	
to_date
	�������� ��¥������ ��ȯ
	
	1981�� 2�� 20�Ͽ� �Ի��� ����� �˻�
	select ename, hiredate from emp where hiredate=to_date(19810220, 'yyyymmdd');
	
3) NULL�� �ٸ� ������ ��ȯ�ϴ� NVL�Լ�
nvl
	NULL�� 0 �Ǵ� �ٸ� ������ ��ȯ
	
	select ename, sal, comm, job from emp order by job;
	
	���� ���
	select ename, sal, comm, sal12+comm, nvl(comm, 0), sal12+nvl(comm, 0) from emp order by job
	
4) ������ ���� DECODE �Լ�
	�������� ��쿡 ���ؼ� ������ �� �ֵ��� �ϴ� ����� ����
	
	����� �μ� ��ȣ�� �̸����� ����
	select deptno, decode(deptno, 10, 'a', 20, 'b', 'default') from emp order by deptno;

5) ���ǿ� ���� ���� �ٸ� ó���� ������ CASE �Լ�

```

__08. SQL ������ �Լ� - �׷� �Լ�__
```sql
1) �׷� �Լ�
	�ϳ� �̻��� ���� �׷����� ���� �����Ͽ�, �ϳ��� ����� ��Ÿ
	
sum
	�׷� �Լ��� �̿��ؼ� ����� �� �޿�
	 select sum(sal) from emp;
	 �׷��Լ��� ����� ����� �� 14���ε��� ����� �ϳ��� ������ ���
	 
	 Ŀ�̼�(COMM) �Ѿ�
	  select sum(comm) from emp;
	  
avg
	�ش� �÷� ���� ���� ���
	�޿� ����� ����
	select avg(sal) from emp;
	

max : ������ �÷� �� �߿��� �ִ밪
	
	���� ���� �޿��� ���� ���� �޿�
	select max(sal), min(sal) from emp;
	
count
	���̺��� ������ �����ϴ� ���� ����
	��� ���̺��� ����� �߿��� Ŀ�̼�(COMM)�� ���� ����� ��
	select count(comm) from emp;
	
2) group by ��
	��� ���̺��� �μ� ��ȣ�� �׷� ����
	select deptno from emp group by deptno;
	
	�Ҽ� �μ��� ��� �޿�
	select avg(sal) from emp group by deptno;
	
	�Ҽ� �μ��� �޿� �Ѿװ� ��� �޿�
	select deptno, sum(sal), avg(sal) from emp group by deptno;
	
3) having ��
	group by ���� ���� ������ ��� �� �� ���ϴ� ���ǿ� �����ϴ� �ڷḸ ������ �� ��
	
	�׷� ������ �μ��� ��� �޿��� 2000 �̻��� �μ��� ��ȣ�� �μ��� ��� �޿��� ���
	select deptno, avg(sal) from emp group by deptno having avg(sal) >= 2000;
	
	�μ��� �ִ밪�� �ּҰ��� ���ϵ�, �ִ� �޿��� 2900 �̻��� �μ��� ���
	 select deptno, max(sal), min(sal) from emp group by deptno having max(sal) >= 2900; 
```
__09. SQL ��� �Լ��� ���� ����Ʈ �����__

__10. ����__

__11. ���� ����__

__12. ���̺� ���� ����, ���� �����ϴ� DDL__

__13. ���̺��� ������ �߰�, ����, �����ϴ� DML__

__14. Ʈ������ ����__

__15. ������ ���Ἲ�� ���� ���� ���� - 1__

__16. ������ ���Ἲ�� ���� ���� ���� - 2__

__17. ���� ���̺��� ��__

__18. �ε���__

__19. �����ͺ��̽� ������ ���� ����__

__20. �������� ���Ǿ�__

