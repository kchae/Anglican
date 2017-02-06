;; gorilla-repl.fileformat = 1

;; **
;;; Boiler-plate code --- importing necessary things.
;; **

;; @@
(use 'nstools.ns)
(ns+ tree
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
;**********************
;ADT practice with tree
;**********************

; Define a new data type: tree
(defadt tree
  (Empty)
  (Leaf value)
  (Node left right)
  )

; Define a (depth) function on the data type
(defmulti depth adt-type) ;adt-type here is a dispatch function.
(defmethod depth Empty [_] 0)
(defmethod depth Leaf [_] 1)
(defmethod depth Node [node]
  (+ 1 (max (depth (node :left)) (depth (node :right)))))
(defmethod depth :default [_] 0)

; Test
(let [tree (Node (Node (Leaf 3) (Leaf 100)) (Leaf 2))]
  (depth tree))

;; @@
;; =>
;;; {"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"html","content":"<span class='clj-var'>#&#x27;tree/adt-name</span>","value":"#'tree/adt-name"},{"type":"html","content":"<span class='clj-var'>#&#x27;tree/adt-type</span>","value":"#'tree/adt-type"}],"value":"[#'tree/adt-name,#'tree/adt-type]"},{"type":"html","content":"<span class='clj-var'>#&#x27;tree/adt?</span>","value":"#'tree/adt?"}],"value":"[[#'tree/adt-name,#'tree/adt-type],#'tree/adt?]"},{"type":"html","content":"<span class='clj-var'>#&#x27;tree/emit-constructor</span>","value":"#'tree/emit-constructor"}],"value":"[[[#'tree/adt-name,#'tree/adt-type],#'tree/adt?],#'tree/emit-constructor]"},{"type":"html","content":"<span class='clj-var'>#&#x27;tree/defadt</span>","value":"#'tree/defadt"}],"value":"[[[[#'tree/adt-name,#'tree/adt-type],#'tree/adt?],#'tree/emit-constructor],#'tree/defadt]"},{"type":"html","content":"<span class='clj-var'>#&#x27;tree/Node</span>","value":"#'tree/Node"}],"value":"[[[[[#'tree/adt-name,#'tree/adt-type],#'tree/adt?],#'tree/emit-constructor],#'tree/defadt],#'tree/Node]"},{"type":"html","content":"<span class='clj-var'>#&#x27;tree/depth</span>","value":"#'tree/depth"}],"value":"[[[[[[#'tree/adt-name,#'tree/adt-type],#'tree/adt?],#'tree/emit-constructor],#'tree/defadt],#'tree/Node],#'tree/depth]"},{"type":"html","content":"<span class='clj-unkown'>#multifn[depth 0x64227904]</span>","value":"#multifn[depth 0x64227904]"}],"value":"[[[[[[[#'tree/adt-name,#'tree/adt-type],#'tree/adt?],#'tree/emit-constructor],#'tree/defadt],#'tree/Node],#'tree/depth],#multifn[depth 0x64227904]]"},{"type":"html","content":"<span class='clj-unkown'>#multifn[depth 0x64227904]</span>","value":"#multifn[depth 0x64227904]"}],"value":"[[[[[[[[#'tree/adt-name,#'tree/adt-type],#'tree/adt?],#'tree/emit-constructor],#'tree/defadt],#'tree/Node],#'tree/depth],#multifn[depth 0x64227904]],#multifn[depth 0x64227904]]"},{"type":"html","content":"<span class='clj-unkown'>#multifn[depth 0x64227904]</span>","value":"#multifn[depth 0x64227904]"}],"value":"[[[[[[[[[#'tree/adt-name,#'tree/adt-type],#'tree/adt?],#'tree/emit-constructor],#'tree/defadt],#'tree/Node],#'tree/depth],#multifn[depth 0x64227904]],#multifn[depth 0x64227904]],#multifn[depth 0x64227904]]"},{"type":"html","content":"<span class='clj-unkown'>#multifn[depth 0x64227904]</span>","value":"#multifn[depth 0x64227904]"}],"value":"[[[[[[[[[[#'tree/adt-name,#'tree/adt-type],#'tree/adt?],#'tree/emit-constructor],#'tree/defadt],#'tree/Node],#'tree/depth],#multifn[depth 0x64227904]],#multifn[depth 0x64227904]],#multifn[depth 0x64227904]],#multifn[depth 0x64227904]]"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"}],"value":"[[[[[[[[[[[#'tree/adt-name,#'tree/adt-type],#'tree/adt?],#'tree/emit-constructor],#'tree/defadt],#'tree/Node],#'tree/depth],#multifn[depth 0x64227904]],#multifn[depth 0x64227904]],#multifn[depth 0x64227904]],#multifn[depth 0x64227904]],3]"}
;; <=

;; @@

;; @@

;; @@

;; @@
