/* Copyright  http://morshalim.webs.com/ � All Rights Reserved. Modification of
			    this code is Strictly prohibited. */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class passwordchange extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
        try
        {
        	String opw=request.getParameter("opw");
        	String npw=request.getParameter("npw");
        	DAOModel dm=new DAOModel();
        	dm.setCuspwd(opw);
        	System.out.println("Executed");
        	boolean b=dm.passwordchange(npw);
			if(b==true){
				response.sendRedirect("/BankApp/passwordchangesuccess.jsp");
			}
			else{
				response.sendRedirect("/BankApp/passwordchangefailure.jsp");
			}
        }
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
}