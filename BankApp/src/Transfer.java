/* Copyright  http://morshalim.webs.com/ � All Rights Reserved. Modification of
			    this code is Strictly prohibited. */

import java.io.IOException;
import java.security.Provider.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Transfer extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		try{
			int amttransf=Integer.parseInt(request.getParameter("amttransf"));	
			int tpaccno=Integer.parseInt(request.getParameter("tpaccno"));
			DAOModel dm=new DAOModel();
			HttpSession session=request.getSession();
			int accno=(Integer) session.getAttribute("accno");
			dm.setAccno(accno);
			dm.setTpaccno(tpaccno);
			boolean b=dm.transfer(amttransf);
			if(b==true){
				response.sendRedirect("/BankApp/transfersuccess.jsp");
			}
			else{
				response.sendRedirect("/BankApp/transferfailure.jsp");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

