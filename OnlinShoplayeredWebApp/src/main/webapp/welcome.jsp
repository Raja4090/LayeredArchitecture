<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:useBean id="ob" class="com.phoenix.web.models.LoginBean" scope="request">
</jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:cyan;">

<h3 style="color:green;">Dear  <jsp:getProperty property="username" name="ob"/> ,enjoy your shopping</h3>
   <% 
   String username=request.getParameter("username");
   session.setAttribute("user",username);
   session.setMaxInactiveInterval(60);
   String encodeProductUrl=response.encodeURL("ProductAllServlet");
   %>
   <p style="color:red;">Session timeout: <%=session.getMaxInactiveInterval()%>  </p>
   <p>To enjoy shopping <a href="<%=encodeProductUrl%>"> Click Here</a></p>
   
</body>
</html>