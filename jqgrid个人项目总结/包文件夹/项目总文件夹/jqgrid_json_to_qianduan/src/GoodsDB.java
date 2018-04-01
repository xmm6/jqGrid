

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.rtf.RTFEditorKit;




public class GoodsDB {
	Connection conn = null;
	public Connection getConn() {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/goods","root","123");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return conn;
		
	}
	
	
	public void CloseReason(ResultSet rs,Statement stmt,Connection conn) {
		
		try {
			if(rs!=null) {
				rs.close();
				rs=null;
			}
			
			if(stmt!=null) {
				stmt.close();
				stmt=null;
			}
			if(conn!=null) {
				conn.close();
				conn=null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	/**
	 * 
	 * @param stmt
	 * @param conn
	 */
	public void CloseReason(Statement stmt,Connection conn) {
		
		try {
			
			
			if(stmt!=null) {
				stmt.close();
				stmt=null;
			}
			if(conn!=null) {
				conn.close();
				conn=null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	public void close(){
        if(conn != null){
            try {
                this.conn.close();
            } catch (SQLException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        }
    }
	

	

}
