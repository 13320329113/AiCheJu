package com.rz;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class proinout
 */
@WebServlet("/repairadd")
public class repairadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public repairadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				request.setCharacterEncoding("utf-8");
				String tbproid=request.getParameter("tbproid");
				String tbpronum=request.getParameter("tbpronum");
				String tbproname=request.getParameter("tbproname");
				String tbpropath=request.getParameter("tbpropath");
				String tbproimg=request.getParameter("tbproimg");				
				String tbmaster=request.getParameter("tbmaster");		
				String tbmastertel=request.getParameter("tbmastertel");
				String tberror=request.getParameter("tberror");
				Date time1=new Date();
			    SimpleDateFormat df1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			    String ctime=df1.format(time1);
				String strSql1=" insert into tbrepair (proid,pronum,proname,protype,proimgurl,tbmaster,tbmastertel,tberror,ctime) values (?,?,?,?,?,?,?,?,?)";
				List<Object> params = new ArrayList<Object>();
				
				params.add(tbproid);
				params.add(tbpronum);	
				params.add(tbproname);				
				params.add(tbpropath);				
				params.add(tbproimg);				
				params.add(tbmaster);
				params.add(tbmastertel);
				params.add(tberror);
				params.add(ctime);	
				
				DBHelper Dal=new DBHelper();		
				Dal.excuteSql(strSql1, params);	
				
				
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("<font color='green'>保存成功</font>");
				response.setHeader("Refresh", "3;URL="+request.getContextPath()+"/admin/repairadd.jsp");	
	}

}
