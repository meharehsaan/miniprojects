<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String type = (String) session.getAttribute("type");  
  if(type == null){
    response.sendRedirect("index.jsp");
  } else {
    String fname = (String) session.getAttribute("fname");  
    String lname = (String) session.getAttribute("lname");  
	%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
    <title>Dashboard</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap"rel="stylesheet"/>
    <link rel="stylesheet" href="css/login.css" />
  </head>

  <body>
    <div class="background">
      <div class="shape"></div>
      <div class="shape"></div>
    </div>
    <form action="signout" method="get">
      	<h3><% out.print("<span>" + fname + " " + lname + "</span>"); %> </h3>
        <% 
        if(type.equals("1")) {
            type = "Student";
          } else if (type.equals("0")){
            type = "Admin";		
          } else {
              type = "Anonymous";
          }
          %>
        <label>Congratulations <% out.print("<span>" + type + "</span>"); %> </label>

        <label>You are successfully logged in.</label>
        <label>Your Quote </label>
        <label>“Life is like a camera. Capture the good times, develop from the negatives, and if things don’t work out, just take another shot.”</label>
        <button type="submit">Sign Out</button>

        <!-- <div class="social">
          </div> -->
    </form>
  </body>
</html>
<% } %>     
<!-- Ending else -->