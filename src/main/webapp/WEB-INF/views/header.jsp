<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="fr">

<head>
	<title>Look-AT</title>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	
	<link href="<%=request.getContextPath()%>/resources/Personalisation/star-rating/css/star-rating.min.css" media="all" rel="stylesheet" type="text/css" />
	<script src="<%=request.getContextPath()%>/resources/Personalisation/star-rating/js/star-rating.min.js" type="text/javascript"></script>
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
          <a class="navbar-brand" href="home">LOOK - AT</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="home">Category</a></li>
            <li><a href="publishSite">Add new Site</a></li>
			<c:choose> 
			  <c:when test="${email == null || empty email}">
			    <li><a href="signin">Sign In</a></li>
			  </c:when>
			  <c:otherwise>
			    <li><a href="signin">Sign Out</a></li>
			  </c:otherwise>
		
			</c:choose>

			
		
          </ul>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
    </nav><!-- /.navbar -->
    
    <br>
    <br>
    <br>
    <br>