// File: VariableScope1.js
// Written by: N. Acemian
// Purpose: To demonstrate/play with variable scope
// Course: SOEN 287
var aVar1 = 11;
aVar2 = 12;
aVar3 = 13;
aVar4 = 14;
aVar5 = 15;
function fcn1()
{
	alert("the value of aVar1 in fcn1() is " + aVar1);
    alert("the value of aVar2 in fcn1() is " + aVar2); 
	alert("the value of aVar3 in fcn1() is " + aVar3);
	alert("the value of aVar4 in fcn1() is " + aVar4);
	alert("the value of aVar5 in fcn1() is " + aVar5);
	
}

function fcn2()
{
	aVar1 = 21;
	aVar2 = 22;
	alert("the value of aVar1 in fcn2() is " + aVar1);
    alert("the value of aVar2 in fcn2() is " + aVar2); 
	alert("the value of aVar3 (before calling fcn3() in fcn2() is " + aVar3);
	alert("the value of aVar4 in fcn2() is " + aVar4);
	alert("the value of aVar5 in fcn2() is " + aVar5);
	fcn3();
	alert("the value of aVar3 (after calling fcn3() in fcn2() is " + aVar3);
}

function fcn3()
{
	aVar3 = 33;
	alert("the value of aVar1 in fcn3() is " + aVar1);
    alert("the value of aVar2 in fcn3() is " + aVar2);
	alert("the value of aVar3 in fcn3() is " + aVar3);
	alert("the value of aVar4 in fcn3() is " + aVar4);
	alert("the value of aVar5 in fcn3() is " + aVar5);
}