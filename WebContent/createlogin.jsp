<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<style type="text/css">
#content {
	position: relative;
}

#login {
	position: relative;
	top: 100px;
}

.align-right {
	text-align: right;
}

table {
	border: 1px solid gray;
	padding: 20px;
	background-color: #CCCCFF;
}

.login-error {
	font-size: 16px;
	font-color: bold;
	font-weight: red;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<center>

		<div id="createlogin" />

		<form method="post"
			action="<%=response.encodeUrl(request.getContextPath() + "/Controller?action=createlogin")%>"/>
		<input type="hidden" name="action" value="createlogin" />
		<table>
			<tr>
				<td class="align-right">Email Address:</td>
				<td><input type="text" name="email"
					value="<%= request.getAttribute("email")%>">
			<tr>
				<td class="align-right">Password:</td>
				<td><input type="password" name="password"
					value="<%=request.getAttribute("password")%>">
			<tr>
				<td class="align-right">Repeat Password:</td>
				<td><input type="password" name="repeatPassword"
					value="<%=request.getAttribute("repeatPassword")%>">
			
			<tr>
				<td class="align-right" colspan=2></td>
				<td><input type="submit" value="log in">
		</table>

		<p class="createlogin-error"><%=request.getAttribute("message")%></p>
		</form>
		</div>
	</center>


</body>
</html>