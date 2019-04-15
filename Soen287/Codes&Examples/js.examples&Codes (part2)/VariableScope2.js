// File: VariableScope2.js
// Written by: N. Acemian
// Purpose: To demonstrate/play with variable scope
// Course: SOEN 287

aVar5 = 50;
function fcn4()
{
	aVar4 = 44;
	alert("the value of aVar1 in fcn4() is " + aVar1);
  	alert("the value of aVar2 in fcn4() is " + aVar2);
	alert("the value of aVar3 in fcn4() is " + aVar3);
	alert("the value of aVar4 in fcn4() is " + aVar4);
	alert("the value of aVar5 in fcn4() is " + aVar5);	
}