<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <% String path = request.getContextPath(); %>
        <title>Insert title here</title>
    </head>
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/jQuery/pagination.css">
    <script type="text/javascript">
        var path = "<%=path%>";
    </script>
    <script src="<%=path%>/js/jQuery/jquery-1.6.2.js"></script>
	<script src="<%=path%>/js/jQuery/jquery.cookie-min.js"></script>
	<script src="<%=path%>/js/jQuery/pagination.js"></script>
    <script src="<%=path%>/js/point/client/test.js"></script>
    <body>
    	<div id="loadimg">Loading....</div>
		<div id="mainpagediv"></div>
    </body>
</html>