partof(egypt, africa).
partof(canada, america).
partof(china, asia).
belong(ottawa, canada).
belong(beijing, china).
belong(X,Y):-partof(Z,Y), belong(X,Z).
belong(X):-belong(X,_).