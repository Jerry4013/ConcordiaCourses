var dom;
function getElementAmpersand() {
  dom = document.getElementById("field");
  dom.addEventListener("blur",convertAmpersands,false);
}

function convertAmpersands() {
  dom.value = dom.value.replace(/&/g," and ");
}

window.addEventListener("load", getElementAmpersand, false);
