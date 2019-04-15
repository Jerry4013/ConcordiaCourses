solve([_|T],X):- solve(T,X).
solve([H|_],H).