package com.highmobility.mqttsample;

class Env {
   static final String MQTT_CLIENT_ENDPOINT = "mqtt.high-mobility.com";

   // certificate id form the developer console
   static final String MQTT_CLIENT_ID = "b9a17324-9cf9-4af9-8d26-89f17732cac3";

   // mqtt certificate. This is not a real certificate and cannot be used.
   // Please use a real certificate downloade from the developer console.
   static final String MQTT_SERVICE_CERT = """
    -----BEGIN CERTIFICATE-----
    MIIDVTCCAj2gAwIBAgIIBYg3AjKASmIwDQYJKoZIhvcNAQELBQAwJzELMAkGA1UE
    BhMCREUxGDAWBgNVBAMMD0hNIFByb2QgTVFUVCBDQTAeFw0yMjA4MzEwNDAxMTZa
    Fw0yMzA4MzEwNDA2MTZaMDAxCzAJBgNVBAYTAkRFMSEwHwYDVQQDDBhBMjQ5RDcw
    NDBDQjFFNjE5MDAwMjcyOEYwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIB
    AQClB22ojOumquC3hNVxaorVfy3INkTIPdxfNZ/df8Hcj2oNZDF3ORj9HCZnhVTZ
    50qPNAi+9SXW5RSLCs2RAz9yY2GCOWNP3nxbW8vVt8RnCeXwWbt192M9NGPPE9kr
    FeHjwqz3f5yrC3Mm/YRg2LdTvyNCJDXbAwDTt0sFkLVKsrp8ghrzHVIrQFBErepr
    a/JZ3dvUIJ3nKlQDS7mUIVx1MtpdTUqEwil1qJjZIXPEx1ukTxGhnlx+6KzkSevD
    ZfAawe5Vndzo0J9m2qDMIYkjxl2C23OlaFRZKx+3y/Z4xtNBsuk/uMB5tKHEVSrQ
    t0p1OcdBL3lhjSoGdfqoNlG5AgMBAAGjfDB6MAkGA1UdEwQCMAAwDgYDVR0PAQH/
    BAQDAgWgMB0GA1UdJQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjAdBgNVHQ4EFgQU
    a8tXVY3jnvvSGpy/j3Ey5PPjupEwHwYDVR0jBBgwFoAUZhKFLvJ+WgKhXlJYQYAK
    YBUK+o4wDQYJKoZIhvcNAQELBQADggEBAG33hUXk87VMbLPz8QHzzL35O9w7ip3s
    prQ+B/ksf32yImzhwdMK+wwrt0FQ03S5q0mMeULnTjU9+aRQZK1mQclXFg7cQMWg
    JLV7SAYWvGePXCRFDyZuFkxwblyMCaB561cNFVV8+GRNZkZ0oSTjtx2T6bVGIv7e
    phYOS0pa9XNjUZygDq4FpcZR0rpxMMlZvi5Az9VLFVR+MVia5stWMvt50fOt8sNu
    XPifgEVf8cXIAC+BaKT2W6LYFsOxYn5s8tSdDM2eM8Nv1Z5jZIOuNzys2R8A4z1X
    St+0Fh+1NT64BLAVfzUfUZXjC3KcnmvC0Br0H6J00PTXaMrbjwjlshQ=
    -----END CERTIFICATE-----

    """;

   // mqtt service private key. This is not a real private ke and cannot be used.
   // Please use the real private key downloaded from the developer console.
   // IMPORTANT: never store the private key in code. Use environment
   // variables or some other secure system instead.
   static final String MQTT_SERVICE_PRIVATE_KEY = """
    -----BEGIN RSA PRIVATE KEY-----
    MIIEowIBAAKCAQEApQdtqIzrpqrgt4TVcWqK1X8tyDZEyD3cXzWf3X/B3I9qDWQx
    dzkY/RwmZ4VU2edKjzQIvvUl1uUUiwrNkQM/cmNhgjljT958W1vL1bfEZwnl8Fm7
    dfdjPTRjzxPZKxXh48Ks93+cqwtzJv2EYNi3U78jQiQ12wMA07dLBZC1SrK6fIIa
    8x1SK0BQRK3qa2vyWd3b1CCd5ypUA0u5lCFcdTLaXU1KhMIpdaiY2SFzxMdbpE8R
    oZ5cfuis5Enrw2XwGsHuVZ3c6NCfZtqgzCGJI8ZdgttzpWhUWSsft8v2eMbTQbLp
    P7jAebShxFUq0LdKdTnHQS95YY0qBnX6qDZRuQIDAQABAoIBAB7W14gy5Wqc7id9
    XEG4jj89Z/nNImdlIARuyfQjhr/H0SK1gYTtF51dIFQiF2wtC8LdD3FX8H1LC967
    4xRhTf77UWJ7hPKM+iI8ckf68mnq8JxMuHpgA5yRaMFuzRt/GFpuq9IId+eC2T8F
    CzLp7MBqrJUUnTfTRNlLnGpq02Yk2U/jWW3S/h3A3sG1GNtQSNj4n81OKKdXbSjJ
    REiHmbtjpCATJKfb6AkkR+FBL2/AT1RpJ/gTjqafvrMUl32i5fiEei4McOm0yQxb
    EBFeTUslbPVL4Gv0zVBfeWiBFOoHXDWX6Ehr4a4uoiqWLuPC4XcDN2pKBG7SXp/6
    Pa9NHG0CgYEA1idLBAihIOJUVBt3crPo/p3wvRIyX5Y6YguS1PJ5zrOD/g28dZNU
    MHQYH1SK/qjUI9kOzX2gRkvJ4TzIjGJtKDy1kQGepKlR6ZpIs8E6rGw9nGURprF+
    hPpC4CquRAvzx9aA8DXlhN81rYTELznSK4PydZX6UuW4z9MWu17BIQcCgYEAxUbB
    4RuZOmdmFxJzzm9kmPJZFtuPAoXcuYu6YDGdzrPhFHZgjSQWPqIdQadZImBJm9Iu
    Qrw3+RlL9dcjK95sh3+D5Qpyatnu5vB1UlnNnkp9G/IwGyz0AU31kW3VsrHMfzkG
    fzqxbjAHrIEccCrEp1ZaBLFtfWxIIAqCZHD4Bz8CgYEAzn2kv4bylpqlZVP2oQsI
    pjn0Xtqk57YbJV6zfdEv0jcWFml4RoaArxfCCrOiMlrn8ojg1RNE74M0bZIGbhaZ
    2ipviBpftbXt3al+YJT41jioT5zEoE6VB/OneC6vSb2cmhwix3uwi6YOQ/m4kTDX
    jk30A51ReY033mxThueeoRECgYArrWTToDamtanmxdEaDZOqQU30P5xEJLsf4Y3c
    KmAUGcNlsmfiF/FM4Lu1g4W6lLL3auuPHvkNj8o/nehNmCtTPKpJFa0Ld0DrpKV1
    HCjoOPnGLDL2cVd8ynPqRPUhYTgzmr6TgL0z9jJcwSE4vF9Z5UZ874OcV1MItQr1
    jgV8JQKBgDcMlOiJS4NE2hBCZ6/HzJLI9pKNlyk13frtxRDnCYn/MwGsPE6w8OvK
    fOuBX+eAh/YsY87UpQz7ssmy4gDaQYWgdIOsB7q7SM6WcFfAnC5Sv5wa1PZJ6Ris
    RCt5NIt8DhuI7SlHQZA9qyTmb6yhOklSgl3GCiWH+5LZH0pW/Kcc
    -----END RSA PRIVATE KEY-----
       
    """;
}
