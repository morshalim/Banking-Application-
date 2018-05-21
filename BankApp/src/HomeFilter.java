/* Copyright  http://morshalim.webs.com/ � All Rights Reserved. Modification of
			    this code is Strictly prohibited. */

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class HomeFilter
 */
public class HomeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public HomeFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		String cusID=request.getParameter("cusID");//getting parameter from view(user input)
		String cuspwd=request.getParameter("cuspwd");//getting parameter from view(user input)
		if(cusID.length()==0 || cuspwd.length()==0){
			((HttpServletResponse)response).sendRedirect("/BankApp/error.html");
		}
		else{
			chain.doFilter(request, response);	
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
