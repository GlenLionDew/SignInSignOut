<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="<%= response.encodeURL(request.getContextPath()+"/Controller?action=dologin") %>" method="post">
Enter some text: <input type="text" name="someText" />
<input type="hidden" name="postdologin"value="dologin" />
<input type="submit" value="submit" />
</form>




</body>
</html>