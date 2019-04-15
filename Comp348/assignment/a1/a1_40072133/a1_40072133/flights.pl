
flightPath(lax,nrt,11,5439).
flightPath(cdg,jfk,8,3624).
flightPath(cdg,lax,11,5656).
flightPath(cdg,fco,2,684).
flightPath(lju,cdg,2,587).
flightPath(lju,fco,2,628).
flightPath(jfk,lax,6,2469).
flightPath(jfk,nrt,14,6729).
flightPath(fco,jfk,10,4266).
flightPath(fco,sin,12,6245).
flightPath(sin,nrt,7,3329).
transferTime(lax,2).
transferTime(jfk,2).
transferTime(fco,2).
transferTime(cdg,2).
transferTime(lju,2).
transferTime(sin,2).
transferTime(nrt,2).

connection(A,B):-flightPath(A,B,_,_);flightPath(A,C,_,_),connection(C,B).

flightTime(Start,Destination,Time,Path):-
flightPath(Start,Destination,FlightTime,_),
transferTime(Start,WTimeStart),
transferTime(Destination,WTimeDest),
 Time is FlightTime + WTimeStart + WTimeDest,
append([Start],[Destination],Path).

flightTime(Start,Destination,Time,Path):-
 flightPath(Start,X,FlightTime,_),
 transferTime(Start,WTimeStart1),
 flightTime(X,Destination,TimeX,PathX),
 Time is FlightTime + TimeX +WTimeStart1,
 append([Start],PathX,Path).

pathLength([],0).
pathLength([_],0).
pathLength([X,Y|L],Length):-
flightPath(X,Y,_,T),
pathLength([Y|L], Length1),
Length is Length1+ T.

shortestPath(Start, Destination) :-
findall(Path, flightTime(Start, Destination, _, Path), Paths),
findall(Length, (member(MemberOfPaths, Paths), pathLength(MemberOfPaths, Length)), Lengths),
min_list(Lengths, ShortestLength),
member(ShortestPath, Paths),
pathLength(ShortestPath, ShortestLength),
print(ShortestPath).



