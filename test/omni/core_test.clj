(ns omni.core-test
  (:require [clojure.test :refer :all]
            [omni.core :as omni]))



(deftest basics

  (testing "retrieving with no key in system"
    (do
      (omni/clear!)
      (let [db (omni/want :db)]
        (is (nil? db)))))

  (testing "adding and retrieving"
    (do
      (omni/register! :db {:host "localhost" :user "user" :pass "pass"})
      (let [db (omni/want :db)]
        (is (not (nil? db)))
        (is (= "user" (:user db))))))

  (testing "Removing from system"
    (do
      (omni/register! :db {:host "localhost" :user "user" :pass "pass"})
      (omni/clear!)
      (let [db (omni/want :db)]
        (is (nil? db))))))
