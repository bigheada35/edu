
__04. SQL*PLUS ��ɾ��� ����__
	
__05. Ư�� ���ڵ� ���� �� SQL�Լ� �����ϱ�__
```
- select/from/where ��
```sql
	������̺�(dept)���� �޿� (sal)�� 3000 �̻��� ���
	 select * from emp where sal > 3000;
```
- ���/��/�� ������
```sql
	�μ� ��ȣ(deptno)�� 20�� ���
	select * from emp where deptno = 20;
	
	����, ��¥�� �ݵ�� ���� ����ǥ �ȿ� ǥ���ؾ� �Ѵ�.
	(���ڴ� ��ҹ��� ���� ����)
	�̸�(ename)�� FORD ����� ���(empno), �̸�(ename), �޿�(sal)�� ���
	select empno, ename, sal from emp where ename = 'FORD';
	
	1982�� 1�� 1�� ���Ŀ� �Ի��� ���
	select empno, ename, sal from emp where hiredate >= '1982/01/01';
	
```
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
```sql
	1) �ڵ����� �Ұ�/�հ踦 �����ִ� �Լ�
	2) ������ ���� �����
	3) ���Ӱ� �߰��� �Լ��� ������ ����� ��� ����
```
__10. ����__
```sql
1) cartesian product
2) equi join
	��) ��� ������ ����� ��, �� ����� �Ҽӵ� �μ��� �� ������ ����ϱ� ���� �� ���� ���̺��� ����
	select * from emp, dept where emp.deptno = dept.deptno;
	deptno�� ���� ���� ����� �Ǵ� ���̺� ���������� �����ϴ� �÷���� ������ ����(=)���� �����Ͽ� ���ϴ� ����� ��� �Ǵ°��̴�.
	
	�� ������� Ư�� �÷��� ������ ��� ������
	select ename, dname from emp, dept where emp.deptno = dept.deptno; 
	
	�̸��� SCOTT�� ����� �μ����� ����� ���� ������
	select ename, dname from emp, dept where emp.deptno = dept.deptno and ename = 'SMITH'; 
	
	�μ� ��ȣ(DEPTNO)�� EMP���̺�� DEPT���̺� �������� ����ִ�. �̷� ��� ��� ���̺� �Ҽ����� �Һи� �Ͽ� ���� �޽����� ��µȴ�. �׷��ٸ� ��� �ؾ��ұ�?
	
	select emp.ename, dept.dname, emp.deptno from emp, dept where emp.deptno = dept.deptno and ename = 'SMITH';

	���(emp)���̺��� ��Ī�� e��, �μ�(dept)���̺��� ��Ī�� d�� �ο��ϴ� ������
	select e.ename, d.dname, e.deptno from emp e, dept d where e.deptno = d.deptno and ename = 'SMITH';
	
	
3) non-equi join(�� ����)
4) self join
5) outer join
```
__11. ���� ����__
```sql
	1) ������ ���� ����
	2) ������ ���� ����
```
__12. ���̺� ���� ����, ���� �����ϴ� DDL__
```sql
	1) ���̺� ������ �����ϴ� create table
	2) ���̺� ������ �����ϴ� alter table
	3) ���̺� ������ �����ϴ� drop table
	4) ���̺��� ��� �ο츦 �����ϴ� truncate table
	5) ���̺���� �����ϴ� rename
	6) delete, truncate, drop ��ɾ��� ������
	7) ������ ��ųʸ��� ������ ��ųʸ���
```
__13. ���̺��� ������ �߰�, ����, �����ϴ� DML__
```sql
1) insert ��ɹ�

2) ���� ���̺� ������ �Է��ϱ�

3) update ��ɹ�

	�� 1) �ǽ��� ����� ���̺��� �����ϴ� ������
	drop table emp01;
	create table emp01 as select * from emp;
	
	�� 2) ��� ����� �μ� ��ȣ�� 30������ ���� �� Ȯ���ϴ� ������
	update emp01 set deptno=30;
	
	��) ����� �޿��� 10% �λ��Ű�� UPDATE���� ����� ������
	update emp01 set sal = sal*1.1; 
	
	��� �Ի����� ���÷� �����ϴ� ������
	update emp01 set hiredate = sysdate; 
	
	�ǽ��� ����� ���̺��� �����ϴ� ������
	drop table emp01;
	create table emp01 as select * from emp;
	
	�μ� ��ȣ�� 10���� ����� �μ� ��ȣ�� 40������ �����ϰ� Ȯ���ϴ� ������
	update emp01 set deptno = 40 where deptno = 10;
	
	JOB �÷����� MANAGER�� ���, �޿��� 10% �λ��ϴ� ������
	update emp01 set sal = sal * 1.1 where job = 'MANAGER';
	
	1987�⿡ �Ի��� ����� �Ի����� ���÷� �����ϴ� ������
	update emp01 set hiredate = sysdate where substr(hiredate, 1, 2) = '87';
	
	SCOTT ����� �μ���ȣ�� 20������, JOB �÷����� MANAGER�� �Ѳ����� �����ϴ� ������
	update emp01 set deptno=20, job='MANAGER' where ename='SCOTT';
	
	SCOTT ����� �Ի� ��¥�� ���÷�, �޿��� 50����, Ŀ�̼��� 4000���� �����ϴ� ������
	update emp01 set hiredate = sysdate, sal=50, comm=4000 where ename='SCOTT';
	
	SCOTT ����� �ڷᰡ ���ǿ� �°� �� �����Ǿ����� Ȯ���ϴ� ������
	select * from emp01 where ename = 'SCOTT';
	
	20�� �μ��� �������� 40�� �μ��� ���������� �����ϱ� ���ؼ� ���� �������� ����� ������
	update dept01 set loc = (select loc from dept01 where deptno=40) where deptno=20;
	
4) delete ��ɹ�
5) merge ��ɹ�
```
__14. Ʈ������ ����__
```sql
	1) commit�� rollback
	2) �ڵ� commit
	3) savepoint
```
__15. ������ ���Ἲ�� ���� ���� ���� - 1__
```sql
	1) not null ���� ����
	2) unique ���� ����
	3) �÷� ������ ���� ���� �����ϱ�
```
__16. ������ ���Ἲ�� ���� ���� ���� - 2__
```sql
	1) primary key
	2) foreign key  ***
```
__17. ���� ���̺��� ��__
```sql
	1) �ܼ� ��� ���� ��
	2) with check option / with read only �ɼ� �˾ƺ���
	3) �並 �̿��Ͽ� top-n ���ϱ�
```
__18. �ε���  *** __
```sql
	1) �ε��� ���� �� �����ϱ�
	2) �ε��� ��뿩�� �Ǵ� �� ������ϱ�
	3) Invisible Index
```
__19. �����ͺ��̽� ������ ���� ����__
```sql
	1) ����� �����ϱ�
	2) ������ �ο��ϴ� grant ��ɾ�
```
__20. �������� ���Ǿ�__
```sql
	1) ������ �ǹ��� �����ϱ�
	2) ���Ǿ��� ����� ����
	3) ���Ǿ��� ���� �� �����ϱ�
```