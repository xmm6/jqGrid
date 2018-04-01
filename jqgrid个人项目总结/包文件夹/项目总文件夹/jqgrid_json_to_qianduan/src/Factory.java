

public class Factory {
    public static DemoDAO getDemoDAOInstance(){
        return new GoodsDAOProxy();
    }
}