function atsakymas = simplex(B, X0, r)
epsilon = 10^-4;
counteris = 0;
f = @(X) B(X,r);
n = 2;
alfa = 0.5;
delta1 = (alfa*((sqrt(n+1) + (n-1))/n*sqrt(2))); %tokie patys
delta2 = (alfa*((sqrt(n+1)-1))/(n*sqrt(2))); % tokie patys
beta = 0.5;
eta = -0.5;
teta = 1;
gama = 1.5;
norma = 1;
keliamas = 0;
funkckvietimai = 0; 
X1 = [X0(1)+delta2, X0(2)+delta1,X0(3)+delta1];
X2 = [X0(1)+delta1, X0(2)+delta2,X0(3)+delta1];
X3 = [X0(1)+delta1, X0(2)+delta1,X0(3)+delta2];
FX0 = f(X0);
FX1 = f(X1);
FX2 = f(X2);
FX3 = f(X3);
%XC = (X1 + X2 + X0)/3;
X =[X0;X1;X2;X3];
Y  = [FX0,FX1,FX2,FX3];
[Y1,nr] = sort(Y);
i=4;
YL = Y1(1);
YA = Y1(2);
YH = Y1(4);
YG = Y1(3);
XL = X(nr(1),:);
XA = X(nr(2),:);
XH = X(nr(4),:);
XG = X(nr(3),:);
while norma >= epsilon
  
  XC=(sum(X)-XH)/3;
  XNew = XH +(1+teta)*(XC-XH);
  YNew = f(XNew);
  if  (YL < YNew && YNew < YG )
  teta = 1;  
elseif YNew < YL
  teta = gama;
    Xlaikinas = XH +(1+teta)*(XC-XH); % pletimas i ta pacia puse
  Ylaikinas = f(Xlaikinas);
  funkckvietimai++;
  if Ylaikinas < YNew
    XNew = Xlaikinas;
    YNew = Ylaikinas;
    endif 
    
elseif YNew > YH
  teta = eta;
    XNew = XH +(1+teta)*(XC-XH);
  YNew = f(XNew);
  funkckvietimai++;
elseif YG < YNew && YNew < YH 
  teta = beta;
  funkckvietimai++;
    XNew = XH +(1+teta)*(XC-XH);
  YNew = f(XNew);
endif
  %f(XL) < F(XNew) <F(XG)  tai teta = 1; nekinta
 % f(XNew) <F(XL) tai teta >= 1  ( GAMA ) pleciame
 % F(XNew) > F(XH) teta = eta   (kita puse)
 %jei F(XG) < F(XNew) < F(XH) teta = beta (spaudimas
 %
  % ir tada vel skaiciuoju XL XG XH 
  
funkckvietimai++;
funkckvietimai++;
funkckvietimai++;
funkckvietimai++;
X =[XL;XA;XG;XNew];
Y  = [YL,YA,YG,YNew];
[Y1,nr] = sort(Y);
YL = Y1(1);
YA = Y1(2);
YH = Y1(4);
YG = Y1(3);
XL = X(nr(1),:);
XA = X(nr(2),:);
XH = X(nr(4),:);
XG = X(nr(3),:);
%XC = (X1 + X2 + X0)/3;
%X =[XL;XG;XNew];
%Y  = [YL,YG, YNew];
%[Y1,nr] = sort(Y);
%YL = Y1(1);
%YA = Y1(2);
%YH = Y1(3);
%YG = Y1(4);
%XL = X(nr(1),:);
%XA = X(nr(2),:);
%XH = X(nr(3),:);
%XG = X(nr(4),:);
i = i+1;

%fprintf('%f    %f %f   %d           %d\n', XNew, YNew, i, funkckvietimai);
 if (max([norm(XL-XG),norm(XL-XG),norm(XH-XG),norm(XA-XG),norm(XA-XH),norm(XA-XL)])<epsilon) && (abs(YH - YL) < epsilon )
           break
      end    
endwhile
atsakymas = [XNew,i];
end
