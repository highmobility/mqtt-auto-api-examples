/*
 * Copyright 2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.highmobility.mqttsample.sampleUtil;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.List;

/**
 * This is a helper class to facilitate reading of the configurations and
 * certificate from the resource files.
 */
public class SampleUtil {


  public static KeyStorePasswordPair getKeyStorePasswordPair(final String certificateString, final String privateKeyString) {
    PrivateKey privateKey;
    List<Certificate> certificates;

    try (BufferedInputStream stream = new BufferedInputStream(new ByteArrayInputStream(certificateString.getBytes()))) {
      final CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
      certificates = (List<Certificate>) certFactory.generateCertificates(stream);
    } catch (IOException | CertificateException e) {
      System.out.println("Failed to load certificate");
      return null;
    }

    try (DataInputStream stream = new DataInputStream(new ByteArrayInputStream(privateKeyString.getBytes()) {
    })) {
      privateKey = PrivateKeyReader.getPrivateKey(stream, "RSA");
    } catch (IOException | GeneralSecurityException e) {
      System.out.println("Failed to load private key ");
      return null;
    }

    return createKeyStorePasswordPair(certificates, privateKey);
  }


  private static KeyStorePasswordPair createKeyStorePasswordPair(final List<Certificate> certificates, final PrivateKey privateKey) {
    KeyStore keyStore;
    String keyPassword;
    try {
      keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
      keyStore.load(null);

      // randomly generated key password for the key in the KeyStore
      keyPassword = new BigInteger(128, new SecureRandom()).toString(32);

      Certificate[] certChain = new Certificate[certificates.size()];
      certChain = certificates.toArray(certChain);
      keyStore.setKeyEntry("alias", privateKey, keyPassword.toCharArray(), certChain);
    } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) {
      System.out.println("Failed to create key store");
      return null;
    }

    return new KeyStorePasswordPair(keyStore, keyPassword);
  }
}
