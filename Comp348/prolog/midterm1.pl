parent(sabrina,roger).
parent(anna,jim).
parent(sabrina,janis).
parent(robert,roger).
parent(robert,jim).
parent(robert,janis).
siblings(X,Y):-parent(P,X),parent(P,Y),X\=Y.
    