/*
 
 
 TITLE:-Design at least 10 SQL queries for suitable database application using SQL DML statements:Insert,Delete,Update,Delete
 Clauses using distinct,count,aggregation on Client-Data server(Three tier).
 
*/
import java.io.*;
import java.sql.*;
import java.util.*;

import com.mysql.jdbc.Statement;
public class JDBCExample3
{
 // JDBC driver name and database URL
static final String JDBC_DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";  
 static final String DB_URL = "jdbc:odbc:jdbc";

   //  Database credentials
   static final String USER = "system";
   static final String PASS = "admin";
  
	public static void main(String args[]) throws ClassNotFoundException
	{
			Connection con;
		  Statement stmt;
		  PreparedStatement psn=null;
		Scanner s=new Scanner(new InputStreamReader(System.in));
		try
		{
			//Class.forName("com.mysql.jdbc.Driver");
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Loaded driver");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
			//con = //DriverManager.getConnection("jdbc:mysql://localhost/dbms?"
	//		+ "user=xyz&password=1234");
			System.out.println("Successfully connected");
			stmt=(Statement) con.createStatement();
			int ch,j,k;
			String v;
			do
			{
				
				System.out.println("1.SELECT");
				System.out.println("2.INSERT");
				System.out.println("3.UPDATE");
				System.out.println("4.DELETE");
				System.out.println("5.DISTINCT");
				System.out.println("6.COUNT");
				System.out.println("7.SUM");
				System.out.println("8.AVERAGE");
				System.out.println("9.MINIMUM");
				System.out.println("10.MAXIMUM");
				System.out.println("11.EXIT");
				System.out.println("Enter ur choice::");
				ch=s.nextInt();
				switch(ch)
				{
				
				case 1:
					ResultSet rs=stmt.executeQuery("select * from sid");
					System.out.println("ROLLNO.   NAME     MARKS");	
					while(rs.next())
					{
					int i = rs.getInt("Roll_no");	
					String n=rs.getString("Name");
					int m = rs.getInt("Marks");
					System.out.println(+i+"        "+n+"      "+m);
					}
					break;
					
				case 2:
					psn=con.prepareStatement("insert into sid values(?,?,?)");
					System.out.println("Enter Roll Number::");
					j=s.nextInt();
					System.out.println("Enter name::");
					v=s.next();
					System.out.println("Enter Marks::");
					k=s.nextInt();
					psn.setInt(1, j);
					psn.setString(2, v);
					psn.setInt(3, k);
					psn.executeUpdate();
					break;
					
				case 3:
					psn=con.prepareStatement("update sid set Name=? where Roll_no=?");
					System.out.println("Enter Roll Number u want to update::");
					j=s.nextInt();
					System.out.println("Enter name::");
					v=s.next();
					psn.setInt(2, j);
					psn.setString(1, v);
					psn.executeUpdate();
					break;
					
					
				case 4:
					psn=con.prepareStatement("delete from sid where Roll_no= ?");
					System.out.println("Enter Roll Number u want to delete::");
					int i;
					i=s.nextInt();		
					psn.setInt(1, i);
					psn.executeUpdate();
					
					break;
				
					
				case 5:
					ResultSet RS=stmt.executeQuery("select distinct Marks as 'Marks' from sid");
					System.out.println("MARKS");
					while(RS.next())
					{
					int m = RS.getInt("Marks");
					System.out.println(m);
					}
					break;
					
				case 6:
					ResultSet q=stmt.executeQuery("select count(*) as 'Count' from sid");
					System.out.println("COUNT");
					while(q.next())
					{
					int m = q.getInt("Count");
					System.out.println(m);
					}
					break;
					
				case 7:
					ResultSet y=stmt.executeQuery("select sum(Marks) from sid");
					System.out.println("SUM");
					while(y.next())
					{
						int m=y.getInt("sum(Marks)");
						System.out.println(m);
					}
					break;
					
				case 8:
					ResultSet result=stmt.executeQuery("select avg(Marks) from sid");
					System.out.println("AVERAGE");
					while(result.next())
					{
						int m=result.getInt("avg(Marks)");
						System.out.println(m);
					}
					break;
					
				case 9:
					ResultSet result1=stmt.executeQuery("select min(Marks) from sid");
					System.out.println("MIN_MARKS");
					while(result1.next())
					{
						int m=result1.getInt("min(Marks)");
						System.out.println(m);
					}
					break;
				case 10:
					ResultSet result2=stmt.executeQuery("select max(Marks) from sid");
					System.out.println("MAX_MARKS");
					while(result2.next())
					{
						int m=result2.getInt("max(Marks)");
						System.out.println(m);
					}
					break;
					
				case 11:
					System.out.println("Program Executed Successfully");
				}
			}while(ch!=11);
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
/*OUTPUT:-
Loaded driver
Successfully connected
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.DISTINCT
6.COUNT
7.SUM
8.AVERAGE
9.MINIMUM
10.MAXIMUM
11.EXIT
Enter ur choice::
1
ROLLNO.   NAME     MARKS
1        aa         55
2        bb	    70
3        cc         77
4        dd         60
5        ee         66
6        ff         99
7        gg         66
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.DISTINCT
6.COUNT
7.SUM
8.AVERAGE
9.MINIMUM
10.MAXIMUM
11.EXIT
Enter ur choice::
2
Enter Roll Number::
8
Enter name::
sonal
Enter Marks::
60
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.DISTINCT
6.COUNT
7.SUM
8.AVERAGE
9.MINIMUM
10.MAXIMUM
11.EXIT
Enter ur choice::
3
Enter Roll Number u want to update::
1
Enter name::
sid
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.DISTINCT
6.COUNT
7.SUM
8.AVERAGE
9.MINIMUM
10.MAXIMUM
11.EXIT
Enter ur choice::
1
ROLLNO.   NAME     MARKS
1        sid        55
2        sudhir     70
3        jitu       77
4        prem       60
5        shweta     66
6        priti      99
7        gg         66
8        sonal      60
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.DISTINCT
6.COUNT
7.SUM
8.AVERAGE
9.MINIMUM
10.MAXIMUM
11.EXIT
Enter ur choice::
4
Enter Roll Number u want to delete::
7
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.DISTINCT
6.COUNT
7.SUM
8.AVERAGE
9.MINIMUM
10.MAXIMUM
11.EXIT
Enter ur choice::
1
ROLLNO.   NAME     MARKS
1        sid        55
2        sudhir     70
3        jitu       77
4        prem       60
5        shweta     66
6        priti      99
8        sonal      60
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.DISTINCT
6.COUNT
7.SUM
8.AVERAGE
9.MINIMUM
10.MAXIMUM
11.EXIT
Enter ur choice::
5
MARKS
55
70
77
60
66
99
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.DISTINCT
6.COUNT
7.SUM
8.AVERAGE
9.MINIMUM
10.MAXIMUM
11.EXIT
Enter ur choice::
6
COUNT
7
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.DISTINCT
6.COUNT
7.SUM
8.AVERAGE
9.MINIMUM
10.MAXIMUM
11.EXIT
Enter ur choice::
7
SUM
487
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.DISTINCT
6.COUNT
7.SUM
8.AVERAGE
9.MINIMUM
10.MAXIMUM
11.EXIT
Enter ur choice::
8
AVERAGE
69
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.DISTINCT
6.COUNT
7.SUM
8.AVERAGE
9.MINIMUM
10.MAXIMUM
11.EXIT
Enter ur choice::
9
MIN_MARKS
55
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.DISTINCT
6.COUNT
7.SUM
8.AVERAGE
9.MINIMUM
10.MAXIMUM
11.EXIT
Enter ur choice::
10
MAX_MARKS
99
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.DISTINCT
6.COUNT
7.SUM
8.AVERAGE
9.MINIMUM
10.MAXIMUM
11.EXIT
Enter ur choice::
11
Program Executed Successfully
*/
