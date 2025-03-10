package test;

import java.sql.*;
import java.util.ArrayList;

public class ViewAllProductsDAO 
{
	public ArrayList<ProductBean> al = new ArrayList<ProductBean>();
	
	public ArrayList<ProductBean> getProducts()
	{
		try {
			Connection conn = DBConnection.getConn();
			PreparedStatement ps = conn.prepareStatement("select * from product70");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				ProductBean pb = new ProductBean();
				pb.setCode(rs.getInt(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getFloat(3));
				pb.setQty(rs.getInt(4));
				
				al.add(pb);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return al;
	}

}
