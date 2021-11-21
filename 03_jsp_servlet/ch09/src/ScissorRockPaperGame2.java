package edu.kosmo.ex.scissor_rock_paper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScissorRockPaper
 */
@WebServlet("/scissor_rock_paper")
public class ScissorRockPaperGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScissorRockPaperGame() {
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
		//doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		
		//-------------------//
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset=\"UTF-8\">");
		pw.println("<title>Document</title>");
		pw.println("</head>");
		pw.println("<body>");
		//-------------------//
		String submit = request.getParameter("submit");
		System.out.println(submit);
		if(submit.equals("게임 하기")) {

			try {
				String personSelect = request.getParameter("scissor_rock_paper");
				System.out.println(personSelect);
				ScissorRockPaper srp = new ScissorRockPaper(personSelect);
				String winner = srp.getWinner();
				
				
				System.out.println("---"+srp.getMySelect());
				System.out.println("---"+srp.getComputerSelect());
				
				//pw.println("유저  : " + srp.getMySelect()+" " );
				pw.println("유저:");
				if(srp.getMySelect().equals("가위")) {
					
					pw.println("<input type=\"image\" src=\"C:\\Users\\swj\\eclipse-workspace\\java1\\t4b_grade_student_today_quiz1\\src\\main\\webapp\\21.PNG\" alt=\"\"/>");
				}else if(srp.getMySelect().equals("바위")) {
					
					pw.println("<input type=\"image\" src=\"C:\\Users\\swj\\eclipse-workspace\\java1\\t4b_grade_student_today_quiz1\\src\\main\\webapp\\22.PNG\" alt=\"\"/>");
				}else {
					
					pw.println("<input type=\"image\" src=\"C:\\Users\\swj\\eclipse-workspace\\java1\\t4b_grade_student_today_quiz1\\src\\main\\webapp\\23.PNG\" alt=\"\"/>");
				}
				
				//pw.println("컴퓨터 : " + srp.getComputerSelect()+" " );
				pw.println("컴퓨터:");
				if(srp.getComputerSelect().equals("가위")) {
					
					pw.println("<input type=\"image\" src=\"C:\\Users\\swj\\eclipse-workspace\\java1\\t4b_grade_student_today_quiz1\\src\\main\\webapp\\21.PNG\" alt=\"\"/>");
				}else if(srp.getComputerSelect().equals("바위")) {
					
					pw.println("<input type=\"image\" src=\"C:\\Users\\swj\\eclipse-workspace\\java1\\t4b_grade_student_today_quiz1\\src\\main\\webapp\\22.PNG\" alt=\"\"/>");
				}else {
					
					pw.println("<input type=\"image\" src=\"C:\\Users\\swj\\eclipse-workspace\\java1\\t4b_grade_student_today_quiz1\\src\\main\\webapp\\23.PNG\" alt=\"\"/>");
				}
				pw.println("<br>");
				if(winner.equals("person")) {
					
					pw.println("<input type=\"image\" src=\"C:\\Users\\swj\\eclipse-workspace\\java1\\t4b_grade_student_today_quiz1\\src\\main\\webapp\\31.PNG\" alt=\"\"/><br>");
					pw.println("결과 : 유저가 이겼습니다.<br>" );
					
				}else if(winner.equals("computer")) {
					
					pw.println("<input type=\"image\" src=\"C:\\Users\\swj\\eclipse-workspace\\java1\\t4b_grade_student_today_quiz1\\src\\main\\webapp\\32.PNG\" alt=\"\"/><br>");
					pw.println("결과 : 유저가 졌습니다.<br>" );
					
				}else {
					
					pw.println("<input type=\"image\" src=\"C:\\Users\\swj\\eclipse-workspace\\java1\\t4b_grade_student_today_quiz1\\src\\main\\webapp\\33.PNG\" alt=\"\"/><br>");
					pw.println("결과 : 비겼습니다.<br>" )	;
				}
				
				
			}catch(Exception e) {
				pw.println("<h2>선택을 하고 시작하세요.</h2><br>" );
				pw.println("<form action=\"scissor_rock_paper\"method=\"post\">");
				pw.println("<input type=\"submit\" name=\"submit\" value=\"다시 하기\"><br>");
				pw.println("</form>");
				pw.println("</body>");
				pw.println("</html>");
				e.printStackTrace();
			}finally {

			}
			

			
			pw.println("<form action=\"scissor_rock_paper\"method=\"post\">");
			pw.println("<input type=\"submit\" name=\"submit\" value=\"다시 하기\"><br>");
			//pw.println("<input type=\"reset\" name=\"reset\" value=\"다시 하기\"><br>");
			pw.println("</form>");
			
		}else {
			pw.println("<form action=\"scissor_rock_paper\"method=\"post\">");
			pw.println("<h2>가위 바위 보 를 선택하세요</h2>");
			
			pw.println("<input type=\"image\" src=\"C:\\Users\\swj\\eclipse-workspace\\java1\\t4b_grade_student_today_quiz1\\src\\main\\webapp\\21.PNG\" alt=\"\"/>");
			pw.println("<input type=\"radio\" name=\"scissor_rock_paper\" value=\"가위\"> 가위 <br>");
			
			pw.println("<input type=\"image\" src=\"C:\\Users\\swj\\eclipse-workspace\\java1\\t4b_grade_student_today_quiz1\\src\\main\\webapp\\22.PNG\" alt=\"\"/>");
			pw.println("<input type=\"radio\" name=\"scissor_rock_paper\" value=\"바위\"> 바위 <br>");
			
			pw.println("<input type=\"image\" src=\"C:\\Users\\swj\\eclipse-workspace\\java1\\t4b_grade_student_today_quiz1\\src\\main\\webapp\\23.PNG\" alt=\"\"/>");
			pw.println("<input type=\"radio\" name=\"scissor_rock_paper\" value=\"보\"> 보 <br><br>");
			
			
			pw.println("<input type=\"submit\" name=\"submit\" value=\"게임 하기\"><br>");
			pw.println("<input type=\"reset\" name=\"reset\" value=\"다시 하기\"><br>");
			pw.println("</form>");
		}
		//-------------------//
		pw.println("</body>");
		pw.println("</html>");
		//-------------------//
		
	}

}
