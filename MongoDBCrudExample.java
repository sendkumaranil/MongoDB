package com.mongodb.example;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoDBCrudExample {

	
	public static void main(String[] args) {

		MongoClient mongo=new MongoClient("localhost",27017);
		DB database=mongo.getDB("Cinema");
		
		DBCollection collection=database.getCollection("employee");
		
		Address address=new Address();
		address.setStreet("102");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setPincode("560068");
		
		Employee employee=new Employee();
		employee.setEmpid(1001);
		employee.setEmpname("Anil Verma");
		employee.setEmpaddress(address);
		
		BasicDBObject addrdocument=new BasicDBObject();
		addrdocument.put("street",address.getStreet());
		addrdocument.put("city", address.getCity());
		addrdocument.put("state", address.getState());
		addrdocument.put("pincode", address.getPincode());
		
		BasicDBObject empdocument=new BasicDBObject();
		empdocument.put("_id", employee.getEmpid());
		empdocument.put("empname", employee.getEmpname());
		empdocument.put("empaddress", addrdocument);
		
		//collection.insert(empdocument);
		
		DBCursor cursor = collection.find();
		while(cursor.hasNext()){
			System.out.println(cursor.next());
		}
				
		
	}

	private static User createUser() {
		User u = new User();
		u.setId(1007);
		u.setName("Harish");
		u.setEmployee(true);
		u.setRole("SE");
		u.setAge(33);
		return u;
	}
	
	private static DBObject createDBObject(User user) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
								
		docBuilder.append("_id", user.getId());
		docBuilder.append("name", user.getName());
		docBuilder.append("role", user.getRole());
		//docBuilder.append("isEmployee", user.isEmployee());
		return docBuilder.get();
	}
	
	
}
