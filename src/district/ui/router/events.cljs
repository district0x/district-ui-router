(ns district.ui.router.events
  (:require
    [district.ui.router.effects :as effects]
    [district.ui.router.queries :as queries]
    [re-frame.core :refer [reg-event-fx trim-v reg-fx inject-cofx]]))

(def interceptors [trim-v])

(reg-event-fx
  ::start
  interceptors
  (fn [{:keys [:db]} [{:keys [:bide-router :html5?]}]]
    {:db (-> db
           (queries/assoc-bide-router bide-router)
           (queries/assoc-html5 html5?))}))


(reg-event-fx
  ::active-page-changed
  interceptors
  (fn [{:keys [:db]} [name params query]]
    {:db (queries/assoc-active-page db {:name name :params params :query query})}))


(reg-event-fx
  ::watch-active-page
  interceptors
  (fn [{:keys [:db]} [watchers]]
    {::effects/watch-active-page watchers}))


(reg-event-fx
  ::unwatch-active-page
  interceptors
  (fn [{:keys [:db]} [watchers]]
    {::effects/unwatch-active-page watchers}))


(reg-event-fx
  ::navigate
  interceptors
  (fn [{:keys [:db]} [name params query]]
    {::effects/navigate [(queries/bide-router db) name params query]}))


(reg-event-fx
  ::replace
  interceptors
  (fn [{:keys [:db]} [name params query]]
    {::effects/replace [(queries/bide-router db) name params query]}))


(reg-event-fx
  ::stop
  interceptors
  (fn [{:keys [:db]}]
    {:db (queries/dissoc-router db)}))

