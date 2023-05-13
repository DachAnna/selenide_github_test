package com.annadach.config;

@org.aeonbits.owner.Config.Sources({"classpath:config/credentials.properties"})
public interface Config extends org.aeonbits.owner.Config {

    @Config.Key("remoteUrl")
    String getRemoteUrl();

    @Config.Key("remoteLogin")
    String getRemoteLogin();

    @Config.Key("remotePassword")
    String getRemotePassword();
}
