;; gorilla-repl.fileformat = 1

;; **
;;; Boiler-plate code --- importing necessary things.
;; **

;; @@
(use 'nstools.ns)
(ns+ adt
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
;ADT implementation
;**********************

; Utility functions
(defn adt-name
  "Returns the name of the ADT that this object is a part of."
  [obj]
  (-> obj meta :adt))

(defn adt-type
  "Returns the name of the type in the ADT this was created as."
  [obj]
  (-> obj meta :adt-type))

(defn adt?
  "Returns true if this object was created by an ADT"
  [obj]
  (-> obj meta :adt boolean))

; ADT Code generation
(defn- emit-constructor
  "Generates a constructor function for a specific type in an ADT"
  [adt-name type-name & fields]
  (let [type-name# (symbol type-name)
        metadata {:adt (str adt-name) :adt-type type-name#}]
    (if (empty? fields)
      ;Can't create an empty struct, and so create map instead
      `(defn ~type-name# [] (with-meta {} ~metadata))
      ;Define a struct to collect arguments into
      `(defn ~type-name# [~@fields]
         (with-meta
           (struct (create-struct ~@(map keyword fields)) ~@fields)
           ~metadata)))))

; Macro (use this when defining a new data type)
(defmacro defadt
  "Defines an algebraic data type based on a series of constructors"
  [adt-name & constructors]
  `(do
     ;Define our test function
     (defn ~(symbol (str adt-name "?")) [~'obj]
       (= ~(str adt-name) (adt-name ~'obj)))
     ;Create our type constructor
     ~@(for [[type-name & fields] constructors]
(apply (partial emit-constructor adt-name type-name) fields))))

;; @@
;; =>
;;; {"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"html","content":"<span class='clj-var'>#&#x27;adt-tree/adt-name</span>","value":"#'adt-tree/adt-name"},{"type":"html","content":"<span class='clj-var'>#&#x27;adt-tree/adt-type</span>","value":"#'adt-tree/adt-type"}],"value":"[#'adt-tree/adt-name,#'adt-tree/adt-type]"},{"type":"html","content":"<span class='clj-var'>#&#x27;adt-tree/adt?</span>","value":"#'adt-tree/adt?"}],"value":"[[#'adt-tree/adt-name,#'adt-tree/adt-type],#'adt-tree/adt?]"},{"type":"html","content":"<span class='clj-var'>#&#x27;adt-tree/emit-constructor</span>","value":"#'adt-tree/emit-constructor"}],"value":"[[[#'adt-tree/adt-name,#'adt-tree/adt-type],#'adt-tree/adt?],#'adt-tree/emit-constructor]"},{"type":"html","content":"<span class='clj-var'>#&#x27;adt-tree/defadt</span>","value":"#'adt-tree/defadt"}],"value":"[[[[#'adt-tree/adt-name,#'adt-tree/adt-type],#'adt-tree/adt?],#'adt-tree/emit-constructor],#'adt-tree/defadt]"}
;; <=

;; @@

;; @@

;; @@

;; @@
