# MQTT sample app


## Setup

- Log into High-Mobility developer center and fetch MQTT certificate and private key for your app.
- Change the MQTT environment variables in the `src/com/highmobility/mqttsample/Env.java` class. 
- This is an example app, in production you should never store the private key in code.

## Run the app

`./gradlew run`