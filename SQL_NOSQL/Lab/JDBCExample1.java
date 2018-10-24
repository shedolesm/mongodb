//STEP 1. Import required packages
import java.sql.*;

public class JDBCExample1 {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";  
   static final String DB_URL = "jdbc:odbc:jdbc";

   //  Database credentials
   static final String USER = "system";
   static final String PASS = "oracle";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
//Class.forName(driver).newInstance();
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();
      
      String sql = "CREATE TABLE REG" +
                   "(id INTEGER not NULL, " +
                   " first VARCHAR(255), " + 
                   " last VARCHAR(255), " + 
                   " age INTEGER, " + 
                   " PRIMARY KEY ( id ))"; 

      stmt.executeUpdate(sql);

	String sql1 = "INSERT INTO  REG VALUES" +
		   "(23,'Sit','Lonavala',21)";

	stmt.executeUpdate(sql1);

	String sql2="DELETE  FROM REG WHERE id = 23";
			
	stmt.executeUpdate(sql2);
      System.out.println("Created table in given database...");
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample