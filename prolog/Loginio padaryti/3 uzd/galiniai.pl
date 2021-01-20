%galiniai(S,K,R) - sàraðas R - paskutiniøjø K duoto sàraðo S elementø
% sàraðas. Pavyzdþiui:
%?- galiniai([a,b,c,d,e],3,R).

%R = [c,d e].
%
%
%
%
%
%
%
%apvopt(PRAD,APV):-
	%apv1(PRAD,[],APV).

%apv1([],APV,APV).
%apv1([P|G],TARP, APV):-
	%apv1(G,[P|TARP],APV).

% galiniai([First|Tail],K,R):- , apvopt(L,[First|Tail]),K1 is K-1,
% galiniai(Tail,K1,[First|R]).
% galiniai([First|Tail],K,R):- K \=0,R = First,K1 is K-1,
% galiniai(Tail,K1,[First|R]).
%galiniai(_,0,_).

galiniai([a,b,c,d,e],3,R).

%galiniai([First|Tail],K,R):-K \=0, galiniai(Tail,K,[First|R]).
%galiniai(L,K,R):- L = [].
galiniai([_|Tail],K,R):- K\=0,galiniai(Tail,K,R).
galiniai([First|Tail],K,[R|L]):- k\=0,R = First,K1 is K-1,galiniaib(Tail,K1,L).
galiniai([],0,[]).
galiniaib([First|Tail],K,[R|L]):- k\=0,R = First,K1 is K-1,galiniaib(Tail,K1,L).
galiniaib([],0,[]).




zenklas(Front,pliusas):- Front is pliusas.
zenklas(Front,atimtis):-Front is atimtis.
zenklas(Front,nieko):- Front is nieko.
sudetiPliusus(Sarasas,Atsakymas,ZenkluSekimas):-paskaiciuotiDabartineReiksme(Sarasas,Atsakymas,ZenkluSekimas,0).
paskaiciuotiDabartineReiksme([],X,[],X).
paskaiciuotiDabartineReiksme([Front|Tail],Atsakymas,[SignFront|SignTail],DabartineReiksme):-kitaReiksmeBus(Front,SignFront,DabartineReiksme,KitaReiksme,_) ,paskaiciuotiDabartineReiksme(Tail,Atsakymas,SignTail,KitaReiksme).
kitaReiksmeBus(Priekis,,Dabartine,KitaReiksme,_):-zenklas(Priekis,pliusas), KitaReiksme is(Dabartine + Priekis).
kitaReiksmeBus(Priekis,Zenklas,Dabartine,KitaReiksme,_):-zenklas(Priekis,atimtis) , KitaReiksme is(Dabartine - Priekis).
kitaReiksmeBus(Priekis,Zenklas,Dabartine,KitaReiksm,_:-zenklas(Priekis,nieko)  ,laipsnio_pakelimas() ,KitaReiksme is(Dabartine + Priekis).

