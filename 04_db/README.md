
__04. SQL*PLUS ��ɾ��� ����__
	
__05. Ư�� ���ڵ� ���� �� SQL�Լ� �����ϱ�__


- select/from/where ��

- desc
- select
- where 

```sql
	������̺�(dept)���� �޿� (sal)�� 3000 �̻��� ���
	 select * from emp where sal > 3000;
```

- ���/��/�� ������
- ��� ������
```sql
	select ename, sal, sal+100 from emp;
```
- �� ������
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
- ��������
```sql
AND
	select empno, deptno, job from emp where deptno = 10 and job = 'MANAGER';
	
OR : �� ���� ���� �߿��� �� ������ �����ϴ��� �˻��� �� �ִ�.	
	select empno, deptno, job from emp where deptno = 10 or job = 'MANAGER';
	
NOT : ���ǿ� �������� ���ϴ� �͸� �˻��� �� �ִ�	
	select empno, deptno, job from emp where not deptno = 10;
	
	select empno, deptno, job from emp where deptno <> 10;
	
	select empno, deptno, job from emp where deptno != 10;
```
- between and ������
```sql
between
	�ϳ��� �ķ��� ���� ���� ���� ���ϴ��� �˾ƺ��� ���� ������
	������, ������, ��¥���� ��� ����
	
	�޿��� 2000~3000 ������ ����� �˻��ϴ� ������
	select * from emp where sal between 2000 and 3000;

	�޿��� 2000 �̸��̰ų� 3000 �ʰ��� ����� �˻��ϴ� ������
	select * from emp where sal not between 2000 and 3000;
	
	1987�⿡ �Ի��� ����� ����ϴ� ������
	select * from emp where hiredate between '1987/01/01' and '1987.12.31';
	
IN
	Ŀ�̼�(COMM)�� 300 Ȥ�� 500 Ȥ�� 1400�� ����� �ִ��� �˻��ϴ� ������
	select * from emp where comm in (300, 500, 1400);
	
	
	Ŀ�̼�(COMM)�� 300 Ȥ�� 500 Ȥ�� 1400�� �ƴ� ����� �ִ��� �˻��ϴ� ������
	select * from emp where comm not in (300, 500, 1400);
```

2)SQL���� �̿��Ͽ� ������ ��������-2

- like ������ �� ���ϵ� ī��
```sql
LIKE
	�÷��� ����� �������� ���� ��ġ�� �����Ͱ� ��ġ�ϸ� ��ȸ�� ������ ������
	
  %
	Ư�� ���ڰ� ���ԵǱ⸸ �ϰ� �� �����̳� ���Ŀ� � ���ڰ� �� ���� ������ ������ٴ� �ǹ̸� ǥ���ϱ� ���ؼ��� LIKE �����ڿ� �Բ� ���
		
		�̸��� F�� �����ϴ� ����� ã�� ������
		select * from emp where ename like 'f%';
		
		��ġ ��� ���� �̸� �߿� A�� ����ִ� ����� ã�� ������
		select * from emp where ename like '%a%';

		�̸��� N���� ������ ����� ã�� ������
		select * from emp where ename like '%n';
		
  _
	
	� ���ڰ� ���� ������ٴ� �ǹ̷� ���
	%���� �������� %�� �� ���� ���ڰ� ���� ����� ������ _�� �� �� ���ڿ� ���ؼ��� ���ϵ� ī�� ������ �Ѵ�
	������ ���� ��ġ�� ������ �����ϱ� �ٶ���
	
		�̸��� �� ��° ���ڰ� A�� ����� ã�� ������
		select * from emp where ename like '_A%';
	
		�̸��� �� ��° ���ڰ� A�� ����� ã�� ������
		select * from emp where ename like '__A%';
	
  escape �ɼ�
		LIKE �����ڿ��� ����ϴ� ���ϵ� ����(%, _) ��ü�� ������ ���ڿ��� �˻��� ��, 
		���ϵ� ���ڸ� �Ϲ� ����ó�� ����ϱ� ���� �ɼ��̴�.
		
		�ش��ϴ� ���ϵ� ���� �տ� ����ڰ� ���ϴ� �� ���ڸ� ���� escape �ɼ��� ����Ͽ� 
		�ش� ���� �ڿ� �� ���ڴ� �Ϲ� ���� �״�� �νĵǵ��� ���� �Ǿ��ִ�.
		
		���ڿ� ��� �����(_)�� ���Ե� ��츦 �˻��ϴ� ������
		select * from emp where ename like '%_%';
		
		�̸�(ENAME)�� '%\%%'�� ���� �����͸� �˻��ϴ� ������
		 select * from emp where ename like '%\%%' escape'\';

NOT LIKE ������
	
	�̸��� A�� �������� �ʴ� ����� �˻��ϴ� ������
	select * from emp where ename not like '%A%';
```
- null�� ���� ������	
```sql
	is null/ is not null
		
		Ŀ�̼�(COMM)�� ���� �ʴ� ����� �˻��ϴ� ������
		select ename, job, comm from emp where comm is null;
		
		
```
- ������ ���� order by��
```sql
	������� �޿��� ������������ �����ϴ� ������
	select * from emp order by sal asc;
	
	���� �ֱٿ� �Ի��� ������� ����ϴ� ������
	select * from emp order by hiredate desc;
	
```
- distinct/��Ī/���� ������
```sql
	distinct
		������ ������ ������ �ߺ��Ǿ� ��µ��� �ʵ��� ���
		
		������� �ҼӵǾ� �ִ� �μ��� ��ȣ�� ����ϴ� ������
		select distinct deptno from emp;
		
	��Ī ������
		�÷� �̸����� �ǹ̸� �˾� ���� ���� ��� �÷��� �̸��� ��Ī�� �ο��� �� �ִ�
		
		select ename, sal12+nvl(comm, 0) from emp;

		select ename, sal12+nvl(comm, 0) as annsal from emp;
		
	" "(ū ����ǥ)�� ��Ī �ο��ϱ�
		���鹮�ڳ� Ư�� ���ڸ� ���Խ�ų�� ����Ѵ�
		
		select ename, sal*12+nvl(comm, 0) "������A n n s a l������" from emp;
		
	�ѱ۷� ��Ī �ο��ϱ�
		select ename, sal*12+nvl(comm, 0) "����" from emp;
		
	���� ������
		select�� ���ο� "||" �����ٸ� ����ؼ� ǥ���Ѵ�
		
	
```

- ���� ������
```sql
	"||" ������
	������ �÷����� ���ڿ��� �߰��ϰ��� �� ? ����Ѵ�.
	
		select ename || ' is a ' || job "�������� ��" from emp;
```
 
__06. SQL ������ �Լ� - ���� �Լ� ���� �Լ�__
```sql
1) �Լ��� ���� �� DUAL ���̺�
	DUAL ���̺�
		�� ������ ����� ����ϱ� ���� ���̺�
		��� �����̳� ���� �÷� ���� ���� �ѹ��� ����ϰ� ���� �� ���� ����Ѵ�
	
		select 24*60 from emp; 
		�̷��� �ϸ�, emp �� ��(12��) ��ŭ ����� �ȴ�.
		
		��� ������ ����� �� �ٷ� ��� ���ؼ� ����Ŭ���� �����ϴ� ���̺�
		select 24*60 from dual;
		�̷��� �ϸ�, dual �� ��( 1��) ��ŭ  ��������� ����� 1�ٷ� ��µȴ�.
		
		DUAL ���̺��� ���̴� ������ ���� ���� ��¥�� ���Ҷ��̴�.
		
			���� ��¥�� ���ϴ� ������
			select sysdate from dual;

2) ���� �Լ�
	abs
		���밪�� ���ϴ� �Լ�
		
		-10�� ���� ���밪�� ���ϴ� ������
		select -10, abs(-10) from dual;
		
	floor
		�Ҽ��� �Ʒ��� ������ �Լ��̴�
		
		34.5432�� FLOOR �Լ��� �����ϴ� ������
		select 34.5432, floor(34.5432) from dual;
		
		���: 34
		
	round
		Ư�� �ڸ������� �ݿø��ϴ� �Լ��̴�.
		34.5678�� �ݿø��ϴ� ������
		 select 34.5678, round(34.5678) from dual;
		 
		 ���: 35
		
		Ư�� �ڸ������� 34.5678�� �ݿø��ϴ� ������
		select 34.5678, round(34.5678, 2) from dual;
		  
		 ���: 34.57
		 
	trunc
		Ư�� �ڸ������� �߶󳻴� �Լ��̴�
		�ι�° ���ڰ��� 2�� ��� : �Ҽ��� ���� ����° �ڸ����� ���� ������ �����Ѵ�
		�ι�° ���ڰ��� 0�� ��� : �Ҽ��� �ڸ����� ���� ������ �����Ѵ�
		�ι�° ���ڰ��� -1�� ��� : ���� �ڸ����� ���� ������ �����Ѵ�.
		�ι�° ���ڰ��� ���� ��� : �Ҽ��� �ڸ����� ���� ������ �����Ѵ�
		
		select trunc(34.5678, 2), trunc(34.5678, -1), trunc(34.5678), trunc(34.5678, 0) from dual;
		
		���:     34.56                 30                   34                   34
	mod
		������ ������ �� �� �������� ����� �ǵ����ִ� �Լ��̴�
		select mod(27, 2), mod(27, 5), mod(27, 7) from dual;
		
		���:        1            2           6
		
3) ���� ó�� �Լ�
	upper
		�빮�ڷ� ��ȯ�ϴ� �Լ��̴�.
		select 'welcome to oracle' "������", upper('welcome to oracle') "upper������" from dual;
		
	lower
		�ҹ��ڷ� ��ȯ�ϴ� �Լ��̴�.
		select 'welcome to oracle' "������", lower('welcome to oracle') "lower������" from dual;
		
	initcap
		�̴ϼȸ� �빮�ڷ� ��ȯ�ϴ� �Լ��̴�.
		select 'welcome to oracle' "������", initcap('welcome to oracle') "initcap������" from dual;
		
		���:                        -->  Welcome To Oracle
		
	length
		���� ���̸� ���ϴ� �Լ��̴�.
		select length('oracle'), length('����Ŭ') from dual;
		
		���:            6                    3
		
	lengthb
		����Ʈ ���� �˷��ִ� �Լ��̴�
		select lengthb('oracle'), lengthb('����Ŭ') from dual;
		��� :                6                  6
		
	instr
		Ư�� ������ ��ġ�� ���ϴ� �Լ��̴�.
		select instr('welcome to Oracle', 'O') from dual;
		
		���:                    12
		
		
	substr
		��� ���ڿ��̳� �÷��� �ڷῡ�� ���� ��ġ���� ���� ������ŭ�� ���ڸ� ����
		
			�ε��� 4���� �����ؼ� ���� 3���� ����
			select substr ('welcome to oracle', 4, 3) from dual;
		
			������� �Ի��Ͽ��� �Ի� �⵵�� �Ի� ���� ����ϴ� ������
			select ename, 19||substr(hiredate, 1, 2)�⵵, substr(hiredate, 4, 2)�� from emp;
		
			9���� �Ի��� ����� ���
			select ename, 19||substr(hiredate, 1, 2)�⵵, substr(hiredate, 4, 2)�� from emp where substr(hiredate, 4, 2) = '09';
	substrb 
		��õ� ������ŭ�� ���ڰ� �ƴ� ����Ʈ ���� �߶󳽴�
		substr�� �ѱ� ���ڸ� 1����Ʈ�� ������ substrb�� 2����Ʈ�� ���� ������ �ؿ� ����� �ٸ��� ��Ÿ����
		
		select substr('����������Ŭ', 3, 4), substrb('����Ŭ����Ŭ', 3, 4) from dual;
		
		���:            ������Ŭ                        ��Ŭ   
		
	lpad/rpad
		Ư�� ��ȣ�� ä��� �Լ��̴�.
		
		lpad(left padding) : ������ ���� �� ���ʿ� ���� �� ���鿡 Ư�� ���ڸ� ä��� �Լ��̴�.
		
			20�ڸ��� ������ �� �����ʿ� ��� ���ڿ��� ����ϰ�, ���ʿ� ���� �� ������ '#' ��ȣ�� ä��� ������
			select lpad('oracle', 20, '#') from dual;
		
			���: ##############oracle
		
		rpad(right padding) : ���� ���� �� �����ʿ� ���� �� ���鿡 Ư�� ���ڸ� ä��� �Լ��̴�
		
			20�ڸ��� ������ �� ���ʿ� ��� ���ڿ��� ����ϰ�, �����ʿ� ���� �� ������ '#' ��ȣ�� ä��� ������
			select rpad('oracle', 20, '#') from dual;
		
	ltrim/rtrim	
		ltrim : ���ڿ� ����(��)�� ���� ���ڵ��� �����Ѵ�.
			select ltrim(' oracle') from dual;
			���:oracle
			
		rtrim : ���ڿ� ������(��)�� ���� ���ڵ��� �����Ѵ�.	
			select rtrim('oracle ') from dual;
	
	trim
		Ư�� ���ڸ� �߶󳻴� �Լ��̴�.
		�÷��̳� ��� ���ڿ����� Ư�� ���ڰ� ù ��°�� �������� ��ġ�� ������, 
		�ش� Ư�� ���ڸ� �߶� �� ���� ���ڿ��� ��ȯ�Ѵ�.
		
			select trim('a' from 'aaaaORACLEaaaaa') from dual;
			
			���:ORACLE
			
			���� ���ڰ� �����ȴ�
			select trim(' ORACLE ') from dual;
			���:ORACLE
	
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
	�� ����� �޿��� �� ������� ���캸�� ������
	select ename, sal, grade from emp, salgrade where sal between losal and hisal;
	
	�� ���� ��� �̸��� �Ҽ� �μ���, �޿��� ����� ����ϴ� ������
		(������̺��� �μ� ��ȣ�� �μ� ���̺��� �����Ͽ� �μ��� �̸��� �����;� �ϰ�,
		������̺��� �޿��� �޿� ������̺��� �����Ͽ� ����� �����;� �Ѵ�
		3���� ���̺�(emp, dept, salgrade)�� �����ؾ� �Ѵ�)
	select e.ename, d.dname, s.grade from emp e, dept d, salgrade s where e.deptno = d.deptno and e.sal between s.losal and s.hisal;
	
4) self join
	EMP���̺��� EMPLOTEE�� MANAGER�� ��Ī�� ������ �� Ư�� ����� �Ŵ����� �������� �˾Ƴ��� ������
	select employee.ename||'�� �Ŵ����� '|| manager.ename||'�Դϴ�.' from emp employee, emp manager where employee.mgr = manager.empno;
	
	
5) outer join
	���� ���ǿ� �������� �ʴ� �൵ ��Ÿ���� ���� ��� --> KING�� �޴����� ��� ����� �ʵǴµ�, ���Ƿ� ����ϰ��� �Ҷ�, (+)�� �����.
	
	Ư�� ����� �Ŵ����� �������� �˾Ƴ��� ������
	select employee.ename||'�� �Ŵ����� '|| manager.ename||'�Դϴ�.' from emp employee, emp manager where employee.mgr = manager.empno(+);
	
	������̺�� �μ� ���̺��� �����Ͽ� ������ �μ� ��ȣȭ �μ����� ����ϴ� ������
	select e.ename, e.deptno, d.deptno, d.dname from emp e, dept d where e.deptno(+) = d.deptno;
	������̺��� �μ� ��ȣ�� 40�� ����� ������ �ܺ� ����(OUTER JOIN)�� ����Ͽ� �μ� ���̺� �ִ� �μ� ��ȣ�� 40�� �μ��� OPERATION�� ��Ÿ������ �Ѵ�
```
__11. ���� ����__
```sql
	select dname from dept where deptno = (select deptno from emp where ename = 'SMITH');

	1) ������ ���� ����
		���� ����� ���� �ϳ��� �ο�(��)���� ��ȯ�ϴ� ��
		
		������� ��� �޿����� �� ���� �޿��� �޴� ����� �˻��ϴ� ������
		select ename, sal from emp where sal > (select avg(sal) from emp);
	
		ALLEN �޿��� �����ϰų� �޿��� �� ���� �޴� ����� �޿��� ����ϴ� ������ allen
		select ename, sal from emp where sal>= (select sal from emp where ename = 'ALLEN');
		
		
	2) ������ ���� ����
		���� ���������� ����� �� �� �̻� ��µǴ� ��
		
		������ ������
			IN
			ANY, SOME
			ALL
			EXISTS
	
		IN
			������ 3000�̻� �޴� ����� �Ҽӵ� �μ��� ������ �μ����� �ٹ��ϴ� ������� ������ ����ϴ� ������
			--���� select ename, sal, deptno from emp where deptno = (select distinct deptno from emp where sal >= 3000);
			����� 2�� �̻� �������� �������� ���� ������ ����� ���� ������ �����ڿ� �Բ� ����ؾ� �Ѵ�!
			
			select ename, sal, deptno from emp where deptno in (select distinct deptno from emp where sal >= 3000);
		ANY	
			�μ� ��ȣ�� 30���� ������� �޿� �� ���� ���� ��(950)���� ���� �޿��� �޴� ����� �̸�, �޿��� ����ϴ� ������
			select ename, sal from emp where sal > any (select sal from emp where deptno = 30);
		
		ALL
			���� ������ �� ������ ���� ������ �˻� ����� ��� ���� ��ġ�ϸ� ���� ������
			
			30�� �Ҽ� ����� �߿��� �޿��� ���� ���� �޴� ���ʺ��� �� ���� �޿��� �޴� ����� �̸��� �޿��� ����ϴ� ������
			select ename, sal from emp where sal> all (select sal from emp where deptno = 30);
			
		EXISTS
			���� ������ �� ������ ���� ������ ��� �߿��� �����ϴ� ���� �ϳ��� �����ϸ� ���� ������
			
			emp���̺� �ִ� �μ��ڵ�(deptno)�� ���� �������� �ִ� dept���̺��� deptno�� ���� �����Ͽ�, 
			deptno�� 10, 20�� �����Ͱ� �����ϸ�, 
			emp ���̺� ���� �ִ� �ش� �÷�(ename, deptno, sal)�� ����ϴ� ������
			select ename, deptno, sal from emp e where exists (select 1 from dept d where d.deptno in (12, 20) and e.deptno = d.deptno);
			
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
	���̺� ���ο� �ο츦 �߰��� �� ����ϴ� SQL��
	���̺� ���ο� �����͸� �Է��ϱ� ���� ����ϴ� ������ ���۾�
	���̺��� ��� �÷��� �ڷḦ �Է��ϴ� ��� �÷� ����� ������� �ʾƵ� �ȴ�
	 �÷� ����� �����Ǹ� VALUES�� ������ ������ ���̺��� �⺻ �÷� ������� �Էµȴ�
		
		�ǽ��� ���� dept���̺��� dept02���̺�η� ������ ������ �� 
		�����͸� �߰��� �� �����͸� ��ȸ�ϴ� ������
			create table dept02 as select * from dept where 1=0;
			insert into dept02 (deptno, dname, loc) values (10, 'accounting', 'new york');
			select * from dept02;
	
		insert ������ �̿��Ͽ� �÷����� �����ϰ�, �����͸� �߰��� �� ��ȸ�ϴ� ������
			insert into dept02 values (20, 'research', 'dallas');
			select * from dept02;
			
		 �ǽ��� ���� dept���̺��� dept03���̺�η� ������ ������ �� 
		 ���� ������ �̿��Ͽ� �����͸� �߰��� �� �����͸� ��ȸ�ϴ� ������
			//���̺� ������ ����
			create table dept03 as select * from dept where 1=0; 
			//dept�� �ִ� �ο�,�÷��� ��� ������ ����.
			insert into dept03 select * from dept;
			select * from dept03;
			
			
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



#  === ����Ǯ�� ===


- 35> ������ ��ȣ �� �ش� �����ڿ� ���� ������� ���� �޿��� ����϶�.
��, �����ڰ� ���� ��� �� ���� �޿��� 1000 �̸��� �׷��� ���ܽ�Ű�� �޿��� ��������
��� ����� ������������ �����϶�.
```sql
select mgr, min(sal) from emp group by mgr having min(sal) > 1000 and mgr is not null order by min(sal) desc;



select mgr, min(sal)from emp where mgr is not null group by mgr having min(sal)>=1000 order by min(sal)

```
�м�: 
```sql
select mgr, min(sal)from emp where mgr is not null group by mgr;
```
![�׸�](PNG/1210_2.PNG)

![�׸�](PNG/1210_3.PNG)
```sql
select mgr, min(sal)from emp where mgr is not null group by mgr having min(sal)>=1000;
```
![�׸�](PNG/1210_4.PNG)
```sql
select mgr, min(sal)from emp where mgr is not null group by mgr having min(sal)>=1000 order by min(sal)
```
![�׸�](PNG/1210_5.PNG)

- 36> �μ����� �μ��̸�, �μ���ġ, ��� �� �� ��� �޿��� ����϶�.
�׸��� ������ �÷����� �μ���,��ġ,����� ��,��ձ޿��� ǥ���϶�.
```sql

select e.deptno as "�μ���", d.dname as "�μ��̸�", d.loc as "��ġ", count(e.empno) as "����� ��", avg(e.sal) as "��ձ޿�"
from emp e, dept d where e.deptno=d.deptno group by e.deptno, d.dname, d.loc
```

![�׸�](PNG/1210_6.PNG)


- 37> Smith�� ������ �μ��� ���� ��� ����� �̸� �� �Ի����� ����϶�.
��, Smith�� �����ϰ� ����Ͻÿ�
```sql
select ename, to_char(hiredate,'yyyy-mm-dd')from emp where deptno in(select deptno from emp where ename='SMITH') and ename!='SMITH';
```
```sql
select ename, to_char(hiredate,'yyyy-mm-dd')from emp where deptno in(select deptno from emp where ename='SMITH');
```

![�׸�](PNG/1210_7.PNG)

```sql
select ename, to_char(hiredate,'yyyy-mm-dd')from emp where deptno in(select deptno from emp where ename='SMITH') and ename!='SMITH';
```

![�׸�](PNG/1210_8.PNG)

 
- 38> �ڽ��� �޿��� ��� �޿����� ���� ��� ����� ��� ��ȣ, �̸�, �޿���
ǥ���ϴ� ���Ǹ� �ۼ��ϰ� �޿��� �������� ����� ������������ �����϶�.

```sql
select empno, ename, sal from emp where sal>(select avg(sal) from emp) order by sal desc;
``` 
 
```sql
select empno, ename, sal from emp where sal>(select avg(sal) from emp);
``` 

![�׸�](PNG/1210_9.PNG)

```sql
select empno, ename, sal from emp where sal>(select avg(sal) from emp) order by sal desc;
``` 

![�׸�](PNG/1210_10.PNG) 
 
 
- 39> �̸��� T�� ���� ����� ���� �μ����� �ٹ��ϴ� ��� �����
�����ȣ �� �̸��� ����϶�.

```sql
select empno, ename from emp where deptno in (select deptno from emp where ename like '%T%');
```

```sql
select empno, ename, deptno from emp where ename like '%T%';
```
![�׸�](PNG/1210_11.PNG)

```sql
select empno, ename from emp where deptno in (select deptno from emp where ename like '%T%');
```

![�׸�](PNG/1210_12.PNG)

![�׸�](PNG/1210_13.PNG)


- 40> �μ���ġ�� Dallas�� ��� ����� �̸�,�μ���ȣ �� ������ ����϶�.
```sql
select e.ename, e.deptno, e.job from emp e, dept d where e.deptno=d.deptno and d.loc='DALLAS';
```

![�׸�](PNG/1210_14.PNG)


- 41> KING���� �����ϴ� ��� ����� �̸��� �޿��� ����϶�.
```sql
select ename, sal from emp where mgr=(select empno from emp where ename='KING');
```

![�׸�](PNG/1210_15.PNG)

![�׸�](PNG/1210_16.PNG)

- 42> Sales �μ��� ��� ����� ���� �μ���ȣ, �̸� �� ������ ����϶�.
```sql
select e.deptno, e.ename, e.job from emp e, dept d where e.deptno=d.deptno and d.dname='SALES';
```

```sql
select e.deptno, e.ename, e.job from emp e inner join dept d on e.deptno=d.deptno where d.dname='SALES';
```

![�׸�](PNG/1210_17.PNG)

- 43> �ڽ��� �޿��� ��� �޿����� ���� �̸��� T�� ���� �����
������ �μ��� �ٹ��ϴ� ��� ����� ��� ��ȣ, �̸� �� �޿��� ����϶�.

```sql
select empno, ename, sal from emp 
where sal > (select avg(sal) from emp) 
and deptno in(select deptno from emp where ename like '%T%');
```

- 44> Ŀ�̼��� �޴� ����� �޿��� ��ġ�ϴ� ����� �̸�,�μ���ȣ,�޿��� ����϶�.
```sql
select ename, deptno, sal
from emp
where sal in(select sal
from emp
where comm is not null)
```
 
- 45> Dallas���� �ٹ��ϴ� ����� ������ ��ġ�ϴ� ����� �̸�,�μ��̸�, �� �޿��� ����Ͻÿ�
```sql
select e.ename, d.dname, e.sal
from emp e, dept d
where e.deptno=d.deptno
and e.job in(select e.job
from emp e, dept d
where e.deptno=d.deptno
and d.loc='dallas')
```
 
- 46> Scott�� ������ �޿� �� Ŀ�̼��� �޴� ��� ����� �̸�, �Ի��� �� �޿��� ����Ͻÿ�
```sql
select ename, hiredate, sal
from emp
where sal=(select sal
from emp
where ename='SCOTT')
and nvl(comm,0)=(select nvl(comm,0)
from emp
where ename='SCOTT')
```
 
- 47> ������ Clerk �� ����麸�� �� ���� �޿��� �޴� ����� �����ȣ, �̸�, �޿��� ����ϵ�,
����� �޿��� ���� ������ �����϶�.
```sql
select empno, ename, sal
from emp
where sal>all(select sal
from emp
where job='CLERK') --�ᱹ �ִ밪�� �� any �ּҰ��� ��
order by sal desc
```
 
- 48> �̸��� A�� ���� ����� ���� ������ ���� ����� �̸��� ����, �μ���ȣ�� ����϶�.
```sql
select ename, sal, deptno
from emp
where job in(select job
from emp
where ename like '%A%')
```
 
- 49> New York ���� �ٹ��ϴ� ����� �޿� �� Ŀ�̼��� ���� ����� ����̸��� �μ����� ����϶�.
```sql
select * from emp join dept
on emp.deptno = dept.deptno
and dept.loc='NEW YORK';
``` 
 
```sql 
select e.ename, d.dname
from emp e, dept d
where
e.deptno= d.deptno
and e.sal in(
select e.sal
from emp e, dept d
where e.deptno=d.deptno and loc='NEW YORK'
)
and nvl(comm,0) in(
select nvl(comm,0)
from emp e, dept d
where e.deptno=d.deptno
and loc='NEW YORK');
```
 
- 50> Dallas���� �ٹ��ϴ� ����� ���� �� �����ڰ� ���� ����� �����ȣ,����̸�,
����,����,�μ���,Ŀ�̼��� ����ϵ� Ŀ�̼��� å������ ���� ����� NoCommission���� ǥ���ϰ�,
Ŀ�̼��� �÷����� Comm���� ������ ����Ͻÿ�. (��, �ְ���޺��� ��µǰ� �Ͻÿ�)
```sql
SELECT E.EMPNO, E.ENAME, E.JOB, E.SAL, D.DNAME,
NVL((TO_CHAR(E.COMM)),'NoCommision') AS "COMM"
FROM EMP E, DEPT D
WHERE E.DEPTNO=D.DEPTNO
AND JOB IN(SELECT JOB
FROM EMP E, DEPT D
WHERE E.DEPTNO=D.DEPTNO AND LOC='DALLAS')
AND MGR IN(SELECT MGR
FROM EMP E, DEPT D
WHERE E.DEPTNO=D.DEPTNO AND LOC='DALLAS')
```

- job �� MANAGER �̸� ROLE_USER �� �ٲ㼭 ���
```sql
select 
	ename, 
	CASE 
		when job = 'MANAGER' then 'ROLE_USER' 
	END 
from emp 
where ename = ?
```