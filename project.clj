(defproject domain "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/data.json "0.2.6"]]
  :javac-options ["-target" "1.9" "-source" "1.9" "-Xlint:-options"]
  :aot [domain.core]
  :main domain.core
  :plugins [[lein-ancient "0.5.5"]])
