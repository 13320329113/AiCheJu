package com.rz;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class proinout
 */
@WebServlet("/newsadd")
public class newsadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newsadd() {
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
				Object currentmember=request.getSession().getAttribute("currentuser");
		        if(currentmember == null||currentmember == ""||currentmember.equals("")){
		        	try{	
		        		HttpServletResponse res = (HttpServletResponse) response;
					    response.reset();   
					    request.setCharacterEncoding("UTF-8");
					    response.setContentType("text/html; charset=UTF-8");
					    ServletOutputStream servletOutputStream  = res.getOutputStream();
					    servletOutputStream.println("<script language=javascript>window.parent.location.href=\"./admin/login.jsp\"</script>");
					
					  }catch (Exception e) {
					}
		        	return;
		        }        
		
				request.setCharacterEncoding("utf-8");
				String title=request.getParameter("title");
				String author=((Map<String,Object>)request.getSession().getAttribute("currentuser")).get("truename").toString(); 
				String contents=request.getParameter("contents");
				String typeid=request.getParameter("typeid");				
				Date time1=new Date();
			    SimpleDateFormat df1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			    String ctime=df1.format(time1);
				String strSql1=" insert into tbnews (title,author,contents,typeid,createtime) values (?,?,?,?,?)";
				List<Object> params = new ArrayList<Object>();
				
				params.add(title);
				params.add(author);					
				params.add(contents);				
				params.add(typeid);				
				params.add(ctime);	
				
				DBHelper Dal=new DBHelper();		
				Dal.excuteSql(strSql1, params);	
				
				
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("<font color='green'>发布成功</font>");
				response.setHeader("Refresh", "3;URL="+request.getContextPath()+"/admin/newsadd.jsp");	
	}

}
