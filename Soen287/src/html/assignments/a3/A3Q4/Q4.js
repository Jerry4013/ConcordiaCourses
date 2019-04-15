document.getElementById("sub").type = "button";
document.getElementById("sub").onclick = calculate;
var node = document.createElement("link");
node.rel = "stylesheet";
node.href = "Q4.css";
document.getElementsByTagName("head")[0].appendChild(node);

function calculate() {
  var inputFields = document.getElementsByTagName("Input");
  for (var i = 0; i < inputFields.length - 1; i++) {
    if (inputFields[i].value === ""){
      alert("Please enter all the fields.");
      return;
    }
  }
  var quan1 = document.getElementById("pizza").value;
  var quan2 = document.getElementById("burger").value;
  var quan3 = document.getElementById("salad").value;
  var quan4 = document.getElementById("soup").value;
  var sum = quan1 * 19.5 + quan2 * 15.5 + quan3 * 10.00 + quan4 * 5.00;
  var results = new Array();
  results[0] = "Pizza (Quantity = " + quan1 + "): $" + quan1 * 19.5;
  results[1] = "Burger (Quantity = " + quan2 + "): $" + quan2 * 15.5;
  results[2] = "Salad (Quantity = " + quan3 + "): $" + quan3 * 10.00;
  results[3] = "Soup (Quantity = " + quan4 + "): $" + quan4 * 5.00;
  var result = document.createTextNode("Final Total: $" + sum);
  var form = document.getElementById("frm");
  for (var i = 0; i < results.length; i++) {
    var text = document.createTextNode(results[i]);
    form.appendChild(text);
    form.appendChild(document.createElement("br"));
  }
  form.appendChild(document.createElement("br"));
  form.appendChild(result);
  form.appendChild(document.createElement("br"));
}
