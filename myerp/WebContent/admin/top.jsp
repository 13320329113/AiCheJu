<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="java.util.regex.*" %>
<%
List<Map<String, Object>> list = (List<Map<String, Object>>)request.getAttribute("list");
%>

<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>爱车居进销存管理系统V1.0</title>
		<link rel="stylesheet" type="text/css" href="css/comm.css" />

		<style type="text/css">
			.linear {
				width: 100%;
				height: 100px;
				background-color: white;
			}
			
			.nav {
				width: 100%;
				height: 34px;
				list-style: none;
				background-color: white;
				border-bottom: solid 1px #0044C0;
			}
			
			.nav li {
				float: left;
				height: 30px;
				position: relative;
				background-color: #e1384c;
				margin-right: 3px;
				margin-top: 2px;
				border-top-left-radius: 0px;
				border-top-right-radius: 15px;
				background-image: url(./img/aixin.png);
				background-repeat: no-repeat;
				background-position: 1px 6px;
			}
			
			.nav li a {
				text-decoration: none;
				padding: 0 20px;
				line-height: 30px;
				color: white;
				display: block;
			}
			
			.timeanduser {
				width:200px;
				text-align: right;
				height: 60px;
				position: absolute;
				right:5px;
				top: 20px;
				font-size: 12px;
				padding-right: 10px;
				padding-top: 10px;
				color: black;
				border-radius: 5px;
				background-color:antiquewhite;
				border-bottom-right-radius: 0;
				border-top-right-radius: 0;
				box-shadow: 0 0 10px 1px #fff;
				line-height: 22px;
				border:2px solid #a1a1a1;
			}
			
			#currentuser{
				/*background-image: url(img/logout.png);*/
				background-repeat: no-repeat;
				background-size:18px auto;
				background-position:right 5px;
				padding-right: 30px;
                position:relative;
			}
		    #logout {
		    
            }
             #logout  img{
		        width:20px;
                height:20px;
                position:absolute;
                right:0px;
                top:1px;
            }
            .company{
            	position: absolute;
            	left: 430px;
            }
		</style>

	</head>

	<body>
		
			<div class="linear">
				<div class="company">
				<img src="./img/logo1.0.jpg" style="height:100px;" />
				</div>
				<div class="timeanduser">
					<p id="timecontainer"></p>
					<p id="currentuser">当前用户: 【<%= ((Map<String,Object>)session.getAttribute("currentuser")).get("truename")%>】<a href="logout" target="_top" id="logout" title="退出系统"><img src="./img/logout5.png"></a> </p>
				</div>
			</div>
			<hr/>
			<ul class="nav">
				<%for (Map<String, Object> m : list) { %>
                <li><a href="./left?id=<%=m.get("id")%>" target="left"><%=m.get("MenuName")%></a></li>
                <% } %>
           		<li> <a href="./logout" target="_top" >退出系统</a></li>
			</ul>
			
		

		<script type="text/javascript">
		    t();

		    function t() {
		        var obj = document.getElementById('timecontainer');
		        var now = new Date();
		        var yy = now.getFullYear();
		        var mm = now.getMonth() + 1;
		        var dd = now.getDate();
		        var hhh = now.getHours();
		        var mmm = now.getMinutes();
		        var sss = now.getSeconds();
		        if (mm < 10) mm = "0" + mm;
		        if (dd < 10) dd = "0" + dd;
		        if (hhh < 10) hhh = "0" + hhh;
		        if (mmm < 10) mmm = "0" + mmm;
		        if (sss < 10) sss = "0" + sss;
		        var week;
		        if (now.getDay() == 0) week = "星期日";
		        if (now.getDay() == 1) week = "星期一";
		        if (now.getDay() == 2) week = "星期二";
		        if (now.getDay() == 3) week = "星期三";
		        if (now.getDay() == 4) week = "星期四";
		        if (now.getDay() == 5) week = "星期五";
		        if (now.getDay() == 6) week = "星期六";
		        var time = yy + "年" + mm + "月" + dd + "日 " + hhh + ":" + mmm + ":" + sss + " " + week;
		        obj.innerHTML = time;
		        setTimeout('t()', 1000);
		    }
		</script>
	</body>

</html>