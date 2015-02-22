--1_2_3_4_5_6_7_8_9
--from 119170003 to 119176603 by +10

import Data.Char
import Data.List

isOk :: Int -> Bool
isOk n = length str == 17 && isOk' 1 str
         where str = show (n * n)
               isOk' 9 [a] = a == '9'
               isOk' d (x:_:xs) = d == ord x - ord '0' && isOk' (d + 1) xs

main :: IO ()
main = do putStrLn $ "ending with 3: " ++ (show $ find isOk [101000003,101000013..139000003])
          putStrLn $ "ending with 7: " ++ (show $ find isOk [101000007,101000017..139000007])
--find isOk [101000003,101000013..139000003]
--find isOk [101000007,101000017..139000007]
