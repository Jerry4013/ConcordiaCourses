var threem = 0;
var fivem = 0;
var inputArray = [];
var i;
var index = 0;

var temporary = prompt("Please enter a number: \n");
while(temporary != -1){
  if (temporary == null) {
    break;
  }
  if(!isNaN(Number(temporary)) && temporary != -1 && temporary !==""){
      inputArray[index] = temporary;
      index++;
  }
  temporary = prompt("Please enter a number: \n");
}

for(i = 0; i < inputArray.length; i++){
    if(inputArray[i] % 3 == 0){
        threem++;
    }
}

for(i = 0; i < inputArray.length; i++){
    if(inputArray[i] % 5 == 0){
        fivem++;
    }
}

document.write("You entered " + inputArray.length + " numbers<br />");
document.write("Multiple of 3: " + threem + " numbers<br />");
document.write("Multiple of 3: " + fivem + " numbers");
