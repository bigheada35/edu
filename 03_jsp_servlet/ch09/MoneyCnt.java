package edu.kosmo.ex.money;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StarInc
 */
@WebServlet("/money")
public class MoneyCnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoneyCnt() {
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
		System.out.println("--doGet");
		PrintWriter pw = response.getWriter();
		Money money = new Money(Integer.valueOf(request.getParameter("var_money")));
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html lang=\"en\">");
		pw.println("<head>");
		pw.println("<meta charset=\"UTF-8\">");
		pw.println("<title>Document</title>");
		pw.println("</head>");
		pw.println("<body>");
		
		
//		HashMap<String,Integer> wallet = money.getMoneyCnt();
//		
//		Set<String> keys = wallet.keySet();
//		Iterator<String> iter = keys.iterator();
//		
//		while(iter.hasNext()) {
//			String okey = iter.next();
//			Integer cnt = wallet.get(okey);
//			pw.print(okey + " : " + cnt + "매");
//			System.out.println(okey + ": " + cnt);
//		}
		
		ArrayList<Integer> cnt = money.getMoneyCnt();
		ArrayList<String> type = money.getMoneyType();
		pw.print(money.getMoney() + " =  <br>");
		for(int i=0; i< cnt.size(); i++) {
			pw.print(type.get(i) + " : " + cnt.get(i) + "매 <br>" );
			System.out.println(type.get(i) + " : " + cnt.get(i) + "매");
		}
		
		pw.println("</body>");
		pw.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
