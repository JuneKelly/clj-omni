(ns omni.core)


(defonce system-map (atom {}))


(defn register! [key val]
  (do
    (swap! system-map assoc key val)
    val))


(defn want [key]
  (key @system-map))


(defn want-or-die [key]
  (let [val (key @system-map)]
    (if (nil? val)
      (throw (Exception. (str "No registered component found for " key)))
      val)))


(defn reset! []
  (swap! system-map (fn [_] {})))
