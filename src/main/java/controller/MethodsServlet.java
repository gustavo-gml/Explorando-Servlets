package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = {"/methods"})


public class MethodsServlet extends HttpServlet{
	
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		  resp.setHeader("Allow", "GET, POST, OPTIONS");
		 resp.setStatus(HttpServletResponse.SC_OK);
		 resp.getWriter().write("Metodos Suportados: Allow, GET, POST, OPTIONS");
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			
		resp.sendRedirect("index.html?executar=true");
			
		}
	
	

	
}