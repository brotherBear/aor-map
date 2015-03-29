(ns domain.board
   (:require [clojure.data.json :as json]))

(defrecord Area [name pre?])

(defrecord Province [name alias capacity]
  Object
  (toString [this]
    (str "CREATE (" (:alias this) ":Province { name:'" (:name this) "', alias:'" (:alias this) "', capacity:" (:capacity this) "})")))

(defn create-conn [p1 p2 & conns]
  (str "CREATE (" (:alias p1) ") - [:CONNECT_BY_LAND] -> (" (:alias p2) ")"))


(defn to-json [record]
  (json/write-str record))