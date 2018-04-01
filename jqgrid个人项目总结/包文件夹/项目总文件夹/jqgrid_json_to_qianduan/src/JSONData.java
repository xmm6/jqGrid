

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class JSONData
 */
@WebServlet("/JSONData")
public class JSONData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
							response.setContentType("text/json; charset=utf-8");
							PrintWriter out = response.getWriter();
							
							String page = request.getParameter("page"); // 取得当前页数,注意这是jqgrid自身的参数  
					        String rows = request.getParameter("rows"); // 取得每页显示行数，,注意这是jqgrid自身的参数  
					        String sidx = request.getParameter("sidx"); //取得排序字段
					        String sord = request.getParameter("sord");//排序方式asc、desc 
					      //  String rowNum=request.getParameter("rowNum");
					        
		                    try { 
		                     
		                      Class.forName("com.mysql.jdbc.Driver");            
		                      Connection connect=DriverManager.getConnection("jdbc:mysql://localhost/goods","root","123");
		                      Statement stmt = connect.createStatement(); //创建Statement对象
		                      String sql;
		                       sql = "SELECT * FROM goods";
		                      ResultSet rs = stmt.executeQuery(sql);
		                      JSONArray jsonarray = new JSONArray();  
		                      JSONObject jsonobj = new JSONObject(); 
		                       // 展开结果集数据库
		                      int i=0;
		                        while(rs.next()){
		                          // 通过字段检索
		                          jsonobj.put("id", rs.getString("id"));  
		                          jsonobj.put("type", rs.getString("type"));  
		                          jsonobj.put("pay", rs.getString("pay"));                           
		                          jsonobj.put("name", rs.getString("name")); 
		                          jsonobj.put("text", rs.getString("text")); 
		                          i++;
		                          jsonarray.add(jsonobj);             
		                        }
		                        int total=(i%Integer.valueOf(rows)==0)?i/Integer.valueOf(rows):(i/Integer.valueOf(rows)+1);
		                       JSONObject jsonObject = new JSONObject();
		                       jsonObject.put("page", page);//当前页数
		                       jsonObject.put("total", total-1);//总页数
		                       jsonObject.put("records", i); //记录数
		                       jsonObject.put("rows", jsonarray);
		                     //  "userdata":{"amount":3220,"tax":342,"total":3564,"name":"Totals:"}
		                       JSONObject userdata = new JSONObject();
		                       userdata.put("amount", 3220);
		                       userdata.put("tax", 342);
		                       userdata.put("total", 3564);
		                       userdata.put("name", "Totals:");
		                       jsonObject.put("userdata", userdata);
		                       
		                     // 输出数据
		                       
		                        out.print(jsonObject);
		                     // 完成后关闭
		                        rs.close();   
		                        stmt.close();   
		                     connect.close();                  
		                    }catch (Exception e) { 
		                        out.print("get data error!"); 
		                         e.printStackTrace(); }
		                 
		                 
		                 
		                          
		//		// TODO Auto-generated method stub
//		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		// 定义返回的数据类型：json，使用了json-lib
//        JSONObject jsonObj = new JSONObject();
//        // 根据jqGrid对JSON的数据格式要求给jsonObj赋值
//        jsonObj.put("page", 1);                // 当前页
//        jsonObj.put("total", 1);        // 总页数
//        jsonObj.put("records", 4);        // 总记录数
//        // 定义rows，存放数据
//        JSONArray rows = new JSONArray();
//        // 放入4条数据
//        for(int i=0;i<4;i++)
//        {
//                // 存放一条记录的对象
//                JSONObject cell = new JSONObject();
//                cell.put("id", i);
//                if(i%2==0)
//                {
//                        cell.put("userName", "polaris");
//                        cell.put("gender", "女");
//                }
//                else
//                {
//                        cell.put("userName", "徐新华");
//                        cell.put("gender", "男");
//                }
//                cell.put("email", "polaris@gmail.com");
//                cell.put("QQ", "772"+i+"1837"+i);
//                cell.put("mobilePhone", "132"+i+"1837"+i+"3"+i);
//                cell.put("birthday", "198"+i+"-10-"+"1"+i);
//                // 将该记录放入rows中
//                rows.add(cell);
//        }
//        // 将rows放入json对象中
//        jsonObj.put("rows", rows);
//        // 自控制台打印输出，以检验json对象生成是否正确
//        System.out.println("要返回的json对象：\n" + jsonObj.toString());
//        // 设置字符编码
//        response.setCharacterEncoding("UTF-8");
//        // 返回json对象（通过PrintWriter输出）
//        response.getWriter().print(jsonObj);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
//		 String jsondata = "{\"page\":\"1\"," +
//			        "      \"total\":2," +
//			        "      \"records\":\"13\"," +
//			        "      \"rows\":" +
//			        "          [" +
//			        "            {" +
//			        "              \"id\":\"13\"," +
//			        "              \"cell\":" +
//			        "                  [\"13\",\"2007-10-06\",\"Client 3\",\"1000.00\",\"0.00\",\"1000.00\",null]" +
//			        "            }," +
//			        "            {" +
//			        "              \"id\":\"12\"," +
//			        "              \"cell\":" +
//			        "                  [\"12\",\"2007-10-06\",\"Client 2\",\"700.00\",\"140.00\",\"840.00\",null]" +
//			        "            }," +
//			        "            {" +
//			        "              \"id\":\"11\"," +
//			        "              \"cell\":" +
//			        "                  [\"11\",\"2007-10-06\",\"Client 1\",\"600.00\",\"120.00\",\"720.00\",null]" +
//			        "            }," +
//			        "            {" +
//			        "              \"id\":\"10\"," +
//			        "              \"cell\":" +
//			        "                  [\"10\",\"2007-10-06\",\"Client 2\",\"100.00\",\"20.00\",\"120.00\",null]" +
//			        "            }," +
//			        "            {" +
//			        "              \"id\":\"9\"," +
//			        "              \"cell\":" +
//			        "                  [\"9\",\"2007-10-06\",\"Client 1\",\"200.00\",\"40.00\",\"240.00\",null]" +
//			        "            }," +
//			        "            {" +
//			        "              \"id\":\"8\"," +
//			        "              \"cell\":" +
//			        "                  [\"8\",\"2007-10-06\",\"Client 3\",\"200.00\",\"0.00\",\"200.00\",null]" +
//			        "            }," +
//			        "            {" +
//			        "              \"id\":\"7\"," +
//			        "              \"cell\":" +
//			        "                  [\"7\",\"2007-10-05\",\"Client 2\",\"120.00\",\"12.00\",\"134.00\",null]" +
//			        "            }," +
//			        "            {" +
//			        "              \"id\":\"6\"," +
//			        "              \"cell\":" +
//			        "                  [\"6\",\"2007-10-05\",\"Client 1\",\"50.00\",\"10.00\",\"60.00\",\"\"]" +
//			        "            }," +
//			        "            {" +
//			        "              \"id\":\"5\"," +
//			        "              \"cell\":" +
//			        "                  [\"5\",\"2007-10-05\",\"Client 3\",\"100.00\",\"0.00\",\"100.00\",\"no tax at all\"]" +
//			        "            }," +
//			        "            {" +
//			        "              \"id\":\"4\"," +
//			        "              \"cell\":" +
//			        "                  [\"4\",\"2007-10-04\",\"Client 3\",\"150.00\",\"0.00\",\"150.00\",\"no tax\"]" +
//			        "            }" +
//			        "          ]," +
//			        "      \"userdata\":{\"amount\":3220,\"tax\":342,\"total\":3564,\"name\":\"Totals:\"}" +
////			        "    }";
//		JSONObject	json = new JSONObject();
//		json.put("id","1");
//		json.put("invdate","张三");
//		json.put("name","123456");
//		json.put("amount","1");
//		json.put("tax","张三");
//		json.put("total","123456");
//		json.put("note","1");
//		System.out.println(json.toString());
//		response.getWriter().println(json);
	}

}
