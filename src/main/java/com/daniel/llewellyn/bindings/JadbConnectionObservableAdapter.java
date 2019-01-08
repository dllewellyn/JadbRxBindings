package com.daniel.llewellyn.bindings;

import io.reactivex.Single;
import se.vidstige.jadb.JadbConnection;
import se.vidstige.jadb.JadbDevice;

import java.util.List;

public class JadbConnectionObservableAdapter {

    final JadbConnection connection;

    public JadbConnectionObservableAdapter(final JadbConnection connection) {
        this.connection = connection;
    }

    public Single<List<JadbDevice>> getDevices() {
        return Single.create(emitter -> emitter.onSuccess(this.connection.getDevices()));
    }

    public Single<String> getHostVersion() {
        return Single.create(emitter -> emitter.onSuccess(this.connection.getHostVersion()));
    }
}
