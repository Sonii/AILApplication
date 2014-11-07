  <%@ include file="/WEB-INF/views/header.jsp" %>
  
	<div class="row row-offcanvas row-offcanvas-right">
	
	<c:forEach items="${liste}" var="commentaire" varStatus="loop">
	  <div class="container">
         <div class="jumbotron siteDisplay">
         <p style="display:inline;font-weight: bold;" ><c:out value="${users[loop.index]}"/> :</p>
          <c:forEach var="j" begin="${commentaire.etoile}" end="4">
	   			 <span style="float:right;" class="glyphicon glyphicon-star-empty"></span>
			  </c:forEach>
               <c:forEach var="i" begin="1" end="${commentaire.etoile}">
   				<span style="float:right;" class="glyphicon glyphicon-star"></span>
			  </c:forEach>
			 
          <p>"${commentaire.contenu}"</p>

            <div style="text-align:right;"> 
            <a href="modifyCommentf?idC=${commentaire.id}"> Modify <span class="glyphicon glyphicon-pencil"></span></a>
	      <a href="deleteComment?idC=${commentaire.id}"> Delete <span class="glyphicon glyphicon-trash"></span></a> 
	      </div>
        </div>
        </div>
	</c:forEach>
	</div>
</body>
</html>