  <%@ include file="/WEB-INF/views/header.jsp" %>

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
	        <form method="put" action="addclick">
	        <input type="hidden" name="siteId" value="<c:out value='${site.id}'/>" >
	        <p class = "monButton">
	        <button style="position:relative; bottom:50px;left:10px;" type="submit" class="btn btn-primary btn-sm btnLogIn" id="btn" onclick="OpenInNewTab('${site.url}')">LOOK-AT &raquo;</button>
	        </p>
	        </form>

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