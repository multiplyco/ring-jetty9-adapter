(ns build
  (:require [clojure.tools.build.api :as b]))

(defn compile-handlers
  "Compile the two generated Jetty handler classes needed by source dependencies."
  [_]
  (b/compile-clj {:basis (b/create-basis {:project "deps.edn"})
                  :class-dir "target/classes"
                  :ns-compile '[ring.adapter.jetty9.handlers.sync
                                ring.adapter.jetty9.handlers.async]})
  (spit "target/classes/.prepared" ""))
