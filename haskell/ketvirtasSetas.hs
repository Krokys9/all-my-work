module KetvirtasSetas where

import Test.QuickCheck
import Data.List
import Control.Applicative

data GTree a = Leaf a | Gnode [GTree a]
 deriving (Eq,Ord,Show,Read)

dfsDepth' step (Leaf a) = [step] 
dfsDepth' step (Gnode leafs) 
  | length(leafs) > 1  =
     dfsDepth' inc firstValue ++ dfsDepth' step  -- making list 
  | length(leafs) == 1 = dfsDepth' inc firstValue -- if first then that 
  | otherwise = []
  where 
    firstValue = head leafs
    remainder = Gnode (tail leafs)
    inc = step + 1 

dfsDepth (Leaf a) = 0
dfsDepth (Gnode node) = maximum depthList
  where depthList = dfsDepth' 0 (Gnode node)
  
dfs f (Leaf a) = f a
dfs f (Gnode leafs) = 
   if length(leafs) > 1 then
     if dfs f (head leafs) then True
     else dfs f (Gnode (tail leafs))
   else False

dfsOccurs value node = dfs (==value) node

dMap ::(a->a) -> GTree a -> GTree a
dMap f (Leaf v) = Leaf (f v)
dMap f (Gnode leafs) = Gnode( map (dMap f) leafs)



 -- tree =  Gnode [Leaf 1, Gnode [Leaf 2, Leaf 3, Gnode[Leaf 4]], Leaf 5]













-- exr 2


data Expr a = Lit a | EVar Var | Op (Ops a) [Expr a]
type Ops a = [a] -> a
type Var = Char

data Valuation a = Valuation [(a,Var)]


 -- what i need to do is for each thing return value? and then what i need to do
 -- is for each bum bum add all soo for Lit a just lit a for Evar get value from valutation boom bom 
 -- if no valutation then gg return error can't valaute 
 -- if we get Opertaion that is boom of expressions and we return a single value Lit ? 
eval :: Valuation a -> Expr a -> a
eval _ (Lit a) = a
eval valuat (EVar var) = valuating valuat
  where
     valuating (Valuation []) = error "there is no such EVAR"
     valuating (Valuation ((x,v):xs)) = if var == v then x else valuating (Valuation xs)
eval valuat (Op ops expr) = (ops. map (eval valuat) ) expr


-- for testing 

values :: Valuation Integer
values = Valuation [( 1,'a'), (2,'b'), (3,'c')]
e1 = Op sum [Lit 6, EVar 'a']
fullExp = Op sum [e1,Lit 10]
testExpr = eval values fullExp



-- exr 3
-- aštuntas exirsise scanr? foldr?
splits :: [a] -> [([a],[a])]
splits xs = foldr (\x completeList -> (splitAt x xs)  : completeList) [splitAt n xs] [0..(n-1)]   -- 0 - 3 mes splitinam ir pakeiciam listo elemntus i stringus
  where n = length xs

type RegExp = String -> Bool

epsilon :: RegExp
epsilon = (=="")

char :: Char -> RegExp
char ch = (==[ch])

(|||) :: RegExp -> RegExp -> RegExp
e1 ||| e2 = \x -> e1 x || e2 x


(<*>) :: RegExp -> RegExp -> RegExp
e1 <*> e2 = \x -> or [e1 y && e2 z | (y,z) <- splits x]

star :: RegExp -> RegExp
star p = epsilon ||| plus p

option :: RegExp -> RegExp
option p = epsilon ||| p

test31 = option (char 'x') "x"
test32 = option (char 'x') "xs"

plus :: RegExp -> RegExp  -- not(epsilon) && star p
plus p = (p KetvirtasSetas.<*> star p) -- STar p ir kažkaip reik padaaryt kad netiktų tusčias 
-- tiesiog nueimt iš star p epsilon ||| ?

test33 = plus (char 'x') "x"

-- ok soo <*> checks ar nors vienas satisfinio arba tiesiog tusčias

-- ketvirta užd 

data NumList a = Nlist [a]
    deriving (Show)
-- pačiam reik parašyt EQ ir odr 

instance Integral a => Eq (NumList a) where 
    (==) v1 v2 = average' v1 == average' v2
    
instance Integral a => Ord (NumList a) where 
   (<=) v1 v2 = average' v1 <= average' v2
   
average' (Nlist []) = 0
average'  (Nlist x)  = fromIntegral(sum x) / genericLength x

test41 = (Nlist [1, 2, 2, 3]) == (Nlist [1,3])
test42 = (Nlist [1, 2, 2, 4]) == (Nlist [1,3])

test43 = (Nlist [1, 2, 2, 4]) >= (Nlist [1,3])
test44 = (Nlist [1, 2, 2, 4]) >= (Nlist [1,3,500])

-- penkta užd 

data Result a = OK a | Error String
 deriving(Show)

composeResult :: (a -> KetvirtasSetas.Result b) -> (b -> KetvirtasSetas.Result c)-> (a -> KetvirtasSetas.Result c)
composeResult f g variabl =
    case f variabl of 
    OK v ->  g v
    Error a -> Error a


func1 :: Integer -> KetvirtasSetas.Result Integer
func1 x 
    |x < 0 = Error "fail"
    |otherwise =  OK (x+1)

func2 :: Integer -> KetvirtasSetas.Result Integer
func2 0 = Error "Division by zero"
func2 x = OK (ceiling (100 / fromIntegral x))

test51 = composeResult func1 func2 2

-- šėštokas 
primes :: [Integer]
primes = sieve [2 ..]

sieve (x:xs) = x : sieve [y | y <- xs, y `mod` x > 0]

goldbach :: Integer -> Bool
goldbach n 
    |n < 4 = error " must be 4 or more "
    |otherwise = foldr (\x y -> (elem x sums )&& y) True evenNum
    where 
    sums = [x+y | x <- takeWhile (<n) primes, y <- takeWhile (<=x) primes, even(x+y), x+y <=n ]
    evenNum = [4,6..n]

-- exersiss 7 
data Stream a = Cons a (Stream a)

streamtoList :: Stream a -> [a]
streamtoList (Cons x xs) = x : streamtoList xs


streamIterate :: (a -> a) -> a -> Stream a
streamIterate f seed  = Cons seed (streamIterate f (f seed))


test71 = take 10 (streamtoList(streamIterate (\x -> x+x) 1))

streamInterleave :: Stream a -> Stream a -> Stream a
streamInterleave (Cons element xs) ys = Cons element (streamInterleave ys xs)  
s1 = streamIterate (\x -> x+x) 2
s2 = streamIterate (+1) 1
s3 = streamInterleave s2 s1
test72 = take 20 $ streamtoList s3

