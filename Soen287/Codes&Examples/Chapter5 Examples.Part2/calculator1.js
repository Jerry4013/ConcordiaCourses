// calculator1.js
 
 function add(){
    var dom=document.getElementById("calc"); 
    var num1=parseFloat(dom.num1.value);
    var num2=parseFloat(dom.num2.value);
    dom.result.value=num1+num2;
  }

  function subtract(){
	var dom=document.getElementById("calc");
    var num1=dom.num1.value;
    var num2=dom.num2.value;
    dom.result.value=num1-num2;
  }

  function multiply(){
	var dom=document.getElementById("calc");
    var num1=dom.num1.value;
    var num2=dom.num2.value;
    dom.result.value=num1*num2;
  }

  function divide(){
	var dom=document.getElementById("calc");
    var num1=dom.num1.value;
    var num2=dom.num2.value;

    if (num2==0) {
      window.alert("You can't divide by 0.");
      dom.result.num2.value="";
    }
    else {
      dom.result.value=num1/num2;
    }
  }