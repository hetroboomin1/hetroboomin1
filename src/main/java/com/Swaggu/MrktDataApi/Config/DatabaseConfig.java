package com.Swaggu.MrktDataApi.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

// @Configuration
@Component("databaseConfig")
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "database")
public class DatabaseConfig {
    private String driver;
    private String username;
    private String password;
    private String databaseUrl;

    public void setDatabaseUrl(String databaseUrl){
        this.databaseUrl = databaseUrl;
    }
    public String getDatabaseUrl(){
        return databaseUrl;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public void setDriver(String driver){
        this.driver = driver;
    }
    public String getDriver(){
        return driver;
    }
}
