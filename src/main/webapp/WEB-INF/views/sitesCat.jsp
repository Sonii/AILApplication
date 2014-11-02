<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Bootstrap/CSS/bootstrap-theme.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Bootstrap/CSS/bootstrap-theme.min.css">

	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/Bootstrap/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/Bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/Bootstrap/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Personalisation/stylesheet.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/Personalisation/monjs.js"></script>
</head>
<body>
<script> 
	 	function OpenInNewTab(url) {
		  var win = window.open(url, '_blank');
		  win.focus();
		}
</script>
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

	<br><br><br><br><br>
	<div class="row row-offcanvas row-offcanvas-right">

	<c:forEach items="${liste}" var="site"  varStatus="loop">
	    <div class="container">

	      <!-- Main component for a primary marketing message or call to action -->
	      <div style="margin-bottom: 0px;" class="jumbotron siteDisplay">
	      	<div>
	        <h2 class="monTitre"><c:out value="#${loop.index + 1}" /> - ${site.nom}</h2>
	   		<p class="monClick"> Vue : <span class="badge">${site.nbClick}</span></p>
	   		 </div>
	        <p>"${site.description}"</p>
	          <p class = "monButton"><a class="btn btn-default" role="button" onclick="OpenInNewTab('${site.url}')" >LOOK-AT &raquo;</a> </p>
	       
	       <div>
	       	 <p  style="display:inline;"> Publié Par : <c:out value="${users[loop.index]}"/></p>

	       	<a style="display:inline;position: relative;float:right;" href="avis?idC=${site.id}"> Notifications <span class="glyphicon glyphicon-flag"></span></a>
	       	<a style="display:inline;position: relative;float:right;right: 15px;" href="addcomf?idS=${site.id}"> Add Comment <span class="glyphicon glyphicon-plus"></span></a>
	       	<a  style="display:inline;position: relative;float:right;right: 30px;;" href="deleteSite?idS=${site.id}"> Delete WebSite <span class="glyphicon glyphicon-trash"></span></a>
	      </div>
	      </div>
		<br><br><br>
	    </div> <!-- /container -->
	</c:forEach>
	</div>
</body>
</html>