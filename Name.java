package com.deloitte;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Name")
public class Name extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Name() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String un = request.getParameter("username");
		String ps = request.getParameter("pass");
		
		if(un.equals(ps))
		{
			pw.println("You are a valid user");
		}
		else
		{
			pw.println("You are a invalid user");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
