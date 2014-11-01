function validateLogin() {
    var x = document.forms["login"]["email"].value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    var formCheck = document.getElementById("emailLoginForm");
    
    if (atpos< 1 || dotpos<atpos+2 || dotpos+2>=x.length ) {
    	
        formCheck.classList.add("has-error");
   
       var span = document.createElement("span");
       span.setAttribute("id", "helpErrorEmail");
       span.appendChild( document.createTextNode("Please enter a valid E-Mail") );
       span.className = span.className + "help-block";
       span.style.display="table-caption";
       var first = formCheck.firstChild;
       formCheck.appendChild(span);
       return false;
       
    }
    else {
    	formCheck.classList.remove("has-error");
    	var message = document.getElementById("helpErrorEmail");
    	message.parentNode.removeChild(message);
    }
    y = document.forms["login"]["pass"].value;
    if (y == null || y == "") {
        alert("Plz enter a password");
        return false;
    }
}