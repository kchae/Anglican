;; gorilla-repl.fileformat = 1

;; **
;;; Boiler-plate code --- importing necessary things.
;; **

;; @@
(use 'nstools.ns)
(ns+ lang
  (:like anglican-user.worksheet)
  (:use [anglican core runtime emit stat])
  (:require [gorilla-plot.core :as plot])
    )
;; @@
;; =>
;;; {"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"},{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}],"value":"[nil,nil]"}
;; <=

;; **
;;; Let us define a simple query.
;; **

;; @@
;*** Interpreter ***
;Test1
(eval-exp (NUM 40) 5)
;Test2
(eval-exp (VAR "x") 10)
;Test3
(eval-exp (BEX (BBEX (GT (NUM 8) (NUM 9)))) 2)
;Test4
(eval-exp (BEX (ABEX (PLUS (NUM 5) (NUM 6)))) 2)
;Test5
(eval-exp
  (ITE (BEX (BBEX (GT (VAR "x") (NUM 4))))
       (NUM 102)
       (NUM 53)
    ) 3)


;*** Transformation rules ***
"[Original-1]"
(str-exp (ITE (BEX (BBEX (LT (VAR "x") (NUM 10))))
              (VAR "x")
              (NUM 20)))
"[Transformed-1]"
(str-exp
  (trule/trans-exp
    (ITE (BEX (BBEX (LT (VAR "x") (NUM 10))))
         (VAR "x")
         (BEX (ABEX (MINUS (NUM 0) (VAR "x"))))) 100 200 300))

"[Original-2]"
(str-exp
  (BEX (ABEX
           (PLUS (NUM 10)
                 (NUM 20)))))
"[Transformed-2]"
(str-exp
  (trule/trans-exp
    (BEX (ABEX
           (PLUS (NUM 10)
                 (NUM 20)))) 1 2 3))
"[Original-3]"
(str-exp
  (UEX (NOT
         (BEX (BBEX
                (LT (VAR "y")
                    (NUM 10)))))))
"[Transformed-3]"
(str-exp
  (trule/trans-exp
    (UEX (NOT
           (BEX (BBEX
                  (LT (VAR "y")
                      (NUM 10)))))) 1 2 3))




;; @@
;; =>
;;; {"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"html","content":"<span class='clj-long'>40</span>","value":"40"},{"type":"html","content":"<span class='clj-long'>10</span>","value":"10"}],"value":"[40,10]"},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[[40,10],false]"},{"type":"html","content":"<span class='clj-long'>11</span>","value":"11"}],"value":"[[[40,10],false],11]"},{"type":"html","content":"<span class='clj-long'>53</span>","value":"53"}],"value":"[[[[40,10],false],11],53]"},{"type":"html","content":"<span class='clj-string'>&quot;[Original-1]&quot;</span>","value":"\"[Original-1]\""}],"value":"[[[[[40,10],false],11],53],\"[Original-1]\"]"},{"type":"html","content":"<span class='clj-string'>&quot;IF (LT(VAR(x),NUM(10))) THEN (VAR(x)) ELSE (NUM(20))&quot;</span>","value":"\"IF (LT(VAR(x),NUM(10))) THEN (VAR(x)) ELSE (NUM(20))\""}],"value":"[[[[[[40,10],false],11],53],\"[Original-1]\"],\"IF (LT(VAR(x),NUM(10))) THEN (VAR(x)) ELSE (NUM(20))\"]"},{"type":"html","content":"<span class='clj-string'>&quot;[Transformed-1]&quot;</span>","value":"\"[Transformed-1]\""}],"value":"[[[[[[[40,10],false],11],53],\"[Original-1]\"],\"IF (LT(VAR(x),NUM(10))) THEN (VAR(x)) ELSE (NUM(20))\"],\"[Transformed-1]\"]"},{"type":"html","content":"<span class='clj-string'>&quot;PLUS(PLUS(MULT(NUM(100),VAR(x)),MULT(NUM(200),MINUS(NUM(0),VAR(x)))),NUM(300))&quot;</span>","value":"\"PLUS(PLUS(MULT(NUM(100),VAR(x)),MULT(NUM(200),MINUS(NUM(0),VAR(x)))),NUM(300))\""}],"value":"[[[[[[[[40,10],false],11],53],\"[Original-1]\"],\"IF (LT(VAR(x),NUM(10))) THEN (VAR(x)) ELSE (NUM(20))\"],\"[Transformed-1]\"],\"PLUS(PLUS(MULT(NUM(100),VAR(x)),MULT(NUM(200),MINUS(NUM(0),VAR(x)))),NUM(300))\"]"},{"type":"html","content":"<span class='clj-string'>&quot;[Original-2]&quot;</span>","value":"\"[Original-2]\""}],"value":"[[[[[[[[[40,10],false],11],53],\"[Original-1]\"],\"IF (LT(VAR(x),NUM(10))) THEN (VAR(x)) ELSE (NUM(20))\"],\"[Transformed-1]\"],\"PLUS(PLUS(MULT(NUM(100),VAR(x)),MULT(NUM(200),MINUS(NUM(0),VAR(x)))),NUM(300))\"],\"[Original-2]\"]"},{"type":"html","content":"<span class='clj-string'>&quot;PLUS(NUM(10),NUM(20))&quot;</span>","value":"\"PLUS(NUM(10),NUM(20))\""}],"value":"[[[[[[[[[[40,10],false],11],53],\"[Original-1]\"],\"IF (LT(VAR(x),NUM(10))) THEN (VAR(x)) ELSE (NUM(20))\"],\"[Transformed-1]\"],\"PLUS(PLUS(MULT(NUM(100),VAR(x)),MULT(NUM(200),MINUS(NUM(0),VAR(x)))),NUM(300))\"],\"[Original-2]\"],\"PLUS(NUM(10),NUM(20))\"]"},{"type":"html","content":"<span class='clj-string'>&quot;[Transformed-2]&quot;</span>","value":"\"[Transformed-2]\""}],"value":"[[[[[[[[[[[40,10],false],11],53],\"[Original-1]\"],\"IF (LT(VAR(x),NUM(10))) THEN (VAR(x)) ELSE (NUM(20))\"],\"[Transformed-1]\"],\"PLUS(PLUS(MULT(NUM(100),VAR(x)),MULT(NUM(200),MINUS(NUM(0),VAR(x)))),NUM(300))\"],\"[Original-2]\"],\"PLUS(NUM(10),NUM(20))\"],\"[Transformed-2]\"]"},{"type":"html","content":"<span class='clj-string'>&quot;PLUS(NUM(10),NUM(20))&quot;</span>","value":"\"PLUS(NUM(10),NUM(20))\""}],"value":"[[[[[[[[[[[[40,10],false],11],53],\"[Original-1]\"],\"IF (LT(VAR(x),NUM(10))) THEN (VAR(x)) ELSE (NUM(20))\"],\"[Transformed-1]\"],\"PLUS(PLUS(MULT(NUM(100),VAR(x)),MULT(NUM(200),MINUS(NUM(0),VAR(x)))),NUM(300))\"],\"[Original-2]\"],\"PLUS(NUM(10),NUM(20))\"],\"[Transformed-2]\"],\"PLUS(NUM(10),NUM(20))\"]"},{"type":"html","content":"<span class='clj-string'>&quot;[Original-3]&quot;</span>","value":"\"[Original-3]\""}],"value":"[[[[[[[[[[[[[40,10],false],11],53],\"[Original-1]\"],\"IF (LT(VAR(x),NUM(10))) THEN (VAR(x)) ELSE (NUM(20))\"],\"[Transformed-1]\"],\"PLUS(PLUS(MULT(NUM(100),VAR(x)),MULT(NUM(200),MINUS(NUM(0),VAR(x)))),NUM(300))\"],\"[Original-2]\"],\"PLUS(NUM(10),NUM(20))\"],\"[Transformed-2]\"],\"PLUS(NUM(10),NUM(20))\"],\"[Original-3]\"]"},{"type":"html","content":"<span class='clj-string'>&quot;NOT(LT(VAR(y),NUM(10)))&quot;</span>","value":"\"NOT(LT(VAR(y),NUM(10)))\""}],"value":"[[[[[[[[[[[[[[40,10],false],11],53],\"[Original-1]\"],\"IF (LT(VAR(x),NUM(10))) THEN (VAR(x)) ELSE (NUM(20))\"],\"[Transformed-1]\"],\"PLUS(PLUS(MULT(NUM(100),VAR(x)),MULT(NUM(200),MINUS(NUM(0),VAR(x)))),NUM(300))\"],\"[Original-2]\"],\"PLUS(NUM(10),NUM(20))\"],\"[Transformed-2]\"],\"PLUS(NUM(10),NUM(20))\"],\"[Original-3]\"],\"NOT(LT(VAR(y),NUM(10)))\"]"},{"type":"html","content":"<span class='clj-string'>&quot;[Transformed-3]&quot;</span>","value":"\"[Transformed-3]\""}],"value":"[[[[[[[[[[[[[[[40,10],false],11],53],\"[Original-1]\"],\"IF (LT(VAR(x),NUM(10))) THEN (VAR(x)) ELSE (NUM(20))\"],\"[Transformed-1]\"],\"PLUS(PLUS(MULT(NUM(100),VAR(x)),MULT(NUM(200),MINUS(NUM(0),VAR(x)))),NUM(300))\"],\"[Original-2]\"],\"PLUS(NUM(10),NUM(20))\"],\"[Transformed-2]\"],\"PLUS(NUM(10),NUM(20))\"],\"[Original-3]\"],\"NOT(LT(VAR(y),NUM(10)))\"],\"[Transformed-3]\"]"},{"type":"html","content":"<span class='clj-string'>&quot;NOT(LT(VAR(y),NUM(10)))&quot;</span>","value":"\"NOT(LT(VAR(y),NUM(10)))\""}],"value":"[[[[[[[[[[[[[[[[40,10],false],11],53],\"[Original-1]\"],\"IF (LT(VAR(x),NUM(10))) THEN (VAR(x)) ELSE (NUM(20))\"],\"[Transformed-1]\"],\"PLUS(PLUS(MULT(NUM(100),VAR(x)),MULT(NUM(200),MINUS(NUM(0),VAR(x)))),NUM(300))\"],\"[Original-2]\"],\"PLUS(NUM(10),NUM(20))\"],\"[Transformed-2]\"],\"PLUS(NUM(10),NUM(20))\"],\"[Original-3]\"],\"NOT(LT(VAR(y),NUM(10)))\"],\"[Transformed-3]\"],\"NOT(LT(VAR(y),NUM(10)))\"]"}
;; <=

;; @@

;; @@

;; @@

;; @@
