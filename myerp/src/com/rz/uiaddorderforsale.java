package com.rz;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/uiaddorderforsale")
public class uiaddorderforsale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uiaddorderforsale() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public String getDateFormat(){
	    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	    return df.format(new Date());    
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取当前登录的人的id
		Map<String, Object> obj=(Map<String,Object>)request.getSession().getAttribute("currentuser");	
		String memberid=obj.get("id").toString();
		
		//接收前端ajax传递过来的三个参数
		String tbname=request.getParameter("tbname");
		String tbtel=request.getParameter("tbtel");
		String tbaddress=request.getParameter("tbaddress");
		//获取当前的sessionid
	    String sessionid=request.getSession().getId();
	    
	    //下单的过程就是把购物车里面的商品读取出来 假如到订单明细表中的过程 同时向订单的抬头表中加入订单的收货人信息
	    
	    String strSqlcarpros="select * from tbshoppingcarforsale where sessionid=? ";
	    DBHelper db=new DBHelper();
	    List<Object> params = new ArrayList<Object>();
	    params.add(sessionid);
	    List<Map<String,Object>> carprolist=null;
	    try {
	    	carprolist=db.executeQuery(strSqlcarpros,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    if(!(carprolist.size()>0))
	    {
	    	return;
	    }
	    	    
	    Date t=new Date();
	    SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	    SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String orderid=df1.format(t);
	    String createtime=df2.format(t);

	    
	    int sum=0;
	    //通过循环购物车查询出来的商品信息 把购物车里面的商品加入到订单明细表中
	    for (Map<String, Object> m : carprolist) {
	    	//累加商品的价格    每个商品的价格=单价*数量  然后把每个商品的总价累加起来 得到订单的总价
	    	sum=sum+Integer.parseInt(m.get("price").toString())*Integer.parseInt(m.get("procount").toString());
	    	
	    	String strSqlitems="insert into tbsaleorderitems (orderid,proid,proname,price,procount,imgurl) values (?,?,?,?,?,?)";
	    	List<Object> paramsitems = new ArrayList<Object>();
	    	paramsitems.add(orderid);
	    	paramsitems.add(m.get("proid"));
	    	paramsitems.add(m.get("proname"));
	    	paramsitems.add(m.get("price"));
	    	paramsitems.add(m.get("procount"));
	    	paramsitems.add(m.get("imgurl"));
	    	db.excuteSql(strSqlitems, paramsitems);
	    }
	    
	   
	    //把接收到的收货人信息插入到订单抬头表
	    String StrSql1="insert into tbsaleorderhead (orderid,sname,stel,saddress,sumprice,memberid,ctime) values (?,?,?,?,?,?,?)";
	    List<Object> params1 = new ArrayList<Object>();
	    params1.add(orderid);
	    params1.add(tbname);
	    params1.add(tbtel);
	    params1.add(tbaddress);
	    params1.add(sum);
	    params1.add(memberid);
	    params1.add(createtime);
	    db.excuteSql(StrSql1, params1);
	    
	    
	    //清空购物车
	    String strSqlClearCar="delete from tbshoppingcarforsale where sessionid=?";
	    db.excuteSql(strSqlClearCar, params);
	    
	    response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write("{\"msg\":\"ok\"}");
	}

}
