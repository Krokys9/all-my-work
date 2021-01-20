#niutono
#funkcija f(x)=(x^2-5)^2/2-1

format long
x = 0:0.0001:10;
f = ((x.^2-6).^2/2)-1;
ylim([-3,20]);
hold on;
xlim([0,4]);
hold on;
plot(x,f);
hold on;

iterations = 0;
functionCalls = 1;
xi = 10;
xi1 = 0;
epsilon = 0.0001;
xi1 = xi - myFuncDerF(xi)/myFuncDerS(xi);  

while (epsilon < sqrt((xi1 - xi)^2))
xi = xi1;
iterations +=1;
xi1 = xi - myFuncDerF(xi)/myFuncDerS(xi);  
  plot(xi,myFunc(xi),'r*');
  hold on


endwhile

minimum = myFunc(xi1);

