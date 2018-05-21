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
 * Servlet Filter implementation class passwordchangefilter
 */
public class passwordchangefilter implements Filter {

    /**
     * Default constructor. 
     */
    public passwordchangefilter() {
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
		String npw=request.getParameter("npw");
		String cnpw=request.getParameter("cnpw");
		if(npw.equals(cnpw)){
			chain.doFilter(request, response);	
		}
		else{
			((HttpServletResponse)response).sendRedirect("/BankApp/passwordchangeerror.jsp");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
