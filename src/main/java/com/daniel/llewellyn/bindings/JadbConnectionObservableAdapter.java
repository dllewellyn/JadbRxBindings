package com.daniel.llewellyn.bindings;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import se.vidstige.jadb.JadbConnection;
import se.vidstige.jadb.JadbDevice;

import java.util.List;

public class JadbConnectionObservableAdapter {

    final JadbConnection connection;

    public JadbConnectionObservableAdapter(final JadbConnection connection) {
        this.connection = connection;
    }

    public Single<List<JadbDevice>> getDevices() {
        return Single.create(emitter -> {
            try {
                emitter.onSuccess(connection.getDevices());
            } catch (Exception ex) {
                emitter.onError(ex);
            }
        }
        );
    }

    public Single<String> getHostVersion() {
        return Single.create(emitter -> {
            try {
                emitter.onSuccess(this.connection.getHostVersion());
            } catch (Exception ex) {
                emitter.onError(ex);
            }
        });
    }
}
