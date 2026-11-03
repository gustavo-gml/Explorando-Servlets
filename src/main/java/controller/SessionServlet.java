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



@WebServlet(urlPatterns = {"/session"})


public class SessionServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
			PrintWriter out = resp.getWriter();
			
			String status = req.getParameter("status");
			
			
			if(status != null && status.equals("Autorizado")){
				req.getSession().setAttribute("user", "X");
				resp.sendRedirect("index.html");
			} else {
				String usuario = (String) req.getSession().getAttribute("user");
				
				if (usuario != null) {
			        out.print("Usuario logado: " + usuario + "\nSeja bem vindo!");
			        req.getSession().removeAttribute("user");
			    }else {
			    	out.print("Usuario sem login.\nPor favor realize o Login para entrar ");
			    }
			}
			
			
		}
	
	

	
}