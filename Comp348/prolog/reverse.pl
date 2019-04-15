append_list([], L, L).
append_list([H|T], L, [H|T1]):-append_list(T,L,T1).
reverse2([], []).
reverse2([H|T],R):-reverse2(T,R1),append_list(R1,[H],R).