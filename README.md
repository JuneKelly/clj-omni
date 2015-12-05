# omni

A simple, lightweight, global system manager.
Register values with omni, then retrieve them later.

## Usage

Require the `omni.core` namespace:
```clojure
(ns whatever.core
  (:require [omni.core :as omni]))
...
```

Register a value you want to access throughout your application:
```clojure
(omni/register! :db {:host "localhost" :user "user" :pass "a_bad_password"})
```

Retrieve a value (or `nil`):
```clojure
(let [db (omni/want :db)]
  ...)
```

Insist on getting a value, raise an exception if not found:
```clojure
(let [db (omni/need! :db)]
  ...)
```

## Why use Omni instead of Component?

Because Omni is massively simpler, and doesn't require full-app buy-in.
I've got nothing against Component, it's a great tool, but sometimes you really
just want your "system" to be a global lookup table, without any other baggage.


## License

Copyright © 2015 Shane Kilkelly

Distributed under the MIT license.
