function atsakymas=AuksinisPjuvis(X0, gradientas)
% Dalijimo pusiau metodu randamas funkcijos f(x) minimumas intervale [l,r].


f=@(X) (X(1).^2).*X(2) + X(1).*(X(2).^2) - X(1).*X(2);
f1=@(t) f(X0-t*gradientas);
l=0;   % apatinis intervalo rezis
r=3.4;  % desinysis intervalo rezis

epsilon=10^(-4); %tikslumas
k=1; %iteraciju skaitliukas
kmax=100; % maksimalus iteraciju skaitliukas


%Metodo realizavimas
L=r-l;      %intervalo ilgis
t=(sqrt(5)-1)/2; %aukso pjuvis

x1=r-t*L;
x2=l+t*L;
y1=f1(x1);
y2=f1(x2);

format short   % Jeigu noresi trumpesnio formato, uzkomentuok eilute :)
while L>= epsilon
%       disp([x1, y1, k, k+2]);
%       hold on
%       plot(x1, y1, 'r o');
      if y2 < y1
          l=x1;
          L=r-l;
          x1=x2;
          y1=y2;
          x2=l+t*L;
          y2=f1(x2);
      else
          r=x2;
          L=r-l;
          x2=x1;
          y2=y1;
          x1=r-t*L;
          y1=f1(x1);
      end
      if k==kmax
%           disp(['Pasiektas maksimalus iteraciju skaicius k=', num2str(kmax)]);
          break
      end    
      k=k+1;
      L=r-l;
end
gama=x1;
itsk=k+2;
atsakymas=[gama, itsk];
end