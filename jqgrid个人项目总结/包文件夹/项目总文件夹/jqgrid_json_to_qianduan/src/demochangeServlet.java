

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/demochangeServlet")
public class demochangeServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * The doGet method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to get.
     * 
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        boolean flag = false;
      
        String oper =request.getParameter("oper");
     
        switch (oper) {
            case "del":
                {
                    String[] ids = request.getParameter("id").split(",");
                    for (int i = 0; i < ids.length; i++) {
                        int id =Integer.valueOf(ids[i]);
                        flag=Factory.getDemoDAOInstance().doDelete(id);
                    }
                    System.out.println("删除了");
                }           
                break;
            case "add":
                {
                	String  type = String.valueOf(request.getParameter("type"));
                    Double pay = Double.valueOf(request.getParameter("pay"));
                    String name = request.getParameter("name");
                    String text = request.getParameter("text");
                    Goods demo = new Goods(-1,type,pay,name,text);//-1代表一个无用的值，不传自增长的值
                    flag = Factory.getDemoDAOInstance().doCreate(demo);                         
                }
                break;
            case "edit":
                {
                    int id = Integer.valueOf(request.getParameter("id"));
                    String type = String.valueOf(request.getParameter("type"));
                    Double pay = Double.valueOf(request.getParameter("pay"));
                    String name = request.getParameter("name");
                    String text = request.getParameter("text");
                    Goods demo = new Goods(id,type,pay,name,text);
                    flag = Factory.getDemoDAOInstance().doChange(demo);                         
                }
                break;

            default:
                break;
        }
        System.out.println(flag);
    }

    /**
     * The doPost method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to post.
     * 
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doGet(request, response);
    }

}