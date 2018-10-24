/*
Assignment no:-B-18
Title:-Connectivity with MongoDB using any Java application.
*/
import com.mongodb.*;
import java.io.*;
import java.util.Scanner;

public class mongo{
   private static Scanner s;

public static void main( String args[] ){
      try{   
        // MongoClient mongoClient = new MongoClient();
 MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
         s = new Scanner(new InputStreamReader(System.in));
         DB db = mongoClient.getDB( "test" );
		 System.out.println("Connect to database successfully");
		 DBCollection coll=db.getCollection("employee");
		 int ch,y,v,i,r,z;
		 String q,j;
		 do
		 {
			 
			 	System.out.println("1.SELECT");
				System.out.println("2.INSERT");
				System.out.println("3.UPDATE");
				System.out.println("4.DELETE");
				System.out.println("5.SEARCH");
				System.out.println("6.COUNT");
				System.out.println("7.EXIT");
				System.out.println("Enter ur choice::");
				ch=s.nextInt();
				switch(ch)
				{
				case 1:
					 DBCursor cursor=coll.find();
					 try{
						 while(cursor.hasNext())
						 {
							 
							 System.out.println(cursor.next());
						 }
					 }finally{
						 cursor.close();
					 }
					 break;
					 
				case 2:
					System.out.println("How many records ou want to enter::");
					i=s.nextInt();
					for(y=0;y<i;y++){
					System.out.println("Enter Employee_id::");
					v=s.nextInt();
					System.out.println("Enter Employee_name::");
					j=s.next();
					System.out.println("Enter Department::");
					q=s.next();
					System.out.println("Enter Salary::");
					r=s.nextInt();
					BasicDBObject doc=new BasicDBObject("Employee_id",v)
					 .append("Employee_name",j)
					 .append("Department",q)
					 .append("Salary",r);
					 coll.insert(doc);
					}
					 System.out.println("Inserted successfully");
					 break;
					 
				case 3:
					System.out.println("Enter Employee_id u want to update::");
					z=s.nextInt();
					BasicDBObject searchQuery = new BasicDBObject().append("Employee_id", z);
					BasicDBObject newDocument = new BasicDBObject();
					System.out.println("Enter Employee_id::");
					v=s.nextInt();
					System.out.println("Enter Employee_name::");
					j=s.next();
					System.out.println("Enter Department::");
					q=s.next();
					System.out.println("Enter Salary::");
					r=s.nextInt();
					newDocument.put("Employee_id", v);
					newDocument.put("Employee_name", j);
					newDocument.put("Department", q);
					newDocument.put("Salary", r);
					coll.update(searchQuery, newDocument);
					System.out.println("Updated successfully");
					break;
					
				case 4:
					System.out.println("Enter Employee_id u want to remove::");
					z=s.nextInt();
					BasicDBObject query = new BasicDBObject();
					query.append("Employee_id",z);

					coll.remove(query);
				
				System.out.println("Removed successfully");
					break;
					
					
					case 5:
					System.out.println("Enter Employee_id u want to search::");
						z=s.nextInt();
					BasicDBObject SearchQuery = new BasicDBObject().append("Employee_id", z);
						 DBCursor x=coll.find(SearchQuery);
						 try{
							 while(x.hasNext())
							 {
								 
								 System.out.println(x.next());
							 }
						 }finally{
							 x.close();
						 }
						 break;
					case 6:
						
			System.out.println("Number of Records in Database is::"+coll.getCount());
				}			
		 }while(ch!=7);
		 
		 
		       }catch(Exception e){
	  }
   }
}

/*OUTPUT:-
Connect to database successfully
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.SEARCH
6.COUNT
7.EXIT
Enter ur choice::
1
{ "_id" : { "$oid" : "54279e4cc8647d7fcb0ed609"} , "Employee_id" : 1 , "Employee_name" : "aa" , "Department" : "Manager" , "Salary" : 10000}
{ "_id" : { "$oid" : "54279e86c8647d7fcb0ed60a"} , "Employee_id" : 2 , "Employee_name" : "bb" , "Department" : "Clerk" , "Salary" : 5000}
{ "_id" : { "$oid" : "54279efec8647d7fcb0ed60b"} , "Employee_id" : 3 , "Employee_name" : "cc" , "Department" : "peon" , "Salary" : 4000}
{ "_id" : { "$oid" : "5427a380e4b00e35e3c2a906"} , "Employee_id" : 4 , "Employee_name" : "dd" , "Department" : "dept_manager" , "Salary" : 8000}
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.SEARCH
6.COUNT
7.EXIT
Enter ur choice::
2
How many records ou want to enter::
1
Enter Employee_id::
5
Enter Employee_name::
ff
Enter Department::
CA
Enter Salary::
80000
Inserted successfully
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.SEARCH
6.COUNT
7.EXIT
Enter ur choice::
1
{ "_id" : { "$oid" : "54279e4cc8647d7fcb0ed609"} , "Employee_id" : 1 , "Employee_name" : "aa" , "Department" : "Manager" , "Salary" : 10000}
{ "_id" : { "$oid" : "54279e86c8647d7fcb0ed60a"} , "Employee_id" : 2 , "Employee_name" : "bb" , "Department" : "Clerk" , "Salary" : 5000}
{ "_id" : { "$oid" : "54279efec8647d7fcb0ed60b"} , "Employee_id" : 3 , "Employee_name" : "cc" , "Department" : "peon" , "Salary" : 4000}
{ "_id" : { "$oid" : "5427a380e4b00e35e3c2a906"} , "Employee_id" : 4 , "Employee_name" : "dd" , "Department" : "dept_manager" , "Salary" : 8000}
{ "_id" : { "$oid" : "5427a472e4b0dcd6b1f29bf2"} , "Employee_id" : 5 , "Employee_name" : "ff" , "Department" : "CA" , "Salary" : 80000}
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.SEARCH
6.COUNT
7.EXIT
Enter ur choice::
3
Enter Employee_id u want to update::
5
Enter Employee_id::
5
Enter Employee_name::
ff
Enter Department::
CA
Enter Salary::
100000
Updated successfully
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.SEARCH
6.COUNT
7.EXIT
Enter ur choice::
1
{ "_id" : { "$oid" : "54279e4cc8647d7fcb0ed609"} , "Employee_id" : 1 , "Employee_name" : "aa" , "Department" : "Manager" , "Salary" : 10000}
{ "_id" : { "$oid" : "54279e86c8647d7fcb0ed60a"} , "Employee_id" : 2 , "Employee_name" : "bb" , "Department" : "Clerk" , "Salary" : 5000}
{ "_id" : { "$oid" : "54279efec8647d7fcb0ed60b"} , "Employee_id" : 3 , "Employee_name" : "cc" , "Department" : "peon" , "Salary" : 4000}
{ "_id" : { "$oid" : "5427a380e4b00e35e3c2a906"} , "Employee_id" : 4 , "Employee_name" : "dd" , "Department" : "dept_manager" , "Salary" : 8000}
{ "_id" : { "$oid" : "5427a472e4b0dcd6b1f29bf2"} , "Employee_id" : 5 , "Employee_name" : "ff" , "Department" : "CA" , "Salary" : 100000}
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.SEARCH
6.COUNT
7.EXIT
Enter ur choice::
4
Enter Employee_id u want to remove::
5
Removed successfully
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.SEARCH
6.COUNT
7.EXIT
Enter ur choice::
1
{ "_id" : { "$oid" : "54279e4cc8647d7fcb0ed609"} , "Employee_id" : 1 , "Employee_name" : "aa" , "Department" : "Manager" , "Salary" : 10000}
{ "_id" : { "$oid" : "54279e86c8647d7fcb0ed60a"} , "Employee_id" : 2 , "Employee_name" : "bb" , "Department" : "Clerk" , "Salary" : 5000}
{ "_id" : { "$oid" : "54279efec8647d7fcb0ed60b"} , "Employee_id" : 3 , "Employee_name" : "cc" , "Department" : "peon" , "Salary" : 4000}
{ "_id" : { "$oid" : "5427a380e4b00e35e3c2a906"} , "Employee_id" : 4 , "Employee_name" : "dd" , "Department" : "dept_manager" , "Salary" : 8000}
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.SEARCH
6.COUNT
7.EXIT
Enter ur choice::
5
Enter Employee_id u want to search::
4
{ "_id" : { "$oid" : "5427a380e4b00e35e3c2a906"} , "Employee_id" : 4 , "Employee_name" : "dd" , "Department" : "dept_manager" , "Salary" : 8000}
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.SEARCH
6.COUNT
7.EXIT
Enter ur choice::
6
Number of Records in Database is::4
1.SELECT
2.INSERT
3.UPDATE
4.DELETE
5.SEARCH
6.COUNT
7.EXIT
Enter ur choice::
7
*/
