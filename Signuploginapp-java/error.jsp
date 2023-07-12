<%
  String message = (String)request.getAttribute("message");  
%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Something Happened</title>
	<link href="https://fonts.googleapis.com/css?family=Montserrat:200,400,700" rel="stylesheet">
	<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div id="notfound">
		<div class="notfound"> 
			<div class="notfound-404">
				<h1>Oops!</h1>
				<%
				if(message == null){
					out.println("<h2>"+ response.getStatus() + " - No error expected</h2>");
				  } else {
					  out.println("<h2>" + response.getStatus() + " - " + message + "</h2>"); 
				  }
				%>
			</div>
			<a href="index.jsp">Redirect to login</a>
			<a href="register.jsp">Redirect to Register</a>
		</div>
	</div>
</body>
</html>

<!-- This templates was made by Colorlib (https://colorlib.com) -->
