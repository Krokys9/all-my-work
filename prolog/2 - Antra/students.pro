/* Uzduotis 2b: Studentai (yra jaunesnis) */
studentas(tomas, 3).
studentas(valera, 3).
studentas(andrius, 1).
studentas(petras, 2).
studentas(vitalijus, 5).
studentas(rimas, 4).
studentas(juozas, 4).
studentas(rokas, 2).

yraVyresnis(vitalijus, rimas).
yraVyresnis(rimas, juozas).
yraVyresnis(juozas, valera).
yraVyresnis(valera, tomas).
yraVyresnis(tomas, andrius).
yraVyresnis(andrius, rokas).
yraVyresnis(rokas, petras).

yraJaunesnis(Studentas1, Studentas2) :- 
    yraVyresnis(Studentas2, Studentas1).

yraJaunesnis(Studentas1, Studentas2) :- 
    yraVyresnis(X,Studentas1), 
    yraJaunesnis(X,Studentas2).