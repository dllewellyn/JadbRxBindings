# RxBindings for Jadb

This library is intended to provide a way of calling Jadb with Rx bindings

## Gradle

Install in gradle

```
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.vidstige:jadb:v1.1.0'
    implementation 'com.github.dllewellyn:JadbRxBindings:master-SNAPSHOT'
}
```

Usage

```
JadbConnectionObservableAdapter adapter = new JadbConnectionObservableAdapter(new JadbConnection());
adapter.getDevices().subscribe()
```