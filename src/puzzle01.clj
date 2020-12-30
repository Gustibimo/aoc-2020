
(ns playground.aoc-2020.puzzle01
  (:require [clojure.java.io :as io]))


;; Part one
(def test-input [1721
            979
            366
            299
            675
            1456])

(def input
  (map #(Long/parseLong %)
       (line-seq (io/reader(io/resource "input1.txt" )))))

(set
 (for [x input
       y input
       :when (= 2020 (+ x y))]
   (* x y)))

;;part two

(set
 (for [x input
       y input
       z input
       :when (= 2020 (+ x y z))]
   (* x y z)))
