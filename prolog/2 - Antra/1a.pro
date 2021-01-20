
% Antros uzduoties 1a variantas:
% Duotas miestus jungian�i� keli� tinklas. Keliai vienakryp�iai,
% NESUDARANTYS cikl�. �inomi atstumai tarp miest�. Tai i�rei�kiama faktais
% kelias(Miestas1, Miestas2, Atstumas).
% Apibr��ti predikat� "galima perva�iuoti  i� miesto X i miest� Y,
%       a) kad bendras nuva�iuotas atstumas nevir�yt� L (duotas) kilometr�;

kelias(miestas1,miestas2,17).
kelias(miestas2,miestas3,8).
kelias(miestas3,miestas4,90).
kelias(miestas3,miestas5,10).
kelias(miestas2,miestas6,5).
kelias(miestas6,miestas4,85). 
kelias(miestas1,miestas7,42).
kelias(miestas1,miestas8,14).
kelias(miestas8,miestas7,51).
kelias(miestas7,miestas9,3).
kelias(miestas9,miestas10,250).
kelias(miestas5,miestas11,15500).
kelias(miestas4,miestas11,1000).
kelias(miestas8,miestas10,300).
kelias(miestas4,miestas10,450).

gp(PradinisMiestas,GalinisMiestas,Atstumas) :-
    	%writeln(Atstumas),
		kelias(PradinisMiestas,GalinisMiestas,TarpinisAtstumas),
    	TarpinisAtstumas<Atstumas.

gp(PradinisMiestas,GalinisMiestas,Atstumas) :-
		kelias(PradinisMiestas,TarpinisMiestas,TarpinisAtstumas),
		TarpinisAtstumas<Atstumas,
		LikesAtstumas is Atstumas-TarpinisAtstumas,
		gp(TarpinisMiestas,GalinisMiestas,LikesAtstumas).
	
    	