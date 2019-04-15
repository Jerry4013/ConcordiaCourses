f(0,0).
f(1,1).
f(N,X):- N1 is N-1, N2 is N-2, f(N1,X1), f(N2,X2), X is X1+X2.