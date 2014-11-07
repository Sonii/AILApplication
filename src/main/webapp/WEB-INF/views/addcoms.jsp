 <%@ include file="/WEB-INF/views/header.jsp" %>

	<div id="logDiv" class="jumbotron">
		<h2>Laisser un commentaire</h2>
		<br><br>
	<f:form name="comForm" modelAttribute="com" method="post" action="addcoms?idS=${idS}" onsubmit="return validateCom()"> 
		<div id="contenuComForm" class="input-group input-group-lg form-group">
		  <span class="input-group-addon"></span>
		  <f:textarea rows="7" style="height:200px;" class="form-control" path="contenu" placeholder="Votre commentaire.."/>
		</div>
		<br>
		<div id="starComForm" class="input-group input-group-lg form-group">
		  <span class="input-group-addon"></span>
		  <f:select name="selValue" class="form-control selectpicker" path="etoile">
			   <option disabled selected="selected" value=""> Stars </option>
			   <option value="0">0</option>
			   <option value="1">1</option>
			   <option value="2">2</option>
			   <option value="3">3</option>
			   <option value="4">4</option>
			   <option value="5">5</option>
		  </f:select>
		</div>
		<br><br><br>
		<f:button type="submit" class="btn btn-primary btn-sm btnLogIn" id="btn">Envoyer mon avis</f:button>
	</f:form>
	</div>
	
</body>
</html>