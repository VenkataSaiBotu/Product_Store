package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProductDAO 
{
	public int k = 0;
	
	public int updateProduct(ProductBean pb)
	{
		try {
			Connection conn = DBConnection.getConn();
			PreparedStatement ps = conn.prepareStatement("update product70 set price=?, qty=? where code=?");
			ps.setFloat(1, pb.getPrice());
			ps.setInt(2, pb.getQty());
			ps.setInt(3, pb.getCode());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}

}
