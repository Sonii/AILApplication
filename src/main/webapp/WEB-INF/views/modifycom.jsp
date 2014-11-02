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
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Bootstrap/CSS/bootstrap-theme.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Bootstrap/CSS/bootstrap-theme.min.css">

	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/Bootstrap/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/Bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/Bootstrap/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Personalisation/stylesheet.css">
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
            <li class="active"><a href="signin">Sign In</a></li>
          </ul>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
    </nav><!-- /.navbar -->

	<br><br><br><br><br>
	<div id="logDiv" class="jumbotron">
		<h2>Laisser un commentaire</h2>
		<br><br>
	<f:form name="comForm" modelAttribute="commentaire" method="put" action="modifyCom?idC=${idC}" onsubmit="return validateCom()"> 
		<div id="contenuComForm" class="input-group input-group-lg form-group">
		  <span class="input-group-addon"></span>
		  <f:textarea rows="7" style="height:200px;" class="form-control" path="contenu" placeholder="Votre commentaire.."/>
		</div>
		<br>
		<div id="starComForm" class="input-group input-group-lg form-group">
		  <span class="input-group-addon"></span>

		  <f:select name="selValue" class="form-control selectpicker" path="etoile">
			   <option value="0" <c:if test="${commentaire.etoile == 0}"> selected </c:if> >0</option>
			   <option value="1"<c:if test="${commentaire.etoile == 1}"> selected </c:if>>1</option>
			   <option value="2"<c:if test="${commentaire.etoile == 2}"> selected </c:if>>2</option>
			   <option value="3"<c:if test="${commentaire.etoile == 3}"> selected </c:if>>3</option>
			   <option value="4"<c:if test="${commentaire.etoile == 4}"> selected </c:if>>4</option>
			   <option value="5"<c:if test="${commentaire.etoile == 5}"> selected </c:if>>5</option>
		  </f:select>
		</div>
		<br><br><br>
		<f:button type="submit" class="btn btn-primary btn-sm btnLogIn" id="btn">Envoyer mon avis</f:button>
	</f:form>
	</div>
	
</body>
</html>