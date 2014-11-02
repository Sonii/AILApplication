<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page session="false" %>
<html>
<head>
	<title>Look-AT</title>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Bootstrap/CSS/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Bootstrap/CSS/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Bootstrap/CSS/Bootstrap-theme.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Bootstrap/CSS/bootstrap-theme.min.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Personalisation/stylesheet.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/Bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/Bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/Bootstrap/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/Bootstrap/jquery/docs.min.js"></script> 
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/Personalisation/monjs.js"></script>
</head>
<body>
	<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">LOOK - AT</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="home">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="publishSite">Publish WebSite</a></li>
            <li><a href="#contact">Contact</a></li>
            <li><a href="signin">Sign In</a></li>
          </ul>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->

    </nav><!-- /.navbar -->
     <c:if test="${created == true}">
		   <div class = "MonCompteCreer" > 
		   		<p class="monCompteCreer" style="position:initial;">Félicitation, votre compte a bien été créé ! Redirection..</p>
		   		<script language="javascript">
					setTimeout("window.location='signin'",4000);
		   		</script>
		   	</div>
	 </c:if>
	<br><br><br><br><br>
	<div id="logDiv" class="jumbotron">
	<h2>Sign Up</h2>
		<br><br>
		<c:if test="${present == true}">
		   <p class="monErreur">Email déjà utilisée. Re-essayer :<p>
		</c:if>
		<f:form name="signup" modelAttribute="user" method="post" action="saveuser" onsubmit="return validateSignup()"> 
		
		<div id="pseudoSignupForm" class="input-group input-group-lg form-group">
		  <span class="input-group-addon"></span>
		  <f:input  name="pseudo" path="pseudo" type="text" class="form-control" placeholder="Pseudo"/>
		</div>
		<br>
		<div id="emailSignupForm" class="input-group input-group-lg form-group">
		  <span class="input-group-addon"></span>
		  <f:input name="email" type="email" class="form-control" placeholder="email@example.com" path="email"/>
		</div>
		<br>
		<div  id="passSignupForm" class="input-group input-group-lg form-group">
		  <span class="input-group-addon"></span>
		  <f:input type="password" class="form-control" placeholder="Password" path="password"/>
		</div>
		<br>
		<div  id="confirmSignupForm" class="input-group input-group-lg form-group">
		  <span class="input-group-addon"></span>
		  <input  type="password" class="form-control" placeholder="Confirm Password" name="confirmP" onkeyup="checkPass()"/>
		</div>
		<br>
		<f:button type="submit" class="btn btn-primary btn-sm btnLogIn" id="btnCreateAccount" disabled="false">Create my Account</f:button>
	</f:form>
	</div>