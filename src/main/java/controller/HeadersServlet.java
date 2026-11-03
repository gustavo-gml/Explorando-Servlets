package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = {"/headers"})


public class HeadersServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			
			PrintWriter out = resp.getWriter();
			Enumeration<String> headers = req.getHeaderNames();
			
			String ip = req.getRemoteAddr();
			String protocol = req.getProtocol();
			
			out.print("Ip: " + ip + "\nProtocolo:" + protocol + "\n\n");
			
			while( headers.hasMoreElements() ){
				String headerName = headers.nextElement();
				String headerValue = req.getHeader(headerName);
				
				
				
				out.print("Nome: " + headerName + "\nValor:" + headerValue + "\n");
			}
		}
	
	

	
}