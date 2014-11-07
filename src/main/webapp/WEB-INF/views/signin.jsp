  <%@ include file="/WEB-INF/views/header.jsp" %>
  
	<div id="logDiv" class="jumbotron">
		<h2>Sign In</h2>
		<br><br>
		<c:if test="${wrong == true}">
		   <p class="monErreur">Email ou Password incorrecte. Re-essayer :<p>
		</c:if>
		<form name="login" role="form" method="post" action="login" class="border-row" onsubmit="return validateLogin()">
		<div id="emailLoginForm" class="input-group input-group-lg form-group">
		  <span class="input-group-addon"></span>
		  <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email" name="email">
		</div>
		<br>
		<div id="passLoginForm" class="input-group input-group-lg form-group">
		  <span class="input-group-addon"></span>
		  <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="pass">
		</div>
		<br>
		  	<button type="submit" class="btn btn-primary btn-sm btnLogIn" id="btn">Log me in !</button>
		  	<br><br><br><br>
		</form>
		
		<p class="newAccountLink"> New on Look-At ? <a href="signup">Create an account</a>
	</div>
	
</body>
</html>