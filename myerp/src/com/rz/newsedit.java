package com.rz;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

/**
 * Servlet implementation class proedit
 */
@WebServlet("/newsedit")
public class newsedit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newsedit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String id=request.getParameter("id"); 
		 DBHelper Dal=new DBHelper();
		 String strSql=" select * from tbnwes where id=? "; 
		 Map<String, Object> objbyid = null;
		 List<Object> params = new ArrayList<Object>();
		 params.add(id);
		 objbyid=Dal.getSingleObject(strSql, params);
		 request.setAttribute("objbyid", objbyid);
		 request.getRequestDispatcher("../newsedit").forward(request, response);
	}
	
	public String getDateFormat(){
		 SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		 return df.format(new Date());    
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id="";
		String title="";
		String author="";
		String contents="";
		String createtime="";
		String typid="";
		
		

        
/*********************************保存数据开始*************************************/
         DBHelper Dal=new DBHelper();
		 String strSql=" update tbnews set title=?,contents=?,typid=? where id=?"; 
		 List<Object> params = new ArrayList<Object>();
		 params.add(title);
		 
		 params.add(contents);	  
		 	
		 params.add(typid);
		
		
		 params.add(id);
		 Dal.excuteSql(strSql, params);
		 
/*********************************保存数据结束*************************************/
        response.setCharacterEncoding("utf-8");
   		response.setContentType("text/html;charset=utf-8");
   		response.getWriter().write("<font color='green'>保存成功，3秒后跳转!</font>");
   		response.setHeader("Refresh", "3;URL="+request.getContextPath()+"/newsedit?id="+id);
	
	}

}
