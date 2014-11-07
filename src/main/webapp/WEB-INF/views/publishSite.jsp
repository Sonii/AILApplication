  <%@ include file="/WEB-INF/views/header.jsp" %>
  
	<div id="logDiv" class="jumbotron">
	<h2>Publier un nouveau site :</h2>
		<br><br>
		<f:form name="publish" modelAttribute="site" method="post" action="savesite"  onsubmit="return validatePublish()">  
			<div id="urlPublishForm" class="input-group input-group-lg form-group">
			  <span class="input-group-addon"></span>
			  <f:input  type="url" class="form-control" placeholder="URL" path="url"/>
			</div>
			<br>
			<div id="nomPublishForm" class="input-group input-group-lg form-group">
			  <span class="input-group-addon"></span>
			  <f:input  type="text" class="form-control" placeholder="Nom" path="nom"/>
			</div>
			<br>
			<div id="descriptionPublishForm" class="input-group input-group-lg form-group">
			  <span class="input-group-addon"></span>
			  <f:textarea  rows="7" style="height:200px;" class="form-control"  placeholder="une description" path="description"/>
			</div>
			<br>
			<div id="categoriePublishForm" class="input-group input-group-lg form-group">
			  <span class="input-group-addon"></span>
			  <f:select  name="selValue" class="form-control selectpicker" path="idCat">
				   <option disabled selected="selected" value="0"> Catégorie </option>
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
			<br>
			<f:button type="submit" class="btn btn-primary btn-sm btnLogIn" id="btnCreateAccount">Publier ce site</f:button>
		</f:form>
	</div>
</body>
</html>