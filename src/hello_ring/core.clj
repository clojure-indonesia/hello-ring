(ns hello-ring.core
  (:require [ring.adapter.jetty :refer [run-jetty]])
  (:gen-class))

(defn handler
  [_]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello, Ring!"})

(defn -main
  [& [port]]
  (let [port (or port (get (System/getenv) "PORT" 3000))
        port (cond-> port (string? port) Integer/parseInt)]
    (run-jetty handler {:port port
                        :join? false})))
