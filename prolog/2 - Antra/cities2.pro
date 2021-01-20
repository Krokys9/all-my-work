/* Uzduotis: 1c: Miestai (nevaziuoti per M) */ 
kelias(vilnius,lentvaris,17).
kelias(lentvaris,trakai,8).
kelias(trakai,kaunas,90).
kelias(trakai,paluknis,10).
kelias(lentvaris,grigiskes,5).
kelias(grigiskes,kaunas,85).
kelias(vilnius,kalveliai,42).
kelias(vilnius,juodsiliai,14).
kelias(juodsiliai,kalveliai,51).
kelias(kalveliai,sumskas,3).
kelias(sumskas,minskas,250).
kelias(paluknis,amundsend,15500).
kelias(kaunas,amundsend,1000).
kelias(juodsiliai,minskas,300).
kelias(kaunas,minskas,450).

galimaPervaziuoti(MiestasX,MiestasY,M) :- 
    kelias(MiestasX,MiestasY,_), 
    MiestasX\=M, 
    MiestasY\=M.

galimaPervaziuoti(MiestasX,MiestasY,M) :- 
    kelias(Y,MiestasY,_), 
    Y\=M, 
    MiestasX\=M, 
    galimaPervaziuoti(MiestasX,Y,M).