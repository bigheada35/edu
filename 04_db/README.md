
__04. SQL*PLUS 명령어의 종류__
	
__05. 특정 레코드 추출 및 SQL함수 정복하기__
```
- select/from/where 절
```sql
	사원테이블(dept)에서 급여 (sal)가 3000 이상인 사원
	 select * from emp where sal > 3000;
```
- 산술/비교/논리 연산자
```sql
	부서 번호(deptno)가 20인 사원
	select * from emp where deptno = 20;
	
	문자, 날짜는 반드시 단일 따옴표 안에 표시해야 한다.
	(문자는 대소문자 구분 있음)
	이름(ename)이 FORD 사람의 사번(empno), 이름(ename), 급여(sal)를 출력
	select empno, ename, sal from emp where ename = 'FORD';
	
	1982년 1월 1일 이후에 입사한 사원
	select empno, ename, sal from emp where hiredate >= '1982/01/01';
```
```
- between and 연산자
- in
- like 연산자 와 와일드 카드
	%
	_
	ESCAPE 옵션				
- null을 위한 연산자	
- 정렬을 위한 order by절
- distinct/별칭/연결 연산자
- 연결 연산자
	"||" 수직바
```

__06. SQL 단일행 함수 - 숫자 함수 문자 함수__
```sql
1) 함수의 종류 및 DUAL 테이블
2) 숫자 함수
	abs
		절대값을 
	floor
		소수점 아래를 버리는 함수
	round
		특정 자릿수에서 반올림
	trunc
		특정 자릿수에서 잘라
	mod
		나누기 연산을 한 후 나머지를 결과로 되돌려주는 함수
3) 문자 처리 함수
	upper
	lower
	initcap
		이니셜만 대문자로
	length
		문자 길이를 구하
	lengthb
		바이트 수
	instr
		특정 문자의 위치를 구하
	substr
		대상 문자열이나 컬럼의 자료에서 시작 위치부터 선택 개수만큼의 문자를 추출
		ex:
		인덱스 4부터 시작해서 문자 3개를 추출
		select substr ('welcome to oracle', 4, 3) from dual;
		
		ex:
		9월에 입사한 사원을 출력
		select ename, 19||substr(hiredate, 1, 2)년도, substr(hiredate, 4, 2)달 from emp where substr(hiredate, 4, 2) = '09';
```

__07. SQL 단일행 함수 - 날짜함수/형 변환함수/일반함수__
```sql
1) 날짜 함수
sysdate
	시스템에서 현재 날짜를 읽어 와서 출력
	select sysdate from dual;
	
months_between	
	각 직원들이 근무한 개월 수
	select ename, sysdate, hiredate, months_between(sysdate, hiredate) 근무개월수 from emp;
	
add_months
	입사 날짜에서 4개월을 추가한 결과값
	select ename, hiredate, add_months(hiredate, 4) from emp;
	
2) 형 변환 함수(숫자형, 문자형, 날짜형)

to_char
	현재 날짜를 문자형으로 변환하여 출력
	select sysdate, to_char(sysdate, 'yyyy-mm-dd') from dual;

	 현재 날짜와 시간을 출력
	select to_char(sysdate, 'yyyy/mm/dd, hh24:mi:ss') from dual;
	
to_date
	문자형을 날짜형으로 변환
	
	1981년 2월 20일에 입사한 사원을 검색
	select ename, hiredate from emp where hiredate=to_date(19810220, 'yyyymmdd');
	
3) NULL을 다른 값으로 변환하는 NVL함수
nvl
	NULL을 0 또는 다른 값으로 변환
	
	select ename, sal, comm, job from emp order by job;
	
	연봉 계산
	select ename, sal, comm, sal12+comm, nvl(comm, 0), sal12+nvl(comm, 0) from emp order by job
	
4) 선택을 위한 DECODE 함수
	여러가지 경우에 대해서 선택할 수 있도록 하는 기능을 제공
	
	사원의 부서 번호를 이름으로 설정
	select deptno, decode(deptno, 10, 'a', 20, 'b', 'default') from emp order by deptno;

5) 조건에 따라 서로 다른 처리가 가능한 CASE 함수

```

__08. SQL 복수행 함수 - 그룹 함수__
```sql
1) 그룹 함수
	하나 이상의 행을 그룹으로 묶어 연산하여, 하나의 결과를 나타
	
sum
	그룹 함수를 이용해서 사원의 총 급여
	 select sum(sal) from emp;
	 그룹함수의 결과는 사원이 총 14명인데도 결과는 하나의 행으로 출력
	 
	 커미션(COMM) 총액
	  select sum(comm) from emp;
	  
avg
	해당 컬럼 값에 대해 평균
	급여 평균을 구하
	select avg(sal) from emp;
	

max : 지정한 컬럼 값 중에서 최대값
	
	가장 높은 급여와 가장 낮은 급여
	select max(sal), min(sal) from emp;
	
count
	테이블에서 조건을 만족하는 행위 개수
	사원 테이블의 사원들 중에서 커미션(COMM)을 받은 사원의 수
	select count(comm) from emp;
	
2) group by 절
	사원 테이블을 부서 번호로 그룹 짓는
	select deptno from emp group by deptno;
	
	소속 부서별 평균 급여
	select avg(sal) from emp group by deptno;
	
	소속 부서별 급여 총액과 평균 급여
	select deptno, sum(sal), avg(sal) from emp group by deptno;
	
3) having 절
	group by 절에 의해 생성된 결과 값 중 원하는 조건에 부합하는 자료만 보고자 할 때
	
	그룹 지어진 부서별 평균 급여가 2000 이상인 부서의 번호와 부서별 평균 급여를 출력
	select deptno, avg(sal) from emp group by deptno having avg(sal) >= 2000;
	
	부서의 최대값과 최소값을 구하되, 최대 급여가 2900 이상인 부서만 출력
	 select deptno, max(sal), min(sal) from emp group by deptno having max(sal) >= 2900; 
```
__09. SQL 고급 함수로 멋진 레포트 만들기__
```sql
	1) 자동으로 소계/합계를 구해주는 함수
	2) 계층형 쿼리 만들기
	3) 새롭게 추가된 함수로 쿼리문 만들고 결과 보기
```
__10. 조인__
```sql
1) cartesian product
2) equi join
	예) 사원 정보를 출력할 때, 각 사원이 소속된 부서의 상세 정보를 출력하기 위해 두 개의 테이블을 조인
	select * from emp, dept where emp.deptno = dept.deptno;
	deptno를 보면 조인 대상이 되는 테이블에 공통적으로 존재하는 컬럼들과 동일한 조건(=)으로 조인하여 원하는 결과를 얻게 되는것이다.
	
	위 결과에서 특정 컬럼의 정보만 얻는 쿼리문
	select ename, dname from emp, dept where emp.deptno = dept.deptno; 
	
	이름이 SCOTT인 사람의 부서명을 출력해 보는 쿼리문
	select ename, dname from emp, dept where emp.deptno = dept.deptno and ename = 'SMITH'; 
	
	부서 번호(DEPTNO)가 EMP테이블과 DEPT테이블에 공통으로 들어있다. 이럴 경우 어느 테이블 소속인지 불분명 하여 오류 메시지가 출력된다. 그렇다면 어떻게 해야할까?
	
	select emp.ename, dept.dname, emp.deptno from emp, dept where emp.deptno = dept.deptno and ename = 'SMITH';

	사원(emp)테이블의 별칭을 e로, 부서(dept)테이블의 별칭을 d로 부여하는 쿼리문
	select e.ename, d.dname, e.deptno from emp e, dept d where e.deptno = d.deptno and ename = 'SMITH';
	
	
3) non-equi join(비등가 조인)
	각 사원의 급여가 몇 등급인지 살펴보는 쿼리문
	select ename, sal, grade from emp, salgrade where sal between losal and hisal;
	
	한 명의 사원 이름과 소속 부서명, 급여의 등급을 출력하는 쿼리문
		(사원테이블의 부서 번호로 부서 테이블을 참조하여 부서의 이름을 가져와야 하고,
		사원테이블의 급여로 급여 등급테이블을 참조하여 등급을 가져와야 한다
		3개의 테이블(emp, dept, salgrade)을 조인해야 한다)
	select e.ename, d.dname, s.grade from emp e, dept d, salgrade s where e.deptno = d.deptno and e.sal between s.losal and s.hisal;
	
4) self join
	EMP테이블을 EMPLOTEE와 MANAGER로 별칭을 지정한 후 특정 사원의 매니저가 누구인지 알아내는 쿼리문
	select employee.ename||'의 매니저는 '|| manager.ename||'입니다.' from emp employee, emp manager where employee.mgr = manager.empno;
	
	
5) outer join
	조인 조건에 만족하지 않는 행도 나타내는 조인 기법 --> KING의 메니저는 없어서 출력이 않되는데, 임의로 출력하고자 할때, (+)를 사용함.
	
	특정 사원의 매니저가 누구인지 알아내는 쿼리문
	select employee.ename||'의 매니저는 '|| manager.ename||'입니다.' from emp employee, emp manager where employee.mgr = manager.empno(+);
	
	사원테이블과 부서 테이블을 조인하여 사원명과 부서 번호화 부서명을 출력하는 쿼리문
	select e.ename, e.deptno, d.deptno, d.dname from emp e, dept d where e.deptno(+) = d.deptno;
	사원테이블에는 부서 번호가 40인 사원이 없지만 외부 조인(OUTER JOIN)을 사용하여 부서 테이블에 있는 부서 번호가 40인 부서명 OPERATION가 나타나도록 한다
```
__11. 서브 쿼리__
```sql
	select dname from dept where deptno = (select deptno from emp where ename = 'SMITH');

	1) 단일행 서브 쿼리
		수행 결과가 오직 하나의 로우(행)만을 반환하는 것
		
		사원들의 평균 급여보다 더 많은 급여를 받는 사원을 검색하는 쿼리문
		select ename, sal from emp where sal > (select avg(sal) from emp);
	
		ALLEN 급여와 동일하거나 급여를 더 많이 받는 사원과 급여를 출력하는 쿼리문 allen
		select ename, sal from emp where sal>= (select sal from emp where ename = 'ALLEN');
		
		
	2) 다중행 서브 쿼리
		서브 쿼리에서의 결과가 두 건 이상 출력되는 것
		
		다중행 연산자
			IN
			ANY, SOME
			ALL
			EXISTS
	
		IN
			연봉을 3000이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원들의 정보를 출력하는 쿼리문
			--에러 select ename, sal, deptno from emp where deptno = (select distinct deptno from emp where sal >= 3000);
			결과가 2개 이상 구해지는 쿼리문을 서브 쿼리로 기술할 때는 다중행 연산자와 함께 사용해야 한다!
			
			select ename, sal, deptno from emp where deptno in (select distinct deptno from emp where sal >= 3000);
		ANY	
			부서 번호가 30번인 사원들의 급여 중 가장 낮은 값(950)보다 높은 급여를 받는 사원의 이름, 급여를 출력하는 쿼리문
			select ename, sal from emp where sal > any (select sal from emp where deptno = 30);
		
		ALL
			메인 쿼리의 비교 조건이 서브 쿼리의 검색 결과와 모든 값이 일치하면 참인 연산자
			
			30번 소속 사원들 중에서 급여를 가장 많이 받는 사우너보다 더 많은 급여를 받는 사람의 이름과 급여를 출력하는 쿼리문
			select ename, sal from emp where sal> all (select sal from emp where deptno = 30);
			
		EXISTS
			메인 쿼리의 비교 조건이 서브 쿼리의 결과 중에서 만족하는 값이 하나라도 존재하면 참인 연산자
			
			emp테이블에 있는 부서코드(deptno)와 서브 쿼리문에 있는 dept테이블의 deptno를 서로 조인하여, 
			deptno가 10, 20인 데이터가 존재하면, 
			emp 테이블 내에 있는 해당 컬럼(ename, deptno, sal)을 출력하는 쿼리문
			select ename, deptno, sal from emp e where exists (select 1 from dept d where d.deptno in (12, 20) and e.deptno = d.deptno);
			
```
__12. 테이블 구조 생성, 변경 삭제하는 DDL__
```sql
	1) 테이블 구조를 정의하는 create table
	2) 테이블 구조를 변경하는 alter table
	3) 테이블 구조를 제거하는 drop table
	4) 테이블의 모든 로우를 제거하는 truncate table
	5) 테이블명을 변경하는 rename
	6) delete, truncate, drop 명령어의 차이점
	7) 데이터 딕셔너리와 데이터 딕셔너리뷰
```
__13. 테이블의 내용을 추가, 수정, 삭제하는 DML__
```sql
1) insert 명령문

2) 다중 테이블에 다중행 입력하기

3) update 명령문

	예 1) 실습에 사용할 테이블을 생성하는 쿼리문
	drop table emp01;
	create table emp01 as select * from emp;
	
	예 2) 모든 사원의 부서 번호를 30번으로 수정 후 확인하는 쿼리문
	update emp01 set deptno=30;
	
	예) 사원의 급여를 10% 인상시키는 UPDATE문을 만드는 쿼리문
	update emp01 set sal = sal*1.1; 
	
	모든 입사일을 오늘로 수정하는 쿼리문
	update emp01 set hiredate = sysdate; 
	
	실습에 사용할 테이블을 생성하는 쿼리문
	drop table emp01;
	create table emp01 as select * from emp;
	
	부서 번호가 10번인 사원의 부서 번호를 40번으로 수정하고 확인하는 쿼리문
	update emp01 set deptno = 40 where deptno = 10;
	
	JOB 컬럼값이 MANAGER인 경우, 급여를 10% 인상하는 쿼리문
	update emp01 set sal = sal * 1.1 where job = 'MANAGER';
	
	1987년에 입사한 사원의 입사일을 오늘로 수정하는 쿼리문
	update emp01 set hiredate = sysdate where substr(hiredate, 1, 2) = '87';
	
	SCOTT 사원의 부서번호는 20번으로, JOB 컬럼값은 MANAGER로 한꺼번에 수정하는 쿼리문
	update emp01 set deptno=20, job='MANAGER' where ename='SCOTT';
	
	SCOTT 사원의 입사 날짜는 오늘로, 급여는 50으로, 커미션은 4000으로 수정하는 쿼리문
	update emp01 set hiredate = sysdate, sal=50, comm=4000 where ename='SCOTT';
	
	SCOTT 사원의 자료가 조건에 맞게 잘 수정되었는지 확인하는 쿼리문
	select * from emp01 where ename = 'SCOTT';
	
	20번 부서의 지역명을 40번 부서의 지역명으로 변경하기 위해서 서브 쿼리문을 사용한 쿼리문
	update dept01 set loc = (select loc from dept01 where deptno=40) where deptno=20;
	
4) delete 명령문
5) merge 명령문
```
__14. 트랜젝션 관리__
```sql
	1) commit과 rollback
	2) 자동 commit
	3) savepoint
```
__15. 데이터 무결성을 위한 제약 조건 - 1__
```sql
	1) not null 제약 조건
	2) unique 제약 조건
	3) 컬럼 레벨로 제약 조건 설정하기
```
__16. 데이터 무결성을 위한 제약 조건 - 2__
```sql
	1) primary key
	2) foreign key  ***
```
__17. 가상 테이블인 뷰__
```sql
	1) 단순 뷰와 복합 뷰
	2) with check option / with read only 옵션 알아보기
	3) 뷰를 이용하여 top-n 구하기
```
__18. 인덱스  *** __
```sql
	1) 인덱스 생성 및 제거하기
	2) 인덱스 사용여부 판단 및 재생성하기
	3) Invisible Index
```
__19. 데이터베이스 보완을 위한 권한__
```sql
	1) 사용자 생성하기
	2) 권한을 부여하는 grant 명령어
```
__20. 시퀀스와 동의어__
```sql
	1) 시퀀스 실무에 적용하기
	2) 동의어의 개념과 종류
	3) 동의어의 생성 및 제거하기
```