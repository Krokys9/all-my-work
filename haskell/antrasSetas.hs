module AntrasSetas where

import Data.List
import Data.Char
import Data.Maybe

-- pirmoji užduotis
average :: [Float] -> Float
average [] = 0
average x = (suma x) / lenght x



suma :: [Float] -> Float
suma [] = 0
suma (head:tail) = (head + sum tail)

lenght:: [Float] -> Float
lenght [] = 0
lenght (_:tail) = (1+ lenght tail)

-- antra užduotis
divides :: Integer -> [Integer]
divides x 
    | x>=0 = [a | a <- [1..x], x `mod` a == 0]
    | otherwise = divides (abs x)

dividesTwoInsideRecursion :: Integer-> Integer -> [Integer] -> [Integer]
dividesTwoInsideRecursion x a xs
    | x == 0 = []
    | a <= x && x `mod` a == 0 = dividesTwoInsideRecursion x (a+1) (a:xs)
    | a <= x  = dividesTwoInsideRecursion x (a+1) xs
    |otherwise = xs


dividesTwo :: Integer -> [Integer]
dividesTwo x 
    | x < 0 = dividesTwo (abs x)
    | otherwise = dividesTwoInsideRecursion x 1 []
    

isPrime :: Integer -> Bool
isPrime a = divides a  == [1,a]

-- trečia užduotis
 -- reik pacheckint ar pirmas yra prefix antro, todėl jhei pirms iglensis už 2 tada gg, jei ne move on , tada checkinam kiekvieną raidę pradžios atimam jas ir einam toliau ?
prefix :: String -> String -> Bool
prefix  [] _ = True
prefix  _ [] = False
prefix  (x:s1) (y:s2)
    |length((x:s1)) > length((y:s2)) = False
    |otherwise = x == y && prefix s1 s2

subString :: String-> String -> Bool
subString [] _ = True
subString _ [] = False
subString s1 (x:s2)
    | length(s1) > length((x:s2)) = False
    |prefix s1 (x:s2) == False = subString s1 s2
    |otherwise =  True

-- ketvirrtaas uzduotis  padaryti funkicja kuri per du listus permutations ( same elemenets same number of times ? SO tokie patys listai ? :D tik kitokia tvarka ?
-- sugalvojau du būdus, atiminėt vieną iš kito panašius, jei gaunasi [] [] tada valio, kitu atveju tiesiog keist vietom listus, kol sueis :D  idk, geras dar būdas pagal didejimą išrikiuot ir sulygint. 
-- dar galima išmetinėt iš abiejų listų, tada gaunasi n log n sudetingumas ? + metimas ir listų perkelimas,  tai nežinau padariau su sort, nes paprasčiau tiesiog.

permut :: [Integer] -> [Integer] -> Bool
permut [] [] = True
permut x1 x2 = quicksort x1 == quicksort x2 -- lets go rock n roll

quicksort :: Ord a => [a] -> [a]
quicksort []     = []
quicksort (p:xs) = (quicksort lesser) ++ [p] ++ (quicksort greater)
    where
        lesser  = filter (< p) xs
        greater = filter (>= p) xs
-- penkta užduotis
 -- kiekvieną raidę pereiti ir tada sukelti visas pagal listą? tai jei turim listą [a..z] kurio indexa imamm 1 ... 32 ir tada kitą listą [A.....Z] 1 32 tada galim tiesiog pakeist. o tarpus išmest.
 -- dar galima gal su filteriu, kad paimam tik tuos simbolius kurie nera = tarpui ?  ir tada sukelt su capital yeah pretty much good idea  bet atrodo daug darbo nereikalingo.  jei turime lista raidžių
-- tarkim nuo [A...Z] ir leidžiam būt tik tas raides , o a pakeičiam capitalizintom raidėm tada turėsim ko norime. tik klausimas ,geriau pirma atmest simbolius ir tada cap ir tikrint ar capint ir tada i6mest ir tikrint, 
alphabet =  ['A'..'Z']
capitalise :: String -> String
capitalise s =  [a | a <- [toUpper a | a <-s] , elem a alphabet]

-- šešta užduotis 
-- parašyt dvi funckija itemTotal  kurie sumergina tokius pat daiktus ir tada jų kainas sudeda nu , kaip turi būt, apie kiekį nieko nesako tai nežn ar reik sekti
-- ir item discount first param daikto vardas, antras param discountas trečias param basketas shopinimosi 

 -- ok so lengva ir paprasta programa, pirmiausia reikia 
 
 
  -- tada itemTotal (toliau krepšys) turim sudėt vienodus daiktus. mano idėja, prasortint ir tada šalia esančius tikrint ir pridėt jei paeis, simple idea. kaip sortint pagal kainą? nah pagal abecelę būt gerai bet irgi bbž, gal tiesiog paimt pirmą 
 -- patikrint ar likęs litas cointains, ir kas tada ?  išmesiu ivena ir padvigubinu kainą, bet lieką tas gale, nes negaliu vidurio tiesiog išmest... ir kas bus jei yra daug contains tada išmetu po vieną, žiūr ar tą kur išmečiau nera tas pats, tada vėl tikrinu su likusiu listu kol nebera tokio pat?
 -- gal ir nieko idėja, paprasta, bet neprasta.
 
 -- darysiu paprastai nes tingiu labai, tiesiog darysiu naują listą
itemTotal :: [(String,Float)] -> [(String,Float)]
itemTotal basket = itemTotalManager basket [] basket []

getItemsPrice :: [(String,Float)] -> String -> Float
getItemsPrice (head:listas) name
    |null head = 0
    |length(listas) == 0 && name == fst head = snd head
    |length(listas) == 0 = 0
    |name == fst head =  snd head + getItemsPrice listas name
    |otherwise = 0 + getItemsPrice listas name

itemTotalManager :: [(String,Float)] -> [String] -> [(String,Float)] -> [(String,Float)] -> [(String,Float)]
itemTotalManager (current:basket) visited originalList result
    |elem (fst current) visited && length(basket) == 0 = result
    |not(elem (fst current) visited) && length(basket) == 0 = (current:result)
    |elem (fst current) visited = itemTotalManager basket visited originalList result
    |otherwise = itemTotalManager basket (fst current:visited) originalList (sortedItem:result)
    where
    sortedItem = ((fst current),getItemsPrice originalList (fst current))


-- sugalvojau logi6kiau daryt taip kad einam per lista  ir tada jei atitintka liste esanti daikta, tada mes jam pritaikom akcija ir dedam į return listą?
itemDiscount :: String -> Integer -> [(String,Float)]-> [(String,Float)]
itemDiscount s x listas 
    | x<= 0 = error" failed below zero"
    | x>=100 = error "above 100" 
    |otherwise = itemDiscountController s x listas []
  -- then apply discount to the price  bet tada reik sekti koks listas pas mane yra esamas? 
itemDiscountController :: String -> Integer -> [(String,Float)] -> [(String,Float)] -> [(String,Float)]
itemDiscountController s x (head:listas) currentReturn 
    |length(listas) == 0 && s == fst head = ((s,((snd head)*(1 - (fromIntegral(x)/100)))):currentReturn)
    |length(listas) == 0 = (head:currentReturn)
    |s == fst head = itemDiscountController s x listas ((s,((snd head)*(1 - (fromIntegral(x)/100)))):currentReturn)
    |otherwise = itemDiscountController s x listas (head:currentReturn)
