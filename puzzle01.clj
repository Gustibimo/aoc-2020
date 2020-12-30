(ns playgorund.aoc-2020.puzzle01)


;; Part one
(def input [1721
            979
            366
            299
            675
            1456])
(set
 (for [x input
       y input
       :when (= 2020 (+ x y))]
   (* x y)))

