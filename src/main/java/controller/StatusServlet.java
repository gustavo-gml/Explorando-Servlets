package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = {"/status" })


public class StatusServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		 String r = req.getServletPath(); //pega sem a root
		 String codigo = req.getParameter("codigo");
		 String result = r + "/" + codigo;
		 switch(result)
		 {
		 
		 
		 case "/status/200":
			 resp.setStatus(HttpServletResponse.SC_OK);
				
			 resp.setContentType("application/json");
			 resp.getWriter().write("{\"status\": \"sucesso\"}");
			 break;
			 
		 case "/status/201":
			 resp.setStatus(HttpServletResponse.SC_CREATED);
				
			 resp.setContentType("application/json");
			 resp.getWriter().write("{\"status\": \"criado\"}");
			 break;
			 
		 case "/status/404":
			 resp.sendError(HttpServletResponse.SC_NOT_FOUND, "O recurso solicitado não existe. (Isso é uma mensagem personalisada)");
		     return; 
			 
		 case "/status/500":
			 resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro interno de servidor. (Isso é uma mensagem personalisada)");
		     return; 
			 
			
		 }
		
		
		
	}
	

	
}