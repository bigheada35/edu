#### 03.DI(Dependency Injection)-1
#### 04.DI(Dependency Injection)-2
#### 05.DI활용
#### 06.DI설정 방법
#### 07.생명주기(life cycle)
#### 08.외부파일을 이용한 설정

#### 09.AOP-I
#### 10.AOP-II

#### 11.MVC기초
#### 12.컨트롤러
#### 13.form 데이터
#### 14.@RequestMapping 파라미터
#### 15.폼 데이터 값 검증

#### 16.스프링MVC 게시판-1
#### 17.스프링MVC 게시판-2
#### 18.스프링MVC 게시판-3
#### 19.스프링MVC 게시판-4
#### 20.스프링MVC 게시판-5

#### 21.스프링JDBC

#### 22.트랜젝션(Transaction)-1
#### 23.트랜젝션(Transaction)-2
#### 24.트랜젝션(Transaction)-3

#### 25.Security-1
#### 26.Security-2
#### 27.Security-3

#### 28.Mybatis-1
#### 29.Mybatis-2
#### 30.Mybatis-3

## 추가1 

# 40.게시판에서 paging 기능 추가 방법
# 41.스프링 테스트( Junit )

# 42.정적 리소스 처리 방법 (ex.스프링에서 이미지 넣기  & template 넣고 tables.jsp 안의 path수정하여 template 리스트 보이기)
![그림](img/42.PNG)
----------
![그림](img/42-1.PNG)
----------
![그림](img/42-2.PNG)

# 43.마이바티스를 사용하는 4가지 방법의 예

# 44.스프링 시큐리티 
```
참고 개념:
	Authentication :
		인증 과정, 
		사용자로 부터 입력받은 ip, pwd와 DB에 저장된 것과 일치하는지
		확인하는 과정. 일치하지않으면 HTTP status=401을 보낸다.
	Authorization :
		권한 부여, 
		사용자가 웹사이트에서 제공하는 다양한 기능이나 정보를 사용가능한지 여부를 확인하는데 사용함
			ex)
			인스타그램 : 로그인한 사용자만 스토리를 보고 게시물에 댓글을 달수 있도록 허용.
			Netflix : 유료 구독자만 영화와 프로그램을 볼수 잇도록 허용.
		승인은 대부분의 웹 사이트에서 핵심기능임 ( 대부분의 웹 사이트는 서비스를 특정 사용자 그룹으로 제한을 함)
		
```
# 45.REST ful 사용하여 게시판 구현( jQuery  ajax가 내용 포함 예정)

# 46.스프링 트랜젝션 메니지먼트
```
	2개 작업 단위 실행시, 첫번째는 ok 인데 두번째에서 err발생한 경우에, 첫번째를 롤백 시키는 것.

	update, insert, delete 등 2개 이상이 한꺼번에 작업 단위로 되는 것은
	반드시 @Transactional을 붙여서 사용한다
```
# 47.AOP
# 48.소셜로그인

## 개별진척도에 추가

# 60.게시판(마이바티스)
# 61.게시판(REST ful)
# 62.스프링시큐리티
# 63.소셜로그인( 카카오 소셜 로그인)
# 64.결제모듈(아임포트)
