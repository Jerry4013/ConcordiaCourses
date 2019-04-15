information(mark,clerk,[],2100).
information(jack,typist,[john,anna],3200).
information(john,clerk,[],3000).
information(eli,manager,[sara,mark],3500).
information(sara,typist,[mark],3300).
information(adrianne,manager,[jack,john,anna],3400).
supervises(X,L):-information(X,_,L,_).


sum([],0).
sum([H|T],S):-sum(T,S1),S is S1 + H.
totalgroupsalary(P,S):-findall(Sa,information(_,P,_,Sa),L),
    sum(L,S).
    