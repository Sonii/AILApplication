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
            <li><a href="publishSite">Publish WebSite</a></li>
            <li><a href="#contact">Contact</a></li>
            <li><a href="signin">Sign In</a></li>
          </ul>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
    </nav><!-- /.navbar -->

	<br><br><br><br><br>
	<div class="row row-offcanvas row-offcanvas-right">
	<c:forEach items="${liste}" var="commentaire" varStatus="loop">
        <div class="col-xs-12 col-sm-9">
          <div class="row">
          <br><br><br><br>
          <p> Publi� Par : <c:out value="${users[loop.index]}"/></p>
          <br><br>
            <div class="col-xs-6 col-lg-4">
              <p>${commentaire.contenu}</p>
              <br><br>
              <c:forEach var="i" begin="1" end="${commentaire.etoile}">
   				<span class="glyphicon glyphicon-star"></span>
			  </c:forEach>
			  <c:forEach var="j" begin="${commentaire.etoile}" end="4">
	   			 <span class="glyphicon glyphicon-star-empty"></span>
			  </c:forEach>
            </div><!--/.col-xs-6.col-lg-4-->
            </div>
        </div><!--/.col-xs-12.col-sm-9-->
	</c:forEach>
	</div>
</body>
</html>