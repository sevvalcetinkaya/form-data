package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet2")
public class secondservlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		String userAgent = req.getHeader("User-Agent");
		String browserModel = getBrowserModel(userAgent);
 		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("Name: "+name+"\n"+"Surname: "+surname+"\n"+"Email: "+email+"\n"+"Password: "+password);
		out.println("<script type=\"text/javascript\">");
        out.println("alert('Tarayıcı Modeli: " + browserModel + "');");
        out.println("</script>");
	}
	private String getBrowserModel(String userAgent) {
		String browserModel = "Bilinmiyor";
		
		if(userAgent != null) {
			if(userAgent.contains("Chrome")) {
				browserModel = "Google Chrome";
			} else if (userAgent.contains("Firefox")) {
				browserModel = "Mozilla Firefox";
			} else if (userAgent.contains("Safari")) {
				browserModel = "Apple Safari";
			}
		}
		return browserModel;
	}
}
