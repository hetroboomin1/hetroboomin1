package com.Swaggu.MrktDataApi.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// @Configuration
@Component("databaseConfig")
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "database")
public class DaoConfigBuilder {
    private final Logger logger = LoggerFactory.getLogger(DaoConfigBuilder.class);

    private String driver;
    private String username;
    private String password;
    private String url;

    public void setUrl(String url) {
        logger.info("Database url set to " + url);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDriver() {
        return driver;
    }
}
