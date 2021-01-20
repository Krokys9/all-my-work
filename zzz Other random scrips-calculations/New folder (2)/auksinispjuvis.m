#auksinis pjuvis
function returnas=auksinispjuvis(X0,gradientas)

f=@(X) (X(1).^2).*X(2) + X(1).*(X(2).^2) - X(1).*X(2);
myFunc=@(t) f(X0-t*gradientas);
l=0;   % apatinis intervalo rezis
r=3.4;  % desinysis intervalo rezis
format long
T = (sqrt(5)-1)/2;
iterations = 0;
minimum = 0;
callingFunction = 0;
minimumXm = 0;
epsilon = 10^-4;
L = r-l;
x1 = r - T*L;
x2 = l + T*L;
functionvaluex1 = myFunc(x1);
functionvaluex2 = myFunc(x2);
callingFunction +=1;
while(L > epsilon)
  if(functionvaluex2 < functionvaluex1)
    l = x1;
    x1 = x2;
    L = r - l;
    functionvaluex1 = functionvaluex2;
    x2 = l + T*L;
    functionvaluex2 = myFunc(x2);
    callingFunction +=1;
  else
    r = x2;
    L = r - l;
    x2 = x1;
    functionvaluex2 = functionvaluex1;
    x1 = r - T*L;
    functionvaluex1 = myFunc(x1);
    callingFunction +=1;
  endif
iterations = iterations +1;
endwhile

if(functionvaluex2 < functionvaluex1)
	minimum = functionvaluex2;
  minimumXm = x2;
else
	minimum = functionvaluex1;
  minimumXm = x1;
endif
gama = minimumXm;
returnas= [gama, callingFunction];
end
 