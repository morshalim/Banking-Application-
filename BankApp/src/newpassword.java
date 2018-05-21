/* Copyright  http://morshalim.webs.com/ � All Rights Reserved. Modification of
			    this code is Strictly prohibited. */

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class newpassword extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException	
	{
		try{
			String npw=request.getParameter("npw");
			System.out.println("npw is "+npw);
			HttpSession ses=request.getSession();
			String toEmail=(String)ses.getAttribute("toEmail");
			System.out.println("toEmail is "+toEmail);
			DAOModel dm=new DAOModel();
			boolean b=dm.forgotpassword(npw,toEmail);
			if(b==true){
				response.sendRedirect("/BankApp/successpasswordchange.jsp");
			}
			else{
				response.sendRedirect("/BankApp/failurepasswordchange.jsp");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
    }
}