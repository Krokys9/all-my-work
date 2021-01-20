
%https://app.mindmup.com/map/new/1573057766330
kelias(kaunas,klaipeda,250).%2
kelias(klaipeda,palanga,40).%4
kelias(vilnius,kaunas,100).%1
kelias(panevezys,kelme,50).%5
kelias(vilnius,panevezys,130).%6
kelias(panevezys,siauliai,70).%7
kelias(kelme,silute,100).%8
kelias(kelme,palanga,160).%10
galima(X,Y,M):-kelias(X,Y,_),not(X=M).
galima(X,Y,M):- kelias(Z,Y,_),not(Y = M),not(X = M),galima(X,Z,M).
