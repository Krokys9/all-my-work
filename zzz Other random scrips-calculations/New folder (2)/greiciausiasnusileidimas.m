format short

f=@(x1, x2) (x1.^2).*x2 + x1.*(x2.^2) - x1.*x2;
gradf=@(X) [2.*X(1,1).*X(1,2) + X(1,2).^2 - X(1,2), X(1,1).^2 + 2.*X(1,1).*X(1,2)-X(1,1)];
epsilon = 0.001;

X0= [0.6,0.2];
%axis([0, 1, 0, 1],"graph");
x = -1:0.2:1;
y = -1:0.2:1;
[xx,yy] = meshgrid(x,y);
funcMain =@(xx1,yy1)((xx1.*yy1.*(1.-xx1.-yy1)));
surf(xx,yy,funcMain(xx,yy));
ciklokartas = 0;
hold on
norma = 553464;
disp('    x1                         x2                   f(x1,x2)                k                      funkc. kviet. sk');
while norma > epsilon && ciklokartas<100
gradientas = gradf(X0);
 norma = norm(gradientas);
 returnas = auksinispjuvis(X0,gradientas);
 gama = returnas(1);
 iteracijos = returnas(2);
 X1 = X0 - gama*gradientas;
 plot(X1(1,1),X1(1,2), 'o', "markersize", 7 , "markerfacecolor", "auto");
 hold on
 ciklokartas ++;
 disp([X1, f(X1(1,1),X1(1,2)), ciklokartas, iteracijos]);
 X0 = X1;
endwhile
X0;

%z(x,y) = (1 -2*x*y)/(2* (x + y))
%fgoal(x,y) = x * y * z