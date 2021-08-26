package com.Swaggu.MrktDataApi.Config;

import java.util.HashMap;
import java.util.Map;

import com.Swaggu.MrktDataApi.DatabaseApi.MrktDao;
import com.Swaggu.MrktDataApi.DatabaseApi.KrakenDao.BitcoinDao;
import com.Swaggu.MrktDataApi.DatabaseApi.KrakenDao.EthereumDao;
import com.Swaggu.MrktDataApi.DatabaseApi.KrakenDao.RippleDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


//Could implement a builder and build itself while only changing YAML file?
@Configuration
@Component
public class DaoFactoryConfig {

    @Autowired
    private DatabaseConfig databaseConfig;

    public Map<String,MrktDao> getDaos(){
        Map<String, MrktDao> MrktDaos = new HashMap<String, MrktDao>();
        MrktDaos.put("XBT/CAD", new BitcoinDao(databaseConfig));
        MrktDaos.put("ETH/CAD", new EthereumDao(databaseConfig));
        MrktDaos.put("XRP/CAD", new RippleDao(databaseConfig));
        return MrktDaos;
    }
}

