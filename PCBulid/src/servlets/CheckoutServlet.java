package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import pcbuild.Cart;
import pcbuild.Product;

public class CheckoutServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{    
		HttpSession session = request.getSession (false);  
		PrintWriter responseWriter = response.getWriter ();
		
		response.setContentType ("text/html");
		
		if (session.getAttribute("Cart") == null)
			session.setAttribute("Cart", new Cart ());
		
		Cart cart = (Cart) session.getAttribute ("Cart");
		
		for (Product product : cart.getProducts ())
			responseWriter.write (product.toString ());
		
		responseWriter.write ("Total" + cart.getTotal ());
	}

}
	
