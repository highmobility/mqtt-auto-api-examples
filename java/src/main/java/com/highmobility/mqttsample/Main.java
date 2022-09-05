package com.highmobility.mqttsample;

import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.highmobility.mqttsample.sampleUtil.KeyStorePasswordPair;
import com.highmobility.mqttsample.sampleUtil.SampleUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


class Main {
  Logger logger = LoggerFactory.getLogger("charon.mqtt");
  KeyStorePasswordPair pair = SampleUtil.getKeyStorePasswordPair(Env.MQTT_SERVICE_CERT, Env.MQTT_SERVICE_PRIVATE_KEY);

  AWSIotMqttClient client = new AWSIotMqttClient(
    Env.MQTT_CLIENT_ENDPOINT,
    Env.MQTT_CLIENT_ID,
    pair.getKeyStore(),
    pair.getKeyPassword()
  );

  public static void main(String[] args) {
    new Main().start();
  }

  public void start() {
    logger.debug("init MQTT");
  }
}
