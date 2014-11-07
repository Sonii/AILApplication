  <%@ include file="/WEB-INF/views/header.jsp" %>
    <div id="logDiv" class="jumbotron">
		<h2>Confirm</h2>
		<br><br>
		<c:if test="${wrong == true}">
		   <p class="monErreur">Password incorrecte. Re-essayer :<p>
		</c:if>
	    <form name="passForm" role="form" method="POST" action="confirmDelete?idS=${id}" onsubmit="return validatePass()">
		    <div  id="confirmpassForm" class="input-group input-group-lg form-group">
				 <span class="input-group-addon"></span>
				 <input type="password" class="form-control" placeholder="Confirm Password" name="confirmP"/>
			</div>
			<br>
			<button type="submit" class="btn btn-primary btn-sm btnLogIn" id="btn">Confirm</button>
		</form>
	</div>
</body>
</html>