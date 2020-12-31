package mygroup.myproject;

import java.io.File;
//import java.awt.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mygroup.myproject.model.Address;
import mygroup.myproject.model.Person;

/**
 * Hello world!
 *
 */
public class App 

{
	 public  List<Person>  reading() throws Exception {
		 List<Person> persons;
			ObjectMapper mapper = new ObjectMapper();
		 InputStream inputStream = new FileInputStream(new File("d:\\json\\personsOut.json.txt"));
	    	TypeReference<List<Person>>  typeReference = new TypeReference<List<Person>>() {};

			persons = mapper.readValue(inputStream, typeReference);
			inputStream.close();
			return persons;
	 }
	
	
	public void  Create()
	{
		
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Number of Data to be entered ");
	int n =sc.nextInt();
	sc.nextLine();
	
	
	
	try {
		

		List<Person> persons;
		ObjectMapper mapper = new ObjectMapper();
		
		 File tmpDir = new File("d:\\json\\personsOut.json.txt");
		    boolean exists = tmpDir.exists();
		   // if (exists) System.out.println("/var/tmp exists");
    	
    	if(exists)
    	{	    		 
	    	InputStream inputStream = new FileInputStream(new File("d:\\json\\personsOut.json.txt"));
	    	TypeReference<List<Person>>  typeReference = new TypeReference<List<Person>>() {};

    		persons = mapper.readValue(inputStream, typeReference);
    		inputStream.close();
    		
    	}
    	else
    	{
    		
    		 persons = new ArrayList<Person>();
    		
    	}
    		    	
    	
    	
    	int id;
    	String fName;
    	for(int i=1; i<=n; i++)
    	{
    		System.out.println("Enter-Name");
    		 fName= sc.nextLine();
    		
    		System.out.println("Enter-Id");

    		 id= sc.nextInt();
    		 sc.nextLine();
    		
    		int flag=0;
    		Person person = new Person();
    		
    		
	    	for(Person p:persons) {
    			if(p.getId()==id)
    			{
    				flag=1;
    			}
    			
    			
    		}
	    	
	    	if(flag==0)
	    	{
	    		person.setId(id);
	    		person.setfName(fName);
		    	persons.add(person);
	    	}
	    	else
	    	{
	    		System.out.println("----------ID - " +id+  "  ALREADY EXIST--------------" );
	    		System.out.println("Enter Unique Id");
	    	}

    	}
    	mapper.writerWithDefaultPrettyPrinter().writeValue(new File("d:\\json\\personsOut.json.txt"), persons);
    	
    	
	} 
	
	catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	///
	}
	public void read() throws Exception  {
		File tmpDir = new File("d:\\json\\personsOut.json.txt");
	    boolean exists = tmpDir.exists();
		List<Person> persons;
		//ObjectMapper mapper = new ObjectMapper();
		if(exists)
		{
//		InputStream inputStream = new FileInputStream(new File("d:\\json\\personsOut.json.txt"));
//    	TypeReference<List<Person>>  typeReference = new TypeReference<List<Person>>() {};
//
//		persons = mapper.readValue(inputStream, typeReference);
//		inputStream.close();
			persons = reading();
		
		for(Person p:persons) {
			
			System.out.println("Name " +p.getfName()+ "  ID - " +p.getId() );
		}
		}
		else
		{
			System.out.println("No DATA exists");
		}
	}
	public  void delete() throws Exception {
		
		int id;
		int index;
		int f=-1;
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter the id to be deleted");
		id=sc.nextInt();
		List<Person> persons;
		persons=reading();
		ObjectMapper mapper = new ObjectMapper();
		
		for (Person p:persons) {
			if(p.getId()==id)
{
				index=persons.indexOf(p);
				persons.remove(index);
				mapper.writerWithDefaultPrettyPrinter().writeValue(new File("d:\\json\\personsOut.json.txt"), persons);
				System.out.println("-------------ID " +id+ "  DELETED-------------" );
				break;
}
			
			
		}
		
		
	}
	
	public static void main( String[] args ) throws Exception
    {
       // System.out.println( "Hello World!" );
		int c;
    	
    	App a=new App();
    	
    	while(true) {
    		Scanner sc = new Scanner(System.in);
    		System.out.println("JSON DATA ENTRY");
    		System.out.println("1.Enter new Data");
    		System.out.println("2.Read");
    		System.out.println("3.delete");
    		System.out.println("4.Exit");
    		System.out.println("Enter Option");

        	 c =sc.nextInt();
        	 sc.nextLine();
        	
    	
    	switch(c) {
    	  case 1:
    	    a.Create();
    	    break;
    	  case 2:
    		  a.read();
    	    // code block
    	    break;
    	    
    	  case 3:
    		  a.delete();
    	    // code block
    	    break;
    	  case 4:
    		  System.out.println("-----------Exited-----------");
    		 System.exit(0);
    	    // code block
    	    break;
    	  default:
    	    // code block
    	}
    	
    	}
    	//sc.close();
    	
    	
    	
    	
    	
    }
	
	
	
   
}
