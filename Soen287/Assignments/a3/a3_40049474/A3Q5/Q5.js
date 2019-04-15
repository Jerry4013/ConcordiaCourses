function suggest() {
  var room = document.getElementsByName("numberOfRooms")[3];
  var location = document.getElementsByName("location")[4];
  if (room.checked && location.checked) {
    document.getElementById("ExpertSuggestion").style.visibility = "visible";
  } else{
    document.getElementById("ExpertSuggestion").style.visibility = "hidden";
  }
}

