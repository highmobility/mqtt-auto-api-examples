package com.highmobility.mqttsample.sampleUtil;

import java.security.KeyStore;

public class KeyStorePasswordPair {
    public KeyStore getKeyStore() {
        return keyStore;
    }

    public String getKeyPassword() {
        return keyPassword;
    }

    private KeyStore keyStore;
    private String keyPassword;

    public KeyStorePasswordPair(KeyStore keyStore, String keyPassword) {
        this.keyStore = keyStore;
        this.keyPassword = keyPassword;
    }
}
