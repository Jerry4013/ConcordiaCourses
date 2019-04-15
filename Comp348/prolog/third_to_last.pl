third_to_last([A,_,_],A).
third_to_last([_|T], A):-third_to_last(T,A).