package com.deloitte;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Prg2_passenger
 */
public class Prg2_passenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prg2_passenger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		String dest = request.getParameter("dest");
		
		Prg2_passenger_class pc = new Prg2_passenger_class();
		
		ArrayList passengersList = pc.getAllPassengers(dest);
		
		String str1 = "<table border=1>" + "<tr> <th> First Name </th>" + "<th> Last Name </th>" + "<th> Source </th>" + "<th> Destination </th>" + "<th> Gender </th>"+"</tr>";
		
		pw.println(str1);
		 
		for(int i=0;i<passengersList.size();i++)
		{
			Prg2_passengerVO pvo = (Prg2_passengerVO)passengersList.get(i);
			String str2 = "<tr>"+"<td>"+pvo.getFirstname()+"</td>"+"<td>"+pvo.getLastname()+"</td>"+"<td>"+pvo.getSource()+"</td>"+"<td>"+pvo.getDestination()+"</td>"+"<td>"+pvo.getGender()+"</td>"+"</tr>";
			pw.println(str2);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
