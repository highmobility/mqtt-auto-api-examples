package com.highmobility.mqttsample;

import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMessage;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.amazonaws.services.iot.client.AWSIotTimeoutException;
import com.amazonaws.services.iot.client.AWSIotTopic;
import com.highmobility.mqttsample.sampleUtil.KeyStorePasswordPair;
import com.highmobility.mqttsample.sampleUtil.SampleUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


class Main {
  private static final long PUBLISH_TIMEOUT = 10000L;
  private static final long CONNECT_TIMEOUT = 10000L;

  private final Logger logger = LoggerFactory.getLogger("charon.mqtt");
  private final KeyStorePasswordPair pair = SampleUtil.getKeyStorePasswordPair(Env.MQTT_SERVICE_CERT, Env.MQTT_SERVICE_PRIVATE_KEY);

  public static void main(String[] args) {
    new Main().start();
  }

  void start() {
    logger.debug("init MQTT");

    if (pair == null) {
      logger.debug("Cannot load certificate");
      return;
    }

    final AWSIotMqttClient client = new AWSIotMqttClient(
      Env.MQTT_CLIENT_ENDPOINT,
      Env.MQTT_CLIENT_ID,
      pair.getKeyStore(),
      pair.getKeyPassword()
    );

    try {
      client.connect(CONNECT_TIMEOUT);
      var topic = "live/level13/A249D7040CB1E6190002728F/#";
      logger.debug("subscribing to %s".formatted(topic));
      client.subscribe(new CarStreamTopic(topic));
    } catch (AWSIotException | AWSIotTimeoutException e) {
      logger.debug(e.getLocalizedMessage());
    }
  }

  class CarStreamTopic extends AWSIotTopic {
    public CarStreamTopic(String topic) {
      super(topic, AWSIotQos.QOS1);
    }

    @Override public void onMessage(AWSIotMessage message) {
      logger.debug("Incoming message %s: %s".formatted(message.getTopic(), message.getStringPayload()));
    }
  }
}
