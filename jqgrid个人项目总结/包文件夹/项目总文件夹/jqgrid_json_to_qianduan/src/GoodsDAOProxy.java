

import java.util.List;
public class GoodsDAOProxy implements DemoDAO {
    private GoodsDB dbc = null;
    private DemoDAO ddao = null;

    public GoodsDAOProxy(){
        this.dbc = new GoodsDB();
        this.ddao = new GoodsDAOImpl(this.dbc.getConn());
    }

    @Override
    public boolean doCreate(Goods demo) {
        boolean flag = false;
        flag = this.ddao.doCreate(demo);
        this.dbc.close();
        return flag;
    }

    @Override
    public List<Goods> doSearch(String keys) {
        // TODO Auto-generated method stub
        List<Goods> all = null;
        all = this.ddao.doSearch(keys);
        this.dbc.close();
        return all;
    }

    @Override
    public boolean doDelete(int id) {
        boolean flag = false;
        flag = this.ddao.doDelete(id);
        this.dbc.close();
        return flag;
    }

    @Override
    public boolean doChange(Goods demo) {
        boolean flag = false;
        flag = this.ddao.doChange(demo);
        this.dbc.close();
        return flag;
    }

}