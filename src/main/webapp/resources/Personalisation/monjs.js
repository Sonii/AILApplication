function validateLogin(){
	
		var x = document.forms["login"]["email"].value;
		var atpos = x.indexOf("@");
	    var dotpos = x.lastIndexOf(".");
	    var formCheck = document.getElementById("emailLoginForm");
	    var span=null;
	    var message=null;
	    var ok = true;
	    
	    //debut email check 
	    formCheck.classList.remove("has-error");
    	message = document.getElementById("helpErrorEmail");
		if (message)
				message.parentNode.removeChild(message);
	    
	    if (atpos< 1 || dotpos<atpos+2 || dotpos+2>=x.length ) {
	    	
	       formCheck.classList.add("has-error");
	       span = document.createElement("span");
	       span.setAttribute("id", "helpErrorEmail");
	       span.appendChild( document.createTextNode("Please enter a valid E-Mail") );
	       span.className = span.className + "help-block";
	       span.style.display="table-caption";
	       formCheck.appendChild(span);
	       ok=false;
	    }
	    
	    var passChek =  document.getElementById("passLoginForm");
	    var y = document.forms["login"]["pass"].value;
	    passChek.classList.remove("has-error");
     	message = document.getElementById("helpErrorPass");
     	if (message)
     		message.parentNode.removeChild(message);
     		
	    if (y == null || y == "") {
	    	passChek.classList.add("has-error");
	    	   
	        span = document.createElement("span");
	        span.setAttribute("id", "helpErrorPass");
	        span.appendChild( document.createTextNode("Please enter a Password") );
	        span.className = span.className + "help-block";
	        span.style.display="table-caption";
	        passChek.appendChild(span);
	        ok=false;
	        
	     }
	    
	 return ok;
}

function validateSignup() {

    var span=null;
    var message=null;
    var ok = true;

    var pseudoChek =  document.getElementById("pseudoSignupForm");
	 pseudoChek.classList.remove("has-error");
  	 message = document.getElementById("helpErrorPseudo");
  	 if (message) message.parentNode.removeChild(message);
  	 
  	var pseudo = document.forms["signup"]["pseudo"].value;
  	
    if (pseudo == null || pseudo == "") {
    	pseudoChek.classList.add("has-error");
        span = document.createElement("span");
        span.setAttribute("id", "helpErrorPseudo");
        span.appendChild( document.createTextNode("Please enter a Pseudo") );
        span.className = span.className + "help-block";
        span.style.display="table-caption";
        pseudoChek.appendChild(span);
        ok=false;
        
     }

	
    var emailCheck = document.getElementById("emailSignupForm");
    emailCheck.classList.remove("has-error");
 	message = document.getElementById("helpErrorEmail");
    if (message) message.parentNode.removeChild(message);
    
    var email = document.forms["signup"]["email"].value;
	var atpos = email.indexOf("@");
    var dotpos = email.lastIndexOf(".");
    
    if (atpos< 1 || dotpos<atpos+2 || dotpos+2>=email.length ) {
    	
    	emailCheck.classList.add("has-error");
        span = document.createElement("span");
        span.setAttribute("id", "helpErrorEmail");
        span.appendChild( document.createTextNode("Please enter a valid E-Mail") );
        span.className = span.className + "help-block";
        span.style.display="table-caption";
        emailCheck.appendChild(span);
        ok=false;
        
     }

    
    var passChek =  document.getElementById("passSignupForm");
    passChek.classList.remove("has-error");
 	message = document.getElementById("helpErrorPass");
 	if (message) message.parentNode.removeChild(message);
    
  	var pass = document.forms["signup"]["password"].value;
  	
    if (pass == null || pass == "") {
    	passChek.classList.add("has-error");
        span = document.createElement("span");
        span.setAttribute("id", "helpErrorPass");
        span.appendChild( document.createTextNode("Please enter a Password") );
        span.className = span.className + "help-block";
        span.style.display="table-caption";
        passChek.appendChild(span);
        ok=false;
     }
    else if (pass.length < 6) {
    	passChek.classList.add("has-error");
        span = document.createElement("span");
        span.setAttribute("id", "helpErrorPass");
        span.appendChild( document.createTextNode("Has to be at least 6 charaters password") );
        span.className = span.className + "help-block";
        span.style.display="table-caption";
        passChek.appendChild(span);
        ok=false;
    }
    
    
    var confirmChek =  document.getElementById("confirmSignupForm");
    confirmChek.classList.remove("has-error");
 	message = document.getElementById("helpErrorConfirm");
 	if (message) message.parentNode.removeChild(message);
    
  	var confirm = document.forms["signup"]["confirmP"].value;
  	
    if (confirm == null || confirm == "") {
    	confirmChek.classList.add("has-error");
        span = document.createElement("span");
        span.setAttribute("id", "helpErrorConfirm");
        span.appendChild( document.createTextNode("Please confirm your Password") );
        span.className = span.className + "help-block";
        span.style.display="table-caption";
        confirmChek.appendChild(span);
        ok=false;
        
     }
    
    return ok;
}

function checkPass() {
	var pass = document.forms["signup"]["password"].value;
	var confirm = document.forms["signup"]["confirmP"].value;
	var button =  document.getElementById("btnCreateAccount");
	
	var confirmChek =  document.getElementById("confirmSignupForm");
	var message = document.getElementById("helpErrorConfirmSame");
	
	if (pass === confirm) {
	    confirmChek.classList.remove("has-error");
	 	if (message) message.parentNode.removeChild(message);
	 	button.disabled = false;
	}
	else {
		if (!message) { 
	    	confirmChek.classList.add("has-error");
	        span = document.createElement("span");
	        span.setAttribute("id", "helpErrorConfirmSame");
	        span.appendChild( document.createTextNode("Your Password doesn't match each other") );
	        span.className = span.className + "help-block";
	        span.style.display="table-caption";
	        confirmChek.appendChild(span);
	        button.disabled = true;
		}
	        
	}
	return;
}

function validatePublish(){
	
	    var span=null;
	    var message=null;
	    var ok = true;
	    
	    var urlChek =  document.getElementById("urlPublishForm");
	    urlChek.classList.remove("has-error");
	  	 message = document.getElementById("helpErrorUrl");
	  	 if (message) message.parentNode.removeChild(message);
	  	 
	  	var url = document.forms["publish"]["url"].value;
	  	
	    if (url == null || url == "") {
	    	urlChek.classList.add("has-error");
	        span = document.createElement("span");
	        span.setAttribute("id", "helpErrorUrl");
	        span.appendChild( document.createTextNode("Please enter a valid URL") );
	        span.className = span.className + "help-block";
	        span.style.display="table-caption";
	        urlChek.appendChild(span);
	        ok=false;
	        
	     }
	    
	   var nomChek =  document.getElementById("nomPublishForm");
	    nomChek.classList.remove("has-error");
	  	 message = document.getElementById("helpErrorNom");
	  	 if (message) message.parentNode.removeChild(message);
	  	 
	  	var nom = document.forms["publish"]["nom"].value;
	  	
	    if (nom == null || nom == "") {
	    	nomChek.classList.add("has-error");
	        span = document.createElement("span");
	        span.setAttribute("id", "helpErrorNom");
	        span.appendChild( document.createTextNode("Please enter a name for your site") );
	        span.className = span.className + "help-block";
	        span.style.display="table-caption";
	        nomChek.appendChild(span);
	        ok=false;
	        
	     }
	    
	    var descChek =  document.getElementById("descriptionPublishForm");
	    descChek.classList.remove("has-error");
	  	 message = document.getElementById("helpErrorDesc");
	  	 if (message) message.parentNode.removeChild(message);
	  	 
	  	var description = document.forms["publish"]["description"].value;
	  	
	    if (description == null || description == "") {
	    	descChek.classList.add("has-error");
	        span = document.createElement("span");
	        span.setAttribute("id", "helpErrorDesc");
	        span.appendChild( document.createTextNode("Please enter a description") );
	        span.className = span.className + "help-block";
	        span.style.display="table-caption";
	        descChek.appendChild(span);
	        ok=false;
	        
	     }
	    
	    var catChek =  document.getElementById("categoriePublishForm");
	    catChek.classList.remove("has-error");
	  	 message = document.getElementById("helpErrorCat");
	  	 if (message) message.parentNode.removeChild(message);
	  	 
	  	var idCat = document.forms["publish"]["idCat"].value;
	  	
	    if (idCat == null || idCat == 0 || idCat =="0") {
	    	catChek.classList.add("has-error");
	        span = document.createElement("span");
	        span.setAttribute("id", "helpErrorCat");
	        span.appendChild( document.createTextNode("Please enter a Categorie") );
	        span.className = span.className + "help-block";
	        span.style.display="table-caption";
	        catChek.appendChild(span);
	        ok=false;
	        
	     }
	return ok;
}