function validateLogin(){
	
		var x = document.forms["login"]["email"].value;
		var atpos = x.indexOf("@");
	    var dotpos = x.lastIndexOf(".");
	    var formCheck = document.getElementById("emailLoginForm");
	    var span=null;
	    var first=null;
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
	       first = formCheck.firstChild;
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
	        first = passChek.firstChild;
	        passChek.appendChild(span);
	        ok=false;
	        
	     }
	    
	 return ok;
}

function validateSignup() {
	
	var x = document.forms["login"]["email"].value;
	var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    var formCheck = document.getElementById("emailSignupForm");
    var span=null;
    var first=null;
    var message=null;
    var ok = true;
    var passChek =  document.getElementById("passSignupForm");
    var confirmCheck = document.getElementById("confirmSignupForm");
    var pseudoChek =  document.getElementById("pseudoSignupForm");
    
    var z = document.forms["signup"]["pseudo"].value;
    
	 pseudoChek.classList.remove("has-error");
  	 message = document.getElementById("helpErrorPseudo");
  	 if (message) message.parentNode.removeChild(message);
  	
    if (z == null || z == "") {
    	pseudoChek.classList.add("has-error");
        span = document.createElement("span");
        span.setAttribute("id", "helpErrorPseudo");
        span.appendChild( document.createTextNode("Please enter a Pseudo") );
        span.className = span.className + "help-block";
        span.style.display="table-caption";
        first = pseudoChek.firstChild;
        pseudoChek.appendChild(span);
        ok=false;
        
     }

    
    formCheck.classList.remove("has-error");
 	message = document.getElementById("helpErrorEmail");
    if (message) message.parentNode.removeChild(message);
    if (atpos< 1 || dotpos<atpos+2 || dotpos+2>=x.length ) {
    	
        formCheck.classList.add("has-error");
    
        span = document.createElement("span");
        span.setAttribute("id", "helpErrorEmail");
        span.appendChild( document.createTextNode("Please enter a valid E-Mail") );
        span.className = span.className + "help-block";
        span.style.display="table-caption";
        first = formCheck.firstChild;
        formCheck.appendChild(span);
        ok=false;
        
     }
  
    
    var y = document.forms["signup"]["pass"].value;
    
    passChek.classList.remove("has-error");
 	message = document.getElementById("helpErrorPass");
    if (message) message.parentNode.removeChild(message);
    
    if (y == null || y == "") {
    	
    	passChek.classList.add("has-error");
        span = document.createElement("span");
        span.setAttribute("id", "helpErrorPass");
        span.appendChild( document.createTextNode("Please enter a Password") );
        span.className = span.className + "help-block";
        span.style.display="table-caption";
        first = passChek.firstChild;
        passChek.appendChild(span);
        ok = false;
        
     }

    

    
    var w = document.forms["signup"]["confirm"].value;
    
    confirmChek.classList.remove("has-error");
 	message = document.getElementById("helpErrorConfirm");
    if (message) message.parentNode.removeChild(message);
    
    if (w == null || w == "") {
    	confirmChek.classList.add("has-error");
    	   
        span = document.createElement("span");
        span.setAttribute("id", "helpErrorConfirm");
        span.appendChild( document.createTextNode("Please confirm your Password") );
        span.className = span.className + "help-block";
        span.style.display="table-caption";
        first = confirmChek.firstChild;
        confirmChek.appendChild(span);
        ok=false;
        
     }
    
    return ok;
}