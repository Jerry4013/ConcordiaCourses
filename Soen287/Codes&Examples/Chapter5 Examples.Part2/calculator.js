// calculator.js
 
 function add(){
    var num1=parseFloat(document.calc.num1.value);
    var num2=parseFloat(document.calc.num2.value);
		document.calc.result.value=num1+num2;
  }

  function subtract(){
    var num1=document.calc.num1.value;
    var num2=document.calc.num2.value;
    document.calc.result.value=num1-num2;
  }

  function multiply(){
    var num1=document.calc.num1.value;
    var num2=document.calc.num2.value;
    document.calc.result.value=num1*num2;
  }

  function divide(){
    var num1=document.calc.num1.value;
    var num2=document.calc.num2.value;

    if (num2==0) {
      window.alert("You can't divide by 0.");
      document.calc.num2.value="";
    }
    else {
      document.calc.result.value=num1/num2;
    }
  }
  
  
  
  
  
  
  
  
  