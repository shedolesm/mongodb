package tea4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class Basicmongo {
public static void main(String args[]){
	try{
		MongoClient mc=new MongoClient("localhost",27017);
		DB db=mc.getDB("ad");
		System.out.println("Connect to database successfully");
		DBCollection coll = db.getCollection("ad");
        System.out.println("Collection created successfully");
        
		while(true){
		System.out.println("\n******************************");
		System.out.println("choose any one Option:");
		System.out.println("1.Insert\n2.Update\n3.Read\n4.Delete\n5.Exit");
		System.out.println("******************************\n");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));		
		String ch1=br.readLine();
		int ch=Integer.parseInt(ch1);
		
		
		switch(ch){
		case 1:
			BasicDBObject table=new BasicDBObject();
			System.out.println("Enter the Roll No.:");
			String roll=br.readLine();
			System.out.println("Enter the Name:");
			String name=br.readLine();
			System.out.println("Enter the Address:");
			String addr=br.readLine();
			table.put("Roll_no", ""+roll+"");
			table.put("Name", ""+name+"");
	        table.put("Address", ""+addr+"");
	        coll.insert(table);
	        break;
		case 2:
			System.out.println("Criteria:");
			System.out.println("Enter the columnName:");
			String ccn=br.readLine();
			System.out.println("Enter the Value:");
			String cv=br.readLine();
			System.out.println("\n\nSet:");
			System.out.println("Enter the columnName:");
			String scn=br.readLine();
			System.out.println("Enter the value:");
			String sv=br.readLine();
			BasicDBObject searchQuery=new BasicDBObject().append(""+ccn+"" ,  ""+cv+"");
			BasicDBObject updateQuery=new BasicDBObject();
			updateQuery.append("$set", new BasicDBObject().append(""+scn+"",""+sv+""));
			
			coll.update(searchQuery,updateQuery);
			break;
		case 3:
			DBCursor cursor=coll.find();
			try{
				while(cursor.hasNext()){
					System.out.println(cursor.next());
				}
			}
			finally{
				cursor.close();
			}
			break;
		case 4:
			System.out.println("Enter Column detail which is to be deleted:");
			System.out.println("columnName:");
			String dcn=br.readLine();
			System.out.println("Value:");
			String dv=br.readLine();
			BasicDBObject doc=new BasicDBObject();
			doc.put(""+dcn+"" , ""+dv+"");
			coll.remove(doc);
			
			break;
		case 5:
			System.exit(0);
		}
		}
	}
	catch(Exception e){
		JOptionPane.showMessageDialog(null,e);
	}
	
}
}
	

