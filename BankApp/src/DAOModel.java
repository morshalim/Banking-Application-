/* Copyright  http://morshalim.webs.com/ � All Rights Reserved. Modification of
			    this code is Strictly prohibited. */
import java.sql.*;
import java.util.ArrayList;


public class DAOModel {
	Connection con;
	PreparedStatement  pstmt;
	ResultSet res;
	private int accno;
	private int cusID;
	private String cuspwd;
	private int balance;
	private int amounttransfer;
	//private int amt;
	private int tpaccno;

	DAOModel(){
		DBConnector dc=new DBConnector();
		con=dc.getConnection();
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public void setCusID(int cusID) {
		this.cusID = cusID;
	}
	public void setCuspwd(String cuspwd) {
		this.cuspwd = cuspwd;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void setAmounttransfer(int amounttransfer) {
		this.amounttransfer = amounttransfer;
	}
	
	public int getTpaccno() {
		return tpaccno;
	}
	public void setTpaccno(int tpaccno) {
		this.tpaccno = tpaccno;
	}
	public int getAccno() {
		return accno;
	}
	public int getCusID() {
		return cusID;
	}
	public String getCuspwd() {
		return cuspwd;
	}
	public int getBalance() {
		return balance;
	}
	public int getAmounttransfer() {
		return amounttransfer;
	}
	boolean verify(){
		try{
			pstmt=con.prepareStatement("SELECT * FROM BANK WHERE CUSTOMERID=? AND PASSWORD=?");
			pstmt.setInt(1,cusID);
			pstmt.setString(2,cuspwd);
			res=pstmt.executeQuery();
			while(res.next()==true)
			{
				cusID=res.getInt(6);
				cuspwd=res.getString(3);
				accno=res.getInt(1);
				return true;

			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	boolean transfer(int amttransf){
		try{

			pstmt=con.prepareStatement("UPDATE BANK SET BALANCE=BALANCE-? WHERE ACCNO=?");//BANK is the name of database
			pstmt.setInt(1, amttransf);
			pstmt.setInt(2, accno);
			int rows1=pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("UPDATE BANK SET BALANCE=BALANCE+? WHERE ACCNO=?");
			pstmt.setInt(1, amttransf);
			pstmt.setInt(2, tpaccno);
			int rows2=pstmt.executeUpdate();
			
			
			
			
			pstmt=con.prepareStatement("INSERT INTO STATEMENT VALUES(?,?)");//STATEMENT is the name of database
			pstmt.setInt(1, accno);
			pstmt.setInt(2, amttransf);
			pstmt.executeUpdate();
			
			if(rows1==0 && rows2==0){
				return false;

			}
			else{
				return true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;

	}
	//method must return a value,after exception has occurred its a failure

	boolean balance(){
		try {
			pstmt=con.prepareStatement("SELECT * FROM BANK WHERE ACCNO=?");
			pstmt.setInt(1, accno);
			res=pstmt.executeQuery();
			while(res.next()==true)
			{
				balance=res.getInt(9);
			}
			return true;
		} 
		catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}
	
	boolean passwordchange(String npw)
	{
		try{
			pstmt=con.prepareStatement("UPDATE BANK SET PASSWORD=? WHERE PASSWORD=?");
			pstmt.setString(1, npw);
			pstmt.setString(2, cuspwd);
			int row=pstmt.executeUpdate();
			if(row==0){
				return false;
			}
			else{
				return true;
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	
	ArrayList<Integer> statement(int accno){
		try
		{
			pstmt=con.prepareStatement("SELECT * FROM STATEMENT WHERE ACCNO=?");
			pstmt.setInt(1, accno);
			res=pstmt.executeQuery();
			ArrayList<Integer> al=new ArrayList<Integer>();
			while(res.next()==true)
			{
				al.add(res.getInt(2));
			}
			return al;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	boolean forgotpassword(String npw,String toEmail) throws SQLException
	{
		
		System.out.println("toEmail is "+toEmail);
		pstmt=con.prepareStatement("UPDATE BANK SET PASSWORD=? WHERE EMAIL=?");
		pstmt.setString(1, npw);
		pstmt.setString(2, toEmail);
		int rows=pstmt.executeUpdate();
		System.out.println("Forgot password boolean excuted suucccessfully");
		if(rows==0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
