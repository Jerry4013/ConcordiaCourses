// pswd_chk.js
//   An example of input password checking, using the submit 
//   event
     
// The event handler function for password checking
function chkPasswords() { 
// retrieve the passwords entered
  var init = document.getElementById("initial");
  var sec = document.getElementById("second");
	
	// If the 1st password is empty
  if (init.value == "") {
    alert("You did not enter a password \n" +
          "Please enter one now");
    return false;
  }
	
	// if the two passwords are not the same
  if (init.value != sec.value) {
    alert("The two passwords you entered are not the same \n" +
          "Please re-enter both now");
    return false;
  } else
    return true;
}
