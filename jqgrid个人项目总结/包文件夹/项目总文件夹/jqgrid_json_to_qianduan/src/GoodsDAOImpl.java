

//选中所选取的内容将此值发送给服务器。

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAOImpl implements DemoDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;//statement 的一个子类，查找更快 利用其可以动态的插入数据等等。

    public GoodsDAOImpl(Connection conn){
        this.conn=conn;
    }

    @Override
    public boolean doCreate(Goods demo) {
        boolean flag = false;
        String sql = "INSERT INTO goods(type,pay,name,text ) VALUES(?,?,?,?)";
        try {
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, demo.getType());
            this.pstmt.setDouble(2, demo.getPay());
            this.pstmt.setString(3, demo.getName());
            this.pstmt.setString(4, demo.getText());
            if(this.pstmt.executeUpdate()>0){ //更改的记录数是否不为0
                flag = true;
            }
            this.pstmt.close();
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Goods> doSearch(String keys) {
        // TODO Auto-generated method stub
        if (keys==null) {
            keys="";
        }
        String sql = "SELECT id,name,type,pay,text FROM goods "+keys;
        List<Goods> all = new ArrayList<Goods>();
        System.out.println(sql);
         try {              
                this.pstmt = this.conn.prepareStatement(sql);       
                ResultSet rs = this.pstmt.executeQuery();
                Goods demo = null;
                while(rs.next()){
                    demo = new Goods(rs.getInt("id"),rs.getString("type"),rs.getDouble("pay"),rs.getString("name"),rs.getString("text"));                   
                    all.add(demo);
                }
                this.pstmt.close();         
            } catch (SQLException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        return all;
    }

    @Override
    public boolean doDelete(int id) {
        boolean flag = false;
        String sql = "DELETE FROM goods WHERE id = ?";

        try {
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setInt(1, id);
            if(this.pstmt.executeUpdate()>0){
                flag = true;
            }
            this.pstmt.close();

        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean doChange(Goods demo) {
        boolean flag = false;
        String sql = "UPDATE goods SET type=?,pay=?,name=?,text=? WHERE id=?";
        try {
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setInt(5, demo.getId());
            this.pstmt.setString(1, demo.getType());
            this.pstmt.setDouble(2, demo.getPay());
            this.pstmt.setString(3, demo.getName());
            this.pstmt.setString(4, demo.getText());
            if(this.pstmt.executeUpdate()>0){
                flag = true;
            }
            this.pstmt.close();
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return flag;
    }


	

}
