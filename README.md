# omni

A simple, lightweight, global service locator.
Register values with omni, then retrieve them later.

[![Clojars Project](http://clojars.org/omni/latest-version.svg)](http://clojars.org/omni)

## Install

From [clojars](https://clojars.org/omni):

```clojure
;; in project.clj dependencies
[omni "1.0.0"]
```

## Usage

Require the `omni.core` namespace:
```clojure
(ns whatever.core
  (:require [omni.core :as omni]))
...
```

Register a value you want to access throughout your application:
```clojure
(omni/register! :config {:debug false :app-secret "a-terrible-secret" ...})
(omni/register! :db     {:connection ...})
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
Just shove things into `omni`, and pluck them out later.

I've got nothing against Component, it's a great tool, but sometimes you really
just want your "system" to be a global lookup table, without any other baggage.


## License

Copyright © 2015 Shane Kilkelly

Distributed under the MIT license.
