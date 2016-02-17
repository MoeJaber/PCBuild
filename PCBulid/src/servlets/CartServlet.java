package servlets;  
  
import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import pcbuild.Cart;
import pcbuild.Product;  
  
public class CartServlet extends HttpServlet
{  
    private static final long serialVersionUID = 1L;  
  
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {    
    	HttpSession session = request.getSession ();
    	
    	if (session.getAttribute ("cart") == null)
    		session.setAttribute ("cart", new Cart ());
    	
    	Cart cart = (Cart) session.getAttribute ("Cart");
    	
    }    
}   