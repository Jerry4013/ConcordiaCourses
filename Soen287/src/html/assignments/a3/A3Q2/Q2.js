var balance = 400;
function validateAmount() {
  var dom = document.getElementById("amount").value;
  if (isNaN(dom)){
    alert("Please enter numeric value");
  }
}

function withdrwawAmount() {
  var amount = parseFloat(document.getElementById("amount").value);
  if (amount % 20 != 0 || amount == 0){
    alert("Incorrect withdrawal amount");
  } else if (balance < amount + 0.5){
    alert("Insufficient funds");
  } else {
    balance = balance - amount - 0.5;
    alert("Successful transaction! \n Current Balance is: " + balance);
  }
}
