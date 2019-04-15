insert_nth(R, 0, L, [R|L]).
insert_nth(R, N, [H|T], [H|NL]):-
    M is N-1, insert_nth(R,M,T,NL).