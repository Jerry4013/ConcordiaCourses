function suggest() {
  var room = document.getElementsByName("numberOfRooms")[3];
  var location = document.getElementsByName("location")[4];
  if (room.checked && location.checked) {
    document.getElementById("ExpertSuggestion").style.visibility = "visible";
  } else{
    document.getElementById("ExpertSuggestion").style.visibility = "hidden";
  }
}

function clock() {
    date = new Date;
    document.getElementById("clock").innerHTML = date;
    setTimeout('clock();','1000');
    return true;
}

function formatCheck() {
    var invalidHint = document.getElementById("invalidHint");
    if (invalidHint != null){
        invalidHint.parentNode.removeChild(invalidHint);
    }
    var name = document.getElementById("name").value;
    if (name === ""){
        document.getElementById("usernameHint").style.color = "red";
        document.getElementById("usernameStar").style.visibility = "visible";
        return false;
    }
    var password = document.getElementById("password").value;
    if (password === ""){
        document.getElementById("passwordHint").style.color = "red";
        document.getElementById("passwordStar").style.visibility = "visible";
        return false;
    }
    return checkName() && checkPassword();
}

function checkName() {
    var name = document.getElementById("name").value;
    if (name === ""){
        return false;
    }
    var nameCheck = name.search(/^[a-zA-Z0-9]+$/);
    if (nameCheck < 0 ){
        document.getElementById("usernameHint").style.color = "red";
        document.getElementById("usernameStar").style.visibility = "visible";
        return false;
    } else {
        document.getElementById("usernameHint").style.color = "black";
        document.getElementById("usernameStar").style.visibility = "hidden";
        return true;
    }
}

function checkPassword() {
    var password = document.getElementById("password").value;
    if (password === "")
        return false;
    var passwordCheck = password.search(/^(?!\d+$)(?![a-zA-Z]+$)[a-zA-Z0-9]{6,}$/);
    if (passwordCheck < 0){
        document.getElementById("passwordHint").style.color = "red";
        document.getElementById("passwordStar").style.visibility = "visible";
        return false;
    } else {
        document.getElementById("passwordHint").style.color = "black";
        document.getElementById("passwordStar").style.visibility = "hidden";
        return true;
    }
}

function login() {
    location.href = 'login.php';
}

function logout() {
    location.href = 'logout.php';
}




