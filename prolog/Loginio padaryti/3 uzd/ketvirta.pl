%dvej_skaic(S,K) - dvejetaini� skaitmen� s�ra�as S atitinka skai�i� K.
% Pavyzd�iui: ?- dvej_skaic([1,0,1,1],K).

%K = 11.
%
apvopt(PRAD,APV):-
	apv1(PRAD,[],APV).

apv1([],APV,APV).
apv1([P|G],TARP, APV):-
	apv1(G,[P|TARP],APV).

dvej_skaic(S,K):- apvopt(S,T),dvej_skaic(T,0,0,K).
dvej_skaic([],_,K,K).
dvej_skaic([First|Tail],I0,N0,K):-dvejetainis(First),N1 is N0+2^I0*First,I1 is I0+1,dvej_skaic(Tail,I1,N1,K).
dvejetainis(X):- X = 1.
dvejetainis(X):- X = 0.

