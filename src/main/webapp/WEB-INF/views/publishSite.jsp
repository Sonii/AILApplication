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
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/Bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/Bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/Bootstrap/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/Bootstrap/jquery/docs.min.js"></script> 
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
            <li class="active"><a href="publishSite">Publish WebSite</a></li>
            <li><a href="#contact">Contact</a></li>
            <li><a href="signin">Sign In</a></li>
          </ul>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
    </nav><!-- /.navbar -->

	<br><br><br><br><br>
	<f:form modelAttribute="site" method="post" action="savesite"> 
		<div class="input-group">
		  <span class="input-group-addon">Url</span>
		  <f:input type="text" class="form-control" placeholder="" path="url"/>
		</div>
		<br>
		<div class="input-group">
		  <span class="input-group-addon">Description</span>
		  <f:input type="text" class="form-control" placeholder="" path="description"/>
		</div>
		<br>
		<div class="input-group">
		  <span class="input-group-addon">Nom</span>
		  <f:input type="text" class="form-control" placeholder="" path="nom"/>
		</div>
		<br>
		<div class="input-group">
		  <span class="input-group-addon">Categorie</span>
		  <f:select name="selValue" class="selectpicker" path="idCat">
			   <option value="0"> ------ </option>
			   <option value="1">Mode</option>
			   <option value="2">Sport</option>
			   <option value="3">I-Tech</option>
			   <option value="4">Monde</option>
			   <option value="5">Sales</option>
			   <option value="6">Cinéma</option>
			   <option value="7">People</option>
			   <option value="8">Jeux</option>
		  </f:select>
		</div>
		<br>
		<br><br><br>
		<f:button type="submit" class="btn btn-primary btn-sm" id="btn">Save</f:button>
	</f:form>
	
</body>
</html>