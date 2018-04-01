
import java.util.List;


public interface DemoDAO {
    //添加方法
    public boolean doCreate(Goods demo);
    //查询方法
    public List<Goods> doSearch(String keys);
    //删除方法
    public boolean doDelete(int id);
    //修改方法
    public boolean doChange(Goods demo);

}