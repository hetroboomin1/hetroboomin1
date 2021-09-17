package com.Swaggu.MrktDataApi.Config;

import com.Swaggu.MrktDataApi.DatabaseApi.MrktDao;
import com.Swaggu.MrktDataApi.DatabaseApi.KrakenDatabase.KrakenDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


//Could implement a builder and build itself while only changing YAML file?
@Configuration
@Component
public class DaoFactoryConfig {

    @Autowired
    private DaoConfigBuilder databaseConfig;

    @Bean
    public MrktDao getDao(){
        //pass the config builder and methods into here and assemble the correct DAO?
        return new KrakenDao(databaseConfig);
    }
}

