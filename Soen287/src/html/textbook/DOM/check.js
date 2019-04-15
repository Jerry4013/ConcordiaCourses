function numChecked() {
  var numChecked = 0;
  var dom = document.getElementById("vehicleGroup");
  for (var i = 0; i < dom.vehicles.length; i++) {
    if (dom.vehicles[i].checked){
      numChecked++;
    }
  }
  document.write(numChecked.toString());
}
