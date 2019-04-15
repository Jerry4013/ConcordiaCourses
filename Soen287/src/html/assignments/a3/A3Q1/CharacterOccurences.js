var searchStr;
var ch;
var outResult;

function searchOccurrences() {
  searchStr = document.getElementById("searchString").value;
  ch = document.getElementById("characters").value;
  outResult = document.getElementById("output");

  var counter = 0;
  for (var i = 0; i < searchStr.length - 1; i++) {
    if (searchStr.charAt(i) === ch[0] && searchStr.charAt(i + 1) === ch[1]){
      counter++;
      i++;
    }
  }
  if (counter === 0){
    outResult.textContent = "The characters pattern '" + ch + "' was not found"
  } else {
    outResult.innerHTML = counter + " occurrence(s) of '" + ch + "' found"
  }
}
