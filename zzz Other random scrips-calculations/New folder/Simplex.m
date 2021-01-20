function Simplex
a=6;
b=2;

% X0=[1/2,1/2];
X0=[a/10, b/10];

% f=@(x1, x2) (x1.^2).*x2 + x1.*(x2.^2) - x1.*x2;
f=@(X) (X(1,1).^2).*X(1,2) + X(1,1).*(X(1,2).^2) - X(1,1).*X(1,2);

epsilon=10^(-4); %tikslumas
k=1; %iteraciju skaitliukas
i=0;
imax = 100;
kmax=100; 
norma=Inf;

alfa=1/2;
beta=0.5;
gama=1.3;
eta=-0.5;
teta=1;
n=2;
delta1=alfa*(sqrt(n+1)+n-1)/(n*sqrt(2))
delta2=alfa*(sqrt(n+1)-1)/(n*sqrt(2))

X1=[X0(1)+delta2, X0(2)+delta1];
X2=[X0(1)+delta1, X0(2)+delta2];

y0=f(X0);
y1=f(X1)
y2=f(X2);

Y=[y0, y1, y2];
X=[X0; X1; X2];

[Y1, nr] = sort(Y);

yl=Y1(1);%Y(nr(1));
yg=Y1(2);%Y(nr(2));
yh=Y1(3);%Y(nr(3));

Xl=X(nr(1),:);
Xg=X(nr(2),:);
Xh=X(nr(3),:);

x = [X0(1),X0(1),X1(1);X1(1), X2(1), X2(1)];
y = [X0(2),X0(2),X1(2);X1(2), X2(2), X2(2)];
plot(x, y, 'r');
hold on

i=3;
disp('    X1        X2       y        k         funkc. kviet. sk');
while norma>= epsilon
      Xc=(Xl+Xg)/2;
      Xnew=Xh+(1+teta)*(Xc-Xh);
      ynew=f(Xnew);
      i=i+1;
      if Xnew(1) <= 0 || Xnew(2) <= 0
          teta=eta;
          Xnew=Xh+(1+teta)*(Xc-Xh);
          ynew=f(Xnew);
          i=i+1;
      end
      if(yl < ynew && ynew < yg)
          teta=1;
      elseif(ynew < yl)
          teta=gama;
          Z=Xh+(1+teta)*(Xc-Xh);
          i=i+1;
          yz=f(Z);
          if(yz < ynew)
              Xnew=Z;
              ynew=yz;
          end
      elseif(ynew > yh)
          teta=eta;
          Xnew=Xh+(1+teta)*(Xc-Xh);
          ynew=f(Xnew);
          i=i+1;
      elseif(yg < ynew && ynew < yh)
          teta=beta;
          Xnew=Xh+(1+teta)*(Xc-Xh);
          ynew=f(Xnew);
          i=i+1;
      end
      if Xnew(1) <= 0 || Xnew(2) <= 0
          teta=eta;
          Xnew=Xh+(1+teta)*(Xc-Xh);
          ynew=f(Xnew);
          i=i+1;
      end
      Y=[yl, yg, ynew];
      X=[Xl; Xg; Xnew];

      [Y1, nr] = sort(Y);

      yl=Y1(1);%Y(nr(1));
      yg=Y1(2);%Y(nr(2));
      yh=Y1(3);%=Y(nr(3));

      Xl=X(nr(1),:);
      Xg=X(nr(2),:);
      Xh=X(nr(3),:);

      x = [Xl(1),Xl(1),Xg(1);Xg(1), Xh(1), Xh(1)];
      y = [Xl(2),Xl(2),Xg(2);Xg(2), Xh(2), Xh(2)];
      plot(x, y, 'r');
      hold on

      fprintf('%f %f %f %d %d\n', Xnew, ynew, k, i);
      
      
      if i>=imax && max([norm(Xl-Xg),norm(Xl-Xh),norm(Xh-Xg)])<epsilon && abs(yh - yl) < epsilon
          disp('Patenkintos sustojimo salygos.');
          break
      end    
      k=k+1;
%       X0=X1;
end
grid on
end