(ns domain.board
   (:require [clojure.data.json :as json]))

(defrecord Area [name pre?])

;; Craft a method to generate a list of Provinces from a text file
(defrecord Province [name alias capacity]
  Object
  (toString [this]
    (str "CREATE (" (:alias this) ":Province { name:'" (:name this) "', alias:'" (:alias this) "', capacity:" (:capacity this) "})")))

;; I want to return a list of strings from this method
(defn create-conn [p1 p2 & conns]
  (str "CREATE (" (:alias p1) ") - [:CONNECT_BY_LAND] -> (" (:alias p2) ")"))


(defn to-json [record]
  (json/write-str record))

;; Example for how to generate bidirectional relations for two provinces.

;; First create an index for faster lookup
;; Create index on :Province(name)

;; Match (a:Province{name:'Oran'}),(b:Province{name:'Algiers'} )
;; merge (a)-[:CONNECT_BY_LAND]->(b)
;; merge (b)-[:CONNECT_BY_LAND]->(a)
;; merge (a)-[:CONNECT_BY_COAST]->(b)
;; merge (b)-[:CONNECT_BY_COAST]->(a)

