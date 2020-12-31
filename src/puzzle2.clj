(ns playground.aoc-2020.puzzle2
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

(def sample-input "1-3 a: abcde
 1-3 b: cdefg
 2-9 c: ccccccccc")

(defn parse-long [l]
  (Long/parseLong l))

(defn parse-line [s]
  (let [[_ min max char pwd] (re-find #"(\d+)-(\d+) (.): (.*)" s)]
    [(parse-long min) (parse-long max) (first char) pwd]))

(def entry (-> sample-input
    (str/split #"\n")
    first
    parse-line
    ;;(->> (map parse-line))
    ))

(defn entry-ok? [[min max char pwd]]
  (<= min (get (frequencies pwd) char 0) max))

(def input
  (map parse-line (line-seq (io/reader(io/resource "resources/input2.txt" )))))

(count (filter entry-ok? input))

;;part two
(defn entry-ok2? [[min max char pwd]]
  (let [ok1 (= (nth pwd (dec min)) char)
        ok2 (= (nth pwd (dec max)) char)]
    (not= ok1 ok2)))

(count (filter entry-ok2? input))







