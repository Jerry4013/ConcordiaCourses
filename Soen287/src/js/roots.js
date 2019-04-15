var a = prompt("What is the value of 'a'? \n", "");
var b = prompt("What is the value of 'b'? \n", "");
var c = prompt("What is the value of 'c'? \n", "");

var root_part = Math.sqrt(b * b - 4 * a * c);
var denom = 2 * a;

var root1 = (-b + root_part) / denom;
var root2 = (-b - root_part) / denom;
document.write("The first root is: ", root1.toString(), "<br />");
document.write("The second root is: ", root2.toString(), "<br />");
