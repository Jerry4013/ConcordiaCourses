man(tom).
man(michael).
man(adam).
man(andrew).
man(john).
man(mark).
man(roger).
man(jim).
man(peter).
woman(sandra).
woman(eve).
woman(helen).
woman(judy).
woman(janis).
woman(dephne).
parent(tom, adam). 
parent(tom, helen). 
parent(sandra, adam). 
parent(sandra, helen). 
parent(michael, andrew). 
parent(michael, john). 
parent(eve, andrew). 
parent(eve, john). 
parent(helen, mark). 
parent(andrew, mark). 
parent(judy, roger). 
parent(judy, jim). 
parent(judy, janis). 
parent(mark, roger). 
parent(mark, jim). 
parent(mark, janis). 
parent(janis, daphne). 
parent(peter, daphne). 
grandparent(X,Y):- parent(X,Z), parent(Z,Y).
ancestor(X,Y):- parent(X,Y); parent(X,Z), ancestor(Z,Y).
father(X,Y):- man(X),parent(X,Y).
mother(X,Y):-woman(X),parent(X,Y).
isfather(X):-father(X,_).
ismother(X):-mother(X,_).
son(X,Y):-man(X),parent(Y,X).
daughter(helen,Y):- woman(helen), parent(Y,helen).
siblings(X,Y):-parent(P,X),parent(P,Y), X\=Y. %%X and Y are not equal
%%define uncle,aunt and fullsibiling rules as well
full_siblings(X,Y):-father(F,X),father(F,Y),mother(M,X),mother(M,Y),X\=Y.
uncle(U,N):-man(U),siblings(U,P),parent(P,N).
aunt(A,N):-woman(A),siblings(A,P),parent(P,N).
    
    
    
    

    
   
