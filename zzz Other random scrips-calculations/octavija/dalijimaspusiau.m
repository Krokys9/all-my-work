#dalijimo pusiau
#funkcija f(x)=(x^2-6)^2/2-1

x = 0:0.0001:10;
f = ((x.^2-6).^2/2)-1;
ylim([-3,20]);
hold on;
xlim([0,4]);
hold on;
plot(x,f);
hold on;


format long
l = 0;
r = 10;
iterations = 0;
minimum = 0;
callingFunction = 0;
minimumXm = 0;
xm = (l+r)/2;
L = r-l;
x1 = l + L/4;
x2 = r - L/4;
ValueOfX1 = myFunc(x1);
ValueOfX2 = myFunc(x2);
ValueOfXm = myFunc(xm);
callingFunction += 3;
% TODO : REIKIA Koptimizuoti if'us t.y. prieš dedant i palyginima, juos apsiskai?iuoti, tod?l gausis mažiau 
%funkciju skaiciavimu ;
while(L > 0.0001)
  iterations++;
  if(ValueOfX1 < ValueOfXm)
    r= xm;
    xm = x1;
    ValueOfXm = ValueOfX1;
  elseif(ValueOfX2 < ValueOfXm )
    l = xm;
    xm = x2;
    ValueOfXm = ValueOfX2;
  else
    l = x1;
    r = x2;
endif
L = r - l;
x1 = l + L/4;
x2 = r - L/4;
ValueOfX1 = myFunc(x1);
ValueOfX2 = myFunc(x2);
callingFunction +=2;
plot(x1,myFunc(x1),'b*');
hold on
plot(x2,myFunc(x2),'r*');
hold on
endwhile

if(myFunc(x1)<myFunc(x2) && myFunc(x1)<myFunc(xm))
	minimum = myFunc(x1);
  minimumXm = x1;
	callingFunction += 3;
elseif(myFunc(x2)<myFunc(x1) && myFunc(x2)<myFunc(xm))
	minimum = myFunc(x2);
  minimumXm = x2;
	callingFunction += 5;
else
	minimum = myFunc(xm);
  minimumXm = xm
	callingFunction += 5;
endif
