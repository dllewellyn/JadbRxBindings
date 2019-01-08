package com.daniel.llewellyn.bindings;

import io.reactivex.Completable;
import io.reactivex.Single;
import se.vidstige.jadb.JadbDevice;
import se.vidstige.jadb.JadbException;
import se.vidstige.jadb.RemoteFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JadbDeviceObservableAdapter {

    private final JadbDevice device;

    public JadbDeviceObservableAdapter(final JadbDevice device) {
        this.device =  device;
    }

//    public Observable<Boolean> enableAdbOverTCP() {
//        this.device.enableAdbOverTCP();
//    }

//    public Observable<Boolean> enableAdbOverTCP(int port) {
//        this.device.enableAdbOverTCP(port);
//    }

    public Completable pushDevice(File local, RemoteFile remote){

        return Completable.create(emitter -> {
            device.push(local, remote);
            emitter.onComplete();
        });
    }

    public Completable pullDevice(RemoteFile file, File local) {
        return Completable.create(emitter -> {
            this.device.pull(file, local);
            emitter.onComplete();
        });
    }

    public Single<InputStream> executeShell(String command, String...args) throws IOException, JadbException {
        return Single.create(emitter -> {
            emitter.onSuccess(this.device.executeShell(command, args));
        });
    }

    public Single<List<RemoteFile>> list(String remotePath) throws IOException, JadbException {
        return Single.create(emitter -> {
            emitter.onSuccess(this.device.list(remotePath));
        });
    }
}
