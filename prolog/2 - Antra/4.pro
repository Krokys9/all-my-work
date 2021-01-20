
% Antros uzduoties, ketvirtas variantas:
% Duoti du nat�riniai skai�iai A, B. Rasti j� bendr� did�iausi�
% dalikl� pagal Euklido algoritm�.

dbd(Skaicius, 0, Skaicius).
dbd(Skaicius, Skaicius, Skaicius).
dbd(Skaicius1, Skaicius2, Atsakymas) :- 
       (Skaicius1>Skaicius2),(Skaicius2>0),
	Liekana is Skaicius1 mod Skaicius2,dbd(Skaicius2,Liekana,Atsakymas).
dbd(Skaicius1, Skaicius2, Atsakymas) :- 
	(Skaicius1<Skaicius2),
	dbd(Skaicius2,Skaicius1,Atsakymas).