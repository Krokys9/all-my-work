module TreciasSetas where

import Test.QuickCheck

data Shape = Circle Float (Float,Float) | Rectangle Float Float (Float,Float)
 deriving(Eq,Ord)
 
overlaps:: Shape -> Shape -> Bool
overlaps (Circle r1 (x1,y1)) (Circle r2 (x2,y2))= sqrt((x1-x2)^2 + (y1-y2)^2) <= r1+r2 

overlaps (Rectangle w1 h1 (x1,y1)) (Rectangle w2 h2 (x2,y2)) = (not(x1+w1 < x2 || x2+w2 < x1) && not(y1+h1 < y2 || y2+h1 < y1)) == True

overlaps (Rectangle w h (x, y)) (Circle r (xc, yc)) 
    = let
        (x1, y1) = (x + w, y + h)
        x_near = max x (min xc x1) 
        y_near = max y (min yc y1) 
        dist_x = x_near - xc
        dist_y = y_near - yc
        in (dist_x ^2  + dist_y^2) <= r^2

overlaps x y = overlaps y x

test1 = overlaps (Circle 1 (2, 0)) (Rectangle 2 2 (0, 0)) 
-- to test : overlaps (Circle 1 (2, 0)) (Rectangle 2 2 (0, 0)) 
-- antra užduotis

any1 :: (a->Bool) -> [a] -> Bool
any1 a b = length(filter a b) > 0

all1 :: (a->Bool) -> [a] -> Bool
all1 a b = length(filter a b) == length b

any2 :: (a->Bool) -> [a] -> Bool
any2 f xs = foldr (||) False (map f xs)-- is listo praprenku su mepu kur aititnka a 

all2 :: (a->Bool) -> [a] -> Bool
all2 f xs = foldr (\x y -> x && y ) True (map f xs)-- is listo prap

prop_any :: [Integer] -> Bool
prop_any xs = (any1 even xs == any2 even xs) 

prop_all :: [Integer] -> Bool
prop_all xs = (all1 even xs == all2 even xs)


test21 = any1 even [1..10]
test22 = all1 even [1..10]
test23 = all2 even [1..10]
test24 = any2 even [2,4..10]


-- trecia uzduotis 
unzip1 :: [(a,b)] -> ([a],[b])
unzip1 xs  = foldr f ([],[]) xs 
    where 
      f :: (a, b) -> ([a], [b])-> ([a], [b])
      f (x1,y1) (xs,ys) = (x1:xs,y1:ys)

prop_unzip :: [(Integer,Integer)] -> Bool
prop_unzip x = unzip1 x == unzip x


test31 = unzip [(1,2), (2,3), (3,4), (4,5),(5,6)]
test32 = prop_unzip [(1,2), (2,3), (3,4), (4,5),(5,6)]
-- ketvirta užduot
lengthas1 :: [a] -> Int
lengthas1 = sum . map(\x -> 1)

lengthas2 :: [a] -> Int
lengthas2 = foldr ((+) . (\x -> 1)) 0
--exir 5 -
-- 
ff1:: Integer -> [Integer] -> Integer
ff1 bound = foldl(\x y -> if x+y < bound then x+y else x) 0 . map(\x -> x*10) . filter(>0)
test5 = ff1 150 [1..50]
-- exir 6 
total1:: (Integer -> Integer) -> Integer -> Integer
total1 f 0 = 0
total1 f n = (sum . map f) [0..n]
test6 = total1 (\x -> negate(x)) 10 

--exirsise 7 
 -- reikejo f.f.f.f.f.f.f.f padaryt kai dauota kiek kartu  f pasikartoti turi ir kokia f
 
iter  :: Integer -> (a->a) -> (a ->a)
iter n f 
    | n <= 0 = id 
    | otherwise  = f . iter (n-1) f
   
   
   -- 
iter2 :: Integer -> (a->a) -> (a ->a)
iter2 n f 
    | n <= 0 = id 
    | otherwise = foldr (.) id (replicate (fromIntegral n) f) 

prop_iter :: Integer -> Integer -> Bool
prop_iter n x = iter n (*10) x == iter2 n (*10) x

-- aštuntas exirsise scanr? foldr?
splits :: [a] -> [([a],[a])]
splits xs = foldr (\x completeList -> (splitAt x xs)  : completeList) [splitAt n xs] [0..(n-1)]   -- 0 - 3 mes splitinam ir pakeiciam listo elemntus i stringus
  where n = length xs
 