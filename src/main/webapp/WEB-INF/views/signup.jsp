  <%@ include file="/WEB-INF/views/header.jsp" %>
  
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