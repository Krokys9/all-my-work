a = 3;
b=6;
c=2;
Xm = [a/10, b/10, c/10];

epsilon = 10^(-4);
it_sk = 1; % iterciju skaitliukas
r = 0.21; % baudos daugiklis
funKvSk = 0;

f  = @(X) -X(1) .* X(2) .* X(3); % tiklso funkcija
h1 = @(X) X(1); % nelygybinis apribojimas
h2 = @(X) X(2); % nelygybinis apribojimas
h3 = @(X) X(3); % nelygybinis apribojimas
g  = @(X) 2 .* X(1) .* X(2) + 2 .* X(1) .* X(3)+2 .* X(2) .* X(3) - 1; % lygybinis apribojimas
b  = @(X) g(X).^2 + min(0,h1(X)).^ 2 + min(0,h2(X)).^2 + min(0,h3(X)).^2;
B  = @(X,r) f(X) + 1/r .* b(X);

fprintf('Pradinis taskas: %f, %f, %f\n', Xm(1), Xm(2), Xm(3));
fprintf('%-32s | %-10s | %-10s | %-10s | %-5s | %-10s\n', 'X1', 'B(X1, r)', 'f(X1)', 'r', 'it_sk', 'f(X) kv. sk.');
fprintf('----------------------------------------------------------------------------------------------\n');

norma = Inf;
while (norma > epsilon)
  it_sk = it_sk + 1;
  simple_min = simplex(B, Xm, r);
  X1 = [simple_min(1), simple_min(2), simple_min(3)];
  funKvSk = funKvSk + simple_min(4);
  fprintf('%-10f %-10f %-10f | %-10f | %-10f | %-10f | %-5d | \t%d \n', X1, B(X1,r), f(X1), r, it_sk, funKvSk);
  norma = norm(Xm - X1);
  r = r/6;
  Xm = X1;

end
fprintf('\nRezultatai\n')
fprintf('\tKrastiniu ilgiai: ')
fprintf('\t%f, %f, %f\n', Xm(1), Xm(2), Xm(3));
fprintf('\tDezes turis: ')
fprintf('\t\t%f\n', -f(Xm));