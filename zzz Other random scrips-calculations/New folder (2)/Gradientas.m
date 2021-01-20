format long
funcX = @(X,Y) (((2*X*Y)+(Y^2)-(Y))/8);
funcY = @(X,Y) (((2*X.*Y)+(X.^2)-(X))/8);
gama = 0.6;
epsilon = 0.001;
%axis([0, 1, 0, 1],"graph");
x = -1:0.1:1;
y = -1:0.1:1;
[xx,yy] = meshgrid(x,y);
funcMain =@(xx1,yy1)(1/8*(xx1.*yy1.*(1.-xx1.-yy1)));
surf(xx,yy,funcMain(xx,yy));

hold on
deltaFi = @(X,Y) abs(X)+abs(Y);
xi =[1,1]; 
x = xi;
funccount = 0;
iterations = 0;
funcXans = funcX(xi(1),xi(2));
funcYans = funcY(xi(1),xi(2));
deltaFians = deltaFi(funcXans,funcYans);
while(deltaFians > epsilon)
plot3(xi(1),xi(2),funcMain(xi(1),xi(2)),'r*');
funccount++;
xi(1) = x(1) - gama*funcXans;
xi(2) = x(2) - gama*funcYans;
x = xi;
iterations++;
funcXans = funcX(xi(1),xi(2))
funcYans = funcY(xi(1),xi(2))
deltaFians = deltaFi(funcXans,funcYans);

endwhile
disp ( ' X, Y , F(X) , Iteracijos, funkcijuskaiciavimai');
fprintf ( 'X = %f  Y = %f F(X) =  %f Iteracijos = %i  funkciju skaiciavimai = %i , kai gama = %f', xi, funcMain(xi(1),xi(2)), iterations, funccount, gama);
%z(x,y) = (1 -2*x*y)/(2* (x + y))
%fgoal(x,y) = x * y * z