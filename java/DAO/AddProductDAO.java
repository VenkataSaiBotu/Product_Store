package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddProductDAO 
{
	public int k = 0;
	
	public int addProduct(ProductBean pb)
	{
		try {
			Connection conn = DBConnection.getConn();
			PreparedStatement ps = conn.prepareStatement("insert into product70 values(?,?,?,?)");
			ps.setInt(1, pb.getCode());
			ps.setString(2, pb.getName());
			ps.setFloat(3, pb.getPrice());
			ps.setInt(4, pb.getQty());
			
			k = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed at uploading product");
		}
		return k;
	}

}
