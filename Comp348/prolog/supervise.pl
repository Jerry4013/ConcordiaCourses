clerk(jones).
clerk(smith).
typist(brown).
manager(patel).
manager(lee).
supervises(X,Y):-manager(X),clerk(Y).
supervises(X,Y):-clerk(X),typist(Y).
supervises(X,Y):-manager(X),typist(Y).