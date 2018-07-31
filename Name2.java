package com.deloitte;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Name2
 */
@WebServlet("/Name2")
public class Name2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Name2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("name");
		double sal = Double.parseDouble(request.getParameter("sal"));
		String grade = request.getParameter("grade");

		double bonus=0;
		
		if(sal>100000 && grade.equals("A"))
		{
			bonus=sal*0.05;
		}
		else if(sal>50000 && sal<=100000 && grade.equals("B"))
		{
			bonus=sal*0.07;
		}
		else if(sal<50000 && grade.equals("C"))
		{
			bonus=sal*0.2;
		}
		
		double tax = 0.25*sal;
		double netsal = sal+bonus-tax;
		
		pw.println("Employee Name : "+ name);
		pw.println("<br> Basic salary : Rs. "+ sal);
		pw.println("<br> Bonus : Rs. "+ bonus);
		pw.println("<br> Tax: Rs. "+ tax);
		pw.println("<br>Net salary: Rs. "+ netsal);
		
		String str = "<table border=1>" + "<tr> <th> Name </th>" + "<th> Salary </th>" + "<th> Bonus </th>" + "<th> Tax </th>" + "<th> Net salary </th>"+"</tr>";
		String str1 = "<tr>"+"<td>"+name+"</td>"+"<td>"+sal+"</td>"+"<td>"+bonus+"</td>"+"<td>"+tax+"</td>"+"<td>"+netsal+"</td>"+"</tr>"+"</table>";
		
		pw.println(str + str1);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
