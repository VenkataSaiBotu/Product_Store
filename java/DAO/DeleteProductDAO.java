package test;

import java.sql.*;

public class DeleteProductDAO
{
	int k = 0;
	
	public int deleteProduct(ProductBean pb)
	{
		try {
			Connection conn = DBConnection.getConn();
			PreparedStatement ps = conn.prepareStatement("delete from product70 where code = ?");
			ps.setInt(1, pb.getCode());
			 k = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}

}
