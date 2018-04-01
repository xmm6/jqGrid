<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<title>Insert title here</title>
 		<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery-ui.theme.min.css" />
        <link rel="stylesheet" type="text/css" href="css/ui.jqgrid.css" />
        <link rel="stylesheet" type="text/css" href="css/theme.css" />
        <script src="js/jquery-1.7.2.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="js/jquery-ui.js" type="text/javascript" charset="utf-8"></script>
        <script src="js/jquery.jqGrid.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="i18n/grid.locale-cn.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		
		
			
				$(function()
						{
						        $("#gridTable").jqGrid({
						                //url:'JSONData',//用于检索的url 
						                url:'demoServlet',
						                //用于添加、修改、删除的Servlet URL
					                    editurl:'demochangeServlet',//很重要!!!!!!!
						                datatype: "json",
						                height: 230,
						                mtype:"GET",
						                colNames:['编号','类型', '价钱', '名字', '备注'],
						                colModel:[
						                        {name:'id',
						                        index:'id',
						                        sorttype:"int",
						                        align:"center",
						                        key: true, //当从服务器端返回的数据中没有id时，将此作为唯一rowid使用只有一个列可以做这项设置。
									             //如果设置多于一个，那么只选取第一个，其他被忽略 (不太懂，需要问老师  )
						                        editable: false    
						                        },
						                        
						                        {name:'type',
						                        isdex:'type',
						                        align:"center",
						                       	editable: true, //是否可编辑
						                       	edittype:"text",
						                       	 //edittype: "select", //可以编辑的类型。可选值：text, textarea, select, checkbox, password, button, image and file.s
						                        	//editoptions: {
						                        	//value: "1:进货入库;2:退货出库 "
						                             //}
						                        },
						                        
						                        {name:'pay',
						                        index:'pay',
						                        sorttype:"double",
						                        align:"center",
						                        editable: true
						                        
						                        },
						                        
						                        {name:'name',
						                        index:'name',
						                        align:"center",
						                        editable: true
						                        },
						                        	
						                        {name:'text',
						                        index:'text',
						                        align:"center",
						                        editable: true,
						                        edittype: "textarea",
						                        editoptions: {
						                            rows: "2",
						                            cols: "10"
						                        	}
						                        }             					                     
						                ],
						                
						                    jsonReader : {
						                         root:"rows",
						                       	 page: "page",
						                         total: "total",
						                         records: "records",
						                         repeatitems: false,
						                     },
						                sortname:'id',
						                sortorder:'asc',
						                viewrecords:true,
						                rowNum:10,
						                rowList:[10,20,30],
						                //scroll:1; //滚动翻页的效果
						             	multiboxonly: true, //是否只能点击复选框多选
						                multiselect: true, //是否多选
						                altRows : true,//交替显示表格 
						                autowidth : true,
						                emptyrecords : "当前获取数据为空...",
						                loadtext : "数据加载中...",  
						                
						                
						                //viewrecords: true,//是否在浏览导航栏显示记录总数
				                       // rowNum: 10,//每页显示记录数
				                       // rowList: [10, 20, 30],//用于改变显示行数的下拉列表框的元素数组。
				                       // pager: pager_selector,//分页、按钮所在的浏览导航栏
				                       // altRows: true,//设置为交替行表格,默认为false
				                        //toppager: true,//是否在上面显示浏览导航栏
				                        multiselect: true,//是否多选
				                        //multikey: "ctrlKey",//是否只能用Ctrl按键多选
				                        multiboxonly: true,//是否只能点击复选框多选
				                        // subGrid : true, 
				                        //sortname:'id',//默认的排序列名
				                        //sortorder:'asc',//默认的排序方式（asc升序，desc降序）
				                       // caption: "采购退货单列表",//表名
				                       // autowidth: true//自动宽
						                
						                
						                 viewrecords: true,
						                //loadonce:true;
						                pager:"#gridPager",
						                caption: "jqGrid表格",
						                
						        });
						        //.navGrid('#gridPager',{edit:true,add:true,del:true,view:true});   
						       jQuery("#gridTable").navGrid('#gridPager', {  
                                    edit: true,  
                                    add: true,  
                                    del: true,  
                                    search: true,
                                    refresh: true 
                                },{},// edit options
                                {}, // add options
                                {}, // delete options
                                {multipleSearch:true})//调用搜索方法  
						})   

		
		</script>
</head>


  <body>
    
    <table id="gridTable"></table> 
    <div id="gridPager"></div>
    

  </body>

		
</html>