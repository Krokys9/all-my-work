%rusiuoti(S,R) - sàraðas R gaunamas iðrûðiavus duotojo skaièiø sàraðo S
% elementus didëjimo tvarka. Pavyzdþiui:
%?- rusiuoti([1,23,5,1,2],R).

%R = [1,1,2,5,23]
rastimaziausia([X|[]],X).
rastimaziausia([First|[Second|Tail]],X):- First =< Second,rastimaziausia([First|Tail],X).
rastimaziausia([First|[Second|Tail]],X):- First > Second,rastimaziausia([Second|Tail],X).
pasalintiIsRusiavimo(X, [X|T], T).
pasalintiIsRusiavimo(X,[H|T],[H|R]):- X\=H,pasalintiIsRusiavimo(X,T,R).
rusiuoti([],[]).
rusiuoti(R,[First1|Tail1]):- rastimaziausia(R,First1),pasalintiIsRusiavimo(First1,R,W),rusiuoti(W,Tail1).

