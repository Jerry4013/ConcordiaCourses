size([],0).
size([_|T], S):-size(T,S1), S is S1 + 1.