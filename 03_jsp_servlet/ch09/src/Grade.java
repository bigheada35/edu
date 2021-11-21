package edu.kosmo.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.TryCatchFinally;

/**
 * Servlet implementation class Grade
 */
@WebServlet("/grade")
public class Grade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Grade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//sj - 주의 : 보내기 엔코딩은 맨 먼저 해 줘야 한글이 안깨진다. 
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("--doGet--");
		//response.setCharacterEncoding("UTF-8");
		
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html lang=\"en\">");
		pw.println("<head>");
		pw.println("<meta charset=\"UTF-8\">");
		pw.println("<title>Document</title>");
		pw.println("</head>");
		pw.println("<body>");
		
		try {
			Student st = new Student(
					request.getParameter("var_name"),
					request.getParameter("var_kor"),
					request.getParameter("var_eng"),
					request.getParameter("var_mat")
					);
			
			pw.println("<h1>GET</h1>");
			pw.println("이름 : " + st.getName() + "<br>");
			pw.println("총점 : " + st.getTotal()+ "<br>");
			pw.println("국어 : " + st.getGrade(st.getKor())+ "<br>");
			pw.println("영어 : " + st.getGrade(st.getEng())+ "<br>");
			pw.println("수학 : " + st.getGrade(st.getMath())+ "<br>");			
			
		} catch (Exception e) {
			e.printStackTrace();
			pw.println("<h1>잘못된 입력 입니다.</h1>");
			
		}finally {
			pw.println("</body>");
			pw.println("</html>");
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//sj doGet(request, response);
		
		response.setCharacterEncoding("UTF-8");	
		
		System.out.println("--doPost--");

		//System.out.println("==="+response.getCharacterEncoding());
		//response.setCharacterEncoding("EUC-KR");
		//System.out.println("==="+response.getCharacterEncoding());
		
		Student st = new Student(
				request.getParameter("var_name"),
				request.getParameter("var_kor"),
				request.getParameter("var_eng"),
				request.getParameter("var_mat")
				);		
		
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html lang=\"en\">");
		pw.println("<head>");
		pw.println("<meta charset=\"UTF-8\">");
		pw.println("<title>Document</title>");
		pw.println("</head>");
		pw.println("<body>");
		
		pw.println("<h1>doPost</h1>");
		pw.println("이름 :" + st.getName() + "<br>");
		pw.println("총점 :" + st.getTotal()+ "<br>");
		pw.println("국어 :" + st.getGrade(st.getKor())+ "<br>");
		pw.println("영어 :" + st.getGrade(st.getEng())+ "<br>");
		pw.println("수학 :" + st.getGrade(st.getMath())+ "<br>");		

		System.out.println(st.getName());
		System.out.println(st.getGrade(st.getKor()));
		System.out.println(st.getGrade(st.getEng()));
		System.out.println(st.getGrade(st.getMath()));
		
		pw.println("</body>");
		pw.println("</html>");
		
	}

}
