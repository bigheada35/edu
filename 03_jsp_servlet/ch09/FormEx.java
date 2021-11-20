package edu.kosmo.ex.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormEx
 */
@WebServlet("/FormEx")
public class FormEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter pw = response.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		//pw.println("<meta charset=\"EUC-KR\">");
		pw.println("<meta charset=\"UTF-8\">");
		pw.println("<title>Document</title>");
		pw.println("</head>");
		pw.println("<body>");
		

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		
		String pwd = request.getParameter("pw");
		String[] hobbyArray = request.getParameterValues("hobby");
		String major = request.getParameter("major");
		String protocol = request.getParameter("protocol");
		
		pw.println("이름: " + name +"<br>");
		pw.println( "아이디: " + id +"<br>");
		pw.println( "비밀번호: " + pwd +"<br>");
		
		try {			
			pw.println("취미 : <br>");
			for(int i=0; i<hobbyArray.length ; i++) {
				pw.println(hobbyArray[i] + " ");
			}
		}catch(Exception e) {
			e.printStackTrace();
			pw.println( "취미에 체크를 안했습니다.<br>");
		}finally {
			pw.println("</body>");
			pw.println("</html>");
		}
	
		pw.println("<br>");
		pw.println( "전공: " + major +"<br>");
		pw.println( "프로토콜: " + protocol +"<br>");
	
		pw.println("</body>");
		pw.println("</html>");
			
		System.out.println("--doPost");
	}

}
