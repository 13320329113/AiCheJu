<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="java.util.regex.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

<style>
.nm{
	position: absolute;
	top: 100px;
	left: 300px;
	padding:10px 40px; 
	background:#dddddd;
	width:570px;
	height: 300px;
	border-radius:10px;
	box-shadow: 10px 10px 5px #888888;
			 
	}	
.nd{
 	position: absolute;
	top: 270px;
	left: 290px;
		
	}	
p{
	color: black;
	font-style:oblique;
	color: brown;
	font-weight: bold;
	}
#btnopt{
	cursor:pointer;
	height: 40px;
	width: 85px;
	border-radius:20px;
		
	}	
		
</style>
</head>
<body>
<%
Map<String, Object> objbyid = (Map<String, Object>)request.getAttribute("objbyid");
%>
		
		<div class="nm" id="nm">
			
	        <p class="title" style="text-align:center">
	         	<%=objbyid.get("title")%>
	        </p>
	        <p class="author" style="text-align:center"><%=objbyid.get("author")%></p>
	        <p class="contents" style="text-indent:2em"><%=objbyid.get("contents")%></p>
			<div class="nd" id="nd">
				
				<input type="button" name="btnopt" id="btnopt" value="关闭" onclick="aa();" />
				
			</div>
		</div>
		<script type="text/javascript">
			
			
		
        function aa()
			{
				document.getElementById("nm").style.display="none";
				
			}
					
			    
           
		
		</script>
	</body>
</html>