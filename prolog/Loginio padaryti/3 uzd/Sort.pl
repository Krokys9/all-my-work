%rusiuoti(S,R) - s�ra�as R gaunamas i�r��iavus duotojo skai�i� s�ra�o S
% elementus did�jimo tvarka. Pavyzd�iui:
%?- rusiuoti([1,23,5,1,2],R).

%R = [1,1,2,5,23]
rastimaziausia([X|[]],X).
rastimaziausia([First|[Second|Tail]],X):- First =< Second,rastimaziausia([First|Tail],X).
rastimaziausia([First|[Second|Tail]],X):- First > Second,rastimaziausia([Second|Tail],X).
pasalintiIsRusiavimo(X, [X|T], T).
pasalintiIsRusiavimo(X,[H|T],[H|R]):- X\=H,pasalintiIsRusiavimo(X,T,R).
rusiuoti([],[]).
rusiuoti(R,[First1|Tail1]):- rastimaziausia(R,First1),pasalintiIsRusiavimo(First1,R,W),rusiuoti(W,Tail1).

