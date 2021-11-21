__02강 개발 환경 설정__

__03강 JSP 맛보기__

__04강 Servlet 맛보기__

__05강 Servlet 본격적으로 살펴보기-I__
- Servlet은 JAVA언어를 사용하여 웹프로그램을 제작 하는 것.
- Servlet클래스는 HttpServlet클래스를 상속 받음.

__06강 Servlet 본격적으로 살펴보기-II__
- Servlet작동순서
	+ 클라이언트에서 servlet요청이 들어오면, 서버에서는 servlet컨테이너를 만들고, 
	+ 요청이 있을때마다 스레드가 생성 됨.
- Servlet라이프 사이클(생명주기)
	+ servlet 사용도 높은 이유: 빠른 응답 속도 때문,
	+ servlet 최초 요청시 객체가 만들어져 메모리에 로딩되고,
	+ 이후 요청시에는 기존의 객체를 재활용하게 됨, 따라서 속도 빠름.
- Servlet선처리, 후처리
	+ servlet 라이프 사이클 중 init()과 destroy() 메소드와 관련하여
	+ 선처리( init()전 ) 과 후처리 ( destroy() 후 ) 작업이 가능함	
	
__07강 Servlet 본격적으로 살펴보기-III__
- HTML form태그
- Servlet Parameter
- 한글처리

__08강 Servlet 본격적으로 살펴보기-IV__
- 8-1. 서블릿 초기화 파라미터 : ServletConfig
- 8-2. 데이터 공유 : ServletContext
- 8-3. 웹어플리케이션 감시 : ServletContextListener
__9강. JSP 본격적으로 살펴보기-I__
- 9-1. JSP 태그의 개념 이해
- 9-2. JSP 동작 원리
- 9-3. JSP 내부 객체



