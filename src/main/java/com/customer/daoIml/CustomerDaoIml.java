package com.customer.daoIml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.customer.dao.CustomerDao;
import com.customer.module.Customer;

public class CustomerDaoIml implements CustomerDao{
	

	private static Connection connection =null;
	private static PreparedStatement prepareStatement =null;
	private ResultSet res =null;
	private Statement statement =null;
	private final static String INSERT_QUERY = "insert into `customer_details`(`CustomerId` ,`First_Name`, `Last_Name`, `Street`, `Address`, `City`, `State`,`Email`, `Phone_Number`)values(?,?,?,?,?,?,?,?,?)";
	private final static String SELECT_QUERY ="select * from `customer_details`  where `CustomerId`=?";
	private final static String DELETE_QUERY ="delete from `customer_details` where `CustomerId`=? ";
	private final static String UPDATE_QUERY ="update `customer_details` set `First_Name`=?, `Last_Name`=?, `Street`=?, `Address`=?, `City`=?,`State`=?, `Email`=?, `Phone_Number`=? where `CustomerId`=?";
	private final static String SELECT_ALL_QUERY ="select * from `customer_details`";
	
	
	public CustomerDaoIml() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","root");			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public int addCustomer(Customer customer) {
		try {
			 prepareStatement = connection.prepareStatement(INSERT_QUERY);
			 prepareStatement.setString(1, customer.getuuid());
			 prepareStatement.setString(2, customer.getFirst_name());
			 prepareStatement.setString(3, customer.getLast_name());
			 prepareStatement.setString(4, customer.getStreet());
			 prepareStatement.setString(5, customer.getAddress());
			 prepareStatement.setString(6, customer.getCity());
			 prepareStatement.setString(7, customer.getState());
			 prepareStatement.setString(8, customer.getEmail());
			 prepareStatement.setString(9, customer.getPhone());
			 
			return prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return 0;
		
	}

	@Override
	public int updateCustomer(Customer customer) {
		try {
			 prepareStatement = connection.prepareStatement(UPDATE_QUERY);
			 prepareStatement.setString(1, customer.getFirst_name());
			 prepareStatement.setString(2, customer.getLast_name());
			 prepareStatement.setString(3, customer.getStreet());
			 prepareStatement.setString(4, customer.getAddress());
			 prepareStatement.setString(5, customer.getCity());
			 prepareStatement.setString(6,customer.getState() );
			 prepareStatement.setString(7, customer.getEmail());
			 prepareStatement.setString(8, customer.getPhone());
			 prepareStatement.setString(9, customer.getuuid());
			 
			return prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
		return 0;
	}

	@Override
	public List<Customer> getAllCustomer() {
		
ArrayList<Customer> customerList = new ArrayList();
		
		try {
			 statement = connection.createStatement();
			  res = statement.executeQuery(SELECT_ALL_QUERY);
			  while(res.next()) {
				  String uuid=  res.getString("CustomerId");
					String fname=res.getString("First_Name");
					String lname=res.getString("Last_Name");
					String street=res.getString("Street");
					String address=res.getString("Address");
					String city =res.getString("City");
					String state = res.getString("State");
					String email=res.getString("Email");
					String phoneNumber=res.getString("Phone_Number");
					
					Customer customer =    new Customer(uuid,fname, lname, street, address, city,state, email, phoneNumber);
					customerList.add(customer);
					
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}

	@Override
	public Customer getCustomerById(String customerId) {
		try {
			
			
			 prepareStatement = connection.prepareStatement(SELECT_QUERY);
			 prepareStatement.setString(1, customerId);
			  res = prepareStatement.executeQuery();
			  while(res.next()) {
				  String uuid=  res.getString("CustomerId");
					String fname=res.getString("First_Name");
					String lname=res.getString("Last_Name");
					String street=res.getString("Street");
					String address=res.getString("Address");
					String city =res.getString("City");
					String state = res.getString("State");
					String email=res.getString("Email");
					String phoneNumber=res.getString("Phone_Number");
					
					return new Customer(uuid, fname, lname, street, address, city,state, email, phoneNumber);
					
				  
				  
				  
				  
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
		
		
		
		return null;
	}

	@Override
	public int deleteCustomer(String customerId) {
		
		try {
			 prepareStatement = connection.prepareStatement(DELETE_QUERY);
			 prepareStatement.setString(1,customerId);
			   return prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		
	}
		return 0;

}

	@Override
	public int getAllCustomerCount() {
		int i =0;
		try {
			prepareStatement =connection.prepareStatement("select count(*) from customer_details");
			i= prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return i;
	}

	@Override
	public List<Customer> getCustomerByFirstName(String firstName) {
          ArrayList<Customer> list = new ArrayList();
		try {
			
			
			 prepareStatement = connection.prepareStatement("select * from customer_details where `First_Name`=?");
			 prepareStatement.setString(1, firstName.trim());
			  res = prepareStatement.executeQuery();
			  while(res.next()) {
				    String uuid=  res.getString("CustomerId");
				    String fname=res.getString("First_Name");
					String lname=res.getString("Last_Name");
					String street=res.getString("Street");
					String address=res.getString("Address");
					String city =res.getString("City");
					String state = res.getString("State");
					String email=res.getString("Email");
					String phoneNumber=res.getString("Phone_Number");
					
					
					Customer customer = new Customer(uuid, fname, lname, street, address, city,state, email, phoneNumber);
				  
				  
				  list.add(customer);
				  
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
		
		return list;
	}

	@Override
	public List<Customer> getCustomerByEmail(String email) {
		
		 ArrayList<Customer> list = new ArrayList();
			try {
				
				
				 prepareStatement = connection.prepareStatement("select * from customer_details where `Email`=?");
				 prepareStatement.setString(1, email);
				  res = prepareStatement.executeQuery();
				  while(res.next()) {
					  String uuid=  res.getString("CustomerId");
						String fname=res.getString("First_Name");
						String lname=res.getString("Last_Name");
						String street=res.getString("Street");
						String address=res.getString("Address");
						String city =res.getString("City");
						String state = res.getString("State");
						String email1=res.getString("Email");
						String phoneNumber=res.getString("Phone_Number");
						
						
//						Customer customer = new Customer(uuid, fname, lname, street, address, city,state, email1, phoneNumber);
					  Customer customer = new Customer(uuid, fname, lname, street, address, city, state, email1, phoneNumber);
					  
					  list.add(customer);
					  
				  }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
					
			
			return list;
		
		
	}

	@Override
	public List<Customer> getCustomerByCity(String city) {
		ArrayList<Customer> list = new ArrayList();
		try {
			
			
			 prepareStatement = connection.prepareStatement("select * from customer_details where `City`=?");
			 prepareStatement.setString(1, city);
			  res = prepareStatement.executeQuery();
			  while(res.next()) {
				  String uuid=  res.getString("CustomerId");
					String fname=res.getString("First_Name");
					String lname=res.getString("Last_Name");
					String street=res.getString("Street");
					String address=res.getString("Address");
					String city1 =res.getString("City");
					String state = res.getString("state");
					String email1=res.getString("Email");
					String phoneNumber=res.getString("Phone_Number");
					
					
					Customer customer = new Customer(uuid, fname, lname, street, address, city1, state,email1, phoneNumber);
				  
				  
				  list.add(customer);
				  
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
		
		return list;
	}

	@Override
	public List<Customer> getCustomerByPhone(String phoneNumber) {
		ArrayList<Customer> list = new ArrayList();
		try {
			
			
			 prepareStatement = connection.prepareStatement("select * from customer_details where `Phone_Number`=?");
			 prepareStatement.setString(1, phoneNumber);
			  res = prepareStatement.executeQuery();
			  while(res.next()) {
				  String customerId=  res.getString("CustomerId");
					String fname=res.getString("First_Name");
					String lname=res.getString("Last_Name");
					String street=res.getString("Street");
					String address=res.getString("Address");
					String city =res.getString("City");
					String state = res.getString("State");
					String email1=res.getString("Email");
					String phoneNumber1=res.getString("Phone_Number");
					
					
					Customer customer = new Customer(customerId, fname, lname, street, address, city,state, email1, phoneNumber1);
				  
				  
				  list.add(customer);
				  
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
		
		return list;
	
	}
	public List<Customer> getCustomersWithPagination(int start, int recordsPerPage) {
	    List<Customer> list = new ArrayList<>();
	    
	    try {
	        prepareStatement = connection.prepareStatement("SELECT * FROM customer_details LIMIT ?, ?");
	        prepareStatement.setInt(1, start);
	        prepareStatement.setInt(2, recordsPerPage);
	        res = prepareStatement.executeQuery();
	        
	        while (res.next()) {

	        	String uuid=  res.getString("CustomerId");
				String fname=res.getString("First_Name");
				String lname=res.getString("Last_Name");
				String street=res.getString("Street");
				String address=res.getString("Address");
				String city =res.getString("City");
				String state = res.getString("state");
				String email1=res.getString("Email");
				String phoneNumber1=res.getString("Phone_Number");
				
				
				Customer customer = new Customer(uuid, fname, lname, street, address, city, state,email1, phoneNumber1);
			  
			  
			  list.add(customer);
			  
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return list;
	}

	
	
}
