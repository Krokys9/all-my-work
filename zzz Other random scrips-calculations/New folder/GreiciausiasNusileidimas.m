function GreiciausiasNusileidimas

a=10;
b=10;


% X0=[0, 0];
% X1=[1, 1];
X0=[a/10, b/10];

f=@(x1, x2) (x1.^2).*x2 + x1.*(x2.^2) - x1.*x2;
% f=@(X) (X(1,1).^2).*X(1,2) + X(1,1).*(X(1,2).^2) - X(1,1).*X(1,2);

% gradf=@(x1, x2) [2.*x1.*x2 + x2.^2 - x2, x1.^2 + 2.*x1.*x2-x1];
gradf=@(X) [2.*X(1,1).*X(1,2) + X(1,2).^2 - X(1,2), X(1,1).^2 + 2.*X(1,1).*X(1,2)-X(1,1)];


epsilon=10^(-4); %tikslumas
k=1; %iteraciju skaitliukas
i=0; %funkciju kvietimu skaicius
kmax=100; % maksimalus iteraciju skaitliukas
imax=100; 
norma=Inf;
x = -1:0.1:1
y = -1:0.1:1
[xx,yy] = meshgrid(x,y);
funcMain =@(xx1,yy1)((xx1.*yy1.*(1.-xx1.-yy1)));
surf(xx,yy,funcMain(xx,yy));

hold on
disp('    x1        x2      f(x1,x2)        k         funkc. kviet. sk');
format long   % Jeigu noresi trumpesnio formato, uzkomentuok eilute :)
while norma>= epsilon
    
      gradientas=gradf(X0);
      norma=norm(gradientas);
      
      atsakymas = AuksinisPjuvis(X0, gradientas);
      gama=atsakymas(1);
      itsk=atsakymas(2);
      
      i=i+1+itsk;
      
      X1=X0-gama*gradientas;
      disp([X1, f(X1(1,1),X1(1,2)), k, i]);
      
%       subplot(1,2,2);
      plot(X1(1,1), X1(1,2), 'o');
      hold on
      
      if k==kmax
          disp(['Pasiektas maksimalus iteraciju skaicius k=', num2str(kmax)]);
          break
      end    
      k=k+1;
      X0=X1;
end
grid on
end