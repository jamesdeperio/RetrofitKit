![alt text](https://github.com/jamesdeperio/RetrofitKit/blob/master/retrofitkit.png "RetrofitKit")
[![Release](https://jitpack.io/v/jamesdeperio/RetrofitKit.svg)](https://jitpack.io/#jamesdeperio/RetrofitKit)
[![GitHub release](https://img.shields.io/github/release/jamesdeperio/RetrofitKit.svg)](https://GitHub.com/jamesdeperio/RetrofitKit/releases/)
[![GitHub tag](https://img.shields.io/github/tag/jamesdeperio/RetrofitKit.svg)](https://GitHub.com/jamesdeperio/RetrofitKit/tags/)
[![GitHub commits](https://img.shields.io/github/commits-since/jamesdeperio/RetrofitKit/v1.0.5.svg)](https://GitHub.com/jamesdeperio/RetrofitKit/commit/)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.2.71-green.svg?style=flat-square)](http://kotlinlang.org)
[![Build Status](https://img.shields.io/travis/jamesdeperio/RetrofitKit.svg?style=flat-square)](https://travis-ci.org/jamesdeperio/RetrofitKit)
[![HitCount](http://hits.dwyl.io/jamesdeperio/RetrofitKit.svg)](http://hits.dwyl.io/jamesdeperio/RetrofitKit)
[![License](https://img.shields.io/badge/License%20-Apache%202-337ab7.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://GitHub.com/jamesdeperio/RetrofitKit/graphs/commit-activity)
[![GitHub forks](https://img.shields.io/github/forks/jamesdeperio/RetrofitKit.svg?style=social&label=Fork&maxAge=2592000)](https://GitHub.com/jamesdeperio/RetrofitKit/network/)
[![GitHub stars](https://img.shields.io/github/stars/jamesdeperio/RetrofitKit.svg?style=social&label=Star&maxAge=2592000)](https://GitHub.com/jamesdeperio/RetrofitKit/stargazers/)
[![GitHub watchers](https://img.shields.io/github/watchers/jamesdeperio/RetrofitKit.svg?style=social&label=Watch&maxAge=2592000)](https://GitHub.com/jamesdeperio/RetrofitKit/watchers/)
[![GitHub followers](https://img.shields.io/github/followers/jamesdeperio.svg?style=social&label=Follow&maxAge=2592000)](https://github.com/jamesdeperio?tab=followers)
[![Open Source Helpers](https://www.codetriage.com/jamesdeperio/retrofitkit/badges/users.svg)](https://www.codetriage.com/jamesdeperio/retrofitkit)
[![Waffle.io - Columns and their card count](https://badge.waffle.io/jamesdeperio/RetrofitKit.svg?columns=all)](https://waffle.io/jamesdeperio/RetrofitKit)
[![Throughput Graph](https://graphs.waffle.io/jamesdeperio/RetrofitKit/throughput.svg)](https://waffle.io/jamesdeperio/RetrofitKit/metrics/throughput)
## How to?
### [READ FULL DOCUMENTATION](https://jamesdeperio.github.io/retrofitkit/) 
### [DEMO APK](https://github.com/jamesdeperio/CodePocketBuilderDemo/blob/master/app-debug.apk)
___
## CHANGELOG
#### v1.0.5
* FIXED: Failed to resolve: com.github.jamesdeperio:RetrofitKit:v1.0.4 on jitpack
* UPDATED: Maven dependency version to 2.1
* MERGED: PR of [@marjorietiozon](https://github.com/marjorietiozon) for synchronization of retrofit instance
* RENAMED: initRxAdapterFactory to initCallAdapterFactory
#### ~~v1.0.4 (Cannot download using jitpack due to incompatible gradle and maven version)~~
#### v1.0.3
* FIXED: interceptorConfiguration was not executed in debug mode
* MERGED: PR of [@yuelvic](https://github.com/yuelvic) for code optimization
#### v1.0.2
* UPDATED: kotlin dependency to v1.2.71
* UPDATED: gradle dependency to v3.2.0
* CHANGES: need to include retrofit and okhttp3:logging-interceptor dependency
#### v1.0.1
* Updated: kotlin dependency
* Updated: okhttp3:logging-interceptor dependency
* Fixed: exclude 'META-INF/app_release.kotlin_module'
#### v1.0.0
* Created: base class for lazy retrofit configuration
* Created: multiple converter
___
### DEPENDENCIES
Thanks to the author of external Library used:
* [org.jetbrains.kotlin:kotlin-stdlib-jdk7](https://github.com/JetBrains/kotlin/tree/master/libraries/stdlib)
* [com.squareup.retrofit2:retrofit](https://github.com/square/retrofit)
* [com.squareup.okhttp3:logging-interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor)

### LICENSE
```
Copyright 2018 The RetrofitKit Author

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
