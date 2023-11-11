(ns hello-ring.core
  (:require [ring.adapter.jetty :refer [run-jetty]])
  (:import [java.util.concurrent Executors]
           [org.eclipse.jetty.util.thread QueuedThreadPool])
  (:gen-class))

(defn handler
  [_]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello, Ring!"})

(defn -main
  [& [port]]
  (let [port (or port (get (System/getenv) "PORT" 3000))
        port (cond-> port (string? port) Integer/parseInt)
        thread-pool (QueuedThreadPool.)
        _ (.setVirtualThreadsExecutor thread-pool (Executors/newVirtualThreadPerTaskExecutor))]
    (run-jetty handler {:port port
                        :join? false
                        :thread-pool thread-pool})))
