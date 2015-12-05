(ns omni.core
  (:require [omni.core :as omni]))


(defonce system-map (atom {}))


(defn register!
  "Register a value in the system map under a given key.
  Example: `(omni/register! :db {:connection ...})`"
  [key val]
  (do
    (swap! system-map assoc key val)
    val))


(defn want
  "Get a value from the system map, identified by the supplied key.
  Produces nil if the key is not present"
  [key]
  (key @system-map))


(defn need!
  "Get a value from the system map, identified by the supplied key.
  Raises an Exception if the key is not present"
  [key]
  (let [val (key @system-map)]
    (if (nil? val)
      (throw (Exception. (str "No registered component found for " key)))
      val)))


(defn clear!
  "Empty the system map."
  []
  (swap! system-map (fn [_] {})))
