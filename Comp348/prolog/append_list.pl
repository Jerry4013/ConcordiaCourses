append_list([], L, L).
append_list([H|T], L, [H|T1]):-append_list(T,L,T1).