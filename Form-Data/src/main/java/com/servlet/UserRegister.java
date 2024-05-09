package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String surname = req.getParameter("surname"); 
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.print("<form action='servlet2'> <input type='hidden' name='name' value='"+name+"'><br> <input type='hidden' name='surname' value='"+surname+"'><br> "
				+ "<input type='hidden' name='email' value='"+email+"'><br> <input type='hidden' name='password' value='"+password+"' <br>" + "<button type='submit'>Send</button> </form>");  



	}

}
