package com.toury.libcore.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mongodb")
@Getter
@Setter
public class DBProperties {
    private String userName;
    private String password;
    private String host;
}
