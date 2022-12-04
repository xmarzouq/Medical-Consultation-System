import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Operations {
	String server="jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa";
	String user="ma1912476";
	String pass="ma1912476";
	Connection conn;
	CallableStatement stmt;
	
	public Operations() throws SQLException 
	{
		conn=DriverManager.getConnection(server, user, pass);
	}
	
	
	public void ProcMethod() throws SQLException
	{
		stmt=conn.prepareCall("begin emp_sal(?,?); end;");
		stmt.setInt(1,10);
		stmt.setDouble(2, 0.05);
		stmt.execute();
	}
	
	public void FuncMethod() throws SQLException
	{
		stmt=conn.prepareCall("{? = call TOTALCUSTOMERS()}");
		stmt.registerOutParameter(1, Types.INTEGER);
		stmt.execute();
		int totalemps=stmt.getInt(1);
		System.out.println("Total Employees = "+ totalemps);
	}
	
	public void CloseMethod() throws SQLException
	{
		stmt.close();
		conn.close();
	}

}
