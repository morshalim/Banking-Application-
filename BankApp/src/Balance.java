/* Copyright  http://morshalim.webs.com/ � All Rights Reserved. Modification of
			    this code is Strictly prohibited. */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Balance extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		try{
			HttpSession session=request.getSession();
			int accno=(Integer)session.getAttribute("accno");
			DAOModel dm=new DAOModel ();
			dm.setAccno(accno);
			boolean b=dm.balance();
			int balance=dm.getBalance();
			session.setAttribute("balance", balance);
			if(b==true){
				response.sendRedirect("/BankApp/balancesuccess.jsp");
			}
			else{
				response.sendRedirect("/BankApp/balancefailure.jsp");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
