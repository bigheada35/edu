02강 개발 환경 설정

03강 JSP 맛보기

04강 Servlet 맛보기

__05강 Servlet 본격적으로 살펴보기-I
+Servlet은 JAVA언어를 사용하여 웹프로그램을 제작 하는 것.
-Servlet클래스는 HttpServlet클래스를 상속 받음.

06강 Servlet 본격적으로 살펴보기-II

Servlet작동순서
	클라이언트에서 servlet요청이 들어오면, 서버에서는 servlet컨테이너를 만들고, 
	요청이 있을때마다 스레드가 생성 됨.
Servlet라이프 사이클(생명주기)
	servlet 사용도 높은 이유: 빠른 응답 속도 때문,
	servlet 최초 요청시 객체가 만들어져 메모리에 로딩되고,
	이후 요청시에는 기존의 객체를 재활용하게 됨, 따라서 속도 빠름.
Servlet선처리, 후처리
	servlet 라이프 사이클 중 init()과 destroy() 메소드와 관련하여
	선처리( init()전 ) 과 후처리 ( destroy() 후 ) 작업이 가능함	

07강 Servlet 본격적으로 살펴보기-III

08강 Servlet 본격적으로 살펴보기-IV
