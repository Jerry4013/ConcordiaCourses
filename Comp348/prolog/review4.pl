function(1,_,[]).
function(0,_,[]).
function(_,[],[]).
function(M,[A|A1],[A|B1]) :- M > 1, C is M-1,number(A), function(C,A1,B1). 
function(M,[A|A1],[A|B1]) :- M > 1, C is M-2,\+ number(A), function(C,A1,B1).