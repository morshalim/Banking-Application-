/* Copyright  http://morshalim.webs.com/ � All Rights Reserved. Modification of
			    this code is Strictly prohibited. */

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class statement extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		try
		{
			HttpSession session=request.getSession();
			int accno=(Integer)session.getAttribute("accno");
			DAOModel dm=new DAOModel();
			ArrayList al=dm.statement(accno);
			session.setAttribute("al", al);
			if(al!=null){
				response.sendRedirect("/BankApp/successstatement.jsp");
			}
			else{
				response.sendRedirect("/BankApp/failurestatement.jsp");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
