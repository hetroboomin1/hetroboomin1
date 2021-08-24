package com.Swaggu.MrktDataApi.Config;

import java.util.HashMap;
import java.util.Map;

import com.Swaggu.MrktDataApi.DatabaseApi.MrktDao;
import com.Swaggu.MrktDataApi.DatabaseApi.Pairs.BitcoinDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class DaoFactoryConfig {

    @Autowired
    private DatabaseConfig databaseConfig;

    public Map<String,MrktDao> getDaos(){
        Map<String, MrktDao> MrktDaos = new HashMap<String, MrktDao>();
        MrktDaos.put("XBT/CAD", new BitcoinDao(databaseConfig));
        MrktDaos.put("ETH/CAD", new BitcoinDao(databaseConfig));
        return MrktDaos;
    }
}

