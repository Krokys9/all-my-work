module Name where
import Test.QuickCheck




-- excercise  1
nAnd :: Bool -> Bool -> Bool
nAnd x y = not(x && y)


nAnd2 True x = not (x)
nAnd2 False _ = True
 
nAnd1 True True = False
nAnd1 _ _ = True

--second  excercise 
nAnd3 x y = not x || not y

prop_nAnd :: Bool -> Bool -> Bool
prop_nAnd x y = (nAnd x y == nAnd1 x y) && (nAnd2 x y == nAnd3 x y) 

prop_nAnd2 x y 
      | x == False || y == False = True == nAnd1 x y 
      | otherwise = True 

--third exercise 

nDigits :: Integer -> Int
nDigits x
    | x>=0 = length(show x)
    | x<0 = nDigits(abs x)

--fourth excr

nRoots:: Float -> Float -> Float -> Float
nRoots a b c
    | a == 0 = error "can't be 0" 
    | (b^2) > d =2 
    | (b^2) == d = 1
    | (b^2) < d = 0
     where d = 4 * c * a
-- fifth excersise 
smallerRoot:: Float -> Float -> Float -> Float

largerRoot:: Float -> Float -> Float -> Float

mainRoot:: Float -> Float -> Float -> Float -> Float
mainRoot a b c m = (((-b) + (sqrt(b^2 - 4*a*c)*m))/(2*a))

smallerRoot a b c
     | nRoots a b c == 0 = error "no roots"
     | nRoots a b c == 1 = mainRoot a b c 1.0
     | nRoots a b c == 2 =  min a1 a2
     where 
     a1 = mainRoot a b c 1.0 
     a2 = mainRoot a b c (-1.0)

largerRoot a b c
     | nRoots a b c == 0 = error "no roots"
     | nRoots a b c == 1 = mainRoot a b c 1.0
     | nRoots a b c == 2 =  max a1 a2
     where 
     a1 = mainRoot a b c 1.0 
     a2 = mainRoot a b c (-1.0)
-- 6 excersisce 
power2 :: Integer -> Integer
power2 x
    | x == 0 = 1
    | x > 0 =2* power2 (x-1)
    | otherwise = 0
-- 7 excercise

mult :: Integer -> Integer -> Integer
mult 0 m = 0
mult m 0 = 0
mult m n 
    | m <0 && n < 0 = n + mult a b --
    | m < 0 || n < 0 = (-1) * mult a b
    | otherwise = n + mult (m-1) n
    where 
    a = abs(m)
    b = abs(n)

--excer 8 
prod :: Integer -> Integer -> Integer
prod m n 
    | m < n = error " m is greater than n"
    | m > n = m* prod (m-1) n
    | m == n = n
factorial :: Integer -> Integer
factorial n = prod n 1
