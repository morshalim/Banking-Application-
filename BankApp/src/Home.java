/* Copyright  http://morshalim.webs.com/ � All Rights Reserved. Modification of
			    this code is Strictly prohibited. */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Home extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException	
	{
		try{
		int cusID=Integer.parseInt(request.getParameter("cusID"));//getting parameter from view(user input)
		String cuspwd=request.getParameter("cuspwd");//getting parameter from view(user input)
		DAOModel dm=new DAOModel();
		dm.setCusID(cusID);//setter(passing value from controller to model)
		dm.setCuspwd(cuspwd);//setter(passing value from controller to model)
		boolean b=dm.verify();
		int accno=dm.getAccno();
		HttpSession session=request.getSession(true);//if requesting session for the first time den make it true
		session.setAttribute("accno", accno);//setting value into the session
		if(b==true){
			response.sendRedirect("/BankApp/success.jsp");
		}
		else{
			response.sendRedirect("/BankApp/failure.jsp");
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
}
}
