<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="java.util.regex.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="./css/comm.css"/>
	</head>
<body>
<%
List<Map<String, Object>> list = (List<Map<String, Object>>)request.getAttribute("list");
String pagestr = (String)request.getAttribute("pagestr");
%>
<p class="path">当前位置:/爱车居进销存系统/报修管理/明细查询</p>  <span class="rightbox"><input type="text" id="tbkey"/><input type="button" id="btnsearch" value="查询"/></span></div>


<table border="0" cellspacing="0" cellpadding="0" class="tb tblist">
       <tr>
       	 <td style="width:50px;">ID</td><td style="width:150px;">产品图片</td><td style="width:150px;">商品名称</td><td style="width:150px;">类别</td><td style="width:150px;">编号</td><td style="width:50px;">车主姓名</td><td style="width:150px;">车主电话</td><td style="width:150px;">车辆故障</td><td style="width:120px;">时间</td>   
       </tr>
       <%for (Map<String, Object> m : list) { %>
        <tr>
       		<td><%=m.get("id")%></td>
       		<td><img src="./upload/<%=m.get("proimgurl")%>" style="width:120px;height:60px;padding:5px 0px;"></td>
       		<td><%=m.get("proname")%></td>
       		<td class="typename" title="<%=m.get("protype")%>"><%=m.get("protype")%></td>
       		<td><%=m.get("pronum")%></td>
       		<td><%=m.get("tbmaster")%></td>
       		<td><%=m.get("tbmastertel")%></td>      
       		<td><%=m.get("tberror")%></td>     
       		<td><%=m.get("ctime")%></td>
       </tr>
    	<% } %>
    </table>
    
    <div class="pager">
       		<%=pagestr%>
    </div>
    
    <script src="./js/jquery-1.11.0.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
    var key = localStorage.getItem("keyprosearch");
    $("#tbkey").val(key);
    $("#btnsearch").click(function () {
        var key = $("#tbkey").val();
        localStorage.setItem("keyprosearch", key);
        location.href = "repairlistforsearch?key=" + key+"&classid=0";	;
    });
    </script>

</body>
</html>