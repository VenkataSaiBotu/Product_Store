package test;

import java.sql.*;

public class CustomerLoginDAO 
{
	public CustomerBean cb = new CustomerBean();
	
	public CustomerBean customerLogin(String phno)
	{
		try {
			Connection conn = DBConnection.getConn();
			PreparedStatement ps = conn.prepareStatement("select * from customers70 where phno = ?");
			ps.setLong(1, Long.parseLong(phno));
			ResultSet rs = ps.executeQuery();

			if(rs.next())
			{
				cb.setPhno(rs.getLong(1));
				cb.setCid(rs.getString(2));
				cb.setCname(rs.getString(3));
				cb.setCity(rs.getString(4));
				cb.setMid(rs.getString(5));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cb;
	}
	

}
