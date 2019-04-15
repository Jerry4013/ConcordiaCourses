nth_element(0, H, [H|_]).
nth_element(N, E, [_|T]):-nth_element(N1, E, T),N is N1 + 1.