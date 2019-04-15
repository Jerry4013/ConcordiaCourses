range(I,I,[I]).
range(I,K,[I|T]):-I<K,I1 is I + 1,range(I1,K,T).