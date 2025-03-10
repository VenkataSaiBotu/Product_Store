package test;

import java.sql.*;

public class CustomerRegisterDAO 
{
	int k = 0;
	
	public int registerCustomer(CustomerBean cb)
	{
		try {
			Connection conn = DBConnection.getConn();
			PreparedStatement ps = conn.prepareStatement("insert into customers70 values(?,?,?,?,?)");
			ps.setLong(1, cb.getPhno());
			ps.setString(2, cb.getCid());
			ps.setString(3, cb.getCname());
			ps.setString(4, cb.getCity());
			ps.setString(5, cb.getMid());	
			
			k = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}

}
